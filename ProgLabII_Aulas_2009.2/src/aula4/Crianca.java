package aula4;

public class Crianca extends Paciente {
	private Adulto pai;
	private Adulto mae;
	
	public Crianca(){
		super();
		
	}
	
	public void setPai(Adulto pai){
		this.pai = pai;
	}
	
	public void setMae(Adulto mae){
		this.mae = mae;
	}
	
	public Adulto getPai(){
		return this.pai;
	}
	
	public Adulto getMae(){
		return this.mae;
	}
	

}
