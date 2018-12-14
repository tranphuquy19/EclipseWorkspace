package Bai1;

import java.util.Arrays;

public class sol1 {
	final int max = 100;
	final int maxC = 10000;
	int c[][] = new int[max][max];
	int f[][] = new int[max][max];
	int Trace[] = new int[max];
	int Delta[] = new int[max];
	int n, A, B;
	
	private void SetZeros(int array[][]) {
		Arrays.fill(array, 0);
	}

	private void SetZeros(int array[]) {
		Arrays.fill(array, 0);
	}

	private void Enter() {

	}

	private int Min(int x, int y) {
		if (x < y) {
			return x;
		} else
			return y;
	}

	private boolean FindPath() {
		int u, v;
		int[] Queue = new int[max];
		int First, Last;
		SetZeros(Trace);
		First = 0;
		Last = 0;
		Queue[0] = A;
		Trace[A] = n + 1;
		Delta[A] = maxC;
		do {
			u = Queue[First];
			First++;
			for (v = 0; v < n - 1; v++) {
				if (Trace[v] == 0) {
					if (f[u][v] < c[u][v]) {
						Trace[v] = u;
						Delta[v] = Min(Delta[u], c[u][v] - f[u][v]);
					} else {
						if (f[v][u] > 0) {
							Trace[v] = -u;
							Delta[v] = Min(Delta[u], f[v][u]);
						}
					}

					if (Trace[v] != 0) {
						if (v == B) {
							return true;
						}
						Last++;
						Queue[Last] = v;
					}
				}
			}
		} while (First > Last);
		return false;
	}

	private void IncFlow() {
		int IncValue, u, v;

		IncValue = Delta[B];
		v = B;
		do {
			u = Trace[v];
			if (u > 0) {
				f[u][v] = f[u][v] + IncValue;
			} else {
				u = -u;
				f[v][u] = f[v][u] - IncValue;
			}
			v = u;
		} while (v == A);
	}

	private void PrintResult(){
		int u, v, m;
		m = 0;
		for(u = 0; u< n; u++) {
			for(v = 0; v <n ; v++) {
				if(c[u][v] > 0) {
					System.out.println("f("+u+","+v+")="+f[u][v]);
					if(u == A) {
						m = m + f[A][v];
					}
				}
			}
		}
		System.out.println("Max Flow:"+m);
	}
	
	public static void main(String[] args) {

	}

}
