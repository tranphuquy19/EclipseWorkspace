package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ServerSocket serverSocket;
	static Socket socket, socket2;
	static InputStreamReader inputStreamReader;
	static OutputStreamWriter outputStreamWriter;
	static BufferedReader bufferedReader;
	static BufferedWriter bufferedWriter;
	static PrintWriter printWriter;
	static String mess = "";
	static String temp = "";
	public static void main(String[] args) {
		while(true)
		{
			try {
				serverSocket = new ServerSocket(16057);
				socket = serverSocket.accept();
				temp = socket.getInetAddress().getHostAddress();
				inputStreamReader = new InputStreamReader(socket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader);
				mess = bufferedReader.readLine();
				System.out.println(mess);	
				bufferedReader.close();
				inputStreamReader.close();
				socket.close();
				serverSocket.close();
				new clientOfServer(temp).run();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
