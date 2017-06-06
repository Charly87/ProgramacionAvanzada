package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import shared.Command;
import shared.Packet;
import shared.PacketLogout;
import shared.PacketMessage;
import shared.PacketUpdate;
import shared.PacketUser;

public class Client extends Thread {
	private UIServer uiServer;
	private Server server;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Gson gson;
	private PacketUser user;

	public Client(UIServer uiServer, Server server, Socket socket) {
		this.uiServer = uiServer;
		this.server = server;
		this.socket = socket;
		this.gson = new Gson();
	}

	public void run() {

		try {
			this.in = new ObjectInputStream(this.socket.getInputStream());
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			while (true) {
				String readedObject = (String) this.in.readObject();
				Packet packet = this.gson.fromJson(readedObject, Packet.class);
				switch (packet.getCommand()) {
				case LOGIN: {
					PacketUser packetUser = gson.fromJson(readedObject, PacketUser.class);

					// Valido si es correcto el usuario y contraseña.
					if (true) {
						this.user = packetUser;
						this.user.setLogged(true);
						List<Client> clients = this.server.getClients();
						List<String> users = new LinkedList<String>();

						for (Client client : clients) {
							if (client.getUser().getLogged())
								users.add(client.getUser().getUsername());
						}
						packet = new PacketUpdate(users);

						packet.setStatus(true);
						this.uiServer.log("Usuario " + this.user.getUsername() + " logueado correctamente.");
					} else {
						packet.setStatus(false);
						this.uiServer.log("Usuario o passwrod incorrecto. Usuario: " + this.user.getUsername()
								+ " Password:" + this.user.getPassword());
					}

					packet.setCommand(Command.LOGIN);
					this.out.writeObject(this.gson.toJson(packet));
					break;
				}
				case LOGOUT: {
					PacketLogout packetLogout = gson.fromJson(readedObject, PacketLogout.class);
					break;
				}
				case MESSAGE: {
					PacketMessage packetMessage = gson.fromJson(readedObject, PacketMessage.class);
					// this.uiClients.updateChat(packetMessage.getFrom(),
					// packetMessage.getMessage());
					break;
				}
				case UPDATE: {
					PacketUpdate packetUpdate = gson.fromJson(readedObject, PacketUpdate.class);
					// this.uiClients.updateUsers(packetUpdate.getUsers());
					break;
				}
				default:
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			this.uiServer.log("Exception en Cliente. " + e.toString());
		}

		// Elimino el cliente de cliente conectado
		this.server.getClients().remove(this);

		// Reenvío a todos los clientes los clientes conectados
		List<String> users = new LinkedList<String>();
		for (Client client : this.server.getClients())
			if (client.getUser().getLogged())
				users.add(client.getUser().getUsername());
		PacketUpdate packetUpdate = new PacketUpdate(users);
		try {
			this.out.writeObject(gson.toJson(packetUpdate, PacketUpdate.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PacketUser getUser() {
		return this.user;
	}
}
