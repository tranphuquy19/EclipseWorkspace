package TH1;

import java.util.Scanner;

public class bai1_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a[] = new float[3];
		System.out.print("Nhập a: ");
		a[0]= sc.nextFloat();
		System.out.println("Nhập b: ");
		a[1]= sc.nextFloat();
		System.out.println("Nhập c: ");
		a[2]= sc.nextFloat();
		SoTrungGian(a);
		sc.close();
	}
	public static void SoTrungGian(float[] array)
	{
		float  temp =  0 ;  
	    for  ( int  i =  0 ; i <array.length -  1 ; i ++) {  
	        for  ( int  j =  0 ; j <array.length -  1  - i; j ++) {  
	            if  (array [j]> array [j +  1 ]) {  
	                temp = array [j];  
	                array [j] = array [j +  1 ];  
	                array [j +  1 ] = temp;  
	            }  
	        }  
	    } 
	    if(array[0] == array[1] || array[1]==array[2])
	    {
	    	System.out.println("Không có số trung gian!");
	    }
	    else
	    {
	    	System.out.println("Số trung gian là: "+array[1]);
	    }
	}
}
