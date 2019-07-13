package tk.doraneko.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.println("Nhap N:");
		N = sc.nextInt();
		int[] A = new int[N];
		int[][] B = new int[N][3];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			B[i][1] = A[i];
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i] == B[j][1])
					B[j][2]++;
				break;
			}
		}
		int temp = 0;
		int index = 0;
		ArrayList<int[]> l = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (temp < B[i][2]) {
				index = i;
				temp = B[i][2];
			}
		}
		int result = B[index][1];
		for (int i = 0; i < N; i++) {
			if (result < B[i][1] && B[i][2] == temp)
				result = B[i][1];
		}
		System.out.println(result);
	}

}
