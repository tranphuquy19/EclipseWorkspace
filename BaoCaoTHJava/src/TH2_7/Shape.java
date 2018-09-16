package TH2_7;

public abstract class Shape implements Figure {
	private Point origin;

	public Point getOrigin() {
		return origin;
	}

	public Shape() {
		origin = new Point(0, 0);
	}

	public Shape(int x, int y) {
		origin = new Point(x, y);
	}

	public Shape(Point o) {
		origin = o;
	}

	public void move(Point p) {
		origin = p;
	}
}
