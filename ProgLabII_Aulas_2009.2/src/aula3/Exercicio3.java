package aula3;

public class Exercicio3 {
	public static void main(String[] args) {
		int dado1 = 0, dado2 = 0, resultado = 0,
	    vResult = 0;
	
		System.out.println(" Informa��es do Dados");
		System.out.println("======================");
		System.out.print("Digite o resultado: ");		
		vResult = FBV.Leia(vResult);
		if (vResult < 2 || vResult > 12) {
			throw new IllegalArgumentException("\n -> Error: N�mero tem que ser entre 2 e 12!");
		}else {	
			do {
				dado1 = (int)(Math.random() * 6) + 1;
				dado2 = (int)(Math.random() * 6) + 1;
				resultado++;
				
			} while ((dado1 + dado2) != vResult);
	
			System.out.println("\n            -= Resultado =- ");
			System.out.println("=======================================");
			System.out.println("Total de "+resultado+" jogada(s), para o valor: "+vResult);
		
		}
	}
	
	
	 

}
