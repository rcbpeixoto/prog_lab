package rcbop;


public class Set implements ISet {
	
	private Element first;
	
	/**
	 *  Dado um elemento adiciona este no conjunto caso não já exista
	 * 
	 * @param elementValue
	 */
	@Override
	public void add(Object elementValue) {
		Element e = new Element(elementValue);
		if (isEmpty()) {
			first = e;
		}
		else {
			if (!belongs(elementValue)) {
				addLast(e, this);
			}
		}
	}
	
	/**
	 * 
	 * Dado um elemento remove do conjunto caso este não seja vazio.
	 * 
	 * @param elementValue
	 */
	@Override
	public void remove(Object elementValue) {
		if (!isEmpty()) {
			Element selected = new Element();
			Element previous = new Element();
			selected = previous = first;
			while (selected != null) {
				//ta ai seu equals maldito Jopa hahaha
				if (selected.value.equals(elementValue)) {
					previous.next = selected.next;
				}
				previous = selected;
				selected = selected.next;
			}
		}
	}
	
	/**
	 *  Método verifica se um dado elemento pertence a este conjunto
	 *  
	 *  @param e
	 */
	@Override
	public boolean belongs(Object e) {
		Element selected = first.clone();
		
		while (selected != null) {
			//ta ai seu equals maldito Jopa hahaha
			if (selected.value.equals(e)) {
				return true;
			}
			selected = selected.next;
		}
		return false;
	}
	
	/**
	 * Método verifica se o conjunto é vazio
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return 	(first == null);
	}
	/**
	 * Método retorna string com todos os elementos do conjunto
	 * 
	 * @return String
	 */
	@Override
	public String dump() {
		StringBuffer sb = new StringBuffer();
		Element selected = first.clone();
		
		while (selected != null) {
			sb.append(selected.value.toString());
			if (selected.next != null) 
				sb.append(", ");
			else
				sb.append("\n");
			selected = selected.next;
		}
		return sb.toString();
	}
	
	/**
	 * Método realiza operação de união entre dois conjuntos
	 * 
	 * @param s
	 * @return returnSet
	 */
	@Override
	public ISet union(Set s) {
		Element selected = new Element();
		Set returnSet = new Set();
		returnSet.first = first.clone();
		selected = s.first;
		while (selected != null) {
			if(!belongs(selected.value)){
				returnSet = addLast(selected, returnSet);
			}		
			selected = selected.next;
		}
		return returnSet;
	}
	/**
	 *  Método realiza operação de interseção entre dois conjuntos
	 *  
	 *  @param s
	 *  @return ISet
	 */
	@Override
	public ISet intersection(Set s) {
		Element selected = new Element();
		Set returnSet = new Set();
		selected = s.first.clone();
		while (selected != null) {
			if (belongs(selected.value)) {
				returnSet.add(selected.value);
			}
			selected = selected.next;
		}
		return returnSet;
	}
	
	/**
	 * Método auxiliar:
	 * 
	 * Adiciona elemento no final da lista do conjunto passado por parâmetro
	 * 
	 * @param e
	 * @param returnSet
	 * @return Set
	 */
	private Set addLast(Element e, Set returnSet) {
		Element selected = new Element();
		selected = returnSet.first;
		while (selected.next != null) {
			selected = selected.next;
		}
		selected.next = e;
		selected = e;

		return returnSet;
	}

	/**
	 * POJO para representar um elemento do conjunto
	 * @author rcbop
	 *
	 */
	class Element implements Cloneable {
		Object value;
		Element next;
		
		public Element(Object value) {
			super();
			this.value = value;
		}
		
		public Element() {
			super();
		}
		
		public Element clone(){
			Element o = null;
			try {
				o = (Element) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return o;
		}
	}
	
	public static void main(String[] args) {
		
		Set set1 = new Set();
		
		for (int i = 1; i <= 5; i++) {
			set1.add(new Integer(i));
		}
		
		Set set2 = new Set();
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(6);
		set2.add(7);
		set2.add(7); //ok
		
		System.out.println("DUMPING SET1: "); //ok
		System.out.println(set1.dump());;
		
		System.out.println("DUMPING SET2: "); //ok
		System.out.println(set2.dump());;
		
		System.out.println("Does 3 belongs to SET1?"); //ok 
		System.out.println(set1.belongs(3) + "\n");
		
		System.out.println("Removing element 3 of SET1?"); //ok
		set1.remove(3);
		System.out.println(set1.dump());;
		
		System.out.println("SET1 union SET2"); //ok
		Set unionSet = (Set) set1.union(set2);
		System.out.println(unionSet.dump());
		
		Set set3 = new Set();
		set3.add(1);
		set3.add(2);
		set3.add(7);
		set3.add(5);
		set3.add(9);
		
		System.out.println("DUMPING SET3: ");
		System.out.println(set3.dump());;
		
		
		Set set4 = new Set();
		set4.add(9);
 		set4.add(2);
 		set4.add(7);
 		
		System.out.println("DUMPING SET4: ");
		System.out.println(set4.dump());;
		
		System.out.println("SET3 intersection SET4");
		Set interSet = (Set) set3.intersection(set4);
		System.out.println(interSet.dump());
	}
}
