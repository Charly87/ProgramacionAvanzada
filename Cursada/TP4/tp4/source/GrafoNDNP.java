package tp4.source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class GrafoNDNP {

	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private MatrizSimetrica matrizAdy;

	private int coloresAsignados;
	private short[] colores;
	private Nodo[] nodos;

	public GrafoNDNP(String fileName) throws Exception {

		Scanner input = new Scanner(new File(fileName));

		this.cantNodos = input.nextInt();
		this.cantAristas = input.nextInt();
		this.porcentajeAdyacencia = input.nextInt();
		this.gradoMax = input.nextInt();
		this.gradoMin = input.nextInt();
		this.nodos = new Nodo[this.cantNodos];
		this.matrizAdy = new MatrizSimetrica(this.cantNodos);
		while (input.hasNextInt())
			agregarConexion(input.nextInt(), input.nextInt());

		input.close();

		inicializarColores();
		inicializarGradoNodos();
	}

	private void agregarConexion(int idNodoOrigen, int idNodoDestino) {

		// Chequeo tanto con el Nodo Origen como con el Nodo Destino si no se
		// encuentran en la lista de nodos.
		// El id esta directamente relacionado con el indice dentro de la lista
		// (nodo con ID 0 ---> index 0 ; nodo con ID 1 ---> index 1 ; etc.)
		// En caso de que no se encuentre, lo doy de alta.

		if (nodos[idNodoOrigen] == null)
			nodos[idNodoOrigen] = new Nodo(idNodoOrigen);

		if (nodos[idNodoDestino] == null)
			nodos[idNodoDestino] = new Nodo(idNodoDestino);

		// Agrego la arista
		this.matrizAdy.setValor(idNodoOrigen, idNodoDestino, 1);

	}

	private void inicializarColores() {
		colores = new short[this.cantNodos];
		for (short c = 0; c < colores.length; c++)
			colores[c] = (short) (c + 1);
	}

	private void inicializarGradoNodos() {
		int grado = 0;
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++)
				if (matrizAdy.getValor(i, j) == 1)
					grado++;
			nodos[i].setGrado(grado);
			grado = 0;
		}
	}

	public int getCantidadNodos() {
		return cantNodos;
	}

	public int getCantidadColoresAsignados() {
		return coloresAsignados;
	}

	public void mostrarNodos() {

		for (Nodo nodo : nodos) {
			System.out.println(nodo.getGrado() + " " + nodo.getRandom() + " " + nodo.getId());
		}

		System.out.println("\n\n\n\n\n");

	}

	public void mezclarNodos() {

		for (Nodo nodo : this.nodos)
			nodo.setRandom((int) Math.random() * 100);

		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo o1, Nodo o2) {

				if (o1.getRandom() < o2.getRandom())
					return -1;

				if (o1.getRandom() > o2.getRandom())
					return 1;

				if (o1.getGrado() < o2.getGrado())
					return -1;

				if (o1.getGrado() > o2.getGrado())
					return 1;
				return 0;
			}
		});
	}

	private void aplicarColoreoCharly() {
		int color = 1;
		this.nodos[0].setColor(color);
		List<Integer> coloresUsados = new ArrayList<Integer>();
		List<Integer> coloresAdyacentes = new ArrayList<Integer>();
		coloresUsados.add(color);

		for (int i = 1; i < this.nodos.length; i++) {
			for (int j = 0; j < this.nodos.length; j++) {
				if (this.nodos[i].getId() != j && matrizAdy.getValor(this.nodos[i].getId(), j) == 1) {

					int colorAdyacente = this.nodos[j].getColor();
					if (colorAdyacente != 0) {
						coloresAdyacentes.add(colorAdyacente);
					}
				}

				if (coloresAdyacentes.isEmpty())
					this.nodos[i].setColor(coloresUsados.get(0));
				else {
					this.nodos[i].setColor(obtenerColor(coloresUsados, coloresAdyacentes));
					;
					if (this.nodos[i].getColor() == coloresUsados.size() + 1)
						coloresUsados.add(coloresUsados.size() + 1);
					coloresAdyacentes.clear();
				}
			}
		}
	}

	private int obtenerColor(List<Integer> coloresUsados, List<Integer> coloresAdyacentes) {
		int indice = 0;

		if (coloresUsados.size() == coloresAdyacentes.size())
			return coloresUsados.size() + 1;

		for (Integer integer : coloresAdyacentes) {
			if (coloresUsados.get(indice) != integer)
				return coloresUsados.get(indice);
			indice++;
		}
		return coloresUsados.get(indice);
	}

	private void aplicarColoreo() {

		coloresAsignados = 0;

		// Recorro los nodos del grafo secuencialmente por id
		System.out.println("Inicio Coloreo: 0 ");

		int c = 0;
		boolean colorAsignado = false;
		for (Nodo nodo : nodos) {
			long inicio = System.nanoTime();

			c = 0;
			colorAsignado = false;

			while (c < colores.length && colorAsignado == false) {

				if (sePuedeAsignarColor(nodo, colores[c])) {

					nodo.setColor(colores[c]);
					colorAsignado = true;

					// Esto es para obtener la cantidad de colores
					// asignados.
					// La variable se ira reemplazando en la medida que el
					// indice
					// alcanza valores mas altos.

					if (c > coloresAsignados)
						coloresAsignados = c;
				}

				c++;
			}
			// System.out.println("Coloreo Nodo (Micro):" + (System.nanoTime() - inicio) / 1000);
		}

		coloresAsignados++; // Incremento para que quede con el valor
							// real y no el valor del indice.
	}

	public void quitarColoreo() {
		this.coloresAsignados = 0;
		for (Nodo nodo : nodos)
			nodo.setColor(0);
	}

	public void aplicarColoreoSecuencialAleatorio() {

		// Aplico el algoritmo
		aplicarColoreo();
	}

	public void aplicarColoreoWelshPowell() {

		// Ordeno los nodos de mayor a menor grado

		Arrays.sort(nodos, new Comparator<Nodo>() {

			public int compare(Nodo n1, Nodo n2) {

				if (n1.getGrado() > n2.getGrado())
					return -1;
				else if (n1.getGrado() < n2.getGrado())
					return 1;
				else
					return 0;

			}

		});

		// Aplico el algoritmo

		aplicarColoreo();

	}

	public void aplicarColoreoMatula() {

		// Ordeno los nodos de menor a mayor grado

		Arrays.sort(nodos, new Comparator<Nodo>() {

			public int compare(Nodo n1, Nodo n2) {

				if (n1.getGrado() < n2.getGrado())
					return -1;
				else if (n1.getGrado() > n2.getGrado())
					return 1;
				else
					return 0;

			}

		});

		// Aplico el algoritmo

		aplicarColoreo();

	}

	/** Verifica si se puede asignar un determinado color a un nodo. Para esta
	 * tarea, verifica qué color tienen asignados los nodos adyacentes.
	 * 
	 * @param nodo
	 * - nodo al cual se le asignara el color, en caso de ser
	 * posible.
	 * @param colorAAsignar
	 * - identificador de color dentro de todos los posibles que esta
	 * siendo evaluado para ser asignado.
	 * @return true si se puede asignar el color; false en caso contrario. */
	private boolean sePuedeAsignarColor(Nodo nodo, int colorAAsignar) {

		// Busco nodos adyacentes
		int colorNodoAdyacente;
		for (int j = 0; j < cantNodos; j++) {

			// Si hay un nodo adyacente...
			if (matrizAdy.getValor(nodo.getId(), j) == 1) {

				// Evaluo color de nodo adyacente
				colorNodoAdyacente = nodos[j].getColor();

				// Si el nodo adyacente todavia no tiene un color asignado o si
				// ya tiene uno asignado pero es distinto al que quiero asignar
				if (colorNodoAdyacente != 0 && colorNodoAdyacente == colorAAsignar) {

					return false;

				}

			}

		}

		// Si recorri todos los nodos adyacentes y no encontre ninguno que tenga
		// ese color asignado, entonces se puede asignar dicho color.

		return true;
	}

	public void mostrarGrafoColoreado(String fileName) throws IOException {

		PrintWriter output = new PrintWriter(new FileWriter(fileName));

		// Linea 1

		output.println(cantNodos + " " + coloresAsignados + " " + cantAristas + " " + porcentajeAdyacencia + " "
				+ gradoMax + " " + gradoMin);

		// Linea 2 hasta cantNodos

		for (Nodo nodo : nodos) {

			output.println(nodo.getId() + " " + nodo.getColor());

		}

		output.close();

	}

}
