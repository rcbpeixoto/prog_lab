package simulado;

public class ManipulacaoStr {


	public void qtdCaracter(String texto){
		int vQtde = 0;
		String textoI = "", textoJ = "",vTexto=texto;
		int i = texto.length();
		
		
		while (i > 0){
			vQtde = 0;			
			textoI = texto.substring(0,1).toUpperCase();						
			for (int j = 0; j < vTexto.length(); j++) {
				textoJ = vTexto.substring(j,(j+1)).toUpperCase();
				if (textoI.equalsIgnoreCase(textoJ)){
					vQtde++;
				}
			}			
			vTexto = removeMask(texto, textoI);
			texto = vTexto;
			i = texto.length();
			System.out.println(textoI+" -> "+vQtde);			
		}
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
	
	public String inverterStr(String texto){
		int i = texto.length();
		String vTexto = "";
		while (i > 0){
			vTexto += texto.substring((i-1),i);
			i--;
		}
		return vTexto;
		
		
	}
	
	public String[] quebraStr(String vTexto, String vMask){		
		String nTexto[] = new String[vTexto.length()];
		
		for (int i = 0; i < vTexto.length(); i++) {			
			for (int j = 0; j < vMask.length(); j++) {								
				if (vTexto.substring(i,(i+1)).equalsIgnoreCase(vMask.substring(j,(j+1)))){
					nTexto[i] += vTexto.substring(i,(i+1));
					j = vMask.length();
				}
			}
		}
			
		return nTexto;
	}
	
}
