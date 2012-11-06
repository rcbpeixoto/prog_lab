package aula2;

public class Exercicio2 {
	public static void main(String[] args) {
		int vQtde2 = 0, vNum = 0, vQtde = 0;
		
		for (int i = 1; i <= 10000; i++) {
		 vQtde = 0;		
		 for (int j = 1; j <= 10000; j++) {
			 if (i%j == 0) {
				 vQtde++;
			 }	
		 }
		 if (vQtde >= vQtde2){
		  vQtde2 = vQtde;
		  vNum = i;
		 }
		}
		
		System.out.println(vNum);
		System.out.println(vQtde2);
		
	}
	
	
	 

}
