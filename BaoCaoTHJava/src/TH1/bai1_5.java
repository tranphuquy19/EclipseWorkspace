package TH1;

import java.util.Scanner;

public class bai1_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, y;
		System.out.println("Nhập vào năm: ");
		y = sc.nextInt();
		System.out.println("Nhập vào tháng: ");
		m = sc.nextInt();
		int a[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if((y%4 == 0) && (y%100 != 0) || (y%400 == 0))
		{
			System.out.printf("Số ngày của tháng %d năm %d la: %d ngày!", m, y, a[m-1]);
		}
		else
		{
			if(m == 2)
			{
				System.out.printf("Số ngày của tháng %d năm %d la: 28 ngày!", m, y);
			}
			else
			{
				System.out.printf("Số ngày của tháng %d năm %d la: %d ngày!", m, y, a[m-1]);
			}
		}
		sc.close();
	}
}

