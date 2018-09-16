package TH1;

import java.util.Scanner;

public class bai2_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 2) {
			System.out.println("TRUE");
			System.exit(0);
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (n % i == 0) {
				System.out.println("FALSE");
				System.exit(0);
			}
		}
		System.out.println("TRUE");
		sc.close();
	}

}
