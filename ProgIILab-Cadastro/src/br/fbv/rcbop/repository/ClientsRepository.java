package br.fbv.rcbop.repository;

import java.util.ArrayList;

import br.fbv.rcbop.model.Client;
import br.fbv.rcbop.model.ClientNotFoundException;

public class ClientsRepository {

	ArrayList<Client> dbClient = new ArrayList<Client>();
	
	public void insert(Client c) {
		boolean found = false;
		for (Client client : dbClient) {
			if (client.getCode() == c.getCode()) {
				dbClient.remove(client);
				dbClient.add(c);
				found = true;
			}
		}
		if (!found) {
			dbClient.add(c);
		}
	}
	
	public void remove(long code){
		Client temp = null;
		for (Client client : dbClient) {
			if (client.getCode() == code) {
				temp = client; 
			}
		}
		dbClient.remove(temp);

	}
	
	public Client search(long code) throws ClientNotFoundException{
		Client rtn = null;
		boolean found = false;
		for (Client client : dbClient) {
			if (client.getCode() == code) {
				rtn = client;
				found = true;
			}
		}
		if (!found) {
			throw new ClientNotFoundException();
		}
		return rtn;
	}
	
}
