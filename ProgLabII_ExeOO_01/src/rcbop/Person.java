package rcbop;

public class Person {
	private String	name;
	private int		age;
	private double	height;
	private double	weight;
	private double	imc;
	
	private final double UNDER_WEIGHT_LIMIT = 18.5;
	private final double NORMAL_WEIGHT_LIMIT = 25;
	private final double OVER_WEIGHT_LIMIT = 30;

	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.imc = weight / Math.pow(height, 2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		this.imc = this.weight / Math.pow(height, 2);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		this.imc = weight / Math.pow(this.height, 2);
	}

	public double getImc() {
		return imc;
	}
	
	public String toString(){
		String rtnStr = null;
		
		if (this.imc <= UNDER_WEIGHT_LIMIT) {
			rtnStr = "Name: " + this.name + ", Under weighted";
		}
		else if (this.imc > UNDER_WEIGHT_LIMIT && this.imc <= NORMAL_WEIGHT_LIMIT) {
			rtnStr = "Name: " + this.name + ", Normal weighted";
		}
		else if (this.imc > NORMAL_WEIGHT_LIMIT && this.imc <= OVER_WEIGHT_LIMIT) {
			rtnStr = "Name: " + this.name + ", Over weighted";
		}
		else if (this.imc > OVER_WEIGHT_LIMIT){
			rtnStr = "Name: " + this.name + ", Obese";
		}
		return rtnStr;
	}

}
