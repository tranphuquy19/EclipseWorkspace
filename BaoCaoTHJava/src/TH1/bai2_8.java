package TH1;

import java.util.Scanner;

public class bai2_8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int n2 = n;
		int q = 0;
		while (n2 > 0) {
			q = q * 10 + n2 % 10;
			n2 /= 10; 
		}
		if (n == q) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
}
