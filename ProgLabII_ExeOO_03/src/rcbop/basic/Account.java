package rcbop.basic;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1598350802264874594L;
	private String number;
	private String name;
	private double balance;
	
	public Account(String number, String name, double balance) {
		super();
		this.number = number;
		this.name = name;
		this.balance = balance;
	}
	
	public Account() {
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
