package aula2;

public class Exercicio4 {
	public static void main(String[] args) {
		String vTexto = "";
		
		System.out.print("Digite a Palavra : ");
		vTexto = FBV.Leia(vTexto);
		vTexto = removeMask(vTexto, "*-?,;<>\"\\:+./^]['�`()");
		System.out.println("Resultado: ");
		System.out.println(vTexto);		
	}
	
	public static String removeMask(String vTexto, String vMask){		
		int vQtde = 0;
		String nTexto = "";
		
		for (int i = 0; i < vTexto.length(); i++) {			
			for (int j = 0; j < vMask.length(); j++) {								
				if (vTexto.substring(i,(i+1)).equalsIgnoreCase(vMask.substring(j,(j+1)))){
					vQtde++;										 
				}				
			} 
			if (vQtde == 0){		
				if (vTexto.substring(i,(i+1)).equalsIgnoreCase(" ")){
					nTexto +="\n";	
				}else {
					nTexto += vTexto.substring(i,(i+1));
				}
			}
			vQtde = 0;
		}
		return nTexto;
		
	}

}
