package br.fbv.rcbop;
import java.util.Scanner;


public class Exercicio001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numero = 0;
		System.out.println("Digite o numero");
		numero = console.nextInt();
		
		if(par(numero)){
			System.out.println("O Numero Informado � PAR");
			
		} else {
			System.out.println("O Numero Informado � IMPAR");
		}

	}
	
	
	public static boolean par(int numero){
		
		if(numero % 2 == 0){
			return true;
		} else{
			return false;
		}
		
	}

}
