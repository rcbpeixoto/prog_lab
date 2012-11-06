package rcbop;

public class ComplexNumber {
	
	private double z;
	private double a;
	private double b;
	
	public ComplexNumber(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	private ComplexNumber add(ComplexNumber c) {
		//(a + c) + (b + d)*i
		return new ComplexNumber((this.a + c.a), (this.b + c.b));
	}
	
	private ComplexNumber subtract(ComplexNumber c) {
		//(a - c) + (b - d)*i
		return new ComplexNumber((this.a - c.a),(this.b - c.b));
	}
	
	private ComplexNumber dot(ComplexNumber c) {
		//(ac-bd) + (ad+bc)*i
		return new ComplexNumber((this.a*c.a - this.b*c.b), (this.a*c.b + this.b*c.a));
	}
	
}
