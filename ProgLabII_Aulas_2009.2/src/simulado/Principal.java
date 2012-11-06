package simulado;

public class Principal {

	/**
	 * DECO MELO FBV 2009
	 */
	public static void main(String[] args) {
		ManipulacaoStr mani = new ManipulacaoStr();
		final String mask = "ABCDEFGHIJKLMNOPQRSTUVXZWY";
		final String texto = "DECO: 'TESTE MELO'";		
		String vetor[] = new String[texto.length()];
		
		System.out.println("1�)");
		mani.qtdCaracter("Paralelep�pedo");
		System.out.println("-------");
		System.out.println("2�)");
		System.out.println(mani.inverterStr("DECO"));
		System.out.println("-------");
		System.out.println("3�)");
		vetor = mani.quebraStr(texto, mask);
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		

	}

}
