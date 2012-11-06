package aula3;

public class Exercicio4 {
	public static void main(String[] args) {	
		
		System.out.println("Total   M�dia");
		System.out.println("======  ========");
		for (int i = 2; i <= 12; i++) {
			if (i < 10){
				System.out.println("  0"+i+"    "+mediaDados(i));
			} else {
				System.out.println("  "+i+"    "+mediaDados(i));
			}
		}
	}
	
	public static double mediaDados(int vNum){
		int dado1 = 0, dado2 = 0, vResult = 0;
		final int qtde = 10000;		
		double result = 0.0, resultado = 0.0;
		for (int i = 0; i < qtde; i++) {
			do {
				dado1 = (int)(Math.random() * 6) + 1;
				dado2 = (int)(Math.random() * 6) + 1;
				resultado++;
				vResult = dado1 + dado2;
			} while (vNum != vResult);		
		}
		result = resultado / qtde;
		return result ;
	}
	
	
	 

}
