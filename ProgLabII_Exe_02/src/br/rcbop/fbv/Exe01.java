package br.rcbop.fbv;

import java.util.Scanner;

public class Exe01 {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Digite um número inteiro: ");
		int inputInt = console.nextInt();
		System.out.print("O respectivo número de Fibonacci é: " + fibbonacci(inputInt));
	}
	
	public static int fibbonacci(int n){
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		default:
			return (fibbonacci(n-1) + fibbonacci(n-2));
		}
	}
}
