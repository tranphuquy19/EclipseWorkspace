package TH2_3;

public class UseComplex {
	public static void main(String[] args) {
		Complex c1 = new Complex(2.0, 5.0); // 2.0 + 5.0i
		Complex c2 = new Complex(-3.1, -6.3); // -3.1 - 6.3i
		c1.add(c2); // c1 is now -1.1 - 1.3i
		c1.print();
	}

}
