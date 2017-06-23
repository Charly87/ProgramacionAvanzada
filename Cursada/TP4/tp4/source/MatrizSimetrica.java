package tp4.source;

public class MatrizSimetrica {
	private int[] vector;
	private int dimension;

	/*
	 * Crea una instancia de matriz simétrica
	 * 
	 * @param dimension es la cantidad de filas o columnas de la matriz
	 * simétrica.
	 */
	public MatrizSimetrica(int dimension) throws Exception {
		if (dimension < 2)
			throw new Exception("La matriz debe ser mayor o igual a dimension 2");
		this.dimension = dimension;
		int tamaño = (int) ((Math.pow(this.dimension, 2) - this.dimension) / 2);
		this.vector = new int[tamaño];
	}

	private int getIndice(int fila, int columna) {
		return fila * this.dimension + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2) / 2);
	}

	// No deberiamos usarlo este método
	private int getFila(int indice) {
		return this.vector.length - (int) Math.ceil(1 + (1 + 8 * Math.pow((this.vector.length - indice), 0.5)) / 2);
	}

	// No deberiamos usarlo este método
	private int getColumna(int indice) {
		int fila = this.getFila(indice);
		return this.dimension - (this.vector.length - indice
				- (int) ((this.dimension - fila - 1) * 2 - (this.dimension - fila - 1)) / 2);
	}

	public int getValor(int fila, int columna) {
		if (fila == columna)
			return 0;
		if (fila > columna)
			return this.vector[this.getIndice(columna, fila)];
		return this.vector[this.getIndice(fila, columna)];
	}

	public void setValor(int fila, int columna, int valor) {
		if (fila == columna)
			return;
		if (fila > columna)
			this.vector[this.getIndice(columna, fila)] = valor;
		this.vector[this.getIndice(fila, columna)] = valor;
	}

	public void visualizarVector() {
		System.out.print("Vector[i]: ");
		for (int i = 0; i < this.vector.length; i++) {
			System.out.print(this.vector[i]);
		}
		System.out.println();
	}

	public void visualizar() {
		System.out.println("Vector[i]: ");
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.print(getValor(i, j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getCantidadNodos() {
		return this.dimension/2;
	}

	public int getCantidadAristasTotales() {
		int nodos = getCantidadNodos();
		return nodos * (nodos - 1) / 2;
	}

	public int getCantidadAristas() {
		int cant = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > 0) {
				cant++;
			}
		}
		return cant;
	}

	public int getGradoMax() {
		int max = 0;
		int maxant = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = i + 1; j < dimension; j++) {
				if (getValor(i, j) != 0 && ++max >= maxant) {
					maxant = max;
				}
			}
			max = 0;
		}
		return maxant;
	}

	public int getGradoMin() {
		int min = 0;
		int minant = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = i + 1; j < dimension; j++) {
				if (getValor(i, j) != 0 && ++min <= minant) {
					minant = min;
				}
			}
			min = 0;
		}
		return minant;
	}
	
	public double getPorcentajeAdyacencia(){
		return this.getCantidadAristas()*100/this.getCantidadAristasTotales();
	}
	
	public int getNodoOrigen(){
		return
	}
}
