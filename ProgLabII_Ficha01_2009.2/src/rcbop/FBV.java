package rcbop;

public class FBV {

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