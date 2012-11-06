package simulado;

public class ExercicioSala {
	public static void main(String[] args) {
		int vetor[] = new int[6];
		String vetor1[] = new String[6];
		int qtd = 0, qtde=0;
		
		
		vetor[0] = 0;
		vetor[1] = 0;
		vetor[2] = 2;
		vetor[3] = 1;
		vetor[4] = 2;
		vetor[5] = 0;
		
		
		
		
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if(vetor[i] == vetor[j]){
					qtd++;
				}
			}
		vetor1[i] = "N�mero "+vetor[i]+" = "+qtd;
		qtd = 0;		
		
		}
		for (int j = 0; j < vetor1.length; j++) {
			for (int k = 0; k < vetor1.length; k++) {
				if(vetor1[j].equalsIgnoreCase(vetor1[k])){
					qtde++;
				}
				if (qtde >= 2){
					vetor1[j] = "";
				}
			}
			
			if (qtde == 1){
				System.out.println(vetor1[j]);
			} else {
				if (vetor1[j].equalsIgnoreCase("")){}
				else{
					System.out.println(vetor1[j]);
				}
				vetor1[j] = "";
			}
			qtde = 0;			
		}
	}
	

}