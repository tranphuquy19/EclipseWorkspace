package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientOfServer implements Runnable {
	static Socket socket, socket2;
	static String temp = "";
	static PrintWriter printWriter;
	public clientOfServer(String temp) {
		this.temp = temp;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		try {
			socket2 = new Socket(temp, 16058);
			printWriter = new PrintWriter(socket2.getOutputStream(), true);
			printWriter.println("OK");
			printWriter.flush();
			printWriter.close();
			socket2.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
