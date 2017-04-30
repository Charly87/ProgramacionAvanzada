package progava.tp2.app;

public class SistemaEcuacionesLineales{
	
	private MatrizMath a;
	private MatrizMath b;
	
	public SistemaEcuacionesLineales()
	{
		this.a=null;
		this.b=null;
	}
	
	public SistemaEcuacionesLineales(MatrizMath a, MatrizMath b)
	{
		this.a=a;
		this.b=b;
	}
	
	public static boolean test(SistemaEcuacionesLineales obj)
	{
		if(obj.a.getCantColumnas()==obj.b.getCantFilas())
			return true;
		return false;
	}
	
	public MatrizMath resolver() throws CloneNotSupportedException
	{
		return this.a.inversa().productoPorMatriz(this.b);
	}

	public MatrizMath calcularErrorSolucion(MatrizMath sol) throws IllegalArgumentException, ArithmeticException, CloneNotSupportedException
	{
		return this.a.inversa().productoPorMatriz(this.b).restar(this.a.productoPorMatriz(sol));
	}
	
	private int getCantColumnasA() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return this.a.getCantColumnas();
		
	}

	private int getCantFilasA() {
		// TODO Auto-generated method stub
		return this.a.getCantFilas();
	}
	
	private int getCantColumnasB() {
		// TODO Auto-generated method stub
		return this.b.getCantColumnas();
	}

	private int getCantFilasB() {
		// TODO Auto-generated method stub
		return this.b.getCantFilas();
	}
	
	
}
