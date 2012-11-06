package com.fbv.Class;

public class Professor extends Pessoa {	
	private int idProfessor;
	private Disciplina dis;	
	private static Professor prof[] = new Professor[100];
	
	public Professor() {		
		super();
		this.dis = null;
	}
	
	public Professor(String codigo, String nome, String cpf, String identidade, 
			Endereco endereco, Disciplina disciplina) throws Exception {		
		setCodigo(codigo);
		setNome(nome);
		setCpf(cpf);
		setIdentidade(identidade);		
		setEndereco(endereco);
		setDis(disciplina);		
	}
	
	public int getIdProfessor() {
		for (int i = 0; i < prof.length; i++) {
			if (prof[i] != null){				
				setIdProfessor(i+1);
			}
		}
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public static Professor[] listarPessoa(){
		return prof;
	}	

	public Disciplina getDis() {
		return dis;
	}

	public void setDis(Disciplina dis) throws NullPointerException{
		if (dis == null){
			throw new NullPointerException();
		}		
		this.dis = dis;
	}

	public static Professor[] getProf() {
		return prof;
	}

	public static void setProf(Professor[] prof) {
		Professor.prof = prof;
	}
	
	public static boolean excluirProfessor(String parametro, String tipoPesq) throws NullPointerException, IllegalArgumentException {				
		if (parametro == null){
			throw new NullPointerException();
		}
		
		if (parametro.isEmpty()){
			throw new IllegalArgumentException();			
		}
		
		//boolean retorno = false;
		for (int i = 0; i < prof.length; i++) {
			if (tipoPesq.equalsIgnoreCase("NOME")){
				if (prof[i].getNome().equalsIgnoreCase(parametro)){
					prof[i] = null;
					i = prof.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (prof[i].getCodigo().equalsIgnoreCase(parametro)){
					prof[i] = null;
					i = prof.length;
					return true;
				}
			}
				
		}
		return false;
	}
	
	public static Professor consultaProfessor(String parametro, String tipoPesq){
		Professor prof1 = null;
		for (int i = 0; i < prof.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (prof[i] != null && prof[i].getCodigo().equalsIgnoreCase(parametro)){
					prof1 = prof[i];
					i = prof.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("NOME")){
				if (prof[i] != null && prof[i].getNome().equalsIgnoreCase(parametro)){
					prof1 = prof[i];
					i = prof.length;
				}
			}
		}
		return prof1;		
	}
	
}