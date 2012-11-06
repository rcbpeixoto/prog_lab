package aula2;

public class Exercicio1 {
	public static void main(String[] args) {
		int dado1 = 0, dado2 = 0, resultado = 0,
		    vdado1 = 0, vdado2 = 0;
		
		System.out.println("Informa��es do Dados");
		System.out.print("Digite o primeiro n�mero: ");		
		vdado1 = FBV.Leia(vdado1);
		System.out.print("Digite o seguindo n�mero : ");
		vdado2 = FBV.Leia(vdado2);
		
		do {
			dado1 = (int)(Math.random() * 6) + 1;
			dado2 = (int)(Math.random() * 6) + 1;
			resultado++;	
			//System.out.println("("+dado1+","+dado2+")");
		} while ((dado1 != vdado1) || (dado2 != vdado2));
		
		System.out.println("\nResultado: ");
		System.out.println("total de "+resultado+
				" jogada(s), para os resultados: Dado1 = "+dado1+
		        " e Dado2 = "+dado2);
		
	}

}
