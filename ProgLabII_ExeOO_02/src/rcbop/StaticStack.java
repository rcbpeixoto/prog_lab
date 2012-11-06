package rcbop;

public class StaticStack {
	private Object[] stack;
	private int index;
	
	public StaticStack(int size) {
		this.stack = new Object[size];
		this.index = 0;
	}
	
	public boolean push(Object o){
		if (index < stack.length) {
			stack[index++] = o;
			System.out.println("adding: "+ o.toString());
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object pop(){
		if (!isEmpty()) {
			return stack[--index];
		}
		return null;
	}
	
	public boolean isEmpty(){
		return index == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		StaticStack ss = new StaticStack(5);
		
		System.out.println("ADDING OBJECTS");
		for (int i = 0; i < 6; i++) {
			if (!ss.push(new Integer(i))) {
				System.out.println("STACK FULL!!");
			}
		}
		
		System.out.println("POPPING OBJECTS: ");
		for (int i = 0; i < 6; i++) {
			Object o = ss.pop();
			if (o != null) {
				System.out.println("popping: " + o);
			}
			else {
				System.out.println("STACK EMPTY!!");
			}
		}
	}
}

