package rcbop;

public class Exercicio05 {
	public static void main(String[] args) {

	/* 1)Escreva um outro programa (utilizando o c�digo do exerc�cio anterior) 
	* para imprimir o n�mero da sequ�ncia de Fibonnaci de acordo com a 
	* entrada do usu�rio. Abaixo temos um exemplo da sa�da esperada:
	* Entre a posi��o da sequ�ncia de Fibonnaci: [4]
	* O n�mero na posi��o [4] da sequ�ncia de Fibonnaci � '5'
	*/
		
		int sequen[] = new int[9];
		int num = 0;
		
		System.out.println("Digite o n�mero: ");
		num = FBV.Leia(num);
		
		for (int i = 0; i < sequen.length; i++) {
			
			sequen[i] = num;
			
			if ( i > 0 )
			{
			sequen[i] = (num+1);
			}
			
			if ( i > 1)
			{
			sequen[i] = (sequen[i-2] + sequen[i-1]) ;
			}
			
		}
		
	System.out.println(sequen[0]+" "+sequen[1]+" "+sequen[2]+" "+sequen[3]+" "+sequen[4]+" "+sequen[5]+" "+sequen[6]);
		
	}
		
		
}


