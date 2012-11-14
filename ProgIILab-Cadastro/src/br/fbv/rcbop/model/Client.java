package br.fbv.rcbop.model;

import java.io.Serializable;

public class Client implements Serializable{

	private static final long	serialVersionUID	= -7358830523760354482L;
	
	private long	code;
	private String	name;
	private String	address;
	private String	city;
	private String	state;
	private String	email;
	private String	zipCode;

	public Client(long code, String name, String address, String city, String state, String email, String zipCode) {
		this.code = code;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipCode = zipCode;
	}
	
	public Client(){
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}