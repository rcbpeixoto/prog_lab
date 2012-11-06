package rcbop;

public interface ISet {
	void add(Object o);
	void remove(Object o);
	boolean belongs(Object o);
	boolean isEmpty();
	String dump();
	ISet union(Set s);
	ISet intersection(Set s);
}
