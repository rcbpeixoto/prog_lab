package aula2;

public class Exercicio3 {
	public static void main(String[] args) {		
		String expressao = "";
		double vResultado = 0.0;
		int verifica = -1;
		
		while (verifica != 0) {
			System.out.print("Digite a express�o: ");
			expressao = FBV.Leia(expressao);
			if (expressao.equalsIgnoreCase("0")){				
				verifica = Integer.parseInt(expressao);
			} else {
				expressao = expressao.toUpperCase();
				if (verificaExpressao(expressao,"ABCDEFGHIJKLMNOPQRSTUVXZW\\Y\"[];:,") == false){ 
					vResultado = verificaOperador(expressao, "+-*/");
					System.out.println("Resultado: "+vResultado);
				} else {
					System.out.println("Express�o invalida!");					
				}
			}
		}
		System.out.println("Fim!");

	}
	
	public static boolean verificaExpressao(String vExpressao, String vTexto){		
		int vQtde = 0;	//012	
		
		for (int i = 0; i < vExpressao.length(); i++) {
			for (int j = 0; j < vTexto.length(); j++) {
				if (vExpressao.substring(0,1).indexOf('+') == 0) {
					vQtde++;
				} else if (vExpressao.substring(0,1).indexOf('-') == 0) {
					vQtde++;
				} else if (vExpressao.substring(0,1).indexOf('*') == 0) {
					vQtde++;
				} else if (vExpressao.substring(0,1).indexOf('/') == 0) {
					vQtde++;
				} else if (vExpressao.substring(0,1).indexOf('.') == 0) {
					vQtde++;
				}
				//Verifica a ultima posi��o				
				if (vExpressao.substring(vExpressao.length()-1,vExpressao.length()).indexOf('+') == 0) {
					vQtde++;
				} else if (vExpressao.substring(vExpressao.length()-1,vExpressao.length()).indexOf('-') == 0) {
					vQtde++;
				} else if (vExpressao.substring(vExpressao.length()-1,vExpressao.length()).indexOf('*') == 0) {
					vQtde++;
				} else if (vExpressao.substring(vExpressao.length()-1,vExpressao.length()).indexOf('/') == 0) {
					vQtde++;
				} else if (vExpressao.substring(vExpressao.length()-1,vExpressao.length()).indexOf('.') == 0) {
					vQtde++;
				}
				if (vExpressao.substring(i, (i+1)).indexOf(vTexto.substring(j, (j+1))) == 0){
					vQtde++;
				}
			}	
		}
		
		if (vQtde > 0){
			return true;
		} else {
			return false;
		}
		
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

	public static double verificaOperador(String vExpressao, String vOperador){		
		double vSoma = 0.0;
		double num1 = 0.0;
		String vNum1 = "", vLetra = "";
		char nOperador = 0;
		//                     1+2
		//Percorre o Texto Digitado
		for (int i = 0; i < vExpressao.length(); i++) {
			//Verifica se o Carectere I (Texto) � igual ao Carectere J (Carecteres)
			vLetra = vExpressao.substring(i,(i+1));
			if (verificaLetra(vLetra,vOperador) == false){
				vNum1 += vExpressao.substring(i,(i+1));
				//System.out.println("i = "+i+" = "+vNum1);
			} else {
				num1 = Double.parseDouble(vNum1);
				vNum1= "";
				//System.out.println("i = "+i+" = "+num1);
				if (vSoma == 0) {
					//System.out.println(vSoma +" "+ nOperador+"  "+num1);
					vSoma = num1;
				} else {
					//System.out.println(vSoma +" "+ nOperador+"  "+num1);
					switch (nOperador) {			
					case '+': vSoma = vSoma + num1;		
						break;
					case '-': vSoma = vSoma - num1;		
						break;
					case '*': vSoma = vSoma * num1;		
						break;
					case '/': vSoma = vSoma / num1;		
						break;
					default: vSoma = num1;
				    	break;
					}
				}
				if ( vExpressao.substring(i,(i+1)).equalsIgnoreCase("+")){
					nOperador = '+';
				} else if ( vExpressao.substring(i,(i+1)).equalsIgnoreCase("-")){
					nOperador = '-';
				} else if ( vExpressao.substring(i,(i+1)).equalsIgnoreCase("*")){
					nOperador = '*';
				} else if ( vExpressao.substring(i,(i+1)).equalsIgnoreCase("/")){
					nOperador = '/';
				}
			}
		}	
		num1 = Double.parseDouble(vNum1);
		//System.out.println(vSoma +" "+ nOperador+"  "+num1);
		switch (nOperador) {			
		case '+': vSoma = vSoma + num1;		
			break;
		case '-': vSoma = vSoma - num1;		
			break;
		case '*': vSoma = vSoma * num1;		
			break;
		case '/': vSoma = vSoma / num1;		
			break;
		default: vSoma = num1;
		    break;				   
		}			
		// Retorna o Valor da String sem os caracteres
		return vSoma;
		
	}	

	public static double VerificaLetra(String vLetra, String vTexto){		
		double vQtde = 0;//		1.5+2
		
		for (int i = 0; i < vTexto.length(); i++) {
			if (vTexto.substring(i, (i+1)).equalsIgnoreCase("+")){
				
			}else {vQtde = 0;}
		}		
		if (vQtde > 0){
			return 0;
		} else {
			return 0;
		}		
	}

}
