package br.fbv.rcbop.calc.model;

public interface ICalculator {
	
	public int getOperation();
	public void setOperation(int operation);
	public void getTerm1();
	public void setTerm1(double term1);
	public double getTerm2();
	public void setTerm2(double term2);
	public void clear();
	public double trigonometricFunction(double term, int operation);
	public double resultArithmeticOperation(double term2) throws IllegalArgumentException;
	public void setUnity(int unity);
	public int 	getUnity();
}
