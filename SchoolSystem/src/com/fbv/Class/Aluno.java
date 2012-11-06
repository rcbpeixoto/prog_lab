package com.fbv.Class;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno extends Pessoa {	
	private int idAluno;
	private String dataCadastro;
	private Curso curso;
	private static Aluno alu[] = new Aluno[100];
	
	public Aluno() {		
		super();		
		setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString());
	
	}
    
	public static Aluno[] listarPessoa(){
		return alu;
	}
	
	public Aluno(String nome, String codigo) throws Exception {
		setNome(nome);
		setCodigo(codigo);		
		setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString());
	}	
	
	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static Aluno[] getAlu() {
		return alu;
	}

	public void setAlu(Aluno[] alu) {
		Aluno.alu = alu;
	}

	public int getIdAluno() {
		for (int i = 0; i < alu.length; i++) {
			if (alu[i] != null){				
				setIdAluno(i+1);
			}
		}		
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
	public static Aluno consultaAluno(String parametro, String tipoPesq){
		Aluno alu1 = null;
		for (int i = 0; i < alu.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CPF")){
				if (alu[i] != null && alu[i].getCpf().equalsIgnoreCase(parametro)){
					alu1 = alu[i];
					i = alu.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("NOME")){
				if (alu[i] != null && alu[i].getNome().equalsIgnoreCase(parametro)){
					alu1 = alu[i];
					i = alu.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (alu[i] != null && alu[i].getCodigo().equalsIgnoreCase(parametro)){
					alu1 = alu[i];
					i = alu.length;
				}
			}
		}
		return alu1;		
	}
	
	public static boolean excluirAluno(String parametro, String tipoPesq) throws NullPointerException, IllegalArgumentException {				
		if (parametro == null){
			throw new NullPointerException();
		}
		
		if (parametro.isEmpty()){
			throw new IllegalArgumentException();			
		}
		
		//boolean retorno = false;
		for (int i = 0; i < alu.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CPF")){
				if (alu[i].getNome().equalsIgnoreCase(parametro)){
					alu[i] = null;
					i = alu.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("NOME")){
				if (alu[i].getCpf().equalsIgnoreCase(parametro)){
					alu[i] = null;
					i = alu.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (alu[i].getCodigo().equalsIgnoreCase(parametro)){
					alu[i] = null;
					i = alu.length;
					return true;
				}
			}
				
		}
		return false;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}