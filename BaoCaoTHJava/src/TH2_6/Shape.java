package TH2_6;

public abstract class Shape {
	private Point _origin;

	public Point getOrigin() {
		return _origin;
	}

	public Shape() { _origin = new Point(0,0); }

	public Shape(int x, int y) { _origin = new Point(x,y); }

	public Shape(Point o) { _origin = o; }

	abstract public void draw();
}
