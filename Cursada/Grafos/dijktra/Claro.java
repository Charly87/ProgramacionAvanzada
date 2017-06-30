package dijktra;

public class Claro {
	private int id;
	private char contenido;
	
	public Claro(int id)
	{
		this.id = id;
	}
	
	public Claro(int id, char contenido)
	{
		this(id);
		this.contenido = contenido;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public char getContenido()
	{
		return this.contenido;
	}
}
