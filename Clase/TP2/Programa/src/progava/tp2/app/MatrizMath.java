package progava.tp2.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrizMath 
{
	private int cantFilas;
	private int cantColumnas;
	private int dim;
	private double[][] comp;
	
	/**
	 * Constructor
	 * @param cantFilas cantidad de filas de la matriz
	 * @param cantColumnas cantidad de columnas de la matriz
	 */
	public MatrizMath(int cantFilas, int cantColumnas)
	{
		this.cantFilas = cantFilas;
		this.cantColumnas = cantColumnas;
		this.dim = cantFilas * cantColumnas;
		comp = new double[cantFilas][cantColumnas];
	}
	
	/**
	 * Constructor
	 * @param fileName nombre del archivo de entrada que contiene la dimension y las componentes de la matriz
	 * @throws FileNotFoundException si no se encuentra el archivo de entrada especificado
	 * @throws InvalidInputException si la dimension no es valida
	 */
	public MatrizMath(String fileName) throws FileNotFoundException, InvalidInputException
	{
		Scanner input = new Scanner(new File(fileName));
		
		// la primera linea del archivo de entrada contiene la cantidad
		// de filas y de columnas de la matriz separadas por un espacio 
		cantFilas = input.nextInt();
		cantColumnas = input.nextInt();
		if (cantFilas < 1)			
			throw new InvalidInputException("La cantidad de filas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		else if (cantColumnas < 1)
			throw new InvalidInputException("La cantidad de columnas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		else
		{
			dim = cantFilas * cantColumnas;
			comp = new double[cantFilas][cantColumnas];
		}
		
		// las lineas siguientes contienen cada componente de la matriz, con el formato:
		// (nroFila) (nroColumna) (Componente)
		int cantComponentes = cantFilas * cantColumnas;
		int fila;
		int columna;
		for (int i = 0 ; i < cantComponentes ; i++)
		{
			fila = input.nextInt();
			columna = input.nextInt();
			comp[fila][columna] = input.nextInt();
		}
						
		// si hay una linea mas en el archivo de entrada, entonces hay algo mal, por lo tanto arrojo una excepcion
		if (input.hasNextLine())
			throw new InvalidInputException("El archivo de entrada \"" + fileName + "\" tiene lineas de mas. Verificar.");
	}

	
	/**
	 * Muestra la matriz con el formato:
	 * a11 a12 ... a1n
	 * a21 a22 ... a2n
	 *  .   .       .
	 *  .   .       .
	 *  .   .       .
	 * am1 am2 ... amn
	 */
	public void mostrar()
	{
		for (int i = 0 ; i < cantFilas ; i++)
		{
			for (int j = 0 ; j < cantColumnas ; j++)
				System.out.print(comp[i][j] + " ");
			System.out.println();
		}
		System.out.println();		
	}
	
	/**
	 * Devuelve la matriz que resulta de sumar la matriz llamadora mas la matriz recibida por parametro.
	 * @param matriz matriz a ser sumada
	 * @return matriz resultante de la suma
	 * @throws IllegalArgumentException si la matriz recibida es null
	 * @throws DistDimException si la dimension de la matriz recibida no coincide con la de la matriz llamadora
	 */
	public MatrizMath sumar(MatrizMath matriz) throws IllegalArgumentException, DistDimException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar suma de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new DistDimException("No se pudo realizar suma de matrices por ser las matrices de distinta dimension.");
		
		MatrizMath aux = new MatrizMath(cantFilas, cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < cantColumnas ; j++)
			aux.comp[i][j] = this.comp[i][j] + matriz.comp[i][j];
		
		return aux;
	}
	
	/**
	 * Devuelve la matriz que resulta de restar la matriz llamadora menos la matriz recibida por parametro.
	 * @param matriz matriz a ser sumada
	 * @return matriz resultante de la suma
	 * @throws IllegalArgumentException si la matriz recibida es null
	 * @throws DistDimException si la dimension de la matriz recibida no coincide con la de la matriz llamadora
	 */
	public MatrizMath restar(MatrizMath matriz) throws IllegalArgumentException, DistDimException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar resta de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new DistDimException("No se pudo realizar resta de matrices por ser las matrices de distinta dimension.");
		
		MatrizMath aux = new MatrizMath(cantFilas, cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < cantColumnas ; j++)
			aux.comp[i][j] = this.comp[i][j] - matriz.comp[i][j];
		
		return aux;
	}
	
	
	public MatrizMath productoPorMatriz(MatrizMath matriz) throws IllegalArgumentException, ProdIncException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar producto de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new ProdIncException("No se pudo realizar producto de matrices ya que la cantidad de columnas de la primera matriz no coincide con la cantidad de filas de la segunda.");
		
		MatrizMath aux = new MatrizMath(cantFilas, matriz.cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < matriz.cantColumnas ; j++)
				for (int k = 0; k < cantColumnas ; k++)
					aux.comp[i][j] += this.comp[i][k] * matriz.comp[k][j];
		
		return aux;
	}
	
	
	
	
	

}
