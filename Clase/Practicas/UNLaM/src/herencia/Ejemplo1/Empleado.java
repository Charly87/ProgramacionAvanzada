package herencia.Ejemplo1;

public class Empleado {
	private final String nombre;
	private double sueldo;
    private static int identificador;
    
	public Empleado(String nombre, double sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.identificador++;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	public double getSueldo()
	{
		return this.sueldo;
	}
	
	public int getIdentificador()
	{
		return this.identificador;
	}
}
