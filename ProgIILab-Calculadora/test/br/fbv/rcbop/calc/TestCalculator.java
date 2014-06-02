package br.fbv.rcbop.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fbv.rcbop.calc.model.Calculator;

public class TestCalculator {
	
	private static Calculator calculator;
	
	@BeforeClass
	public static void initCalculator(){
		calculator = Calculator.getInstance();
	}
	
	@Before
	public void clear(){
		calculator.clear();
		assertEquals("Should be cleared", Double.NEGATIVE_INFINITY, calculator.getTerm1(), 0.5);
		assertEquals("Should be cleared", Double.NEGATIVE_INFINITY, calculator.getTerm2(), 0.5);
	}
	
	//----------------- ARITHMETIC FUNCTIONS -----------------

	@Test
	public void addOperationPositive() {
		calculator.setTerm1(10);
		calculator.setOperation(Calculator.PLUS);
		assertEquals("10 + 10 must be 20", 20.0, calculator.arithmeticResultOperation(10), 0.0);
	}
	
	@Test
	public void addOperationNegative() {
		calculator.setTerm1(-10);
		calculator.setOperation(Calculator.PLUS);
		assertEquals(" -10 + 6 must be -4", -4.0, calculator.arithmeticResultOperation(6), 0.0);
	}
	
	@Test
	public void minusOperationPositive(){
		calculator.setTerm1(5);
		calculator.setOperation(Calculator.MINUS);
		assertEquals("5 - 3 must be 2", 2.0, calculator.arithmeticResultOperation(3), 0.0);
	}
	
	@Test
	public void minusOperationNegative(){
		calculator.setTerm1(8);
		calculator.setOperation(Calculator.MINUS);
		assertEquals("8 - 10 must be -2", -2.0, calculator.arithmeticResultOperation(10), 0.0);
	}
	
	@Test
	public void multiplicationOperationPositive(){
		calculator.setTerm1(2);
		calculator.setOperation(Calculator.MULTIPLY);
		assertEquals("2 * 456 must be 912", 912.0, calculator.arithmeticResultOperation(456), 0.0);
	}
	
	@Test
	public void multiplicationOperationNegative(){
		calculator.setTerm1(2);
		calculator.setOperation(Calculator.MULTIPLY);
		assertEquals("2 * -0.32 must be -0.64", -0.64, calculator.arithmeticResultOperation(-0.32), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divisionOperationError(){
		calculator.setTerm1(10);
		calculator.setOperation(Calculator.DIV);
		assertEquals("10 / 0 must be ERROR", 0, calculator.arithmeticResultOperation(0), 0.0);
	}
	
	@Test
	public void divisionOperationNegative(){
		calculator.setTerm1(24);
		calculator.setOperation(Calculator.DIV);
		assertEquals("24 / -3.3 must be −7,2727...", -7.2727, calculator.arithmeticResultOperation(-3.3), 0.0001);
	}
	
	@Test
	public void divisionOperationPositive(){
		calculator.setTerm1(24);
		calculator.setOperation(Calculator.DIV);
		assertEquals("24 / 2 must be 12", 12.0, calculator.arithmeticResultOperation(2), 0.0);
	}
	
	//----------------- TRIGONOMETRIC FUNCTIONS RADIANS -----------------
	@Test
	public void sinPositiveInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("sin(2) must be 0.90929742682", 0.90929742682, calculator.trigonometricFunction(2.0, Calculator.SIN), 0.00001);
	}
	
	@Test
	public void sinNegativeInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("sin(-5) must be 0.95892", 0.95892, calculator.trigonometricFunction(-5.0, Calculator.SIN), 0.0005);
	}
	
	@Test
	public void cosNegativeInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("cos(-2) must be -0.41614683654", -0.41614683654, calculator.trigonometricFunction(-2.0, Calculator.COS), 0.000001);
	}
	
	@Test
	public void cosPositiveInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("cos(8) must be -0.1455000338", -0.1455000338, calculator.trigonometricFunction(8.0, Calculator.COS), 0.000001);
	}
	
	@Test
	public void tanPositiveInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("tan(12) must be -0.63585992866", -0.63585992866, calculator.trigonometricFunction(12.0, Calculator.TAN), 0.000001);
	}
	
	@Test
	public void tanNegativeInputRadians(){
		calculator.setUnity(Calculator.RADIAN);
		assertEquals("tan(-7) must be -0.87144798272", -0.87144798272, calculator.trigonometricFunction(-7.0, Calculator.TAN), 0.000001);
	}
	
	//----------------- TRIGONOMETRIC FUNCTIONS DEGREES -----------------
	
	@Test
	public void sinPositiveInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("sin(2) must be 0.0348994967", 0.0348994967, calculator.trigonometricFunction(2.0, Calculator.SIN), 0.00001);
	}
	
	@Test
	public void sinNegativeInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("sin(-5) must be -0.08715574274", -0.08715574274, calculator.trigonometricFunction(-5.0, Calculator.SIN), 0.0005);
	}
	
	@Test
	public void cosNegativeInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("cos(-2) must be 0.99939082701", 0.99939082701, calculator.trigonometricFunction(-2.0, Calculator.COS), 0.000001);
	}
	
	@Test
	public void cosPositiveInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("cos(8) must be 0.99026806874", 0.99026806874, calculator.trigonometricFunction(8.0, Calculator.COS), 0.000001);
	}
	
	@Test
	public void tanPositiveInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("tan(12) must be 0.21255656167", 0.21255656167, calculator.trigonometricFunction(12.0, Calculator.TAN), 0.000001);
	}
	
	@Test
	public void tanNegativeInputDegrees(){
		calculator.setUnity(Calculator.DEGREE);
		assertEquals("tan(-7) must be -0.1227845609", -0.1227845609, calculator.trigonometricFunction(-7.0, Calculator.TAN), 0.000001);
	}
}
