package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class clientControl {
	private String serverHost = "192.168.1.104";
	private int serverPort = 16057;
	public void action(User user)
	{
		try {
			Socket mySocket = new Socket(serverHost, serverPort);
			System.out.println("Client>> Đã tạo kết nối đến server");
			ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
			oos.writeObject(user);
			System.out.println("Da gui user");
			ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
			Object o = ois.readObject();
			if(o instanceof String)
			{
				String rely = (String)o;
				System.out.println("Server>> "+rely);
			}
			mySocket.close();
			System.out.println("Đã gửi xong gói");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
