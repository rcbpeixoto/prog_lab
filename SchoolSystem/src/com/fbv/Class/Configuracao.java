package com.fbv.Class;

public class Configuracao {
	private double media;	
	private static Configuracao conf[] = new Configuracao[1];	
	
	public Configuracao() {		
		setMedia(0.0);
		
	}
    
	public static Configuracao[] retornaConf() throws NullPointerException {
		if (conf == null){
			throw new NullPointerException("Erro retornar Configuração");
		}
		
		return conf;
	}
	
	public Configuracao(double media) {
		setMedia(media);		
	}

	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) throws NumberFormatException {
		if (media < 0){
			throw new NumberFormatException();			
		}
		
		this.media = media;
	}
}