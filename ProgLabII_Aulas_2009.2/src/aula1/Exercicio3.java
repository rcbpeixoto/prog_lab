package aula1;

public class Exercicio3 {
	public static void main(String[] args) {
		int dado1 = 0, dado2 = 0, resultado = 0;
		dado1 = (int)(Math.random() * 6) + 1;
		dado2 = (int)(Math.random() * 6) + 1;
		resultado = dado1 + dado2;
		System.out.println("Primeiro Dado � : "+dado1);
		System.out.println("Seguindo Dado � : "+dado2);
		System.out.println("Soma dos Resultados � : "+resultado);

	}

}
