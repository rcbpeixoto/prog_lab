package aula3;

public class FBV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nota1, nota2, media;
		nota1 = 0;
		nota2 = 0;
		System.out.println("Digite a Primeira nota :");
		nota1 = Leia(nota1);
		System.out.println("Digite a Segunda nota :");
		nota2 = Leia(nota2);
		media = (nota1 + nota2) / 2;
		System.out.println("M�dia � :"+media);

		
	}
	public static double Leia(double param) { 
		// vari�veis 

		// objeto que cont�m o dado digitado pelo usu�rio 
		java.io.DataInputStream dado_lido; 

		// variavel auxiliar cujo objetivo � facilitar 
		// a conversao dos dados 
		String stemporario; 
		double resultado = 0; 

		try { 
		dado_lido = new java.io.DataInputStream(System.in); 
		stemporario = dado_lido.readLine(); 
		resultado =Double.parseDouble(stemporario); 
		}catch (Exception e) { } 
		return resultado; 
		} 


		public static int Leia(int param) { 

		// vari�veis 

		// objeto que cont�m o dado digitado pelo usu�rio 
		java.io.DataInputStream dado_lido; 

		// variavel auxiliar cujo objetivo � facilitar 
		// a conversao dos dados 
		String stemporario; 
		int resultado = 0; 

		try { 
		dado_lido = new java.io.DataInputStream(System.in); 
		stemporario = dado_lido.readLine(); 
		resultado =Integer.parseInt(stemporario);
		}catch (Exception e) { } 
		return resultado; 
		} 


		public static String Leia(String param) { 

		// vari�veis 

		// objeto que cont�m o dado digitado pelo usu�rio 
		java.io.DataInputStream dado_lido; 

		// variavel auxiliar cujo objetivo � facilitar 
		// a conversao dos dados 
		String stemporario=""; 

		try { 
		dado_lido = new java.io.DataInputStream(System.in); 
		stemporario = dado_lido.readLine(); 
		}catch (Exception e) { } 
		return stemporario; 
		} 

}
