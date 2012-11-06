package com.fbv.Class;


public class Pessoa {
	private String codigo;
	private String nome;
	private String cpf;
	private String identidade;
	private Endereco endereco;
			
	
	public Pessoa() {	
		this.codigo = "";
		this.nome = "";
		this.cpf = "";
		this.identidade = "";
		this.endereco = null;		
	}
    
	public Pessoa(String codigo, String nome, String cpf, String identidade, 
			Endereco endereco) throws NullPointerException {
		setCodigo(codigo);
		setNome(nome);		
		setCpf(cpf);
		setIdentidade(identidade);		
		setEndereco(endereco);
		
	}

	public String getNome() {
		return nome; 
	}
	
	public void setNome(String nome) throws NullPointerException {
		if (nome != null && !nome.equalsIgnoreCase("")){
			this.nome = nome;
		}else{
			throw new NullPointerException("Preencha o Campo Nome!");
		}
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws NullPointerException {
		if (cpf != null && !cpf.equalsIgnoreCase("")){
			this.cpf = cpf;
		}else{
			throw new NullPointerException("Preencha o Campo CPF!");			
		}
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) throws NullPointerException {
		if (identidade != null && !identidade.equalsIgnoreCase("")){
			this.identidade = identidade;
		}else{
			throw new NullPointerException("Preencha o Campo Identidade!");			
		}		
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) throws NullPointerException {
		if (endereco != null){
			this.endereco = endereco;
		}else{
			throw new NullPointerException("Endereço esta Nulo");			
		}
	}	
	
}