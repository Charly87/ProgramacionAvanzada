package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
 private Socket socket;
 
 public Client(String name) throws UnknownHostException, IOException
 {
	 socket = new Socket("127.0.0.1",1001);	
 }
 
 public void Send(String msg)
 {
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
