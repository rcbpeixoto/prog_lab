package aula1;

public class Exercicio2 {
	public static void main(String[] args) {
		String resultado = "", nome = "";
		nome = FBV.Leia(nome);
		
		for (int i = 1; i <= 9; i++) {
			for (int ii = 0; ii < nome.length(); ii++) {
				if (resultado.equalsIgnoreCase("")){
					resultado = DesenhaTexto(nome.substring(ii,ii+1),i);
				} else {
					resultado = resultado +"  "+ DesenhaTexto(nome.substring(ii,ii+1),i);
				}
			}
			
			System.out.println(resultado);
			resultado = "";
		}
		
	}
	public static boolean VerificaLetra(String vLetra, String vTexto){		
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
	public static String DesenhaTexto(String vTexto, int vLinha){		
		switch (vLinha) {
			case 1: //
				if (VerificaLetra(vTexto.toUpperCase(),"ACEFGJOPQRSTZ") == true) {
					return "**********";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"BD") == true){			
					return "******    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"KHVUXYW") == true){
					return "**      **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"M") == true){
					return "****  ****";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true){
					return "****    **";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"L") == true){
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"I") == true){
					return "    **    ";					
				}
			case 2: 
				if (VerificaLetra(vTexto.toUpperCase(),"AHOPQRUKW") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFGLS") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"JTI") == true) {
					return "    **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"XY") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "*        *";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"M") == true) {
					return "****  ****";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"BD") == true) {
					return "**    **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "****    **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "        **";
				}
			case 3: 
				if (VerificaLetra(vTexto.toUpperCase(),"AHOPQRUW") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFGLS") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"JTI") == true) {
					return "    **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"XY") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "*        *";
				} else if (VerificaLetra(vTexto.toUpperCase(),"BK") == true) {			
					return "**      **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"M") == true) {
					return "** *  * **";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "**     ** ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "** **   **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "       ** ";
				}
			case 4: 
				if (VerificaLetra(vTexto.toUpperCase(),"AHOPQRUW") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFGLS") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"JTI") == true) {
					return "    **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"XY") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "*        *";
				} else if (VerificaLetra(vTexto.toUpperCase(),"M") == true) {
					return "** *  * **";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "**     ** ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"BK") == true) {
					return "**    **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "** **   **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "      **  ";
				}
			case 5: 
				if (VerificaLetra(vTexto.toUpperCase(),"AEFHPRS") == true) {
					return "**********";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"DOQUW") == true) {			
					return "**      **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"G") == true) {			
					return "**    ****";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"CL") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"JTI") == true) {
					return "    **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"BK") == true) {
					return "******    ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"XY") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "*        *";
				} else if (VerificaLetra(vTexto.toUpperCase(),"M") == true) {
					return "**  **  **";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "**     ** ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "******    ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "**  **  **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "     **   ";
				}
			case 6: 
				if (VerificaLetra(vTexto.toUpperCase(),"AGHMOQUW") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFLP") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"J") == true) {
					return "**  **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"TIY") == true) {
					return "    **    ";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"X") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return " *      * ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "**     ** ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"BK") == true) {
					return "**    **  ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "**  **  **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"R") == true) {
					return "****      ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"S") == true) {
					return "        **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "    **    ";
				}
			case 7: 
				if (VerificaLetra(vTexto.toUpperCase(),"AGHMOU") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFPL") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"J") == true) {
					return "**  **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"TYI") == true) {
					return "    **    ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"X") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "  *    *  ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"BK") == true) {			
					return "**      **";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"R") == true) {
					return "**  **    ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"D") == true) {
					return "**     ** ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Q") == true) {
					return "** **   **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "**   ** **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"W") == true) {
					return "**  **  **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"S") == true) {
					return "        **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"Z") == true) {
					return "  **      ";
				}
			case 8: 
				if (VerificaLetra(vTexto.toUpperCase(),"AGHMOUK") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEFPLZ") == true) {			
					return "**        ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"J") == true) {
					return "**  **    ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"TIY") == true) {
					return "    **    ";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"X") == true) {
					return "  **  **  ";
				} else if (VerificaLetra(vTexto.toUpperCase(),"V") == true) {
					return "   *  *   ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"BDR") == true) {
					return "**    **  ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"Q") == true) {
					return "***     **";
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "**    ****";
				} else if (VerificaLetra(vTexto.toUpperCase(),"W") == true) {
					return " *  **  * ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"S") == true) {
					return "        **";					
				}
			case 9: 
				if (VerificaLetra(vTexto.toUpperCase(),"AHMRXK") == true) {
					return "**      **";				
				} else if (VerificaLetra(vTexto.toUpperCase(),"CEGLOQSUZ") == true) {			
					return "**********";
				} else if (VerificaLetra(vTexto.toUpperCase(),"PF") == true) {			
					return "**        ";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"DJB") == true) {
					return "******    ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"TIVY") == true) {
					return "    **    ";	
				} else if (VerificaLetra(vTexto.toUpperCase(),"W") == true) {
					return "  * ** *  ";					
				} else if (VerificaLetra(vTexto.toUpperCase(),"N") == true) {
					return "**    ****";
				}
	}
		return "";		
	} 

}
