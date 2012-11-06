package rcbop;

public class Exercicio02 {

	public static void main(String[] args) {

		String nome[] = new String[1];
		String array1[] = new String[9];
		String array2[] = new String[9];

		for (int i = 0; i < nome.length; i++) {
			System.out.println("Digite a " + (i + 1)
					+ "� letra da sa�da padr�o: ");
			nome[i] = FBV.Leia(nome[i]);
		}

		for (int i = 0; i < nome.length; i++) {

			if (nome[i].equalsIgnoreCase("A")
					|| nome[i].equalsIgnoreCase("C") // LINHA HORIZONTAL
					// SUPERIOR
					|| nome[i].equalsIgnoreCase("E")
					|| nome[i].equalsIgnoreCase("F")
					|| nome[i].equalsIgnoreCase("G")
					|| nome[i].equalsIgnoreCase("J")
					|| nome[i].equalsIgnoreCase("O")
					|| nome[i].equalsIgnoreCase("P")
					|| nome[i].equalsIgnoreCase("Q")
					|| nome[i].equalsIgnoreCase("R")
					|| nome[i].equalsIgnoreCase("S")
					|| nome[i].equalsIgnoreCase("T")
					|| nome[i].equalsIgnoreCase("Z")
					|| nome[i].equalsIgnoreCase("2")
					|| nome[i].equalsIgnoreCase("3")
					|| nome[i].equalsIgnoreCase("5")
					|| nome[i].equalsIgnoreCase("6")
					|| nome[i].equalsIgnoreCase("7")
					|| nome[i].equalsIgnoreCase("8")
					|| nome[i].equalsIgnoreCase("9")
					|| nome[i].equalsIgnoreCase("0")) {

				System.out.println("*********");
			}

			if (nome[i].equalsIgnoreCase("A")
					|| nome[i].equalsIgnoreCase("B") // LINHA VERTICAL SUPERIOR
					// ESQUERDA
					|| nome[i].equalsIgnoreCase("C")
					|| nome[i].equalsIgnoreCase("E")
					|| nome[i].equalsIgnoreCase("F")
					|| nome[i].equalsIgnoreCase("G")
					|| nome[i].equalsIgnoreCase("H")
					|| nome[i].equalsIgnoreCase("I")
					|| nome[i].equalsIgnoreCase("J")
					|| nome[i].equalsIgnoreCase("K")
					|| nome[i].equalsIgnoreCase("L")
					|| nome[i].equalsIgnoreCase("M")
					|| nome[i].equalsIgnoreCase("N")
					|| nome[i].equalsIgnoreCase("P")
					|| nome[i].equalsIgnoreCase("Q")
					|| nome[i].equalsIgnoreCase("R")
					|| nome[i].equalsIgnoreCase("S")
					|| nome[i].equalsIgnoreCase("U")
					|| nome[i].equalsIgnoreCase("V")
					|| nome[i].equalsIgnoreCase("1")
					|| nome[i].equalsIgnoreCase("2")
					|| nome[i].equalsIgnoreCase("4")
					|| nome[i].equalsIgnoreCase("5")
					|| nome[i].equalsIgnoreCase("6")
					|| nome[i].equalsIgnoreCase("8")
					|| nome[i].equalsIgnoreCase("9")
					|| nome[i].equalsIgnoreCase("0")) {

				for (int j = 1; j < (array2.length) / 2; j++) {
					array2[0] = "*/n";
				}

			}

			if (nome[i].equalsIgnoreCase("A")
					|| nome[i].equalsIgnoreCase("B") // LINHA VERTICAL INFERIOR
					// ESQUERDA
					|| nome[i].equalsIgnoreCase("C")
					|| nome[i].equalsIgnoreCase("D")
					|| nome[i].equalsIgnoreCase("E")
					|| nome[i].equalsIgnoreCase("F")
					|| nome[i].equalsIgnoreCase("G")
					|| nome[i].equalsIgnoreCase("H")
					|| nome[i].equalsIgnoreCase("I")
					|| nome[i].equalsIgnoreCase("J")
					|| nome[i].equalsIgnoreCase("K")
					|| nome[i].equalsIgnoreCase("L")
					|| nome[i].equalsIgnoreCase("M")
					|| nome[i].equalsIgnoreCase("N")
					|| nome[i].equalsIgnoreCase("O")
					|| nome[i].equalsIgnoreCase("P")
					|| nome[i].equalsIgnoreCase("Q")
					|| nome[i].equalsIgnoreCase("R")
					|| nome[i].equalsIgnoreCase("V")
					|| nome[i].equalsIgnoreCase("1")
					|| nome[i].equalsIgnoreCase("2")
					|| nome[i].equalsIgnoreCase("6")
					|| nome[i].equalsIgnoreCase("8")
					|| nome[i].equalsIgnoreCase("0")) {

				for (int j = (array2.length / 2); j < array2.length; j++) {
					array2[0] = "*/n";
				}

				if (nome[i].equalsIgnoreCase("A")
						|| nome[i].equalsIgnoreCase("B") // LINHA CENTRAL
						|| nome[i].equalsIgnoreCase("C")
						|| nome[i].equalsIgnoreCase("D")
						|| nome[i].equalsIgnoreCase("E")
						|| nome[i].equalsIgnoreCase("F")
						|| nome[i].equalsIgnoreCase("H")
						|| nome[i].equalsIgnoreCase("I")
						|| nome[i].equalsIgnoreCase("J")
						|| nome[i].equalsIgnoreCase("K")
						|| nome[i].equalsIgnoreCase("L")
						|| nome[i].equalsIgnoreCase("M")
						|| nome[i].equalsIgnoreCase("N")
						|| nome[i].equalsIgnoreCase("O")
						|| nome[i].equalsIgnoreCase("P")
						|| nome[i].equalsIgnoreCase("Q")
						|| nome[i].equalsIgnoreCase("R")
						|| nome[i].equalsIgnoreCase("V")
						|| nome[i].equalsIgnoreCase("1")
						|| nome[i].equalsIgnoreCase("2")
						|| nome[i].equalsIgnoreCase("6")
						|| nome[i].equalsIgnoreCase("8")
						|| nome[i].equalsIgnoreCase("0")) {

					for (int j = (array2.length / 2); j < array2.length; j++) {
						array2[0] = "*/n";
					}

				}
			}

		}

	}

	public static String[] agrupar(String array1[], String array2[]) {

		String saida[] = new String[9];

		for (int i = 0; i < array1.length; i++) {
			if (array1[i].equalsIgnoreCase("**")
					|| array2[i].equalsIgnoreCase("**")) {
				saida[i] = "**";
			}

			else {
				saida[i] = " ";
			}
		}

		return saida;

	}

}
