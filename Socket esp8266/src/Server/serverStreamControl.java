package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class serverStreamControl {
private ServerSocket myServer;
private Socket clientSocket;
private int serverPort = 16057;
public serverStreamControl() {
	openServer(serverPort);
	while(true)
	{
		listening();
	}
	
}
private void openServer(int portServer)
{
	try {
		myServer = new ServerSocket(portServer);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
private void listening()
{
	try {
		clientSocket = myServer.accept();
		ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
		//ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		Object o = ois.readObject();
		if(o instanceof String)
		{
			System.out.print("Receive mess>>_"+(String)o);
			System.out.println();
			//oos.writeObject("Đã nhận!");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
