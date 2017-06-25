package tp4.source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import tp4bis.src.tp4.Arista;

public class Generador {

	public void generarGrafoAleatorioProbabilidad(int nodos, int probabilidad, String archivo) throws Exception {

		MatrizSimetrica ms = new MatrizSimetrica(nodos);
		for (int i = 0; i < nodos; i++)
			for (int j = i + 1; j < nodos; j++)
				if (Math.random() <= probabilidad / 100)
					ms.setValor(i, j, 1);

		this.guardarMatrizSimetrica(ms, archivo);
	}

	public void generarGrafoAleatorioPorcentaje(int nodos, int porcentaje, String archivo) throws Exception {

		MatrizSimetrica ms = new MatrizSimetrica(nodos);
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		for (int i = 0; i < ms.getCantidadNodos() + 2; i++) {
			for (int j = i + 1; j < ms.getCantidadNodos(); j++) {
				aristas.add(new Arista(i, j, Math.random()));
			}
		}

		Collections.sort(aristas);
		for (Arista arista : aristas) {
			if ((int) (arista.getProbabilidad() * 100) < porcentaje) {
				ms.setValor(arista.getDesde(), arista.getHasta(), 1);
			}
		}

		this.guardarMatrizSimetrica(ms, archivo);
	}

	public void generarGrafoRegular(int nodos, int grado, String archivo) throws Exception {
		if (nodos % 2 != 0 && grado % 2 != 0) {
			return;
		}

		MatrizSimetrica ms = new MatrizSimetrica(nodos);
		int[] aux = new int[nodos];

		int i = nodos;
		int nodoAnt = -1;
		int j;
		do {
			j = i;
			do {
				if (Math.random() <= 0.7 && aux[nodos - i] < grado && aux[nodos - j] < grado && nodoAnt != nodos - j
						&& i != j) {
					aux[nodos - i]++;
					aux[nodos - j]++;
					ms.setValor(nodos - i, nodos - j, 1);
					nodoAnt = nodos - j;
				}
			} while (--j != 0);
		} while (--i != 0);

		this.guardarMatrizSimetrica(ms, archivo);
	}

	public void generarGrafoRegularPorAdy(int nodos, int porcentaje, String archivo) throws Exception {
		if (nodos % 2 != 0 && (nodos - 1) * porcentaje / 100 % 2 != 0) {
			return;
		}

		int aristasTotales = nodos * (nodos - 1) / 2;
		int aristasAdyacentes = porcentaje * aristasTotales / 100;

		MatrizSimetrica ms = new MatrizSimetrica(nodos);
		int[] aux = new int[nodos];
		int i = nodos;
		int j;
		int nodoAnt = -1;
		do {
			j = i;
			do {
				if (Math.random() <= (float) porcentaje / 100 && aux[nodos - i] < (nodos - 1) * porcentaje / 100
						&& aux[nodos - j] < (nodos - 1) * porcentaje / 100 && nodoAnt != nodos - j && i != j) {
					aux[nodos - i]++;
					aux[nodos - j]++;
					ms.setValor(nodos - i, nodos - j, 1);
					nodoAnt = nodos - j;
					aristasAdyacentes--;
				}
			} while (--j != 0 && aristasAdyacentes != 0);
		} while (--i != 0 && aristasAdyacentes != 0);

		this.guardarMatrizSimetrica(ms, archivo);
	}

	public void generarGrafoRegularNPartitos(int nodos, int nPartitos, String archivo) throws Exception {
		MatrizSimetrica ms = new MatrizSimetrica(nodos);
		for (int i = 0; i < ms.getCantidadNodos() - 1; i++)
			ms.setValor(i, i + 1, 1);
		guardarMatrizSimetrica(ms, archivo);
	}

	public void guardarMatrizSimetrica(MatrizSimetrica ms, String file) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.print(ms.getCantidadNodos() + " ");
		out.print(ms.getCantidadAristas() + " ");
		out.print(ms.getPorcentajeAdyacencia() + " ");
		out.print(ms.getGradoMax() + " ");
		out.println(ms.getGradoMin());
		for (int i = 0; i < ms.getCantidadNodos(); i++) {
			for (int j = i + 1; j < ms.getCantidadNodos(); j++) {
				if (ms.getValor(i, j) != 0) {
					out.println(i + " " + j);
				}
			}
		}
		out.close();
	}

}
