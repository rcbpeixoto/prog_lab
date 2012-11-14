package br.fbv.rcbop.model;

public class ClientNotFoundException extends Exception {
	private static final long	serialVersionUID	= -1492673317373822104L;

	public ClientNotFoundException() {
		super("Cliente não encontrado");
	}

}
