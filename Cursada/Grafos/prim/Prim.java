package prim;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Prim {
	private int orden;
	private int[][] matriz;
	private List<Integer> arbol;
	private int costo;
	private SortedSet<Integer> nodosEvaluados;
	private SortedSet<Integer> nodosNoEvaluados;

	public Prim(int orden) {
		this.orden = orden;
		this.arbol = new LinkedList<Integer>();
		this.nodosEvaluados = new TreeSet<Integer>();
		this.nodosNoEvaluados = new TreeSet<Integer>();
		this.inicializarMatriz();
	}

	private void inicializarMatriz() {
		this.matriz = new int[this.orden][this.orden];
		for (int i = 0; i < this.orden; i++)
			for (int j = 0; j < this.orden; j++)
				this.matriz[i][j] = Integer.MAX_VALUE;
	}

	public void agregarConexion(int nodo1, int nodo2, int peso) {
		this.matriz[nodo1 - 1][nodo2 - 1] = peso;
		this.matriz[nodo2 - 1][nodo1 - 1] = peso;

		if (!this.nodosNoEvaluados.contains(nodo1))
			this.nodosNoEvaluados.add(nodo1);

		if (!this.nodosNoEvaluados.contains(nodo2))
			this.nodosNoEvaluados.add(nodo2);
	}

	public void resolver(int idNodo) {
		
		this.arbol.add(idNodo);
		this.nodosEvaluados.add(idNodo);
		this.nodosNoEvaluados.remove(idNodo);		

		while (this.nodosNoEvaluados.size() > 0) {
			int min = Integer.MAX_VALUE;
			int nodoMin = 0;
			for (int nodoEvaluado : this.nodosEvaluados) {
				for (int nodoNoEvaluado : this.nodosNoEvaluados) {
					if (this.matriz[nodoEvaluado - 1][nodoNoEvaluado - 1] < min) {
						min = this.matriz[nodoEvaluado - 1][nodoNoEvaluado - 1];
						nodoMin = nodoNoEvaluado;
					}
				}
			}

			costo += min;
			
			this.arbol.add(nodoMin);
			this.nodosEvaluados.add(nodoMin);
			this.nodosNoEvaluados.remove(nodoMin);
		}
	}
	
	public void mostrarArbol()
	{
		for(int nodo : this.arbol)
			System.out.print(nodo + ", ") ;		
		System.out.println("Costo Mínimo: " + this.costo);
	}
}
