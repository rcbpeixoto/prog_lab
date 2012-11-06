package rcbop;

public class Vector {

	private double a;
	private double b;
	private double c;
	
	public Vector(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Vector add(Vector v){
		return new Vector(this.a + v.a, this.b + v.b, this.c + v.c);
	}
	
	public void dotK(double k){
		a = this.a * k;
		b = this.b * k;
		c = this.c * k;
	}
	
	public double dot(Vector v){
		return this.a * v.a + this.b * v.b + this.c * v.c; 
	}
	
	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public static void main(String[] args) {
		
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(4, 5, 6);
		System.out.println("Adding V1(1,2,3) to V2(4,5,6): ");
		Vector result = v1.add(v2);
		System.out.println("Result: ("+ result.getA() + ","+ result.getB() + "," + result.getC() + ")");
		System.out.println("Constant value k = 5");
		System.out.println("Scalar product of V2 * k");
		double k = 5;
		Vector vTemp = new Vector(v2.getA(), v2.getB(), v2.getC());
		vTemp.dotK(k);
		System.out.println("Result: ("+ vTemp.getA() + ","+ vTemp.getB() + "," + vTemp.getC() + ")");
		System.out.println("Internal product of V1 * V2: " + v1.dot(v2));
	}
}
