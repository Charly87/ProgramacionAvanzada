package dijktra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijktra {
	int orden;
	Map<Integer, Integer> nodosNoEvaluados;
	Map<Integer, Integer> nodosEvaluados;
	int[][] matriz;

	public Dijktra(int orden) {

		this.orden = orden;
		nodosNoEvaluados = new HashMap<Integer, Integer>();
		nodosEvaluados = new HashMap<Integer, Integer>();
		this.inicializarMatriz();
	}

	private void inicializarMatriz() {
		this.matriz = new int[this.orden][this.orden];

		for (int i = 0; i < this.orden; i++)
			for (int j = 0; j < this.orden; j++)
				this.matriz[i][j] = Integer.MAX_VALUE;
	}

	public void agregarNodo(int nodo) {

		nodosNoEvaluados.put(nodo, nodo);
	}

	public void conectarNodos(int nodo1, int nodo2, int peso) {
		matriz[nodo1 - 1][nodo2 - 1] = peso;
		matriz[nodo2 - 1][nodo1 - 1] = peso;
	}

	public void mostrarMatrizAdyacencia() {
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
			{
				if(matriz[i][j] == Integer.MAX_VALUE)
					System.out.printf("%12s","-");
				else
					System.out.printf("%12s", matriz[i][j]);
			}
			System.out.println();
		}
	}

	public void resolver(int idNodo) {

		this.nodosEvaluados.put(idNodo, idNodo);
		this.nodosNoEvaluados.remove(idNodo);

		// Obtengo todos los nodos adyacentes al nodo inicial
		int[] distancias = matriz[idNodo - 1].clone();
		while (nodosNoEvaluados.size() > 0) {

			int min = Integer.MAX_VALUE;
			int nodoMin = 0;

			// Busco el nodo adyacente con menor distancia
			for (int nodo : this.nodosNoEvaluados.values()) {
				if (distancias[nodo - 1] < min) {
					min = distancias[nodo - 1];
					nodoMin = nodo;
				}
			}

			// Evaluo los nodos adyacentes al nodo obtenido
			for (int j = 0; j < orden; j++) {
				if (matriz[nodoMin - 1][j] != Integer.MAX_VALUE && !nodosEvaluados.containsKey(j + 1)) {

					int directo = distancias[j];
					int indirecto = distancias[nodoMin - 1] + matriz[nodoMin - 1][j];

					if (indirecto < directo)
						distancias[j] = indirecto;
				}
			}

			// Indico que el nodo fue evaluado;
			nodosEvaluados.put(nodoMin, nodoMin);
			nodosNoEvaluados.remove(nodoMin);
		}

		System.out.println("\n\nDistancias minimas desde el nodo " + idNodo + " hacia los demas nodos:");
		for (int i = 0; i < orden; i++) {
			System.out.print("[" + (i + 1) + "]");
		}
		System.out.println();
		for (int i = 0; i < orden; i++) {
			if(distancias[i] == Integer.MAX_VALUE)
				System.out.print(" - ");
			else
				System.out.print(" " + distancias[i] + " ");
		}
	}
}
