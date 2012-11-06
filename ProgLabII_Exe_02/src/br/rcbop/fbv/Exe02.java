package br.rcbop.fbv;

import java.util.Scanner;


public class Exe02 {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Digite a base: ");
		double base = console.nextDouble();
		System.out.print("Digite a expoente: ");
		int exp = console.nextInt();
		
		System.out.printf("O resultado da potência é: %1$.0f", pow(base, exp));
	}
	
	public static double pow(double base, int exp){
		switch (exp) {
		case 0:
			return 1;
		case 1:
			return base;
		default:
			return base*pow(base, exp-1);
		}
	}
}
