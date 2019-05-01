package rank_E;

import java.util.*;

class phanso {
	private int tu, mau;

	public phanso(int tu, int mau) {
		this.tu = tu;
		this.mau = mau;

	}

	public void ToiGian() {
		int ucln = USCLN(this.tu, this.mau);
		this.tu /= ucln;
		this.mau /= ucln;
	}

	int USCLN(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return USCLN(b, a % b);
	}

	public int getTu() {
		return this.tu;
	}

	public int getMau() {
		return this.mau;
	}
}

public class Monitor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		int temp;
		phanso temp2;
		if (a > b || c > d) {
				temp = a;
				a = b;
				b = temp;
				temp = c;
				c = d;
				d = temp;
		} 
		if((a*1.0/b*1.0 - c*1.0/d*1.0) < 0) {
			temp2 = new phanso(Math.abs((a * d - b * c)), (b * d));
		}else {
			
			temp2 = new phanso((a * d - b * c), (a * d));
		}
			
		temp2.ToiGian();
		System.out.println(temp2.getTu() + "/" + temp2.getMau());
	}
}
