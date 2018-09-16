package TH1;

import java.util.Scanner;

public class bai2_11 {
	static long Fibonaci(long n)  
	{
	   int f1=0,f2=1,fi;
	   fi=f2;
	   for(int i = 1;i <= n ;i ++)
	   {
	    System.out.println(fi);
	        fi=f1+f2;
	        f1=f2;
	        f2=fi;
	   }
	   return fi;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fibonaci(n);
		sc.close();
	}

}
