package dijktra;
 
public class Claro {
	private int id;
	private char contenido;
	
	//Comentario
	public Claro(int id)
	{
		this.id = id;
	}
	//Comentario
	public Claro(int id, char contenido)
	{
		
		this(id);
		this.contenido = contenido;
	}
	//Comentario
	public int getId()
	{
		return this.id;
	}
	//Comentario
	public char getContenido()
	{
		return this.contenido;
	}
}



