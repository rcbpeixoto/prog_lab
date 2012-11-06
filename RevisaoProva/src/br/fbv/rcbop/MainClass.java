package br.fbv.rcbop;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(m1(6));

		Stack a = new Stack(2);
		a.push(1);
		a.push(6);
		a.push(11);
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
	}
	
	public static int m1(int x) {
		if (x < 3) {
			return x;
		} else {
			return m1(x-1) - m1(x-2);
		}
	}
	
	public static void m2(){
		int c = 0;
		
		while (c < 17) {
			if (c > 11 || c % 2 == 1) 
				c = c + 1;
			else 
				c = c + 3;
		}
		System.out.println("c= "+c);
	}
}
