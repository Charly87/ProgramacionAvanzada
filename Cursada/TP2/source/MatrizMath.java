package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class MatrizMath {

	private int filas;
	private int columnas;
	private int dimension;
	private double[][] matriz;

	/**
	 * Inicializa un objeto MatrizMath con una matriz.
	 * 
	 * @param matriz
	 *            - matriz creada.
	 */
	public MatrizMath(double[][] matriz) {
		this.matriz = matriz;
		this.columnas = matriz[0].length;
		this.filas = matriz.length;
		this.dimension = this.filas * this.columnas;
	}

	/**
	 * Inicializa un objeto MatrizMath con la cantidad de filas y la cantidad de
	 * columnas especificadas.
	 * 
	 * @param filas
	 *            - cantidad de filas de la matriz.
	 * @param columnas
	 *            - cantidad de columnas de la matriz.
	 */
	public MatrizMath(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.dimension = filas * columnas;
		matriz = new double[filas][columnas];
	}

	/**
	 * Inicializa un objeto MatrizMath con el contenido del archivo de entrada
	 * especificado.
	 * 
	 * @param fileName
	 *            - nombre del archivo de entrada que contiene la dimension y
	 *            las componentes de la matriz.
	 * @throws FileNotFoundException
	 *             - si no se encuentra el archivo de entrada especificado.
	 * @throws InvalidInputException
	 *             - si la dimension no es valida o si el archivo tiene lineas
	 *             de mas.
	 */
	public MatrizMath(String fileName) throws FileNotFoundException, InvalidInputException {
		Scanner input = new Scanner(new File(fileName));
		input.useLocale(Locale.US);

		// la primera linea del archivo de entrada contiene la cantidad
		// de filas y de columnas de la matriz separadas por un espacio
		filas = input.nextInt();
		columnas = input.nextInt();
		if (filas < 1) {
			input.close();
			throw new InvalidInputException(
					"La cantidad de filas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		} else if (columnas < 1) {
			input.close();
			throw new InvalidInputException(
					"La cantidad de columnas de la matriz no es valida. Revisar archivo " + fileName + "\".");
		} else {
			dimension = filas * columnas;
			matriz = new double[filas][columnas];
		}

		// las lineas siguientes contienen cada componente de la matriz, con el
		// formato:
		// (nroFila) (nroColumna) (Componente)
		int cantComponentes = filas * columnas;
		int fila;
		int columna;
		for (int i = 0; i < cantComponentes; i++) {
			fila = input.nextInt();
			columna = input.nextInt();
			matriz[fila][columna] = input.nextDouble();
		}

		// si hay una linea mas en el archivo de entrada, entonces hay algo mal,
		// por lo tanto arrojo una excepcion
		if (input.hasNextLine()) {
			input.close();
			throw new InvalidInputException(
					"El archivo de entrada \"" + fileName + "\" tiene lineas de mas. Verificar.");
		}

		input.close();
	}

	/**
	 * Devuelve la matriz que resulta de sumar la matriz llamadora mas la matriz
	 * recibida por parametro.
	 * 
	 * @param matriz
	 *            - matriz a ser sumada.
	 * @return matriz resultante de la suma.
	 * @throws IllegalArgumentException
	 *             - si la matriz recibida es null.
	 * @throws DistDimException
	 *             - si la dimension de la matriz recibida no coincide con la de
	 *             la matriz llamadora.
	 */
	public MatrizMath sumar(MatrizMath matriz) throws IllegalArgumentException, DistDimException {
		if (matriz == null)
			throw new IllegalArgumentException(
					"No se pudo realizar suma de matrices ya que se recibio como parametro una matriz nula.");

		if (dimension != matriz.dimension)
			throw new DistDimException("No se pudo realizar la suma de matrices por ser de distinta dimension.");

		MatrizMath aux = new MatrizMath(filas, columnas);
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				aux.matriz[i][j] = this.matriz[i][j] + matriz.matriz[i][j];

		return aux;
	}

	/**
	 * Devuelve la matriz que resulta de restar la matriz llamadora menos la
	 * matriz recibida por parametro.
	 * 
	 * @param matriz
	 *            - matriz a ser sumada.
	 * @return matriz resultante de la suma.
	 * @throws IllegalArgumentException
	 *             - si la matriz recibida es null.
	 * @throws DistDimException
	 *             - si la dimension de la matriz recibida no coincide con la de
	 *             la matriz llamadora.
	 */
	public MatrizMath restar(MatrizMath matriz) throws IllegalArgumentException, DistDimException {
		if (matriz == null)
			throw new IllegalArgumentException(
					"No se pudo realizar resta de matrices ya que se recibio como parametro una matriz nula.");

		if (dimension != matriz.dimension)
			throw new DistDimException("No se pudo realizar la resta de matrices por ser de distinta dimension.");

		MatrizMath aux = new MatrizMath(filas, columnas);
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				aux.matriz[i][j] = this.matriz[i][j] - matriz.matriz[i][j];

		return aux;
	}

	/**
	 * Devuelve la matriz que resulta de realizar el producto entre la matriz
	 * llamadora por la matriz recibida por parametro.
	 * 
	 * @param matriz
	 *            - matriz con la cual realizar el producto
	 * @return matriz resultante del producto.
	 * @throws IllegalArgumentException
	 *             - si lamatriz recibida es null.
	 * @throws ArithmeticException
	 *             - si el producto no es compatible.
	 */
	public MatrizMath producto(MatrizMath matriz) throws IllegalArgumentException, ArithmeticException {
		if (matriz == null)
			throw new IllegalArgumentException(
					"No se pudo realizar producto de matrices ya que se recibio como parametro una matriz nula.");

		if (dimension != matriz.dimension)
			throw new ArithmeticException(
					"No se pudo realizar producto de matrices ya que la cantidad de columnas de la primera matriz no coincide con la cantidad de filas de la segunda.");

		MatrizMath aux = new MatrizMath(filas, matriz.columnas);
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < matriz.columnas; j++)
				for (int k = 0; k < columnas; k++)
					aux.matriz[i][j] += this.matriz[i][k] * matriz.matriz[k][j];

		return aux;
	}

	/**
	 * Realiza el producto entre este objeto y el objeto VectorMath
	 * especificado.
	 * 
	 * @param vector
	 *            - vector con el cual realizar el producto.
	 * @return la matriz que resulta del producto entre este objeto y el objeto
	 *         VectorMath especificado.
	 */
	public VectorMath producto(VectorMath vector) {
		if (vector == null)
			throw new IllegalArgumentException(
					"No se pudo realizar producto entre matriz y vector ya que se recibio como parametro un vector nulo.");

		if (columnas != vector.getDimension())
			throw new ArithmeticException(
					"No se pudo realizar producto entre matriz y vector ya que la cantidad de columnas de la matriz no coincide con la dimension del vector.");

		VectorMath v = new VectorMath(filas);

		for (int i = 0; i < filas; i++) {
			double suma = 0;
			for (int j = 0; j < columnas; j++)
				suma += this.matriz[i][j] * vector.getValor(j);

			v.setValor(i, suma);
		}

		return v;
	}

	/**
	 * Realiza el producto de la matriz por un escalar.
	 * 
	 * @param escalar
	 *            - numero a ser multiplicado por cada componente de la matriz.
	 * @return la matriz que resulta de realizar el producto por el escalar
	 *         recibido como parametro.
	 */
	public MatrizMath producto(float escalar) {
		MatrizMath m = new MatrizMath(this.filas, this.columnas);
		double esc = (double) escalar;

		for (int i = 0; i < m.filas; i++)
			for (int j = 0; j < m.columnas; j++)
				m.matriz[i][j] = this.matriz[i][j] * esc;

		return m;

	}

	/**
	 * Calcula el determinante de este MatrizMath.
	 * 
	 * @return determinante
	 * @throws CloneNotSupportedException
	 *             - si este objeto no es cloneable
	 * @throws DistDimException
	 *             - si la matriz no es cuadrada
	 */
	public double determinante() throws CloneNotSupportedException, DistDimException {

		if (filas != columnas)
			throw new DistDimException("No se pudo calcular el determinante ya que no es una matriz cuadrada.");

		int n = filas;

		MatrizMath aux = (MatrizMath) this.clone();

		for (int k = 0; k < n - 1; k++)
			for (int i = k + 1; i < n; i++)
				for (int j = k + 1; j < n; j++)
					aux.matriz[i][j] -= aux.matriz[i][k] * aux.matriz[k][j] / aux.matriz[k][k];

		double deter = 1.0;
		for (int i = 0; i < n; i++)
			deter *= aux.matriz[i][i];

		return deter;
	}

	/**
	 * Obtiene la matriz inversa de este MatrizMath.
	 * 
	 * @return matriz inversa
	 * @throws CloneNotSupportedException
	 *             - si este objeto no es cloneable
	 */
	public MatrizMath inversa() throws CloneNotSupportedException {
		if (filas != columnas)
			throw new DistDimException("No se pudo calcular la inversa ya que no es una matriz cuadrada.");

		if (this.determinante() == 0.0)
			throw new DistDimException("No se pudo calcular la inversa porque el determinante es cero.");

		MatrizMath identidad = new MatrizMath(this.filas, this.columnas);
		MatrizMath aux = (MatrizMath)this.clone();
		int filaPrincipal, fi, co, filaTriangulacion, i, j, n, m;
		int pivoteCero = 0;
		for (i = 0; i < this.filas; i++) {
			for (j = 0; j < this.columnas; j++) {
				if (i != j) {
					identidad.matriz[i][j] = 0;
				} else {
					identidad.matriz[i][j] = 1;
				}
			}
		}

		double pivote; 
		filaPrincipal = 0;
		
		while (filaPrincipal < this.filas - 1) {

			if (pivoteCero == 1) {
				pivoteCero = 0;
				filaPrincipal--;
			}
			if (aux.matriz[filaPrincipal][filaPrincipal] != 0) {
				
				for (filaTriangulacion = filaPrincipal + 1; filaTriangulacion < this.filas; filaTriangulacion++) {
					pivote = (aux.matriz[filaTriangulacion][filaPrincipal] / aux.matriz[filaPrincipal][filaPrincipal]);
					
					for (co = 0; co < this.columnas; co++) {
						aux.matriz[filaTriangulacion][co] -= pivote * aux.matriz[filaPrincipal][co];
						identidad.matriz[filaTriangulacion][co] -= pivote * identidad.matriz[filaPrincipal][co];
					}
				}
			} else {
				m = 0;
				n = filaPrincipal;
				while (pivoteCero == 0) {
					if (aux.matriz[n][filaPrincipal] != 0) {
						while (m < this.columnas) {
							aux.matriz[filaPrincipal][m] += aux.matriz[n][m];
							identidad.matriz[filaPrincipal][m] += identidad.matriz[n][m];
							m++;
						} 
						pivoteCero = 1;
					} 
					n++;
				} 

			} 
			filaPrincipal++;
		} 
		
		for (filaPrincipal = this.filas - 1; filaPrincipal > 0; filaPrincipal--) {
			for (filaTriangulacion = filaPrincipal - 1; filaTriangulacion >= 0; filaTriangulacion--) {
				pivote = (aux.matriz[filaTriangulacion][filaPrincipal] / aux.matriz[filaPrincipal][filaPrincipal]);
				for (co = 0; co < this.columnas; co++) {
					aux.matriz[filaTriangulacion][co] -= pivote * aux.matriz[filaPrincipal][co];
					identidad.matriz[filaTriangulacion][co] -= pivote * identidad.matriz[filaPrincipal][co];
				}

			}
		}
		for (fi = 0; fi < this.filas; fi++) {
			pivote = aux.matriz[fi][fi];
			for (co = 0; co < this.columnas; co++) {
				aux.matriz[fi][co] /= pivote;
				identidad.matriz[fi][co] /= pivote;
			}

		}
		return identidad;
	}

	/**
	 * Calcula la norma uno de este MatrizMath. La norma uno es la maxima suma
	 * en las columnas.
	 * 
	 * @return norma uno
	 */
	public double normaUno() {
		if (this.filas != this.columnas)
			throw new DistDimException("Matriz no cuadrada");
		
		double mayor = 0;
		double acum;

		for (int j = 0; j < columnas; j++) {
			acum = 0;
			for (int i = 0; i < filas; i++)
				acum += Math.abs(matriz[i][j]);

			if (j == 0 || acum > mayor)
				mayor = acum;
		}

		return mayor;
	}

	/**
	 * Calcula la norma dos de este MatrizMath. La norma dos es la raiz cuadrada
	 * de la suma de todas las componentes elevadas al cuadrado.
	 * 
	 * @return norma dos
	 */
	public double normaDos() {
		if (this.filas != this.columnas)
			throw new DistDimException("Matriz no cuadrada");
		
		double suma = 0;

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				suma += Math.pow(matriz[i][j], 2);

		return Math.sqrt(suma);
	}

	/**
	 * Caclula la norma infinito de este MatrizMath. La norma infinito es la
	 * maxima suma en las filas.
	 * 
	 * @return norma infinito
	 */
	public double normaInfinito() {
		double mayor = 0;
		double acum;

		for (int i = 0; i < filas; i++) {
			acum = 0;
			for (int j = 0; j < columnas; j++)
				acum += Math.abs(matriz[i][j]);

			if (i == 0 || acum > mayor)
				mayor = acum;
		}

		return mayor;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public int getDim() {
		return dimension;
	}

	public void setPunto(int fila, int columna, double valor) {
		if (fila < this.filas && columna < this.columnas)
			this.matriz[fila][columna] = valor;
	}

	public double getPunto(int fila, int columna) {
		return matriz[fila][columna];
	}

	public double[][] getMatriz() {
		return matriz;
	}

	/**
	 * Muestra la matriz con el formato: <br>
	 * a11 a12 ... a1n <br>
	 * a21 a22 ... a2n <br>
	 * &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br>
	 * &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br>
	 * &nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.
	 * <br>
	 * am1 am2 ... amn
	 */
	public String toString() {
		String ms = "\n";

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++)
				ms = ms.concat(matriz[i][j] + " ");
			ms = ms.concat("\n");
		}

		return ms;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		MatrizMath other = (MatrizMath) obj;
		if (columnas != other.columnas)
			return false;

		if (filas != other.filas)
			return false;

		if (dimension != other.dimension)
			return false;

		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				if (Math.abs(other.getMatriz()[i][j] - this.matriz[i][j]) > 0.00001)
					return false;

		return true;
	}

	@Override
	public Object clone() {
		double[][] aux = new double[this.filas][this.columnas];
		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				aux[i][j] = this.matriz[i][j];
		return new MatrizMath(aux);
	}
}
