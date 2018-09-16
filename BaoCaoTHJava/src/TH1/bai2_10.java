package TH1;

public class bai2_10 {
	public static int TongUoc(int n) {
		int s = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				s += i;
		}
		return s;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			if (i == TongUoc(i)) {
				System.out.println(i);
			}
		}
	}

}
