package TP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrizMath implements Cloneable
{
	
	private int cantFilas;
	private int cantColumnas;
	private int dim;
	private double[][] comp;
	
	
	/**
	 * Inicializa un objeto MatrizMath con la cantidad de filas y la cantidad de columnas especificadas.
	 * @param cantFilas - cantidad de filas de la matriz.
	 * @param cantColumnas - cantidad de columnas de la matriz.
	 */
	public MatrizMath(int cantFilas, int cantColumnas)
	{
		this.cantFilas = cantFilas;
		this.cantColumnas = cantColumnas;
		this.dim = cantFilas * cantColumnas;
		comp = new double[cantFilas][cantColumnas];
	}
	
	
	/**
	 * Inicializa un objeto MatrizMath con el contenido del archivo de entrada especificado. 
	 * @param fileName - nombre del archivo de entrada que contiene la dimension y las componentes de la matriz.
	 * @throws FileNotFoundException - si no se encuentra el archivo de entrada especificado.
	 * @throws InvalidInputException - si la dimension no es valida o si el archivo tiene lineas de mas.
	 */
	public MatrizMath(String fileName) throws FileNotFoundException, InvalidInputException
	{
		Scanner input = new Scanner(new File(fileName));
		
		// la primera linea del archivo de entrada contiene la cantidad
		// de filas y de columnas de la matriz separadas por un espacio 
		cantFilas = input.nextInt();
		cantColumnas = input.nextInt();
		if (cantFilas < 1)
		{
			input.close();
			throw new InvalidInputException("La cantidad de filas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		}
		else if (cantColumnas < 1)
		{
			input.close();
			throw new InvalidInputException("La cantidad de columnas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		}
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
		{
			input.close();
			throw new InvalidInputException("El archivo de entrada \"" + fileName + "\" tiene lineas de mas. Verificar.");
		}
		
		input.close();
	}
	
	
	public int getCantFilas() 
	{
		return cantFilas;
	}


	public void setCantFilas(int cantFilas) 
	{
		this.cantFilas = cantFilas;
	}


	public int getCantColumnas() 
	{
		return cantColumnas;
	}


	public void setCantColumnas(int cantColumnas) 
	{
		this.cantColumnas = cantColumnas;
	}


	public int getDim() 
	{
		return dim;
	}


	public void setDim(int dim) 
	{
		this.dim = dim;
	}


	public double[][] getComp() 
	{
		return comp;
	}
	
	
	public double getComp(int f, int c)
	{
		return comp[f][c];
	}


	public void setComp(double[][] comp) 
	{
		this.comp = comp;
	}


	/**
	 * Muestra la matriz con el formato: 
	 * <br>a11 a12 ... a1n
	 * <br>a21 a22 ... a2n
	 * <br> &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br> &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br> &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br>am1 am2 ... amn
	 */
	public String toString()
	{
		String ms = "\n";
		
		for (int i = 0 ; i < cantFilas ; i++)
		{
			for (int j = 0 ; j < cantColumnas ; j++)
				ms = ms.concat(comp[i][j] + " ");
			ms = ms.concat("\n");
		}
		
		return ms;
	}

	
	/**
	 * Devuelve la matriz que resulta de sumar la matriz llamadora mas la matriz recibida por parametro.
	 * @param matriz - matriz a ser sumada.
	 * @return matriz resultante de la suma.
	 * @throws IllegalArgumentException - si la matriz recibida es null.
	 * @throws DistDimException - si la dimension de la matriz recibida no coincide con la de la matriz llamadora.
	 */
	public MatrizMath sumar(MatrizMath matriz) throws IllegalArgumentException, DistDimException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar suma de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new DistDimException("No se pudo realizar la suma de matrices por ser de distinta dimension.");
		
		MatrizMath aux = new MatrizMath(cantFilas, cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < cantColumnas ; j++)
				aux.comp[i][j] = this.comp[i][j] + matriz.comp[i][j];
		
		return aux;
	}
	
	
	/**
	 * Devuelve la matriz que resulta de restar la matriz llamadora menos la matriz recibida por parametro.
	 * @param matriz - matriz a ser sumada.
	 * @return matriz resultante de la suma.
	 * @throws IllegalArgumentException - si la matriz recibida es null.
	 * @throws DistDimException - si la dimension de la matriz recibida no coincide con la de la matriz llamadora.
	 */
	public MatrizMath restar(MatrizMath matriz) throws IllegalArgumentException, DistDimException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar resta de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new DistDimException("No se pudo realizar la resta de matrices por ser de distinta dimension.");
		
		MatrizMath aux = new MatrizMath(cantFilas, cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < cantColumnas ; j++)
				aux.comp[i][j] = this.comp[i][j] - matriz.comp[i][j];
		
		return aux;
	}
	
	
	/**
	 * Devuelve la matriz que resulta de realizar el producto entre la matriz llamadora por la matriz recibida por parametro.
	 * @param matriz - matriz con la cual realizar el producto
	 * @return matriz resultante del producto.
	 * @throws IllegalArgumentException - si lamatriz recibida es null.
	 * @throws ArithmeticException - si el producto no es compatible.
	 */
	public MatrizMath productoPorMatriz(MatrizMath matriz) throws IllegalArgumentException, ArithmeticException
	{
		if (matriz == null)
			throw new IllegalArgumentException("No se pudo realizar producto de matrices ya que se recibio como parametro una matriz nula.");
		
		if	(dim != matriz.dim)
			throw new ArithmeticException("No se pudo realizar producto de matrices ya que la cantidad de columnas de la primera matriz no coincide con la cantidad de filas de la segunda.");
		
		//TODO: Esto no se podr� optimizar? tiene un costo de N al Cubo
		MatrizMath aux = new MatrizMath(cantFilas, matriz.cantColumnas);
		for (int i = 0; i < cantFilas; i++)
			for (int j = 0 ; j < matriz.cantColumnas ; j++)
				for (int k = 0; k < cantColumnas ; k++)
					aux.comp[i][j] += this.comp[i][k] * matriz.comp[k][j];
		
		return aux;
	}
	
	
	/**
	 * Realiza el producto entre este objeto y el objeto VectorMath especificado.
	 * @param vector - vector con el cual realizar el producto.
	 * @return la matriz que resulta del producto entre este objeto y el objeto VectorMath especificado.
	 */
	public MatrizMath productoPorVector(VectorMath vector)
	{
		if (vector == null)
			throw new IllegalArgumentException("No se pudo realizar producto entre matriz y vector ya que se recibio como parametro un vector nulo.");
		
		if (cantColumnas != vector.getDimension())
			throw new ArithmeticException("No se pudo realizar producto entre matriz y vector ya que la cantidad de columnas de la matriz no coincide con la dimension del vector.");
		
        MatrizMath m = new MatrizMath(cantFilas, 1);
        for (int i = 0 ; i < cantFilas; i++)
            for(int j = 0 ; j < cantColumnas ; j++)
                m.comp[i][0] += this.comp[i][j] * vector.getPosicion(j);

        return m;
	}
	
	
	/**
	 * Realiza el producto de la matriz por un escalar.
	 * @param escalar - numero a ser multiplicado por cada componente de la matriz.
	 * @return la matriz que resulta de realizar el producto por el escalar recibido como parametro.
	 */
	public MatrizMath productoPorEscalar(float escalar)
	{
		MatrizMath m = new MatrizMath(this.cantFilas, this.cantColumnas);
		double esc = (double)escalar;		
		
		for (int i = 0 ; i < m.cantFilas ; i++)
			for (int j = 0 ; j < m.cantColumnas ; j++)
				m.comp[i][j] = this.comp[i][j] * esc;
		
		return m;
		
	}
	
	
	/**
	 * Calcula el determinante de este MatrizMath.
	 * @return determinante
	 * @throws CloneNotSupportedException - si este objeto no es cloneable
	 * @throws DistDimException - si la matriz no es cuadrada 
	 */
    public double determinante() throws CloneNotSupportedException, DistDimException
    {
    	
		if (cantFilas != cantColumnas)
			throw new DistDimException("No se pudo calcular el determinante ya que no es una matriz cuadrada.");
		
		int n = cantFilas; // como la matriz es cuadrada (cantFilas = cantColumnas) utilizo esta variable para evitar confusiones
    	
        MatrizMath aux = (MatrizMath)this.clone();
        
      //TODO: Esto no se podr� optimizar? tiene un costo de N al Cubo
        for (int k = 0 ; k < n - 1 ; k++)
            for (int i = k + 1 ; i < n ; i++)
                for (int j = k + 1 ; j < n ; j++)
                    aux.comp[i][j] -= aux.comp[i][k] * aux.comp[k][j] / aux.comp[k][k];

        double deter = 1.0;
        for (int i = 0 ; i < n ; i++)
            deter *= aux.comp[i][i];
        
        return Math.round(deter);
    }
    
    
    /**
     * Obtiene la matriz inversa de este MatrizMath.
     * @return matriz inversa
     * @throws CloneNotSupportedException - si este objeto no es cloneable
     */
    public MatrizMath inversa() throws CloneNotSupportedException
    {
		if (cantFilas != cantColumnas)
			throw new DistDimException("No se pudo calcular la inversa ya que no es una matriz cuadrada.");
		
        int n = cantFilas;
        MatrizMath a = (MatrizMath)this.clone();
        MatrizMath b = new MatrizMath(n, n);   //matriz de los términos independientes
        MatrizMath c = new MatrizMath(n, n);   //matriz de las incógnitas
        
        // matriz identidad
        for (int i = 0 ; i < n ; i++)
            b.comp[i][i] = 1.0;
        
        //TODO: Esto no se podr� optimizar? tiene un costo de N al Cubo        
        // transformación de la matriz y de los términos independientes
        for (int k = 0 ; k < n - 1 ; k++)
        {
            for (int i = k + 1 ; i < n ; i++)
            {
            	// términos independientes
                for (int s = 0 ; s < n ; s++)
                    b.comp[i][s] -= a.comp[i][k] * b.comp[k][s] / a.comp[k][k];
                
                // elementos de la matriz
                for (int j = k + 1 ; j < n ; j++)
                    a.comp[i][j] -= a.comp[i][k] * a.comp[k][j] / a.comp[k][k];
            }
        }
        
        //	cálculo de las incógnitas, elementos de la matriz inversa
        for (int s = 0 ; s < n ; s++)
        {
            c.comp[n-1][s] = b.comp[n-1][s] / a.comp[n-1][n-1];
            for (int i = n - 2 ; i >= 0 ; i--)
            {
                c.comp[i][s] = b.comp[i][s] / a.comp[i][i];
                
                for (int k = n-1 ; k > i ; k--)
                    c.comp[i][s] -= a.comp[i][k] * c.comp[k][s] / a.comp[i][i];
            }
        }
        
        return c;
    }
    
    
    /**
     * Calcula la norma uno de este MatrizMath. La norma uno es la maxima suma en las columnas.
     * @return norma uno
     */
    public double normaUno()
    {
    	double mayor = 0;
    	double acum;
    	
    	for (int j = 0 ; j < cantColumnas ; j++)
    	{
    		acum = 0;
    		for (int i = 0 ; i < cantFilas ; i++)
    			acum += Math.abs(comp[i][j]);
    		
    		if (j == 0 || acum > mayor)
    			mayor = acum;    			
    	}

    	return mayor;    			    		    	
    }
	
	
    /**
     * Calcula la norma dos de este MatrizMath. La norma dos es la raiz cuadrada de la suma de todas las componentes elevadas al cuadrado.
     * @return norma dos
     */
    public double normaDos()
    {
    	double suma = 0;
    	
		for (int i = 0 ; i < cantFilas ; i++)
			for (int j = 0 ; j < cantColumnas ; j++)
				suma += Math.pow(comp[i][j], 2);
		
		return Math.sqrt(suma);
    }
    
    
    /**
     * Caclula la norma infinito de este MatrizMath. La norma infinito es la maxima suma en las filas.
     * @return norma infinito
     */
    public double normaInfinito()
    {
    	double mayor = 0;
    	double acum;
    	
    	for (int i = 0 ; i < cantFilas ; i++)
    	{
    		acum = 0;
    		for (int j = 0 ; j < cantColumnas ; j++)
    			acum += Math.abs(comp[i][j]);
    		
    		if (i == 0 || acum > mayor)
    			mayor = acum;    			
    	}

    	return mayor; 
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
		
		MatrizMath other = (MatrizMath) obj;
		if (cantColumnas != other.cantColumnas)
			return false;
		
		if (cantFilas != other.cantFilas)
			return false;
		
		if (!Arrays.deepEquals(comp, other.comp))
			return false;
		
		if (dim != other.dim)
			return false;
		
		return true;
	}
    
    
}
