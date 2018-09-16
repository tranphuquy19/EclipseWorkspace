package TH1;

import java.util.Scanner;

public class bai2_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int q = (int) Math.sqrt(n);
		if (Math.sqrt(n) != q) {
			System.out.println("FALSE");
		} else
			System.out.println("TRUE");

	}

}
