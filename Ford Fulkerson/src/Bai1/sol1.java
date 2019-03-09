package Bai1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class sol1 {
	final static int max = 100;
	final static int maxC = 10000;
	static int c[][] = new int[max][max];
	static int f[][] = new int[max][max];
	static int Trace[] = new int[max];
	static int Delta[] = new int[max];
	static int n;
	static int A;
	static int B;
	static String fileContent = "";
	
	//static String filePath = "input3.txt"; //sol1
	static String filePath = "minicut2.txt"; //sol2

	private static void readFile() {
		Reader reader;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(filePath);
			bufferedReader = new BufferedReader(reader);
			String lines;
			while ((lines = bufferedReader.readLine()) != null) {
				fileContent += lines + "\n";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("The file " + filePath + " not found!");
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file!");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Problem occurs when closing file !");
					e.printStackTrace();
				}
			}
		}
	}

	private static void SetZeros(int array[][]) {
		for(int i = 0; i<array.length; i++) {
			Arrays.fill(array[i], 0);
		}
	}

	private static void SetZeros(int array[]) {
		Arrays.fill(array, 0);
	}

	//Nhập data
	private static void Enter() {
		int m, i, u, v;
		SetZeros(c);
		String part[] = fileContent.split("\n");
		//System.out.println("content file:\n"+fileContent);
		String part2[] = part[0].trim().split(" ");

		n = Integer.parseInt(part2[0]);
		m = Integer.parseInt(part2[1]);
		A = Integer.parseInt(part2[2]);
		B = Integer.parseInt(part2[3]);

		for (i = 1; i <= m; i++) {
			String part3[] = part[i].trim().split(" ");
			u = Integer.parseInt(part3[0]);
			v = Integer.parseInt(part3[1]);
			c[u][v] = Integer.parseInt(part3[2]);
		}
	}

	private static int Min(int x, int y) {
		if (x < y) {
			return x;
		} else
			return y;
	}

	private static boolean FindPath() {
		int u = 1, v = 1;
		int[] Queue = new int[max];
		int First, Last;
		SetZeros(Trace); //chưa đánh dấu tất cả v
		First = 1;
		Last = 1;
		Queue[1] = A;
		Trace[A] = n + 1 ; //đánh dấu bằng số bất kỳ >n
		Delta[A] = maxC; //khởi tạo nhãn
		do {
			u = Queue[First]; //lấy u khỏi Queue
			First++;
			for (v = 1; v <= n; v++) {
				if (Trace[v] == 0) { //xét các đỉnh chưa đánh dấu
					if (f[u][v] < c[u][v]) { //cung thuận trên Gf & trọng số c - f
						Trace[v] = u; //lưu vết, v mang dấu +
						Delta[v] = Min(Delta[u], c[u][v] - f[u][v]);
					}
					else {
						if (f[v][u] > 0) {//cung nghịch, trọng số là f
							Trace[v] = -u;//lưu vết, v mang dấu -
							Delta[v] = Min(Delta[u], f[v][u]);
						}
					}

					if (Trace[v] != 0) {//trace khác 0(u có thể thăm v)
						if (v == B) {//có đường tăng luồng A->B
							return true;
						}
						Last++;
						Queue[Last] = v; //Đưa v vào Queue
					}
				}
			}
		} while (First <= Last);//Queue rỗng
		return false;
	}

	private static void IncFlow() {
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
		} while (v != A);
	}

	private static void PrintResult() {
		int u, v, m;
		m = 0;
		for (u = 1; u <= n; u++) {
			for (v = 1; v <= n; v++) {
				if (c[u][v] > 0) {
					System.out.println("f(" + u + "," + v + ")=" + f[u][v]);
					if (u == A) {
						m = m + f[A][v];
					}
				}
			}
		}
		System.out.println("Max Flow:" + m);
	}

	public static void main(String[] args) {
		readFile();
		Enter();
		SetZeros(f);
		do {
			if(!FindPath()) {
				break;
			}
			IncFlow();
		}while(true);
		PrintResult();
	}
}
