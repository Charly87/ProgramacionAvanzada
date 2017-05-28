package CarlosRodrigo;

public abstract class Personaje {
	protected int salud;
	protected int daño;
	protected int max_distancia;
	protected int min_distancia;
	protected int x;
	protected int y;
	
	public Personaje(int salud, int daño, int max_distancia, int min_distancia, int x, int y)
	{
		this.salud = salud;
		this.daño = daño;
		this.max_distancia = max_distancia;
		this.min_distancia = min_distancia;
		this.x = x;
		this.y = y;
	}
	
	protected double distancia(Personaje atacante, Personaje atacado)
	{		
		double xVector = atacante.x - atacado.x;
		double yVector = atacante.y - atacado.y;
		return Math.sqrt(Math.pow(xVector, 2) + Math.pow(yVector, 2));
	}
	
	public int getSalud()
	{
		return this.salud;
	}
	
	
	protected abstract boolean puedeAtacar(Personaje atacado);
	public abstract boolean atacar(Personaje atacado);	
	public abstract void recargar(Elemento elemento);
}
