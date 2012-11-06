package rcbop;

public class Questao02_Prova {
	public static void main(String[] args) {
		
		String nome = "";
		int peso = 0, idade = 0, n = 0, i = 0;
		
		System.out.println("Digite o n�mero de pessoas: ");
		n = FBV.Leia( n);
		
		while ( i < n){
			System.out.println("Digite o nome: ");
			nome = FBV.Leia(nome);
			System.out.println("Digite o peso: ");
			peso = FBV.Leia(peso);
			System.out.println("Digite a idade: ");
			idade = FBV.Leia(idade);
			if ( ( idade >= 20) && (idade <= 30)){
				System.out.println(nome);
			}
			if (peso < 65){
				System.out.println(idade);
				System.out.println(peso);
			}
			i++;
		}
		

	}

}
