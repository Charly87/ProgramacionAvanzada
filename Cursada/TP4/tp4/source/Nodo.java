package tp4.source;

public class Nodo {
	
	private int id;
	private int grado;
	private int color;
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

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getRandom() {
		return (int)Math.random() * 100;
	}

	public void setRandom(int random) {
		this.random = random;
	}
	
}
