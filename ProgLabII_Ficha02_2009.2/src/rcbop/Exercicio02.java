package rcbop;

public class Exercicio02 {
	public static void main(String[] args) {

		/*
		 * 2) Qual o inteiro, entre 1 e 10000, com o maior n�mero de divisores e
		 * quantos divisores este inteiro tem? Escreva um programa para
		 * encontrar esta resposta e exibir o resultado. Considere poss�vel a
		 * exist�ncia de v�rios inteiros com as caracter�sticas esperadas ou
		 * seja, com o mesmo n�mero de divisores. O seu programa deve apresentar
		 * apenas um deles. A id�ia b�sica do algoritmo � avaliar todos os
		 * inteiros na faixa, guardando o inteiro encontrado com a maior
		 * quantidade de divisores e a quantidade de divisores.
		 */

		int numero = 0, cont = 0, maior = 0;

		for (int i = 1; i <= 10000; i++) {
			cont = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					cont++;
				}
			}
			if (cont >= maior) {
				maior = cont;
				numero = i;
			}
		}

		System.out.println("O n�mero que tem mais divisores inteiros entre 1 e 10000 � "
							+ numero + " e a quantidade de divisores � " + maior);

	}

}
