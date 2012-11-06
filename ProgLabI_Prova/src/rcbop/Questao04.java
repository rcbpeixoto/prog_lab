package rcbop;

public class Questao04 {
		public static void main(String[] args) {

			double vet[] = new double[5];
			double menor = 0;
			
			for (int i = 0; i < vet.length; i++) {
				System.out.println("Digite o num da posi "+(i+1));
				vet[i] = FBV.Leia(vet[i]);
			}
			menor = vet[0];
			
			for (int i = 1; i < vet.length; i++) {
				if (menor > vet[i]){
					menor = vet[i];
				}
			}
			System.out.println("O menor num digitado � "+menor);
		}
	}