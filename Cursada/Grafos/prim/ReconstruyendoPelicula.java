package prim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ReconstruyendoPelicula {

	private int cantSegmentos;
	private int cantEscenas;
	private int[][] matriz;

	private List<int[]> segmentos;
	private List<Integer> segmentosFinal;
	private SortedSet<Integer> segmentosNoEvaluados;
	private SortedSet<Integer> segmentosEvaluados;
	private HashMap<Integer, int[]> segmentosAntecesores;
	private List<Integer> resultado;

	public ReconstruyendoPelicula(String file) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));
		this.cantSegmentos = s.nextInt();
		this.cantEscenas = s.nextInt();

		this.segmentos = new ArrayList<int[]>();
		this.segmentosFinal = new ArrayList<Integer>();
		for (int i = 0; i < this.cantSegmentos; i++) {
			int[] segmento = new int[] { s.nextInt(), s.nextInt(), s.nextInt() };
			this.segmentos.add(segmento);
			if (segmento[2] == this.cantEscenas)
				this.segmentosFinal.add(segmento[0]);
		}

		// ID INI FIN
		// 1 10 30
		// 2 25 40
		int dif;
		this.matriz = new int[this.cantSegmentos][this.cantSegmentos];
		for (int i = 0; i < this.cantSegmentos; i++)
			for (int j = i + 1; j < this.cantSegmentos; j++) {
				dif = this.segmentos.get(i)[2] - this.segmentos.get(j)[1] + 1;
				this.matriz[i][j] = dif < 0 ? Integer.MAX_VALUE : dif;
				this.matriz[j][i] = dif < 0 ? Integer.MAX_VALUE : dif;
			}

		this.segmentosNoEvaluados = new TreeSet<Integer>();
		for (int[] seg : this.segmentos)
			this.segmentosNoEvaluados.add(seg[0]);

		this.segmentosEvaluados = new TreeSet<Integer>();
		this.segmentosAntecesores = new HashMap<Integer, int[]>();
	}

	public void mostrarMatriz() {
		System.out.print("    ");
		for (int i = 0; i < this.cantSegmentos; i++)
			System.out.printf("%4s", "[" + (i + 1) + "]");
		System.out.println();
		for (int i = 0; i < this.cantSegmentos; i++) {
			System.out.print("[" + (i + 1) + "]");
			for (int j = 0; j < this.cantSegmentos; j++)
				if (this.matriz[i][j] == Integer.MAX_VALUE)
					System.out.printf("%4s", "-");
				else
					System.out.printf("%4s", this.matriz[i][j]);
			System.out.println();
		}
	}

	public void prim(int idSegmento) {

		this.segmentosAntecesores.put(idSegmento, new int[] { idSegmento, 0 });
		this.segmentosEvaluados.add(idSegmento);
		this.segmentosNoEvaluados.remove(idSegmento);

		while (this.segmentosNoEvaluados.size() > 0) {
			int min = Integer.MAX_VALUE;

			int segmentoMin = 0;
			int segmentoAnterior = 0;
			for (int segmentoEvaluado : this.segmentosEvaluados)
				for (int segmentoNoEvaluado : this.segmentosNoEvaluados) {
					int valor = this.matriz[segmentoEvaluado - 1][segmentoNoEvaluado - 1];
					if (valor != Integer.MAX_VALUE && valor < min) {
						min = valor;
						segmentoAnterior = segmentoEvaluado;
						segmentoMin = segmentoNoEvaluado;
					}
				}

			this.segmentosAntecesores.put(segmentoMin, new int[] { segmentoAnterior, min });
			this.segmentosEvaluados.add(segmentoMin);
			this.segmentosNoEvaluados.remove(segmentoMin);
		}
	}

	public void resolver(int idSegmento) {

		this.prim(idSegmento);

		// Itero en todas las ramas del arbol y obtengo la de menor costo y tamaño
		List<Integer> vecAnt = new ArrayList<Integer>();
		int costoAnt = 0;
		int seg;

		// Por cada segmento final
		for (int segmentoFinal : this.segmentosFinal) {
			List<Integer> vecAct = new ArrayList<Integer>();
			int[] antecesor = new int[] { segmentoFinal };
			int costoAct = 0;

			// Buscamos la rama usando los segmentos antecesores
			do {
				seg = antecesor[0];
				antecesor = this.segmentosAntecesores.get(seg);
				vecAct.add(seg);
				costoAct += antecesor[1];

			} while (seg != antecesor[0]);

			if (vecAnt.size() == 0 || costoAnt == 0 || costoAct < costoAnt
					|| costoAct == costoAnt && vecAct.size() < vecAnt.size()) {
				vecAnt = new ArrayList<Integer>(vecAct);
				costoAnt = costoAct;
			}
		}
		// Guardo la rama como resultado
		this.resultado = vecAnt;
	}

	public void mostrarResultado() {
		System.out.println();
		for (int i = this.resultado.size(); i > 0; i--)
			System.out.print(this.resultado.get(i - 1) + " ");
	}
}
