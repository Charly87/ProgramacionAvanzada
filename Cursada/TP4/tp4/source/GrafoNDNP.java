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
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class GrafoNDNP {

	private int cantidadNodos;
	private int cantidadAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private MatrizSimetrica matrizAdy;

	private int cantColores;
	private short[] colores;
	private Nodo[] nodos,nodosM;
	private List<Nodo> nodosMezcla = new ArrayList<Nodo>();

	public GrafoNDNP(String fileName) throws Exception {

		Scanner input = new Scanner(new File(fileName));

		this.cantidadNodos = input.nextInt();
		this.cantidadAristas = input.nextInt();
		this.porcentajeAdyacencia = input.nextInt();
		this.gradoMax = input.nextInt();
		this.gradoMin = input.nextInt();
		this.nodos = new Nodo[this.cantidadNodos];
		this.matrizAdy = new MatrizSimetrica(this.cantidadNodos);
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
		colores = new short[this.cantidadNodos];
		for (short c = 0; c < colores.length; c++)
			colores[c] = (short) (c + 1);
	}

	private void inicializarGradoNodos() {
		int grado = 0;
		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++)
				if (matrizAdy.getValor(i, j) == 1)
					grado++;
			nodos[i].setGrado(grado);
			grado = 0;
		}
	}

	public void mostrarNodos() {

		for (Nodo nodo : nodos)
			System.out.println(nodo.getGrado() + " " + nodo.getRandom() + " " + nodo.getId());

		System.out.println("\n\n\n\n\n");
	}

	private int aplicarColoreo() {

		// Inicializo el color de los nodos
		for (Nodo nodo : nodosM)
			nodo.setColor(0);
		
		List<Integer> coloresUsados = new ArrayList<Integer>();		
		SortedSet<Integer> coloresAdyacentes = new TreeSet<Integer>(); // No inserta valores que ya existen
		coloresUsados.add(1); // Al primer nodo le asigno el primer id de color
		this.nodosM[0].setColor(coloresUsados.get(0));

		// Recorro todos los nodos
		for (int i = 1; i < this.nodosM.length; i++) {
			// Recorro todos los nodos adyacentes al nodo
			for (int j = 0; j < matrizAdy.getCantidadNodos(); j++) {
				// Agrego los nodos adyacentes coloreados
				if (this.nodos[i].getId() != j && matrizAdy.getValor(this.nodos[i].getId(), j) == 1) {
                    
					int colorAdyacente = this.nodosM[j].getColor();
					if (colorAdyacente != 0) {
						coloresAdyacentes.add(colorAdyacente);
					}
				}
			}

			// Si no hay nodos coloreados asigno el primer color
			if (coloresAdyacentes.isEmpty()){
				this.nodosM[i].setColor(coloresUsados.get(0));
			}
			// Sino busco el primero que pueda usar
			else {
				this.nodosM[i].setColor(obtenerColor(coloresUsados, coloresAdyacentes));
				if (this.nodosM[i].getColor() == coloresUsados.size() + 1)
					coloresUsados.add(coloresUsados.size() + 1);
				coloresAdyacentes.clear();
			}
		}

		this.cantColores = coloresUsados.size();
		return this.cantColores;
	}

	
	private int obtenerColor(List<Integer> coloresUsados, SortedSet<Integer> coloresAdyacentes) {

		if (coloresUsados.size() == coloresAdyacentes.size())
			return coloresUsados.size()+1;

		// 1 - 1
		// 2 - 2
		// 3 - 4 -> devuelve el 3
		int indice = 0;
		for (Integer integer : coloresAdyacentes) {
			if (coloresUsados.get(indice) != integer)
				return coloresUsados.get(indice);
			indice++;
		}
		return coloresUsados.get(indice);
	}
		

	public int generarColoreoSecuencialAleatorio() {
		
//		// Genero random
//		for (Nodo nodo : this.nodos)
//			nodo.setRandom((int) (Math.random() * 100));
//
//		// Ordeno
//		Arrays.sort(this.nodos, new Comparator<Nodo>() {
//			
//			@Override
//			public int compare(Nodo o1, Nodo o2) {
//				
//				if (o1.getRandom() < o2.getRandom())
//					return -1;
//
//				if (o1.getRandom() > o2.getRandom())
//					return 1;
//				
//				return 0;
//				
//			}
//		});
		nodosMezcla = Arrays.asList(nodos);	
		
	    Collections.shuffle(nodosMezcla, new Random(100));
		
		nodosM=(Nodo[]) nodosMezcla.toArray();

		// Coloreo
		return aplicarColoreo();
	}

	public int generarColoreoWelshPowell() {

		// Genero random
		for (Nodo nodo : this.nodos)
			nodo.setRandom((int) (Math.random() * 100));

		// Ordeno
		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo o1, Nodo o2) {
				if (o1.getGrado() > o2.getGrado())
					return -1;
				else if (o1.getGrado() < o2.getGrado())
					return 1;

				if (o1.getRandom() < o2.getRandom())
					return -1;

				if (o1.getRandom() > o2.getRandom())
					return 1;
				return 0;
			}
		});

		// Coloreo
		return aplicarColoreo();

	}

	public int generarColoreoMatula() {

		// Genero random
		for (Nodo nodo : this.nodos)
			nodo.setRandom((int) (Math.random() * 100));

		// Ordeno
		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo o1, Nodo o2) {
				if (o1.getGrado() < o2.getGrado())
					return -1;
				else if (o1.getGrado() > o2.getGrado())
					return 1;

				if (o1.getRandom() < o2.getRandom())
					return -1;

				if (o1.getRandom() > o2.getRandom())
					return 1;
				return 0;
			}
		});

		return aplicarColoreo();
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public int getCantidadAristas() {
		return cantidadAristas;
	}

	public int getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public MatrizSimetrica getMatrizAdy() {
		return matrizAdy;
	}

	public void guardarColoreo(String fileName) throws IOException {

		PrintWriter output = new PrintWriter(new FileWriter(fileName));
		output.println(cantidadNodos + " " + cantColores + " " + cantidadAristas + " " + porcentajeAdyacencia + " "
				+ gradoMax + " " + gradoMin);
		for (Nodo nodo : nodos)
			output.println(nodo.getId() + " " + nodo.getColor());

		output.close();
	}
}
