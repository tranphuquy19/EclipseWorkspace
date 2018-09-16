package TH1;

import java.util.Scanner;

public class bai2_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int fib1 = 1, fib2 = 1, fib = 2;
		while (fib1 + fib2 <= n) {
			fib = fib1 + fib2;
			fib2 = fib1;
			fib1 = fib;
		}
		if(fib == n)
		{
			System.out.println("YES");
		}
		else System.out.println("NO");
	}

}
