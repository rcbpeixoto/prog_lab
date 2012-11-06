package br.fbv.rcbop.exe1;

public class TrimestralDiscipline extends Discipline {

	@Override
	public double evaluate() {
		return  (grade1 * 0.4) + (grade2 * 0.6);
	}

}
