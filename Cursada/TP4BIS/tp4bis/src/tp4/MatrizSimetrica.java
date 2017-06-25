package tp4bis.src.tp4;

public class MatrizSimetrica {

	private int cantNodos;// Orden de la matriz
	private int tam;// Tama�o del vector
	private boolean matrizDeAdyacencia[];

	public MatrizSimetrica(int n) {
		this.cantNodos = n;
		this.tam = (int) ((Math.pow(n, 2) - n) / 2);// tama�o del vector
		this.matrizDeAdyacencia = new boolean[this.tam];
	}

	public boolean getValor() { // esta de m�s?
		return false;
	}

	public void setValor(int fila, int columna, boolean valor) {
		int i = getPos(fila, columna);
		matrizDeAdyacencia[i] = valor;
	}
	

	public boolean getValor(int fila, int columna) {
		int i = getPos(fila, columna);
		return matrizDeAdyacencia[i];
	}

	private int getPos(int fila, int columna) {
		int aux, i;
		if (fila > columna) {
			aux = fila;
			fila = columna;
			columna = aux;
		}
		i = fila * this.cantNodos + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2)) / 2;
		return i;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public boolean[] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(boolean[] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}
}
