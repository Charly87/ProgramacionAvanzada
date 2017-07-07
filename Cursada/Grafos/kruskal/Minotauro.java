package kruskal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Minotauro {

	private int cantDescansos;
	private int[][] matriz;
	private List<int[]> pasajes;

	private int[] padres;

	private List<int[]> resultado;

	public Minotauro(String file) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));
		this.cantDescansos = s.nextInt();

		this.matriz = new int[this.cantDescansos][this.cantDescansos];
		for (int i = 0; i < this.cantDescansos; i++)
			for (int j = 0; j < this.cantDescansos; j++)
				this.matriz[i][j] = s.nextInt();

		this.pasajes = new ArrayList<int[]>();
		for (int i = 0; i < this.cantDescansos; i++)
			for (int j = i + 1; j < this.cantDescansos; j++)
				this.pasajes.add(new int[] { i + 1, j + 1, this.matriz[i][j] });

		this.pasajes.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				return Integer.compare(p1[2], p2[2]);
			}
		});

		this.inicializar();
	}

	public void inicializar() {
		this.padres = new int[this.cantDescansos];
		for (int i = 0; i < this.cantDescansos; i++)
			this.padres[i] = i;
	}

	public int find(int x) {
		return x == this.padres[x] ? x : this.find(this.padres[x]);
	}

	public void union(int x, int y) {
		this.padres[this.find(x)] = this.find(y);
	}

	public void resolver() {
		this.resultado = new ArrayList<int[]>();
		int x;
		int y;
		for (int[] pasaje : this.pasajes) {
			x = this.find(pasaje[0] - 1);
			y = this.find(pasaje[1] - 1);

			if (x != y) {
				this.union(pasaje[0] - 1, pasaje[1] - 1);
				this.resultado.add(pasaje);
			}
		}
	}

	public void mostrarResultado() {
		System.out.println(this.resultado.size());
		for (int[] r : this.resultado)
			System.out.println(r[0] + " " + r[1] + " " + r[2]);
	}
}
