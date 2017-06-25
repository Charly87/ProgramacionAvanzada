package tp4.source;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Probador {
	
	private MatrizSimetrica matrizAdy;
	
	private int cantNodosIn;
	private int cantAristasIn;
	private int porcentajeAdyacenciaIn;
	private int gradoMaxIn;
	private int gradoMinIn;
		
	private int cantNodosOut;
	private int cantidadColoresAsignados;
	private int cantAristasOut;
	private int porcentajeAdyacenciaOut;
	private int gradoMaxOut;	
	private int gradoMinOut;
	
	
	private int[] nodos;
	private int[] coloresAsignados;
	private Set<Integer> coloresUtilizados;
	
	public Probador(String fileIn, String fileOut) throws Exception {
		
		// Obtengo los datos del archivo de entrada
		
		Scanner inputIn = new Scanner(new File(fileIn));
		cantNodosIn = inputIn.nextInt();
		cantAristasIn = inputIn.nextInt();
		porcentajeAdyacenciaIn = inputIn.nextInt();
		gradoMaxIn = inputIn.nextInt();
		gradoMinIn = inputIn.nextInt();

		matrizAdy = new MatrizSimetrica(cantNodosIn);
		while (inputIn.hasNext())
			matrizAdy.setValor(inputIn.nextInt(), inputIn.nextInt(), 1);

		inputIn.close();
		
		// Obtengo los datos del archivo de salida
		
		Scanner inputOut = new Scanner(new File(fileOut));
		cantNodosOut = inputOut.nextInt();
		cantidadColoresAsignados = inputOut.nextInt();
		cantAristasOut = inputOut.nextInt();
		porcentajeAdyacenciaOut = inputOut.nextInt();
		gradoMaxOut = inputOut.nextInt();
		gradoMinOut = inputOut.nextInt();
				
		nodos = new int[cantNodosOut];
		coloresAsignados = new int[cantNodosOut]; // Este vector me indicara el color de todos los nodos, el indice es el id de nodo
		coloresUtilizados = new HashSet<Integer>();
		
		for (int i = 0; i < nodos.length; i++) {
			nodos[i] = inputOut.nextInt(); // Guardo id del nodo
			coloresAsignados[nodos[i]] = inputOut.nextInt(); // Guardo el color del nodo
			coloresUtilizados.add(coloresAsignados[nodos[i]]); // Agrego el color (si ya existe, no lo agrega)
		}
		
		inputOut.close();
	}

	public void verificarSalida() {
		
		if (cantNodosIn == cantNodosOut)
			System.out.println("Cantidad de nodos OK.");
		else
			System.out.println("La cantidad de nodos es distinta.");
			
		if (cantAristasIn == cantAristasOut)
			System.out.println("Cantidad de aristas OK.");
		else
			System.out.println("La cantidad de aristas es distinta.");
		
		if (porcentajeAdyacenciaIn == porcentajeAdyacenciaOut)
			System.out.println("Porcentaje de adyacencia OK.");
		else
			System.out.println("El porcentaje de adyacencia es distinto");
			
		if (gradoMaxIn == gradoMaxOut)
			System.out.println("Grado maximo OK.");
		else
			System.out.println("El grado maximo es distinto.");
		
		if (gradoMinIn == gradoMinOut) 
			System.out.println("Grado minimo OK.");
		else
			System.out.println("El grado minimo es distinto.");
		
		if (cantidadColoresAsignados == coloresUtilizados.size())
			System.out.println("Cantidad de colores utilizados OK.");
		else
			System.out.println("La cantidad de colores no es correcta");
		
		if (coloresAsignadosCorrectamente())
			System.out.println("Coloreo OK.");
		else
			System.out.println("El coloreo no es correcto.");
				
	}

	private boolean coloresAsignadosCorrectamente() {
		
		/** Verifico por cada nodo, si el color que tiene asignado no es igual al color de alguno de sus adyacentes **/
		
		// Recorro nodos
		
		for (int i = 0 ; i < cantNodosOut ; i++) {
			
			// Recorro nodos adyacentes
			
			for (int j = 0 ; j < cantNodosOut ; j++) {
				
				// Si hay uno adyacente, verifico que el color no sea el mismo
				// Recordar que:
				// * Hay una relacion directa entre indice dentro de la matriz de adyacencias e id de nodo
				// * Variable i = indice del vector de nodos --> me sirve para obtener el id del nodo que estoy evaluando
				// * Variable j = indice de columna dentro de la matriz de adyacencia --> me sirve para obtener id del nodo adyacente
				// * El indice del vector de colores es el id del nodo 
				
				if (matrizAdy.getValor(nodos[i], j) == 1 && coloresAsignados[nodos[i]] == coloresAsignados[j])
					return false;				
				
			}
			
		}
		
		// Si recorri todos los nodos y todos los adyacentes de cada uno de ellos y no encontre un color que colisione,
		// entonces el coloreo fue correctamente realizado.
		
		return true;		
		
	}	

}
