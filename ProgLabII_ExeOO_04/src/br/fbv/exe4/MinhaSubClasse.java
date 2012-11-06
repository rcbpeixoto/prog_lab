package br.fbv.exe4;

public class MinhaSubClasse extends MinhaClasse {

	public MinhaSubClasse(int j) {
		super(j);
	}
	
	@Override
	public void meuMetodo(int i) {
		super.meuMetodo(i);
		System.out.println("meu valor ao quadrado é: " + Math.pow(i, 2));
	}
	
	public void meuMetodo2(int i2){
		System.out.println("SAI MULHEQUE: " + i2);
	}
	
	public static void main(String[] args) {
		MinhaClasse a = new MinhaSubClasse(15);
		a.meuMetodo(5);
		if (a instanceof MinhaSubClasse) {
			System.out.println("EU SOU SUBCLASSE");
		}
		((MinhaSubClasse) a).meuMetodo2(110);
	}

}
