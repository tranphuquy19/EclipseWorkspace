package TH1;

import java.util.Scanner;

public class bai1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a, b;
		System.out.print("Nhập a: ");
		a= sc.nextFloat();
		System.out.println("Nhập b: ");
		b= sc.nextFloat();
		float x;
		x= -b/a;
		System.out.printf("Nghiệm của phương trình a.x + b = 0, x= %f", x);
		sc.close();

	}

}
