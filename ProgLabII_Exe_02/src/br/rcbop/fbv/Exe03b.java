package br.rcbop.fbv;

import java.util.Scanner;

public class Exe03b {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int input = console.nextInt();
		
		System.out.println("O valor do número " + input + " na série triangular é: " + triangularNumber(input));
	}
	
	public static int triangularNumber(int number){
		switch (number) {
		case 1:
			return 1;
		default:
			return number + triangularNumber(number - 1); 
		}
	}
}
