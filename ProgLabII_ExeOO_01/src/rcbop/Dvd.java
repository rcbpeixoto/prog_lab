package rcbop;

public class Dvd {

	private String title;
	private double price;
	private double rent;
	
	public Dvd(String title, double price, double rent) {
		super();
		this.title = title;
		this.price = price;
		this.rent = rent;
	}
	
	public double getOwedRent(int days){
		return days * rent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}
}
