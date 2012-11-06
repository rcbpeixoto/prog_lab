package com.fbv.Class;

public class Disciplina{	
	private String codigo;
	private String descricao;
	private int idDisciplina;
	private Curso curso;
	private static Disciplina dis[] = new Disciplina[100];
	
	public Disciplina(String codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);		
	}
	
	public Disciplina() {		
		super();		
		this.codigo = "";
		this.descricao = "";
	}
	
	public int getIdDisciplina() {
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null){				
				setIdDisciplina(i+1);
			}
		}		
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws NullPointerException, IllegalArgumentException {
		if (codigo == null){
			throw new NullPointerException();
		}
		
		if (codigo.isEmpty()){
			throw new IllegalArgumentException();			
		}
		
		this.codigo = codigo;		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) throws NullPointerException, IllegalArgumentException {
		if (descricao == null){
			throw new NullPointerException();
		}
		
		if (descricao.isEmpty()){
			throw new IllegalArgumentException();			
		}
		this.descricao = descricao;
	}

	public static Disciplina[] getDis() {
		return dis;
	}

	public static void setDis(Disciplina[] dis) {
		Disciplina.dis = dis;
	}	
    
	public static Disciplina listarDisciplina(String disciplina){
		Disciplina dis1 = null;
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null && disciplina.equalsIgnoreCase(dis[i].getDescricao())){
				dis1 = dis[i];		
			}
		}
		return dis1;
	}
	
	public static Disciplina[] listarDisciplina(Curso curso){		
		Disciplina dis1[] = new Disciplina[Curso.getDis().length];
		int ii = 0;
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null && dis[i].getCurso() == curso){
				dis1[ii++] = dis[i];		
			}
		}
		return dis1;
	}
	
	public static Disciplina consultaDisciplina(String parametro, String tipoPesq){
		Disciplina dis1 = null;
		for (int i = 0; i < dis.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (dis[i] != null && dis[i].getCodigo().equalsIgnoreCase(parametro)){
					dis1 = dis[i];
					i = dis.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("DESCRICAO")){
				if (dis[i] != null && dis[i].getDescricao().equalsIgnoreCase(parametro)){
					dis1 = dis[i];
					i = dis.length;
				}
			}
		}
		return dis1;		
	}
	
	public static boolean consultaDisciplina(Disciplina vDisciplina){
		boolean retorno = false;
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null && dis[i].getCodigo().equalsIgnoreCase(vDisciplina.getCodigo()) && 
					dis[i].getDescricao().equalsIgnoreCase(vDisciplina.getDescricao())){
				retorno = true;
				i = dis.length;
			}
		}
		return retorno;		
	}

	public static Disciplina[] listarDisciplinas(){		
		return dis;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) throws NullPointerException {
		if (curso == null){
			throw new NullPointerException();
		}		
		this.curso = curso;
	}
	
	public static boolean excluirDisciplina(String parametro, String tipoPesq) throws NullPointerException, IllegalArgumentException {				
		if (parametro == null){
			throw new NullPointerException();
		}
		
		if (parametro.isEmpty()){
			throw new IllegalArgumentException();			
		}
		
		//boolean retorno = false;
		for (int i = 0; i < dis.length; i++) {
			if (tipoPesq.equalsIgnoreCase("DESCRICAO")){
				if (dis[i].getDescricao().equalsIgnoreCase(parametro)){
					dis[i] = null;
					i = dis.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (dis[i].getCodigo().equalsIgnoreCase(parametro)){
					dis[i] = null;
					i = dis.length;
					return true;
				}
			}
				
		}
		return false;
	}
}