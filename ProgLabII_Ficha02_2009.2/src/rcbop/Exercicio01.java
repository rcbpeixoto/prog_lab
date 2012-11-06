package rcbop;

public class Exercicio01 {
	public static void main(String[] args) {

		/*
		 * 1) Escreva um programa para indicar quantas jogadas de dados s�o
		 * necess�rios para se chegar a um par de resultados esperados. Os
		 * resultados esperados devem ser indicados pelo usu�rio. (dica:
		 * utilizar como base o exerc�cio 3 da Lista de Exerc�cios I).
		 */

		int dado1 = 0, dado2 = 0, esper1 = 0, esper2 = 0, cont = 0;
		boolean igual = false;

		System.out.println("Digite o primeiro n�mero esperado: ");
		esper1 = FBV.Leia(esper1);
		System.out.println("Digite o segundo n�mero esperado: ");
		esper2 = FBV.Leia(esper2);

		while (igual == false) {

			dado1 = (int) ((Math.random() * 6) + 1);
			dado2 = (int) ((Math.random() * 6) + 1);

			System.out.println("Jogada " + (cont + 1) + " : " + dado1 + " "
					+ dado2);

			if ((dado1 == esper1) && (dado2 == esper2) || (dado1 == esper2)
					&& (dado2 == esper1)) {
				igual = true;
			}
			cont++;
		}

		System.out.println();
		System.out.println("Foram necess�rias " + cont + " tentativas.");
	}

}
