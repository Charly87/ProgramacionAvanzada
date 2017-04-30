package TP2;

public class SistemaEcuacionesLineales{
	
	private MatrizMath a;
	private MatrizMath b;
	
	
	public SistemaEcuacionesLineales(MatrizMath a, MatrizMath b)
	{
		this.a=a;
		this.b=b;
	}
	
	public MatrizMath resolverSistema() throws CloneNotSupportedException
	{
		return this.a.inversa().productoPorMatriz(this.b);
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