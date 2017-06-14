package tp4.source;

public class MatrizSimetrica {
	private int[] vector;
	private int orden;

	/*
	 * Crea una instancia de matriz simétrica
	 * @param dimension es la cantidad de filas o columnas de la matriz simétrica.
	 */
	public MatrizSimetrica(int dimension) throws Exception {
		if(dimension < 0)
			throw new Exception("La matriz debe tener como mínimo de tamaño 1");
		this.orden = dimension * dimension;
		int tamaño = (int) ((Math.pow(this.orden, 2) - this.orden) / 2);
		this.vector = new int[tamaño];
	}

	private int getIndice(int fila, int columna) {
		return fila * this.orden + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2) / 2);
	}

	private int getFila(int indice) {
		return this.vector.length - (int) Math.ceil(1 + (1 + 8 * Math.pow((this.vector.length - indice), 0.5)) / 2);
	}

	private int getColumna(int indice) {
		int fila = this.getFila(indice);
		return this.orden
				- (this.vector.length - indice - (int) ((this.orden - fila - 1) * 2 - (this.orden - fila - 1)) / 2);
	}

	public int getValor(int fila, int columna) {
		return this.vector[this.getIndice(fila, columna)];
	}

	public void setValor(int fila, int columna, int valor) {
		this.vector[this.getIndice(fila, columna)] = valor;
	}
}
