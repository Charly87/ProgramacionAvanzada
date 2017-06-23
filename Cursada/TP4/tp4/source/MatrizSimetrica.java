package tp4.source;

public class MatrizSimetrica {
	private int[] vector;
	private int nodos;

	/*
	 * Crea una instancia de matriz simétrica
	 * 
	 * @param nodos es la cantidad de filas o columnas de la matriz simétrica.
	 */
	public MatrizSimetrica(int nodos) throws Exception {
		if (nodos < 2)
			throw new Exception("La matriz debe ser mayor o igual a dimension 2");
		this.nodos = nodos;
		int tamaño = (int) ((Math.pow(this.nodos, 2) - this.nodos) / 2);
		this.vector = new int[tamaño];
	}

	private int getIndice(int fila, int columna) {
		return fila * this.nodos + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2) / 2);
	}

	// No deberiamos usarlo este método
	private int getFila(int indice) {
		return this.vector.length - (int) Math.ceil(1 + (1 + 8 * Math.pow((this.vector.length - indice), 0.5)) / 2);
	}

	// No deberiamos usarlo este método
	private int getColumna(int indice) {
		int fila = this.getFila(indice);
		return this.nodos
				- (this.vector.length - indice - (int) ((this.nodos - fila - 1) * 2 - (this.nodos - fila - 1)) / 2);
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
		for (int i = 0; i < this.nodos; i++) {
			for (int j = 0; j < this.nodos; j++) {
				System.out.print(getValor(i, j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getCantidadNodos() {
		return this.nodos;
	}

	public int getCantidadAristasTotales() {		
		return this.nodos * (this.nodos - 1) / 2;
	}

	public int getCantidadAristas() {
		int cant = 0;
		for (int i = 0; i < vector.length; i++)
			if (vector[i] > 0)
				cant++;
		return cant;
	}

	public int getGradoMax() {
		int max = 0;
		int maxant = 0;
		for (int i = 0; i < nodos; i++) {
			for (int j = i + 1; j < nodos; j++) {
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
		for (int i = 0; i < nodos; i++) {
			for (int j = i + 1; j < nodos; j++) {
				if (getValor(i, j) != 0 && ++min <= minant) {
					minant = min;
				}
			}
			min = 0;
		}
		return minant;
	}

	public double getPorcentajeAdyacencia() {
		return this.getCantidadAristas() * 100 / this.getCantidadAristasTotales();
	}

}
