package socket;

import java.util.Scanner;

import Client.clientStreamControl;

public class runStreamStringClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mess = "";
		while(true) {
			System.out.print("Send mess >>_ ");
			clientStreamControl client = new clientStreamControl();
			mess = sc.nextLine();
			if("EXIT".equals(mess)) break;
			client.action(mess);
		}
		sc.close();
	}

}
