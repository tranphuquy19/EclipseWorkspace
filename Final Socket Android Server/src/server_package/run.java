package server_package;

import java.util.Scanner;

public class run {
	public static void main(String[] args) {
		String message = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Send to Client>>");
			message = sc.nextLine();
			new ToClient(message);
		}
	}
}
