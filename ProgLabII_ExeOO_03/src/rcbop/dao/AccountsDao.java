package rcbop.dao;

import rcbop.basic.Account;
import rcbop.exception.AccountNotFoundException;

public class AccountsDao implements IAccountsDao {

	private Account[] database;
	private final static int DATABASE_INIT_SIZE = 10;

	public AccountsDao() {
		this.database = new Account[DATABASE_INIT_SIZE];
	}

	private int searchIndex(String number) {
		int rtn = -1;
		for (int i = 0; i < this.database.length; i++) {
			if (database[i] != null
					&& this.database[i].getNumber().equalsIgnoreCase(number))
				rtn = i;
		}
		return rtn;
	}

	@Override
	public Account search(String number) throws AccountNotFoundException {
		Account rtn = null;
		if (exists(number))
			rtn = this.database[searchIndex(number)];
		else
			throw new AccountNotFoundException();
		return rtn;
	}

	@Override
	public boolean insert(Account account) {
		boolean rtn = false;
		int i = 0;
		if (!exists(account.getNumber())) {
			if (isFull()) {
				increaseDbSize();
			}
			while (this.database[i] != null) {
				i++;
			}
			this.database[i] = account;
			rtn = true;
		}
		return rtn;
	}

	private boolean isFull() {
		boolean full = true;
		for (Account account : this.database) {
			if (account == null) {
				full = false;
			}
		}
		return full;
	}

	private void increaseDbSize() {
		Account[] newDatabase = new Account[this.database.length
				+ DATABASE_INIT_SIZE];
		for (int i = 0; i < this.database.length; i++) {
			newDatabase[i] = this.database[i];
		}
		this.database = newDatabase;
	}

	@Override
	public boolean update(Account account) {
		boolean rtn = false;
		if (exists(account.getNumber())) {
			this.database[searchIndex(account.getNumber())] = account;
			rtn = true;
		}
		return rtn;
	}

	@Override
	public boolean remove(String number) {
		boolean rtn = false;
		if (exists(number)) {
			this.database[searchIndex(number)] = null;
		}
		return rtn;
	}

	@Override
	public boolean exists(String number) {
		boolean rtn = false;
		int i = searchIndex(number);
		if (i != -1) {
			rtn = true;
		}
		return rtn;
	}

	public void dump() {
		for (Account account : this.database) {
			if (account != null) {
				System.out.println("ACCOUNT DETAILS - NAME: "
						+ account.getName() + " NUMBER: " + account.getNumber()
						+ " BALANCE: " + account.getBalance());
			}
		}
	}
}
