package br.fbv.rcbop.calc.model;

public class Calculator {
	public static final int	MINUS				= 1;
	public static final int	PLUS				= 2;
	public static final int	DIV					= 3;
	public static final int	MULTIPLY			= 4;
	
	public static final int SIN 				= 5;
	public static final int COS 				= 6;
	public static final int TAN 				= 7;
	
	public static final int DEGREE 				= 8;
	public static final int RADIAN 				= 9;

	private int					operation	= -1;
	private int					unity 		= -1;
	
	private double				term1		= Double.NEGATIVE_INFINITY;
	private double				term2		= Double.NEGATIVE_INFINITY;
	
	private static Calculator instance;
	
	private Calculator(){
	}
	
	public static Calculator getInstance(){
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}
	
	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public double getTerm1() {
		return term1;
	}

	public void setTerm1(double term1) {
		this.term1 = term1;
	}

	public double getTerm2() {
		return term2;
	}

	public void setTerm2(double term2) {
		this.term2 = term2;
	}
	
	public int getUnity() {
		return unity;
	}

	public void setUnity(int unity) {
		this.unity = unity;
	}
	
	public void clear(){
		term1 = Double.NEGATIVE_INFINITY;
		term2 = Double.NEGATIVE_INFINITY;
	}
	
	public double trigonometricFunction(double term, int operation){
		double rtn = 0;
		switch (operation) {
		case SIN:
			if (unity == RADIAN){
				rtn = Math.sin(term);
			}
			else {
				double tmp1 = Math.toRadians(term);
				rtn = Math.sin(tmp1);
			}
			break;
		case COS:
			if (unity == RADIAN) {
				rtn = Math.cos(term);
			}
			else {
				double tmp1 = Math.toRadians(term);
				rtn = Math.cos(tmp1);
			}
			break;
		case TAN:
			if (unity == RADIAN) {
				rtn = Math.tan(term);
			}
			else {
				double tmp1 = Math.toRadians(term);
				rtn = Math.tan(tmp1);
			}
			break;
		default:
			break;
		}
		return rtn;
	}
	
	public double arithmeticResultOperation(double term2) throws IllegalArgumentException {
		double rtn;
		this.term2 = term2;
		
		switch (operation) {
		case MINUS:
			term1 = term1 - term2;
			break;
		case PLUS:
			term1 = term1 + term2;
			break;
		case DIV:
			if (term2 != 0) {
				term1 = term1 / term2;
			} else {
				throw new IllegalArgumentException("ERROR: Division by zero");
			}
			break;
		case MULTIPLY:
			term1 = term1 * term2;
			break;
		default:
			break;
		}
		rtn = term1;
		
		return rtn;
	}
}
