package com.fbv.Class;

public class Curso{	
	private String codigo;
	private String descricao;
	private int idCurso;
	private static Curso cur[] = new Curso[100];
	
	public Curso(String codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);		
	}
	
	public Curso() {		
		super();		
		this.codigo = "";
		this.descricao = "";
	}
	
	public int getIdCurso() {
		for (int i = 0; i < cur.length; i++) {
			if (cur[i] != null){				
				setIdCurso(i+1);
			}
		}		
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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

	public static Curso[] getDis() {
		return cur;
	}

	public static void setCur(Curso[] cur) {
		Curso.cur = cur;
	}	
    
	public static Curso listarCursos(String curso){
		Curso cur1 = null;
		for (int i = 0; i < cur.length; i++) {
			if (cur[i] != null && curso.equalsIgnoreCase(cur[i].getDescricao())){
				cur1 = cur[i];
				i = cur.length;
			}
		}
		return cur1;
	}
	
	public static Curso consultaCurso(String parametro, String tipoPesq){
		Curso cur1 = null;
		for (int i = 0; i < cur.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (cur[i] != null && cur[i].getCodigo().equalsIgnoreCase(parametro)){
					cur1 = cur[i];
					i = cur.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("DESCRICAO")){
				if (cur[i] != null && cur[i].getDescricao().equalsIgnoreCase(parametro)){
					cur1 = cur[i];
					i = cur.length;
				}
			}
		}
		return cur1;		
	}

	public static Curso[] listarCursos(){		
		return cur;
	}
}