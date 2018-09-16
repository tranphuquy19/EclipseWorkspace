package TH2_1;

public class Rectangle extends Square{
private double length;
public Rectangle(double width, double length)
{
	super(width);
	this.length = length;
}
public double getLength() {
	return length;
}

}
