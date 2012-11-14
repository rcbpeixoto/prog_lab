package br.fbv.rcbop.controller;

import br.fbv.rcbop.model.Client;
import br.fbv.rcbop.model.ClientNotFoundException;
import br.fbv.rcbop.repository.ClientsRepository;

public class Facade {
	private static Facade instance;
	private ClientsRepository repoClients;
	
	private Facade() {
		repoClients = new ClientsRepository();
	}
	
	public void insert(Client c){
		repoClients.insert(c);
	}
	
	public void remove(long code){
		repoClients.remove(code);
	}
	
	public Client search(long code) throws ClientNotFoundException {
		return repoClients.search(code);
	}
	
	public static Facade getInstance(){
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

}
