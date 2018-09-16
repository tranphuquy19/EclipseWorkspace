package Rarray;
/*
 * Bỏ tên package
 * Xóa static ở mỗi hàm
 * Giữ nguyên import của Random
 */

import java.util.Random;

public class TaoMang {
	private static boolean kt(int a[], int temp) {
		for (int i = 0; i < 8; i++) {
			if (a[i] == temp)
				return true;
		}
		return false;
	}

	private static int kt(int a[]) {
		int count = 0;
		int fist;
		int sub = 0, sub2 =0, sub3 = 0;
		for(int i = 0 ; i<8; i++)
		{
			sub3+= a[i];
		}
		if(sub3 == 0) return 1;
		while (count < 8) {
			fist = a[count];
			sub2 =0;
			for (int i = count + 1; i < 8; i++) {
				if (a[i] < fist) {
					sub2++;
				}
			}
			sub += sub2;
			count++;
		}
		return sub;
	}

	public static void main(String[] args) {
		/*
		 * Phần bỏ vào phần khai báo của class private
		 */
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Random r = new Random();
		int array[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
		//Hết khai báo
		
		/*
		 * Bỏ vào hàm next --> 
		 * private void next(int array[]){<phần while() phía dưới>}
		 * Gọi từ sự kiện btNext --> 
		 * next(this.array);
		 */
		while(kt(array)%2 != 0)
		{
			for(int i = 0; i<8; i++)
			{
				array[i] = 0;
			}
			int temp=0, rand=0;
			int count = 0;
			while (kt(array, 0)) {
				rand = r.nextInt(8);
				temp = a[rand];
				if (kt(array, temp) == false) {
					array[count] = temp;
					count++;
				}
			}
		}
		/*
		 * Phần méo liên quan
		 */
		for (int i = 0; i < 8; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		System.out.println(kt(array));
		
	}

}
