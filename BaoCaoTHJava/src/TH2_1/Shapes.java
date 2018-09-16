package TH2_1;

public class Shapes {
	public static void main(String[] args) {
		Square s = new Square(100);
		System.out.println("s.width = " + s.getWidth());
		Rectangle r = new Rectangle(50, 25);
		System.out.println("r.width = " + r.getWidth());
		System.out.println("r.length = " + r.getLength());
	}
}
