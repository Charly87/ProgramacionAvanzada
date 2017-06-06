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
import shared.PacketLogout;
import shared.PacketMessage;
import shared.PacketUpdate;
import shared.PacketUser;

public class Client extends Thread {
	private UIClients uiClients;
	private Socket socket;
	private FileProperties fileProperties;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Gson gson;
	private Packet packet;
	private PacketUser user;

	public Client(UIClients uiClients, FileProperties fileProperties) {
		this.uiClients = uiClients;
		this.fileProperties = fileProperties;
		this.gson = new Gson();
	}

	public void run() {

		try {
			while (this.packet != null && this.packet.getCommand() != Command.LOGOUT) {
				String readedObject = (String) this.in.readObject();
				this.packet = gson.fromJson(readedObject, Packet.class);
				switch (this.packet.getCommand()) {
				case LOGOUT: {
					PacketLogout packetLogout = gson.fromJson(readedObject, PacketLogout.class);
					// this.uiClients.removeUser(packetLogout.getUsername());
					break;
				}
				case MESSAGE: {
					PacketMessage packetMessage = gson.fromJson(readedObject, PacketMessage.class);
					this.uiClients.receiveMessage(packetMessage.getFrom(), packetMessage.getMessage());
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
			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		this.uiClients.setClient(null);
	}

	public boolean Login(String username, String password) {
		try {
			this.socket = new Socket(fileProperties.getIP(), fileProperties.getPuerto());
			
			// Login
			this.user = new PacketUser(username, password);
			this.user.setCommand(Command.LOGIN);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.out.writeObject(gson.toJson(this.user, PacketUser.class));

			// Respuesta del server
			this.in = new ObjectInputStream(this.socket.getInputStream());
			String readedObject = (String) this.in.readObject();
			this.packet = gson.fromJson(readedObject, Packet.class);

			if (this.packet.getCommand() == Command.LOGIN) {
				// Si el comando fue exitoso
				if (this.packet.getStatus()) {
					this.user.setLogged(true);
					PacketUpdate packetUpdate = gson.fromJson(readedObject, PacketUpdate.class);
					this.uiClients.updateUsers(packetUpdate.getUsers());

					// Inicio el thread para que escuche mensajes
					this.start();
				} else {
					// tirar un popup con el mensaje
				}
			}

			return true;

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void Send(String username, String msg) {
		// try {
		//
		// PacketMessage pm = new PacketMessage(this.user.getId(), idTo,
		// message)
		// this.out.writeObject(pm.);
		//
		//
		// streamOut.writeUTF(msg);
		// streamOut.flush();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public String getUsername() {
		return this.user.getUsername();
	}
}
