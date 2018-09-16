package TH1;

import java.util.Scanner;

public class bai2_13 {
	public static int USCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return USCLN(b, a % b);
    }

    public static int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		sc.close();
		System.out.println("BCNN= " + BSCNN(a, b) + " ;UCLN= "+ USCLN(a,b));
	}

}
