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
	
	private Nodo[] nodos;
	private int[] nodosColoreados; // Este es un vector que tendra el color asignado a cada nodo. El indice es el id de nodo y el contenido es el color asignado a ese nodo.
	private int cantColores;
	private List<Integer> cUsados = new ArrayList<Integer>();	

	public GrafoNDNP(String fileName) throws Exception {

		Scanner input = new Scanner(new File(fileName));

		this.cantidadNodos = input.nextInt();
		this.cantidadAristas = input.nextInt();
		this.porcentajeAdyacencia = input.nextInt();
		this.gradoMax = input.nextInt();
		this.gradoMin = input.nextInt();
		this.nodos = new Nodo[this.cantidadNodos];
		this.nodosColoreados = new int[this.cantidadNodos];
		this.cantColores = 0;
		this.matrizAdy = new MatrizSimetrica(this.cantidadNodos);
		while (input.hasNextInt())
			agregarConexion(input.nextInt(), input.nextInt());

		input.close();

		inicializarGradoNodos(); // Le asigna el grado correspondiente a cada nodo
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
		for (int c = 0 ; c < nodosColoreados.length ; c++)
			nodosColoreados[c] = 0;
		
		List<Integer> coloresUsados = new ArrayList<Integer>();		
		SortedSet<Integer> coloresAdyacentes = new TreeSet<Integer>(); // No inserta valores que ya existen
		coloresUsados.add(1); // Agrego el 1 como primer color		
		nodosColoreados[nodos[0].getId()] = coloresUsados.get(0); // Al primer nodo le asigno el primer id de color

		// Recorro todos los nodos
		for (int i = 1; i < this.nodos.length; i++) {
			
			// Recorro todos los nodos adyacentes a ese nodo
			for (int j = 0; j < matrizAdy.getCantidadNodos(); j++) {
				
				// Si encuentro un nodo adyacente...
				if (matrizAdy.getValor(this.nodos[i].getId(), j) == 1) {
                    
					// Si el nodo adyacente tiene un color asignado...
					if (nodosColoreados[j] != 0)						
						coloresAdyacentes.add(nodosColoreados[j]);
				}
			}

			// Si ningun nodo adyacente tiene un color asignado, entonces asigno el primer color
			if (coloresAdyacentes.isEmpty())
				nodosColoreados[nodos[i].getId()] = coloresUsados.get(0);
			
			// De lo contrario, si hay nodo/s adyacente/s con color/es asignado/s, me fijo cual es el primer color disponible para asignarle ; si no puedo asignarle un color que ya di de alta, doy de alta un nuevo color
			else {
				
				nodosColoreados[nodos[i].getId()] = obtenerColor(coloresUsados, coloresAdyacentes);
				if (nodosColoreados[nodos[i].getId()] == coloresUsados.size() + 1)
					coloresUsados.add(coloresUsados.size() + 1);
				coloresAdyacentes.clear();
			}
		}

		this.cantColores = coloresUsados.size();
		this.cUsados=coloresUsados;
		return this.cantColores;
	}

	
	public List<Integer> getcUsados() {
		return cUsados;
	}

	private int obtenerColor(List<Integer> coloresUsados, SortedSet<Integer> coloresAdyacentes) {

		// Si ya estan usados todos los colores doy de alta uno nuevo
		if (coloresUsados.size() == coloresAdyacentes.size())
			return coloresUsados.size() + 1;
		
		// De lo contrario, me fijo cual es el primer color que puedo asignar dentro de los que tengo dados de alta
		int indice = 0;
		for (Integer colorAdyacente : coloresAdyacentes) {
			if (coloresUsados.get(indice) != colorAdyacente)
				return coloresUsados.get(indice);
			indice++;
		}
		return coloresUsados.get(indice);
	}
		

	public int generarColoreoSecuencialAleatorio() {
		
		// Genero random
		for (Nodo nodo : this.nodos)
			nodo.setRandom((int) (Math.random() * 100));

		// Ordeno
		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			
			@Override
			public int compare(Nodo o1, Nodo o2) {
				
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
	
	public void guardarColoreo(String fileName) throws IOException {

		PrintWriter output = new PrintWriter(new FileWriter(fileName));

		// Primera linea del archivo de salida
		output.println(cantidadNodos + " " + cantColores + " " + cantidadAristas + " " + porcentajeAdyacencia + " "
				+ gradoMax + " " + gradoMin);
		
		// Segunda linea del archivo de salida hasta cantNodos lineas
		for (Nodo nodo : nodos){
			output.println(nodo.getId() + " " + nodosColoreados[nodo.getId()]);
		}

		output.close();
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

}
