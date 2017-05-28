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

	// public void open() throws IOException {
	// streamIn = new DataInputStream(new
	// BufferedInputStream(socket.getInputStream()));
	// }

	// public void close() throws IOException {
	// if (socket != null)
	// socket.close();
	// if (streamIn != null)
	// streamIn.close();
	// }

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
				
				// open();
				// boolean done = false;
				// while (!done) {
				// try {
				// String line = streamIn.readUTF();
				// System.out.println(line);
				// done = line.equals(".bye");
				// } catch (IOException ioe) {
				// done = true;
				// }
				// }
				// close();
			} catch (Exception ie) {
				this.uiServer.log("Exception running Server: " + ie.toString());
			}
		}

	}

}
