package Server;
import Client.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverControl {
private ServerSocket myServer;
private Socket clientSocket;
private int serverPort = 16057;
public serverControl()
{
	System.out.println("Server is running...");
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
private void listening() {
	try {
		//tạo myServer (Server Socket) nhưng về server bản chất nó là socket (ép kiểu)
		clientSocket = myServer.accept();
		ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		Object o = ois.readObject();
		if(o instanceof User)
		{
			User user = (User)o;
			System.out.println("Inbox_Server>> Id:"+user.getUserName()+" passwd:"+user.getUserPassword());
			oos.writeObject("Đã nhận!");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
