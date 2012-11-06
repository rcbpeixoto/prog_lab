package aula1;

public class Exercicio4 {
	public static void main(String[] args) {
		int numeros[] = new int[10];
		
		numeros[0] = 3;
		numeros[1] = 5;
		for (int i = 2; i < 10; i++) {
			numeros[i] = numeros[i-2] + numeros[i-1];
		}
		System.out.print("N�meros: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i]+" ");
		}
		
	}

}
