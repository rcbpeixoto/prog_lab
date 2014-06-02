package br.fbv.rcbop.calc.controller;

import br.fbv.rcbop.calc.model.Calculator;
import br.fbv.rcbop.calc.model.ICalculator;
import br.fbv.rcbop.calc.view.CalculatorScreen;

public class CalculatorController implements ICalculator{
	
	public CalculatorController() {
	}
	
	public void start(){
		new CalculatorScreen();
	}

	@Override
	public int getOperation() {
		return Calculator.getInstance().getOperation();
	}

	@Override
	public void setOperation(int operation) {
		Calculator.getInstance().setOperation(operation);
	}

	@Override
	public void getTerm1() {
		Calculator.getInstance().getTerm1();
	}
	@Override
	public void setTerm1(double term1) {
		Calculator.getInstance().setTerm1(term1);
	}

	@Override
	public double getTerm2() {
		return Calculator.getInstance().getTerm2();
	}

	@Override
	public void setTerm2(double term2) {
		Calculator.getInstance().setTerm2(term2);
	}

	@Override
	public void clear() {
		Calculator.getInstance().clear();
	}

	@Override
	public String resultOperation(double term2) throws IllegalArgumentException {
		return Calculator.getInstance().resultOperation(term2);
	}

	
}
