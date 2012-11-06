package aula4;

import java.sql.Date;

public class Paciente {
	private String nome;
	private Date data_nasc;
	
	public Paciente(){
		this.nome = "";
		this.data_nasc = null;
	}
	
	public Paciente(String nome, Date data_nasc) {
		setNome(nome);
		setDataNasc(data_nasc);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	public String getNome(){
		return nome;
	}
	
	public Date getDataNasc(){
		return data_nasc;
	}
	
}
