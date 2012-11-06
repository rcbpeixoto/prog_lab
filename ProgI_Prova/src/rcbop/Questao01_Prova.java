package rcbop;

public class Questao01_Prova {

	//fa�a um programa que leia a base e a altura do triangulo e imprima a �rea
	
	public static void main(String[] args) {

		double base = 0.0, altura = 0.0, area = 0.0;
		
		System.out.println("Entre com a base: ");
		base = FBV.Leia(base);
		System.out.println("Entre com a altura: ");
		altura = FBV.Leia(altura);
		
		area = (base * altura)/2;
		
		System.out.println("A �rea � de "+area+" unidades de medida");
		
	}

}
