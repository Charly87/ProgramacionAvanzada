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

import shared.Packet;

public class Client extends Thread {
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Gson gson = new Gson();
	private Packet packet;

	public Client(FileProperties fileProperties) throws UnknownHostException, IOException {
		this.socket = new Socket(fileProperties.getIP(), fileProperties.getPuerto());
		this.inputStream = new ObjectInputStream(this.socket.getInputStream());
		this.outputStream = new ObjectOutputStream(this.socket.getOutputStream());
	}

	public void run() {
		while (true) {
			try {

				String readedObject = (String) this.inputStream.readObject();
				this.packet = gson.fromJson(readedObject, Packet.class);
				switch (this.packet.getCommand()) {
				case LOGIN: {
					break;
				}
				case MESSAGE: {
					break;
				}
				case UPDATE: {
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
