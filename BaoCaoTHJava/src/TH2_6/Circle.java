package TH2_6;

public class Circle extends Shape {

	double radius;

	public Circle(double rad) {
		super();
		radius = rad;
	}

	public Circle(int x, int y, double rad) {
		super(x, y);
		radius = rad;
	}

	public Circle(Point o, double rad) {
		super(o);
		radius = rad;
	}

	public void draw() {
		System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
	}

	public static void main(String[] args) {
		Circle circle = new Circle(1.0);
		circle.draw();
	}
}
