package rcbop;

public class Rectangle {

	private double	base;
	private double	height;
	private double	area;
	private double	perimeter;

	public Rectangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
		this.area = base * height;
		this.perimeter = 2 * base + 2 * height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
		this.area = base * this.height;
		this.perimeter = 2 * base + 2 * this.height;
	}

	public double getArea() {
		return area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		this.area = height * this.base;
		this.perimeter = 2 * this.base + 2 * height;
	}

	@Override
	public String toString() {
		return "base: " + this.base + ", height: " + this.height + ", area: " + this.area + ", perimeter: " + this.perimeter;
	}

}
