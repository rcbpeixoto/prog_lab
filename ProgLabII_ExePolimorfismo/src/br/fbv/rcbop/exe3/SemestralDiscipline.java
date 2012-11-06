package br.fbv.rcbop.exe3;

public class SemestralDiscipline implements Evaluable {

	private double		grade1;
	private double		grade2;
	private double		grade3;

	@Override
	public double evaluate() {
		return (grade1 + grade2 + grade3) / 3.0;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}

}
