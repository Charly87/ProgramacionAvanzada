package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Dfs {
	private boolean dirigido;
	private int grado;
	private int[][] matriz;

	private int costo;
	private List<Nodo> nodos;
	private Stack<Nodo> nodosVisitados;

	public Dfs(int grado, boolean dirigido) {
		this.dirigido = dirigido;
		this.grado = grado;
		this.nodos = new ArrayList<Nodo>();
		this.nodosVisitados = new Stack<Nodo>();
		this.inicializarMatriz();
	}

	private void inicializarMatriz() {
		this.matriz = new int[this.grado][this.grado];
		for (int i = 0; i < this.grado; i++)
			for (int j = 0; j < this.grado; j++)
				this.matriz[i][j] = Integer.MAX_VALUE;
	}

	public void agregarConexion(int nodo1, int nodo2, int peso) {
		this.matriz[nodo1 - 1][nodo2 - 1] = peso;

		if (!this.dirigido)
			this.matriz[nodo2 - 1][nodo1 - 1] = peso;

	}

	public void agregarNodo(int nodo) {
		this.nodos.add(new Nodo(nodo));
	}

	public void resolver(int idNodo) {

		Collections.sort(this.nodos);
		
		Nodo nodo = this.nodos.get(idNodo - 1);
		nodo.setVisitado(true);
		this.nodosVisitados.push(nodo);	

		while (!this.nodosVisitados.isEmpty()) {		

			Nodo nodoActual = this.nodosVisitados.pop();	
			System.out.print(nodoActual.getId() + " ");
			boolean hayNodoSinVisitar = false;
			
			for(int j = 0; j < this.nodos.size() ; j++)
			{
				if (this.matriz[nodoActual.getId() -1 ][j] != Integer.MAX_VALUE && !this.nodos.get(j).getVisitado()) {

					Nodo nodoNoVisitado = this.nodos.get(j);
					nodoNoVisitado.setVisitado(true);
					this.nodosVisitados.push(nodoNoVisitado);
				}
			}				
		} 	
	}
	
	public void mostrarResultado()
	{
		int cont = 0;
		for (Nodo n : this.nodos)
			if (n.getVisitado())
				cont++;

		if (cont == this.grado)
			System.out.println("El grafo es conexo");
		else
			System.out.println("El grafo NO es conexo");	
	}
}
