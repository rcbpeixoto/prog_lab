package com.fbv.Class;

public class HistoricoAluno {	
	private Aluno aluno;
	private Disciplina disciplina;
	private double nota1;
	private double nota2;
	private int idHistorico;	
	private static HistoricoAluno historico[] = new HistoricoAluno[1000];
	
	public HistoricoAluno() {		
		super();		
		this.nota1 = 0.0;
		this.nota2 = 0.0;	
	}
	
	public static HistoricoAluno[] listarHistorico(){		
		return historico;
	}
    
	public static HistoricoAluno listarHistorico(Aluno alu, Disciplina dis){
		//HistoricoAluno historico[] = new HistoricoAluno[listarHistorico().length];
		HistoricoAluno historico1 = null;		
		
		for (int i = 0; i < historico.length; i++) {		
			if (historico[i] != null && historico[i].getAluno() == alu &&  historico[i].getDisciplina() == dis){
				historico1 = historico[i];
				i = historico.length;				
			}
		}
		return historico1;
	}
	
	public static HistoricoAluno[] listarHistorico(Aluno alu){		
		HistoricoAluno historico2[] = new HistoricoAluno[historico.length];
		int ii = 0;
		
		for (int i = 0; i < historico.length; i++) {		
			if (historico[i] != null && historico[i].getAluno() == alu ){
				historico2[ii] = historico[i];
				ii++;
				//i = historico.length;	
			}
		}
		return historico2;
	}
		
	
	public static HistoricoAluno[] getAlu() {
		return historico;
	}

	public void setHistorico(HistoricoAluno[] historico) {
		HistoricoAluno.historico = historico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public double getNota1() {
		return nota1;
	}

	public double getNota1(Aluno aluno, Disciplina disciplina) {
		double nota = 0;
		for (int i = 0; i < historico.length; i++) {
			if (historico[i] == null){
				i = historico.length; 
			} else if ( (historico[i].getAluno() == aluno) && 
						(historico[i].getDisciplina() == disciplina)) {
				
				nota = historico[i].getNota1();
				i = historico.length;
				
			}
		}
		return nota;
	}
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}
	
	public double getNota2(Aluno aluno, Disciplina disciplina) {
		double nota = 0;
		for (int i = 0; i < historico.length; i++) {
			if (historico[i] == null){
				i = historico.length; 
			} else if ((historico[i] != null) && (historico[i].getAluno() == aluno) && 
				(historico[i].getDisciplina() == disciplina)) {
				
				nota = historico[i].getNota2();
				i = historico.length;
				
			}
		}		
		return nota;		
	}
	
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public double calcularMedia(){
		return (nota1 + nota2) / 2;
	}
	
	public static HistoricoAluno consultaAluno(String parametro, String tipoPesq){
		HistoricoAluno alu1 = null;
		for (int i = 0; i < historico.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CPF")){
				if (historico[i] != null && historico[i].getAluno().getCpf().equalsIgnoreCase(parametro)){
					alu1 = historico[i];
					i = historico.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("NOME")){
				if (historico[i] != null && historico[i].getAluno().getNome().equalsIgnoreCase(parametro)){
					alu1 = historico[i];
					i = historico.length;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (historico[i] != null && historico[i].getAluno().getCodigo().equalsIgnoreCase(parametro)){
					alu1 = historico[i];
					i = historico.length;
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
		for (int i = 0; i < historico.length; i++) {
			if (tipoPesq.equalsIgnoreCase("CPF")){
				if (historico[i].getAluno().getNome().equalsIgnoreCase(parametro)){
					historico[i] = null;
					i = historico.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("NOME")){
				if (historico[i].getAluno().getCpf().equalsIgnoreCase(parametro)){
					historico[i] = null;
					i = historico.length;
					return true;
				}
			} else if (tipoPesq.equalsIgnoreCase("CODIGO")){
				if (historico[i].getAluno().getCodigo().equalsIgnoreCase(parametro)){
					historico[i] = null;
					i = historico.length;
					return true;
				}
			}
				
		}
		return false;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getIdHistorico() {
		for (int i = 0; i < historico.length; i++) {
			if (historico[i] != null){				
				setIdHistorico(i+1);
			}
		}		
		return idHistorico;
	}

}