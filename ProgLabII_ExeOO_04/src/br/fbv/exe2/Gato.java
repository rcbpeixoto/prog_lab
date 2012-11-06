package br.fbv.exe2;

public class Gato extends Animal {

	private boolean isVacinado;
	private String descricao;

	public Gato() {
	}

	public boolean isVacinado() {
		return isVacinado;
	}

	public void setVacinado(boolean isVacinado) {
		this.isVacinado = isVacinado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "Dono: " + getDono() + "dataNasc: " + getDataNascimento()
				+ " dataVasc: " + getDataVascinacao() + " isVacinado: "
				+ isVacinado + " Descricao: " + descricao;
	}

	public static void main(String[] args) {
		Animal a = new Gato();
		a.setDono("JOPA");
		a.setDataVascinacao("24/08/1900");
		a.setDataNascimento("30/03/1530");
		((Gato) a).setDescricao("Rosinha, extremamente gay, Rabo depenado");
		((Gato) a).setVacinado(true);
		
		System.out.println(a.toString());
	}
}
