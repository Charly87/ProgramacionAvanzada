package floyd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gusano {

	private int enlaces;
	private int[][] matrizAdyacencia;

	private int[][] matrizRecorridos;
	private int[][] matrizTiempos;

	private List<int[]> horarios;
	private List<int[]> sentidoVirus;
	private SortedSet<Integer> resultado;

	public Gusano(String file) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));
		this.enlaces = s.nextInt();

		this.matrizAdyacencia = new int[this.enlaces][this.enlaces];
		for (int i = 0; i < this.enlaces; i++)
			for (int j = 0; j < this.enlaces; j++)
				this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;

		int origen;
		int tiempo;
		int destino;
		this.sentidoVirus = new ArrayList<int[]>();
		for (int i = 0; i < this.enlaces; i++) {
			origen = s.nextInt();
			tiempo = s.nextInt();
			destino = s.nextInt();
			this.matrizAdyacencia[origen - 1][destino - 1] = tiempo;
			this.matrizAdyacencia[destino - 1][origen - 1] = tiempo;
			this.sentidoVirus.add(new int[] { origen, destino });
		}

		this.matrizRecorridos = new int[this.enlaces][this.enlaces];
		for (int i = 0; i < this.enlaces; i++)
			for (int j = 0; j < this.enlaces; j++)
				this.matrizRecorridos[i][j] = j + 1;

		this.horarios = new ArrayList<int[]>();
		int pares = s.nextInt();
		for (int i = 0; i < pares; i++)
			this.horarios.add(new int[] { s.nextInt(), s.nextInt() });

	}

	public void mostrarMatrizAdyacencia() {
		System.out.println("MATRIZ ADYACENCIA");
		System.out.println("====== ==========");
		System.out.print("    ");
		for (int i = 0; i < this.enlaces; i++)
			System.out.printf("%4s", "[" + (i + 1) + "]");
		System.out.println();
		for (int i = 0; i < this.enlaces; i++) {
			System.out.print("[" + (i + 1) + "]");
			for (int j = 0; j < this.enlaces; j++)
				if (this.matrizAdyacencia[i][j] == Integer.MAX_VALUE)
					System.out.printf("%4s", "-");
				else
					System.out.printf("%4s", this.matrizAdyacencia[i][j]);
			System.out.println();
		}
	}

	public void mostrarMatrizTiempos() {
		System.out.println("MATRIZ TIEMPOS");
		System.out.println("====== =======");
		System.out.print("    ");
		for (int i = 0; i < this.enlaces; i++)
			System.out.printf("%4s", "[" + (i + 1) + "]");
		System.out.println();
		for (int i = 0; i < this.enlaces; i++) {
			System.out.print("[" + (i + 1) + "]");
			for (int j = 0; j < this.enlaces; j++)
				if (this.matrizTiempos[i][j] == Integer.MAX_VALUE)
					System.out.printf("%4s", "-");
				else
					System.out.printf("%4s", this.matrizTiempos[i][j]);
			System.out.println();
		}
	}

	public void mostrarMatrizRecorrido() {
		System.out.println("MATRIZ RECORRIDO");
		System.out.println("====== =========");
		System.out.print("    ");
		for (int i = 0; i < this.enlaces; i++)
			System.out.printf("%4s", "[" + (i + 1) + "]");
		System.out.println();
		for (int i = 0; i < this.enlaces; i++) {
			System.out.print("[" + (i + 1) + "]");
			for (int j = 0; j < this.enlaces; j++)
				if (this.matrizRecorridos[i][j] == Integer.MAX_VALUE)
					System.out.printf("%4s", "-");
				else
					System.out.printf("%4s", this.matrizRecorridos[i][j]);
			System.out.println();
		}
	}

	public void floyd() {
		int tiempo;
		this.matrizTiempos = this.matrizAdyacencia.clone();
		for (int i = 0; i < this.enlaces; i++)
			this.matrizTiempos[i][i] = 0;

		// K es el nodo que tomo (A... B.. C...)
		for (int k = 0; k < this.enlaces; k++) {
			// Por cada nodo, recorro la matriz (i,j)
			for (int i = 0; i < this.enlaces; i++) {
				for (int j = 0; j < this.enlaces; j++) {
					if (this.matrizTiempos[i][k] != Integer.MAX_VALUE && this.matrizTiempos[k][j] != Integer.MAX_VALUE
							&& j != i) {
						tiempo = this.matrizTiempos[i][k] + this.matrizTiempos[k][j];
						if (tiempo < this.matrizTiempos[i][j]) {
							this.matrizTiempos[i][j] = tiempo;
							this.matrizRecorridos[i][j] = k + 1;
						}
					}
				}
			}
		}
	}

	public void resolver() {
		this.floyd();
		mostrarMatrizTiempos();
		mostrarMatrizRecorrido();

		resultado = new TreeSet<Integer>();
		for (int[] horario : this.horarios) {
			{
				int fila = horario[0];
				int tiempo = horario[1];
				int col;
				int filaRecorrido;
				for (int j = 0; j < this.enlaces; j++) {
					col = j + 1;
					if (fila != col && tiempo == this.matrizTiempos[fila - 1][col - 1]) {
						filaRecorrido = fila;
						int contenido;
						boolean esOrigenDestino;

						do {
							contenido = this.matrizRecorridos[filaRecorrido - 1][col - 1];
							esOrigenDestino = this.verificarOrigenDestino(contenido, filaRecorrido);
							if (esOrigenDestino) {
								filaRecorrido = contenido;
								if (contenido == col)
									resultado.add(col);
							}
						} while (contenido != col && esOrigenDestino);
					}
				}
			}
		}
	}

	public boolean verificarOrigenDestino(int pc1, int pc2) {

		boolean esOrigenDestino = false;
		for (int[] sentido : this.sentidoVirus) {
			if (sentido[0] == pc1 && sentido[1] == pc2)
				esOrigenDestino = true;

		}
		return esOrigenDestino;
	}

	public void mostrarReultado() {
		System.out.println();
		for (int pc : this.resultado) {
			System.out.print(pc + " ");
		}
	}
}
