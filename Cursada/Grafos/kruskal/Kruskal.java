package kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Kruskal {

	private int orden;
	private int[] padre;

	private List<int[]> aristas;
	private SortedSet<Integer> nodosEvaluados;

	public Kruskal(int orden) {
		this.orden = orden;
		this.padre = new int[orden];
		this.aristas = new ArrayList<int[]>();	
		this.inicializacion();
	}

	public void inicializacion() {
		for (int i = 0; i < this.orden; i++)
			padre[i] = i;
	}

	public int find(int x) {
		return x == this.padre[x] ? x : find(this.padre[x]);
	}

	public void union(int x, int y) {
		this.padre[this.find(x)] = this.find(y);
	}

	public void añadirArista(int x, int y, int valor) {
		this.aristas.add(new int[] { x, y, valor });
	}

	public void resolver() {
		this.aristas.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] a1, int[] a2) {
				return Integer.compare(a1[2], a2[2]);
			}
		});

		for (int[] arista : this.aristas) {
			int x = this.find(arista[0] - 1);
			int y = this.find(arista[1] - 1);
			
			if (x != y) {
				System.out.println((x + 1) + " " + (y + 1) + " " + arista[2]);
				this.union(arista[0] - 1, arista[1] - 1);
			}
		}
	}
}
