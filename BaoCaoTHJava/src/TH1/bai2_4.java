package TH1;

import java.util.Scanner;

public class bai2_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		long S1 = 1, S2 =1;
		for(int i = 2; i <= n; i++) {
			if(i%2 == 0) S2*=i;
			else S1*=i;
		}
		System.out.println("S1 = "+S1+" ;S2= "+S2);
		sc.close();
	}

}
