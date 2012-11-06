package br.fbv.exe3;

public class Retangulo extends Quadrilatero {

	public Retangulo(double altura, double base) {
		super(base, altura, base, altura);
	}
	
	public static void main(String[] args) {
		System.out.println("QUADRADO");
		Quadrado a = new Quadrado(10);
		System.out.println(a.getL1() + " " + a.getL2() + " " + a.getL3() + " " + a.getL4());
		
		System.out.println("RETANGULO");
		Retangulo b = new Retangulo(20, 30);
		System.out.println(b.getL1() + " " + b.getL2() + " " + b.getL3() + " " + b.getL4());
	}
}
