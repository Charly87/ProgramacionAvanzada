package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Client extends Thread {
	UIServer uiServer;
	Socket socket;
	List<Client> clients;

	public Client(UIServer uiServer, String name, Socket socket, List<Client> clients) {
		super(name);
		this.uiServer = uiServer;
		this.socket = socket;
		this.clients = clients;	
	}

	public void run() {
		while (true) {
			try {
				DataInputStream stream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				//stream.close();
				this.uiServer.log(this.getName() + ":" + stream.readUTF());
			} catch (IOException e) {
				this.uiServer.log("Exception on socket " + this.getName() + ": " + e.toString());
			}
		}
	}
}
