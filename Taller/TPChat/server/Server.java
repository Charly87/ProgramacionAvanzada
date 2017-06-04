package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server implements Runnable {
	private ServerSocket serverSocket;
	private Thread thread = null;
	private List<Client> clients;
	private UIServer uiServer;

	public Server(UIServer uiServer, int port) throws IOException {
		this.uiServer = uiServer;
		this.serverSocket = new ServerSocket(port);
		clients = new LinkedList<Client>();
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
			this.uiServer.log("Server started.");
		}
	}

	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
			this.uiServer.log("Server stopped.");
		}
	}

	@Override
	public void run() {

		while (thread != null) {
			try {
				System.out.println("Waiting for a client ...");
				Socket socketClient = this.serverSocket.accept();
				System.out.println("Client accepted: " + socketClient);		
				
				Client client = new Client(this.uiServer, "Cliente", socketClient, clients);				
				clients.add(client);
				client.run();
				
				// Swtich
		
			} catch (Exception ie) {
				this.uiServer.log("Exception running Server: " + ie.toString());
			}
		}

	}

}
