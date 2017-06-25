package tp4.source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generador {

	public MatrizSimetrica generarGrafoAleatorioProbabilidad(int nodos, float porcentaje) {
		MatrizSimetrica ms = null;
		try {
			ms = new MatrizSimetrica(nodos);
			for (int i = 0; i < nodos; i++)
				for (int j = i + 1; j < nodos; j++)
					if (Math.random() <= porcentaje / 100)
						ms.setValor(i, j, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ms;
	}

	public MatrizSimetrica generarGrafoAleatorioPorcentaje(int nodos, int porcentaje) {

		MatrizSimetrica ms = null;
		int i = nodos;
		int j;
		try {
			int aristasTotales = nodos * (nodos - 1) / 2;
			int aristasAdyacentes = porcentaje * aristasTotales / 100;
			ms = new MatrizSimetrica(nodos);
			do {
				j = i;
				do {
					if (Math.random() <= (float) porcentaje / 100) {
						ms.setValor(nodos - i, nodos - j, 1);
						if (i != j)
							aristasAdyacentes--;
					}
				} while (--j != 0 && aristasAdyacentes != 0);
			} while (--i != 0 && aristasAdyacentes != 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ms;
	}

	public MatrizSimetrica generarGrafoRegular(int nodos, int grado) {
		MatrizSimetrica ms = null;
		int[] aux = null;
		int nodoAnt;
		int i;
		int j;
		if (nodos % 2 != 0 && grado % 2 != 0) {
			return ms;
		}
		try {
			ms = new MatrizSimetrica(nodos);
			aux = new int[nodos];
			//do {
				i = nodos;
				nodoAnt = -1;
				do {
					j = i;
					do {
						if (Math.random() <= 0.7 && aux[nodos - i] < grado && aux[nodos - j] < grado
								&& nodoAnt != nodos - j && i != j) {
							aux[nodos - i]++;
							aux[nodos - j]++;
							ms.setValor(nodos - i, nodos - j, 1);
							nodoAnt = nodos - j;
						}
					} while (--j != 0);
				} while (--i != 0);
			//} while (getProm(aux) != grado);
			return ms;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ms;
	}
	
	public MatrizSimetrica generarGrafoRegularPorAdy(int nodos, int porcentaje) {
		MatrizSimetrica ms = null;
		int[] aux = null;
		int nodoAnt;
		int i;
		int j;
		int aristasTotales = nodos * (nodos - 1) / 2;
		int aristasAdyacentes = porcentaje * aristasTotales / 100;
		if (nodos % 2 != 0 && (nodos - 1) * porcentaje / 100 % 2 != 0) {
			return ms;
		}
		try {
			ms = new MatrizSimetrica(nodos);
			aux = new int[nodos];
			i = nodos;
			nodoAnt = -1;
			do {
				j = i;
				do {
					if (Math.random() <= (float) porcentaje/100 && aux[nodos - i] < (nodos - 1) * porcentaje / 100 && aux[nodos - j]
								< (nodos - 1)  * porcentaje / 100 && nodoAnt != nodos - j && i != j) {
						aux[nodos - i]++;
						aux[nodos - j]++;
						ms.setValor(nodos - i, nodos - j, 1);
						nodoAnt = nodos - j;
						aristasAdyacentes--;
					}
				} while (--j != 0 && aristasAdyacentes != 0);
			} while (--i != 0 && aristasAdyacentes != 0);
			
		return ms;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ms;
	}

	public int getProm(int[] vec) {
		int sum = 0;
		for (int i = 0; i < vec.length; i++) {
			sum += vec[i];
		}
		return sum /= vec.length;
	}

	public void generarGrafoRegularNPartitos(int nodos, int nPartitos, String archivo) throws Exception {
		MatrizSimetrica ms= new MatrizSimetrica(nodos);
		for (int i = 0; i < ms.getCantidadNodos() - 1; i++)
			ms.setValor(i, i+1, 1);
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
