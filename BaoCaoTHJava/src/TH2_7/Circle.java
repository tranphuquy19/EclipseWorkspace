package TH2_7;

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

	public double area() {
		return PI * radius * radius;
	}

	public void draw() {
		System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
	}
	static public void main(String argv[]) {
		Circle circle = new Circle(2.0);
		circle.draw();
		circle.move(new Point(1,1));
		circle.draw();
		System.out.println("circle area = " + circle.area()); 
	}
}
