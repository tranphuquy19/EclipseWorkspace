package Client;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientServer {
public static void main(String[] args) {
	Socket socket;
	PrintWriter printWriter;
	try {
		socket = new Socket("192.168.1.111", 16059);
		printWriter= new PrintWriter(socket.getOutputStream());
		printWriter.write("hello cac ban");
		printWriter.flush();
		printWriter.close();
		socket.close();
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
}
