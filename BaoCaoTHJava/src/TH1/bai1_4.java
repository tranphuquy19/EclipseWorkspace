package TH1;

import java.util.Scanner;

public class bai1_4 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a, b, tien = 0;
	System.out.println("Nhập giờ bắt đầu a=");
	a = sc.nextInt();
	System.out.println("Nhập giờ kết thúc b=");
	b = sc.nextInt();
	sc.close();
	if(a<18 && b<18) tien= (b-a)*45000;
	if(a<18 && b>18) tien = (18-a)*45000 + (b-18)*60000;
	if(a>18 && b>18) tien = (b-a)*60000;
	if(a>18 && b<18)
	{
		System.out.println("Bạn hát qua đêm!");
		tien = (24-a)*60000 + (b-0)*45000;
	}
	System.out.printf("Số tiền bạn phải trả là %d", tien);
	sc.close();
}
}
