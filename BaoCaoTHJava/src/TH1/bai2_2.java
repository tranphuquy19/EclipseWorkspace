package TH1;

import java.util.Scanner;

public class bai2_2 {
	public static long factorial(long number) {
	      if (number <= 1)
	         return 1;
	      else
	         return number * factorial(number - 1);
	   }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		double S = 15.0;
		for(int i =1; i<=n; i++)
		{
			S+=Math.pow(-1, i)/(double)factorial(i);
		}
		System.out.println(S);
		sc.close();
	}

}
