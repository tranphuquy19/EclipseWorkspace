package TH1;

import java.util.Scanner;

public class bai2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float S = 0;
		int n;
		System.out.println("Nhập n= ");
		n = sc.nextInt();
		for(int i =1; i<=n; i++)
		{
			S+=(float)(1.0/i);
		}
		System.out.println(S);
		sc.close();
	}

}
