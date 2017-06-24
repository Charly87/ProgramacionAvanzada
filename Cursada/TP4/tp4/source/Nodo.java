package tp4.source;

public class Nodo {
	
	private int id;
	private int grado;
	private int color;
	private double random;
	
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

	public double getRandom() {
		return Math.random();
	}

	public void setRandom(double random) {
		this.random = random;
	}
	
}
