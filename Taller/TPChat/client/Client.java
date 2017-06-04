package client;

import java.awt.Frame;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import com.google.gson.Gson;

import shared.Command;
import shared.Packet;
import shared.PacketLogin;
import shared.PacketLogout;
import shared.PacketMessage;
import shared.PacketUpdate;
import shared.PacketUser;

public class Client extends Thread {
	private UIClients uiClients;
	private Socket socket;
	private FileProperties fileProperties;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Gson gson = new Gson();
	private Packet packet;

	public Client(UIClients uiClients, FileProperties fileProperties) {
		this.uiClients = uiClients;
		this.fileProperties = fileProperties;
	}

	public void run() {
		while (true) {
			try {

				String readedObject = (String) this.inputStream.readObject();
				this.packet = gson.fromJson(readedObject, Packet.class);
				switch (this.packet.getCommand()) {
				case LOGOUT: {
					PacketLogout packetLogout = gson.fromJson(readedObject, PacketLogout.class);
					this.uiClients.removeUser(packetLogout.getUsername());
					break;
				}
				case MESSAGE: {
					PacketMessage packetMessage = gson.fromJson(readedObject, PacketMessage.class);
					this.uiClients.updateChat(packetMessage.getFrom(), packetMessage.getMessage());
					break;
				}
				case UPDATE: {
					PacketUpdate packetUpdate = gson.fromJson(readedObject, PacketUpdate.class);
					this.uiClients.updateUsers(packetUpdate.getUsers());
					break;
				}
				default:
					break;
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean Login(String username, String password) {
		try {
			this.socket = new Socket(fileProperties.getIP(), fileProperties.getPuerto());
			this.inputStream = new ObjectInputStream(this.socket.getInputStream());
			this.outputStream = new ObjectOutputStream(this.socket.getOutputStream());

			// Login
			PacketUser packetUser = new PacketUser(username, password);
			packetUser.setCommand(Command.LOGIN);
			this.outputStream.writeObject(gson.toJson(packetUser, PacketUser.class));

			// Respuesta del server
			String readedObject = (String) this.inputStream.readObject();
			this.packet = gson.fromJson(readedObject, Packet.class);

			if (this.packet.getCommand() == Command.LOGIN) {
				// Si el comando fue exitoso
				if (this.packet.getStatus()) {
					PacketUpdate packetUpdate = gson.fromJson(readedObject, PacketUpdate.class);
					this.uiClients.closeLogin();
					this.uiClients.updateUsers(packetUpdate.getUsers());

					// Inicio el thread para que escuche mensajes
					this.start();
				} else {
					// tirar un popup con el mensaje
				}
			}

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void Send(String msg) {
		try {
			DataOutputStream streamOut = new DataOutputStream(this.socket.getOutputStream());
			streamOut.writeUTF(msg);
			streamOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
