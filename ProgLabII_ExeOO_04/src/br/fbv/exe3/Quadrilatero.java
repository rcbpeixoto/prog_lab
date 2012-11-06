package br.fbv.exe3;

abstract class Quadrilatero {
	private double l1;
	private double l2;
	private double l3;
	private double l4;
	
	public Quadrilatero(double l1, double l2, double l3, double l4) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}

	protected double getL1() {
		return l1;
	}

	protected void setL1(double l1) {
		this.l1 = l1;
	}

	protected double getL2() {
		return l2;
	}

	protected void setL2(double l2) {
		this.l2 = l2;
	}

	protected double getL3() {
		return l3;
	}

	protected void setL3(double l3) {
		this.l3 = l3;
	}

	protected double getL4() {
		return l4;
	}

	protected void setL4(double l4) {
		this.l4 = l4;
	}

}
