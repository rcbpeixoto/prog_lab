package aula3;

public class Exercicio2 {
	public static void main(String[] args) {
		String vTexto = "";
		
		System.out.print("Digite o texto: ");
		vTexto = FBV.Leia(vTexto);
		if (validaHexa(vTexto) == false){
			System.out.println(convertHexa(vTexto));
		} else {
			System.out.println("N�o � um Hexadecimal V�lido!");
		}
	}	
	
	public static boolean validaHexa(String vHexadecimal){		
		int vQtde = 0;		
		String vLetra = "", vMask = "0123456789ABCDEF";
		
		vHexadecimal = vHexadecimal.toUpperCase();
		for (int i = 0; i < vHexadecimal.length(); i++) {
			for (int j = 0; j < vMask.length(); j++) {
				vLetra = vHexadecimal.substring(i, (i+1));
				//System.out.println(vLetra);
				if (vLetra.indexOf(vMask.substring(j, (j+1))) == 0){
					vQtde++;
				}
			}			
		}		
		
		if (vQtde == vHexadecimal.length()){
			return false;
		} else {
			return true;
		}		
	}
	
	public static String convertHexa(String vHexadecimal){		
		int vValor = 0, vPow = 0;		
		String vLetra = "", vMask = "ABCDEF";
		
		
		
		vPow = vHexadecimal.length()-1;
		for (int i = 0; i < vHexadecimal.length(); i++) {
			vLetra = vHexadecimal.substring(i,(i+1)).toUpperCase();
			
			if (verificaLetra(vLetra,vMask)){
				if(vLetra.equalsIgnoreCase("A")){
					vLetra = "10";
				} else if(vLetra.equalsIgnoreCase("B")){
					vLetra = "11";
				} else if(vLetra.equalsIgnoreCase("C")){
						vLetra = "12";
				} else if(vLetra.equalsIgnoreCase("D")){
						vLetra = "13";
				} else if(vLetra.equalsIgnoreCase("E")){
						vLetra = "14";
				} else if(vLetra.equalsIgnoreCase("F")){
						vLetra = "15";
				}					
			}		
			vValor +=  Integer.parseInt(vLetra) * (int) Math.pow(16, vPow);
			vPow--;
		}
		return vValor+"";		
	

	}
	
	public static boolean verificaLetra(String vLetra, String vTexto){		
		int vQtde = 0;		
		
		for (int i = 0; i < vTexto.length(); i++) {
			if (vLetra.indexOf(vTexto.substring(i, (i+1))) == 0){
				vQtde++;
			}
		}
		
		if (vQtde > 0){
			return true;
		} else {
			return false;
		}
	}
	
}
