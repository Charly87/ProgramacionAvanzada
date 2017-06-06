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
			this.uiServer.log("Servidor iniciado.");
		}
	}

	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
			this.uiServer.log("Servidor detenido.");
		}
	}

	@Override
	public void run() {

		while (thread != null) {
			try {
				this.uiServer.log("Esperando a un cliente...");
				Socket socketClient = this.serverSocket.accept();
				this.uiServer.log("Cliente conectado: " + socketClient);		
				
				Client client = new Client(this.uiServer,this, socketClient);				
				clients.add(client);
				client.run();
			} catch (Exception ie) {
				this.uiServer.log("Excepción en el servidor: " + ie.toString());
			}
		}

	}
	
	public List<Client> getClients()
	{
		return this.clients;
	}

}
