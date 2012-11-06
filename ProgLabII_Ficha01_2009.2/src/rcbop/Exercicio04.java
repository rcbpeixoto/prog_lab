package rcbop;

public class Exercicio04 {
	public static void main(String[] args) {

		/* 1)Escreva um programa para calcular os dez primeiros 
		 * n�meros da sequ�ncia de Fibonnaci e imprimir o resultado  
		 * na tela. Lembrando que cada n�mero da  sequ�ncia de Fibonnaci
		 * � o resultado da soma dos dois anteriores, calculada a partir 
		 * do terceiro n�mero. Abaixo temos o resultado esperado:
		 * 1 2 3 5 8 13 21 ...
		 */
		
		int sequen[] = new int[9];
		

		
		for (int i = 0; i < sequen.length; i++) {
			
		sequen[i] = (i+1);
			
			if ( i > 1)
			{
			sequen[i] = (sequen[i-2] + sequen[i-1]) ;
			}
			
		}
		
	System.out.println(sequen[0]+" "+sequen[1]+" "+sequen[2]+" "+sequen[3]+" "+sequen[4]+" "+sequen[5]+" "+sequen[6]);
		
	}


}
