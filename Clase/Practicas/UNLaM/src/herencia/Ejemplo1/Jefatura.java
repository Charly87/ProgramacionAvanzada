package herencia.Ejemplo1;

public class Jefatura extends Empleado {
	private double incentivo;

	public Jefatura(String nombre, double sueldo) {
		super(nombre, sueldo);
		this.incentivo = 3500;
		//this.identificador++;
	}
	
	public double getSueldo()
	{
		return super.getSueldo() + this.incentivo;
	}
}
