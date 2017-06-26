package tp4.source;

public class Nodo {
	
	private int id;
	private int grado;
	private int random;
	
	public Nodo(int id) {		
		this.id = id;		
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getRandom() {
		return this.random;
	}

	public void setRandom(int random) {
		this.random = random;
	}
	
}
