package br.fbv.rcbop;

public class Stack {

	private Object[] stack;
	private int index;
	
	public Stack(int size) {
		this.stack = new Object[size];
	}
	
	public boolean isEmpty(){
		return (index == 0);
	}

	public boolean push(Object o){
		if (index < stack.length)
			stack[index++] = o;
		return (index < stack.length);
	}
	
	public Object pop(){
		return isEmpty() ? null : stack[--index];
	}
	
}
