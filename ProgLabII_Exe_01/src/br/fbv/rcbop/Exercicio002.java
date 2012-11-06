package br.fbv.rcbop;
import java.util.Scanner;

public class Exercicio002 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numero = 0;
		System.out.println("Digite o numero");
		numero = console.nextInt();
		
		if(primo(numero)){
			System.out.println("O Numero Informado � PRIMO");
			
		} else {
			System.out.println("O Numero Informado � COMPOSTO");
		}

	}
	
	
	public static boolean primo(int numero){
		
		int temp = 2;
		boolean ehPrimo = true;
		
		while (ehPrimo && temp <= (numero / 2)) {
			
			for (temp = 2; temp <= (numero / 2) ; temp++) {
				if (numero % temp == 0) {
					ehPrimo = false;
				}
			}

		}
			
		return ehPrimo;
		
	}

}