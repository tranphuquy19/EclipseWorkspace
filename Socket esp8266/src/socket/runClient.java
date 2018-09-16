package socket;

import java.util.Scanner;

import Client.clientControl;
import Client.User;

public class runClient {

	public static void main(String[] args) {
		String id, passwd;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Nhập id: ");
			id = sc.nextLine();
			System.out.println("Nhập password: ");
			passwd = sc.nextLine();
			if("OUT".equals(id)) break;
			User user = new User();
			clientControl client = new clientControl();
			client.action(user.getUser(id, passwd));
		}
		sc.close();

	}

}
