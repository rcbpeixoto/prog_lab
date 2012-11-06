package rcbop;

public class Candidate {

	private String name;
	private short number;
	private int votes;
	
	public Candidate(String name, short number, int votes) {
		super();
		this.name = name;
		this.number = number;
		this.votes = votes;
	}
	
	public void incrementVotes(){
		votes++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) throws IllegalArgumentException {
		if (number > 0) {
			this.number = number;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public int getVotes() {
		return votes;
	}
	
	
}
