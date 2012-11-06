package br.fbv.rcbop;
import java.util.Scanner;

public class Exercicio004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int tamanho;
		System.out.println("Qual o tamanho da matriz quadratica?");
		tamanho = console.nextInt();
		int[][] matriz = new int[tamanho][tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				System.out.println("Digite o elemento [" + (i+1) + "][" + (j+1) + "] da matriz");
				matriz[i][j] = console.nextInt();
			}
		}
		
		System.out.println("A soma da diagonal secundaria eh " + sumDiag(matriz));

	}
	
	
	public static int sumDiag( int[][] array){ 

		int soma = 0;
		int tamanho = array.length;
		
		for (int i = 0; i < tamanho; i++) {
			soma += array[i][(tamanho -1) -i];	
		}
		
		return soma;
	}

}