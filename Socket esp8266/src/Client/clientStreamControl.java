package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientStreamControl {
	private String serverHost = "192.168.1.104";
	private int serverPort = 16057;
	public void action(String mess)
	{
		try {
			Socket  mySocket = new Socket(serverHost, serverPort);
			ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
			oos.writeObject(mess);
			mySocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
