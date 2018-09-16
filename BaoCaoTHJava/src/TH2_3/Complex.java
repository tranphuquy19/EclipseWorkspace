package TH2_3;

public class Complex {
	private double re, im;

	Complex(double real, double imag) {
		re = real;
		im = imag;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	public void add(Complex c) {
		re += c.getRe();
		im += c.getIm();
	}

	public void subtract(Complex c) {
		re -= c.getRe();
		im -= c.getIm();
	}

	public void print () {
	 System.out.println ("(" + re + "," + im + ")");
}
}
