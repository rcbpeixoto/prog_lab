package br.fbv.exe2;


abstract class Animal {
	private String dono;
	private String dataNascimento;
	private String dataVascinacao;
	
	protected Animal(){
	}
	
	protected String getDono() {
		return dono;
	}
	protected void setDono(String dono) {
		this.dono = dono;
	}

	protected String getDataNascimento() {
		return dataNascimento;
	}

	protected void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	protected String getDataVascinacao() {
		return dataVascinacao;
	}

	protected void setDataVascinacao(String dataVascinacao) {
		this.dataVascinacao = dataVascinacao;
	}
	
}
