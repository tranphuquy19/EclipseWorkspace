package TH3_6;

import java.util.Scanner;

public class MyInput {
	static Scanner sc = new Scanner(System.in);
	public int nhapInt()
	{
		return sc.nextInt();
	}
	public double nhapDouble()
	{
		return sc.nextDouble();
	}
	public static String nhapXau() {
		// TODO Auto-generated method stub
		return sc.nextLine();
	}
}
