package aula1;

public class Exercicio5 {
	public static void main(String[] args) {
		int numeros[] = new int[10];
		int resultado = 0;
		
		numeros[0] = 3;
		numeros[1] = 5;
		for (int i = 2; i < 10; i++) {
			numeros[i] = numeros[i-2] + numeros[i-1];
		}
		while (resultado < 1 || resultado > 10){
			System.out.print("Diga a posi��o do n�mero: ");
			resultado = FBV.Leia(resultado);
		}
		System.out.print("O numero da Posi��o "+resultado+" � "+numeros[resultado-1]);
		
	}

}
