package rcbop.main;

import rcbop.basic.Account;
import rcbop.dao.AccountsDao;

public class MainClass {
	public static void main(String[] args) {
		AccountsDao accountDAO = new AccountsDao();
		
		Account acc1 = new Account();
		acc1.setName("Rogério Peixoto");
		acc1.setNumber("x-123xx/");
		acc1.setBalance(150000);
		
		Account acc2 = new Account();
		acc2.setName("João Paulo");
		acc2.setNumber("x-124");
		acc2.setBalance(200000);
		
		Account acc3 = new Account();
		acc3.setName("Dayvison Alexandre");
		acc3.setNumber("x-125");
		acc3.setBalance(250000);
		
		accountDAO.insert(acc1);
		accountDAO.insert(acc2);
		accountDAO.insert(acc3);
		System.out.println("INSERTING ACCOUNT THAT ALREADY EXISTS return -> " + accountDAO.insert(acc1));
		
		accountDAO.dump();
		
		System.out.println("REMOVING ACC2: ");
		accountDAO.remove(acc2.getNumber());
		
		accountDAO.dump();
		
		System.out.println("UPDATING ACC2: ");
		Account acc4 = new Account();
		acc4.setName("Dayvison Alexandre");
		acc4.setNumber("x-125");
		acc4.setBalance(200);
		
		accountDAO.update(acc4);
		
		accountDAO.dump();
		
		
	}
}
