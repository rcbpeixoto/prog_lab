package rcbop;

public class Exercicio03 {
	public static void main(String[] args) {

		/*1)Escreva um programa que simula o lan�amento de um par de dados.
		 *  A simula��o de um dado pode ser efetuada escolhendo um dos 
		 *  inteiros 1, 2, 3, 4, 5 e 6 aleatoriamente. O n�mero escolhido 
		 *  representa o n�mero apresentado no dado ap�s o lan�amento. 
		 *  Utilize a express�o abaixo para obter um valor aleat�rio 
		 *  entre 1 e 6 (lembrar de importar a classe Math):

			(int) (Math.random() * 6) + 1 
			
			Utilize a express�o acima duas vezes e atribua a duas vari�veis para obter os valores de cada 
			lan�amento. O resultado dos dois lan�amentos deve ser armazenado em outra vari�vel. 
			A sa�da do programa deve ser algo do tipo:
			O primeiro lan�amento retornou '5'
			O segundo lan�amento retornou '2'
			O total dos lan�amentos foi de '7'
		 */
		
		int a = 0 , b = 0;
		
		a = (int) ((Math.random() * 6) + 1); 
		
		System.out.println("O primeiro lan�amento retornou ' "+a+" '");
		
		b = (int) ((Math.random() * 6) + 1); 
		
		System.out.println("O segundo lan�amento retornou ' "+b+" '");
		
		System.out.println("O total de lan�amentos foi de ' "+(a+b)+" '");
		
	}

}
