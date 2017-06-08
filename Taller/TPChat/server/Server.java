package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Server implements Runnable {
	private ServerSocket serverSocket;
	private Thread thread = null;
	private Map<String, Client> clients;
	private UIServer uiServer;

	public Server(UIServer uiServer, int port) throws IOException {
		this.uiServer = uiServer;
		this.serverSocket = new ServerSocket(port);
		clients = new HashMap<String, Client>();
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
			thread = null;
			this.closeClients();
			this.closeServer();
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
				for(Client c : this.clients.values())
					this.uiServer.log("Clientes conectados: " + c.getUser().getUsername());
				Client client = new Client(this.uiServer, this, socketClient);
				client.start();
			} catch (Exception ie) {
				this.uiServer.log("Excepción en el servidor: " + ie.toString());
			}
		}
	}
	
	private void closeClients()
	{
		for(Client client : this.clients.values())
			client.close();
	}
	
	private void closeServer()
	{
		if(this.serverSocket != null)
		{
			try {
				this.serverSocket.close();
			} catch (IOException e) {
				this.serverSocket = null;
			}
		}
	}

	public Map<String, Client> getClients() {
		return this.clients;
	}

}
