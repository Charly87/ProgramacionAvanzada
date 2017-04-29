package progava.tp2.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class VectorMath
{
	private int dim;
	private double[] coord;
	
	/**
	 * Constructor
	 * @param dim dimension del vector
	 */
	public VectorMath(int dim)
	{
		this.dim = dim;
		coord = new double[dim];		
	}
	
	/**
	 * Constructor
	 * @param fileName nombre del archivo de entrada que contiene la dimension y 
	 * 				   los valores de las coordenadas del vector.
	 * @throws FileNotFoundException si no se encuentra el archivo de entrada especificado
	 * @throws InvalidInputException si la dimension no es valida
	 */	
	public VectorMath(String fileName) throws FileNotFoundException, InvalidInputException
	{

		Scanner input = new Scanner(new File(fileName));
		
		// la primera linea del archivo de entrada contiene la dimension del vector
		dim = input.nextInt();
		if (dim < 1)			
			throw new InvalidInputException("La dimension del vector no es valida. Revisar archivo \"" + fileName + "\".");
		else
			coord = new double[dim];
		
		// las lineas siguientes contienen cada coordenada del vector
		for (int i = 0 ; i < dim ; i++)
			coord[i] = input.nextInt();
		
		// si hay una linea mas en el archivo de entrada, entonces hay algo mal, por lo tanto arrojo una excepcion
		if (input.hasNextLine())
			throw new InvalidInputException("El archivo de entrada \"" + fileName + "\" tiene lineas de mas. Verificar.");		
						
	}
	

	@Override
	public String toString() 
	{
		return Arrays.toString(coord);
	}

	/**
	 * Devuelve el vector que resulta de la suma del vector llamador mas el vector recibido por parametro.
	 * @param vector vector a ser sumado
	 * @return vector resultante de la suma
	 * @throws IllegalArgumentException si el vector recibido es null
	 * @throws DistDimException si la dimension del vector recibido no coincide con la del vector llamador
	 */
	public VectorMath sumar(VectorMath vector) throws IllegalArgumentException, DistDimException 
	{
		
		if (vector == null)
			throw new IllegalArgumentException("No se pudo realizar suma de vectores ya que se recibio como parametro un vector nulo.");
		
		if	(dim != vector.dim)
			throw new DistDimException("No se pudo realizar suma por ser los vectores de distinta dimension.");
		
		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.coord[i] = this.coord[i] + vector.coord[i];
		
		return aux;
		
	}
	
	
	/**
	 * Devuelve el vector que resulta de la resta del vector llamador menos el vector recibido por parametro.
	 * @param vector vector a ser restado
	 * @return vector resultante de la resta
	 * @throws IllegalArgumentException si el vector recibido es null
	 * @throws DistDimException si la dimension del vector recibido no coincide con la del vector llamador
	 */
	public VectorMath restar(VectorMath vector) throws IllegalArgumentException, DistDimException 
	{
		
		if (vector == null)
			throw new IllegalArgumentException("No se pudo realizar resta de vectores ya que se recibio como parametro un vector nulo.");
		
		if	(dim != vector.dim)
			throw new DistDimException("No se pudo realizar la resta por ser los vectores de distinta dimension.");
		
		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.coord[i] = this.coord[i] - vector.coord[i];
		
		return aux;
		
	}
	
	/**
	 * Efectua el producto escalar de vectores entre el vector llamador y el vector recibido por parametro.
	 * @param vector vector con el cual realizar el producto escalar
	 * @return el resultado del producto escalar
	 * @throws IllegalArgumentException si el vector recibido es null
	 * @throws DistDimException si la dimension del vector recibido no coincide con la del vector llamador
	 */
	public double productoEscalar(VectorMath vector) throws IllegalArgumentException, DistDimException
	{
		if (vector == null)
			throw new IllegalArgumentException();
		
		if	(dim != vector.dim)
			throw new DistDimException("No se pudo realizar el producto escalar por ser los vectores de distinta dimension.");
		
		double aux = 0;
		for (int i = 0; i < dim; i++)
			aux += this.coord[i] * vector.coord[i];
		
		return aux;
		
	}
	
	
	/**
	 * Efectua el producto del vector llamador por el escalar recibido por parametro.
	 * @param escalar escalar con el cual realizar el producto
	 * @return vector multiplo del vector llamador
	 */
	public VectorMath productoPorEscalar(double escalar)
	{
		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.coord[i] = this.coord[i] * escalar;
		
		return aux;
		
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		VectorMath other = (VectorMath) obj;
		if (!Arrays.equals(coord, other.coord))
			return false;
		
		if (dim != other.dim)
			return false;
		
		return true;
	}
	
	/**
	 * Calcula la norma uno del vector llamador. La norma uno se calcula como la suma de las
	 * magnitudes de las componentes del vector. 
	 * 
	 * @return norma uno
	 */
	public double normaUno()
	{
		double suma = 0;
		for (int i = 0 ; i < dim ; i++)
			suma += Math.abs(coord[i]);
		
		return suma;
	}
	
	
	/**
	 * Calcula la norma dos del vector llamador. La norma dos se refiere a la norma euclideana,
	 * que se calcula como la raiz cuadrada de la suma de las componentes al cuadrado.
	 * 
	 * @return norma dos
	 */
	public double normaDos()
	{
		double suma = 0;
		for (int i = 0 ; i < dim ; i++)
			suma += Math.abs(Math.pow(coord[i], 2));
		
		return Math.sqrt(suma);
	}
	
	
	/**
	 * Calcula la norma infinito del vector llamador. Esta norma se obtiene a partir de la
	 * maxima magnitud que se encuentra dentro del vector (la componente de mayor longitud).
	 * 
	 * @return norma infinito
	 */
	public double normaInfinito()
	{
		double mayor = Math.abs(coord[0]);
		
		for (int i = 0 ; i < dim ; i++)
		{
			if (Math.abs(coord[i]) > mayor)
				mayor = Math.abs(coord[i]);
		}
					
		return mayor;
		
	}
		

}
