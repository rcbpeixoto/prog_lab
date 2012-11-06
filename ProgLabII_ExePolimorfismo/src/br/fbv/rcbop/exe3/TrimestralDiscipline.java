package br.fbv.rcbop.exe3;

public class TrimestralDiscipline implements Evaluable {
	
	private double grade1;
	private double grade2;
	
	@Override
	public double evaluate() {
		return  (grade1 * 0.4) + (grade2 * 0.6);
	}

}
