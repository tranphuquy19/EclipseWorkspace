package tk.doraneko.app;

import java.util.Scanner;

public class Bai2 {

	public static void main(String[] args) {
		String a = "";
		int total = 0;
		System.out.println("Nhap chuoi S: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		for(int i = 0; i < a.length(); i++) {
			String s = Character.toString(a.charAt(i));
			try {
				int temp = Integer.parseInt(s);
				total += temp;
			}catch(Exception e) {
				continue;
			}
		}
		System.out.println(total);
	}

}
