package tp4.source;

public class Nodo implements Comparable<Nodo> {
	
	private int id;
	
	public Nodo(int id) {		
		this.id = id;		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int compareTo(Nodo otroNodo) {
		
		if (this.id < otroNodo.id)
			return -1;
		else if (this.id > otroNodo.id)
			return 1;
		else
			return 0;
		
	}
	
}
