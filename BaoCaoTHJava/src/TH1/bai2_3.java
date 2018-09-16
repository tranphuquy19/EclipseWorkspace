package TH1;

import java.util.Scanner;

public class bai2_3 {

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
		double S = 0;
		for(int i =1; i<=n; i+=2)
		{
			S+=1.0/(double)factorial(i);
			System.out.println(i);
		}
		System.out.println(S);
		sc.close();
	}

}
