package br.fbv.rcbop.exe1;

public class SemestralDiscipline extends Discipline {

	private double	grade3;

	@Override
	public double evaluate() {
		return (grade1 + grade2 + grade3) / 3.0;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}

}
