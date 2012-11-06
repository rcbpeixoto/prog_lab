package aula3;

public class Exercicio1 {
	public static void main(String[] args) {
		String vTexto = "";
		
		System.out.print("Digite o texto: ");		
		vTexto = FBV.Leia(vTexto);
		System.out.println(printCapitalized(vTexto));
	}
	
	public static String printCapitalized(String vTexto){
		String nTexto = "";
		int pos = 0;
		for (int i = 0; i < vTexto.length(); i++) {
			if (pos == 0){
				nTexto += vTexto.substring(i, i+1).toUpperCase();
				
			} else {
				nTexto += vTexto.substring(i, i+1);				
			}
			pos++;
			if (vTexto.substring(i, i+1).equalsIgnoreCase(" ")){
				pos = 0;
			}			
		}
		return nTexto;
	}

}
