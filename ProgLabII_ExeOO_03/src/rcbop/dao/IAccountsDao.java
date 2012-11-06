package rcbop.dao;

import rcbop.basic.Account;
import rcbop.exception.AccountNotFoundException;

public interface IAccountsDao {

	public Account search(String number) throws AccountNotFoundException;

	public boolean insert(Account account);

	public boolean update(Account account);

	public boolean remove(String number);

	public boolean exists(String number);
	
	public void dump();
}
