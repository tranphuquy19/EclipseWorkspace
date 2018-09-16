package TH1;

import java.util.Scanner;

public class bai2_9 {
	static boolean snt(int soA)
	{
		if (soA < 2)
		{
			return false;
		}
		else if (soA>2)
		{
			if (soA % 2 == 0)
			{
				return false;
			}
			for (int i = 3; i < Math.sqrt((float)soA); i += 2)
			{
				if (soA%i == 0) 
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = n; i>1; i--)
		{
			if(snt(i))
			{
				System.out.println(i);
			}
		}
		sc.close();
	}
}
