package br.fbv.rcbop;
import java.util.Scanner;

public class Exercicio003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int quantidade = 0;
		System.out.println("Quantos numeros serao digitados?");
		quantidade = console.nextInt();
		int[] conjNumeros = new int[quantidade];
		
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite o numero e pressione enter ("+(i+1)+"/"+quantidade+")");
			conjNumeros[i] = console.nextInt();
		}
		
		System.out.println("O maior numero eh " + maior(conjNumeros));

	}
	
	
	public static int maior( int[] array){
		
		int maior = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		
		return maior;
		
	}

}