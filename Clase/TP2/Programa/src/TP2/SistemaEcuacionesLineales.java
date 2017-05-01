package TP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class SistemaEcuacionesLineales{
	
	private int n;
	private MatrizMath matrizCoef;
	private VectorMath vectorTermInd;
	private VectorMath vectorSol;
	private double errorDeCalculo;
	
	/**
	 * Inicializa un sistema de ecuaciones lineales a partir del archivo de entrada especificado.
	 * @param fileName - nombre del archivo de entrada que contiene los datos del SEL.
	 * @throws FileNotFoundException - si no se encuentra el archivo especificado.
	 * @throws InvalidInputException - si la dimension no es valida.
	 */
	public SistemaEcuacionesLineales(String fileName) throws FileNotFoundException, InvalidInputException
	{
		Scanner input = new Scanner(new File(fileName));
		input.useLocale(Locale.US); // se setea para poder leer los numeros double
		
		n = input.nextInt();
		
		if (n < 1) 
		{
			input.close();
			throw new InvalidInputException("La cantidad de filas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		}
		
		matrizCoef = new MatrizMath(n, n);		
		for (int i = 0 ; i < (n * n) ; i++)
			matrizCoef.setComp(input.nextInt(), input.nextInt(), input.nextDouble());
			
		vectorTermInd = new VectorMath(n);
		for (int i = 0; i < n; i++)
			vectorTermInd.setPosicion(i, input.nextDouble());
		
		input.close();
				
	}
	
	/**
	 * Calcula el vector solucion del sistema de ecuaciones lineales.
	 * @throws CloneNotSupportedException - si no se puede clonear la matriz.
	 */
	public void resolver() throws CloneNotSupportedException
	{
		/* 
		 * Tengo:
		 *	 A = matriz de coeficientes (matrizCoef)
		 *	 B = vector de terminos independientes (vectorTermInd)
		 *	 X = vector de incognitas
		 *  
		 * Entonces, para resolver un SEL matricialmente se realiza lo siguiente:
		 *	 A * X = B
		 *	 A * A^-1 * X = B * A^-1 (siendo A^-1 la matriz inversa de A)
		 *	 
		 * Quedando finalmente:
		 * 	 X = A^-1 * B
		 * 
		 */
		vectorSol = matrizCoef.inversa().productoPorVector(vectorTermInd);
		
		/* Ahora obtengo el error de calculo, al despejar las incognitas matricialmente tengo que:
		 * 	 A * X = Berr (al realizar el calculo obtengo el vector solucion mas o menos un error de redondeo)
		 * 
		 * Para calcular ese error de redondeo, utilizo la longitud del vector, calculandola a traves de la norma dos, entonces:
		 *   err = Modulo ( longitud de Berr - longitud de B )
		 */
		errorDeCalculo = Math.abs(matrizCoef.productoPorVector(vectorSol).normaDos() - vectorTermInd.normaDos()); 
	}
	

	/**
	 * Muestra la solucion en el archivo de salida especificado
	 * @param fileName - nombre del archivo de salida
	 * @throws IOException - si no se puede generar el archivo de salida 
	 */
	public void mostrarResultado(String fileName) throws IOException
	{		
		PrintWriter output = new PrintWriter(new FileWriter(fileName));
		
		output.println(n);
	
		for (int i = 0; i < vectorSol.getDimension(); i++) 
			output.println(vectorSol.getPosicion(i));
		
		output.println(); // linea en blanco
		
		output.println(errorDeCalculo);
		
		output.close();
	}
	
	
}
