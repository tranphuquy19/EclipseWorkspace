package TH1;

import java.util.Scanner;

public class bai2_5 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int S=0, P = 1;
	while(n>0)
	{
		S += n%10;
		P *= n%10;
		n/=10;
	}
	System.out.println("S= "+S+" ;P= "+P);
	sc.close();
}
}
