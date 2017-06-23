package tp4.source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GrafoNDNP {
	
	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private int cantidadColoresAsignados;
	private int[] colores;
	private List<Nodo> nodos;
	public MatrizSimetrica matrizAdy;
	
	public GrafoNDNP(String fileName) throws Exception {
		
		Scanner input = new Scanner(new File(fileName));
		
		cantNodos = input.nextInt();
		cantAristas = input.nextInt();
		porcentajeAdyacencia = input.nextInt();
		gradoMax = input.nextInt();
		gradoMin = input.nextInt();		
		
		nodos = new ArrayList<Nodo>();
		
		matrizAdy = new MatrizSimetrica(cantNodos);
		
		while (input.hasNextLine()) {						
			agregarConexion(input.nextInt(), input.nextInt());			
		}
		
		input.close();
		
		colores = new int[cantNodos]; // en principio la cantidad de colores disponibles sera igual a la cantidad de nodos
		inicializarColores();
		
		inicializarGradoNodos();
		
	}


	private void inicializarColores() {

		// Los colores disponibles se identifican con un numero secuencial que va de 0 a cantNodos - 1
		
		for (int c = 0 ; c < colores.length ; c++) {	
			
			colores[c] = c + 1;	
			
		}
				
	}
	
	private void inicializarGradoNodos() {
		
		for (Nodo nodo : nodos) {
			
			int grado = 0;
			
			// Recorro matriz de adyacencia
			
			for (int j = 0 ; j < cantNodos ; j++) {
				
				if (matrizAdy.getValor(nodo.getId(), j) == 1)
					grado++;
								
			}
			
			nodo.setGrado(grado);
			
		}
		
	}

	private void agregarConexion(int idNodoOrigen, int idNodoDestino) {
			
		// Chequeo tanto con el Nodo Origen como con el Nodo Destino si no se encuentran en la lista de nodos.
		// El id esta directamente relacionado con el indice dentro de la lista (nodo con ID 0 ---> index 0 ; nodo con ID 1 ---> index 1 ; etc.)
		// En caso de que no se encuentre, lo doy de alta.
		
		try {
			
			nodos.get(idNodoOrigen);
			
		} catch (IndexOutOfBoundsException e) {
			
			nodos.add(idNodoOrigen, new Nodo(idNodoOrigen));
			
		}
		
		try {
			
			nodos.get(idNodoDestino);
			
		} catch (IndexOutOfBoundsException e) {
			
			nodos.add(idNodoDestino, new Nodo(idNodoDestino));
			
		}

	
		// Establezco la conexion
		
		matrizAdy.setValor(idNodoOrigen, idNodoDestino, 1);						
		
	}
	
	private void aplicarColoreo() {
		
		// Recorro los nodos del grafo secuencialmente por id
		
		for (Nodo nodo : nodos) {
			
			// Si todavia no se le asigno un color al nodo...
			
			if (nodo.getColor() == 0) {
				
				// Le asigno el menor color posible
				
				int c = 0;
				boolean colorAsignado = false;
				
				while (c < colores.length && colorAsignado == false) {
					
					if (sePuedeAsignarColor(nodo, colores[c])) {
						
						nodo.setColor(colores[c]);						
						colorAsignado = true;
						
						// Esto es para obtener la cantidad de colores asignados.
						// La variable se ira reemplazando en la medida que el indice
						// alcanza valores mas altos.
						
						if (c > cantidadColoresAsignados)
							cantidadColoresAsignados = c;
						
					}
					
					c++;
					
				}								
				
			}
			
		}
		
		cantidadColoresAsignados++; // Incremento para que quede con el valor real y no el valor del indice.
				
	}
	
	public void aplicarColoreoSecuencialAleatorio() {
		
		// Ordeno los nodos menor a mayor ID
		
		Collections.sort(nodos, new Comparator<Nodo>() {
			
		    public int compare(Nodo n1, Nodo n2) {
		        
		    	if (n1.getId() < n2.getId())
		    		return -1;
		    	else if (n1.getId() > n2.getId())
		    		return 1;
		    	else
		    		return 0;
		       
		    }
		    
		});
		
		// Aplico el algoritmo
		
		aplicarColoreo();
		
	}
	
	
	
	public void aplicarColoreoWelshPowell() {
		
		// Ordeno los nodos de mayor a menor grado
		
		Collections.sort(nodos, new Comparator<Nodo>() {
			
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
		
		Collections.sort(nodos, new Comparator<Nodo>() {
			
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

	
	/**
	 * Verifica si se puede asignar un determinado color a un nodo. Para esta tarea, verifica
	 * qué color tienen asignados los nodos adyacentes.
	 * @param nodo - nodo al cual se le asignara el color, en caso de ser posible.
	 * @param colorAAsignar - identificador de color dentro de todos los posibles que esta siendo evaluado para ser asignado.
	 * @return true si se puede asignar el color; false en caso contrario.
	 */
	private boolean sePuedeAsignarColor(Nodo nodo, int colorAAsignar) {
		
		// Busco nodos adyacentes
		
		for (int j = 0 ; j < cantNodos ; j++) {
			
			// Si hay un nodo adyacente...
			
			if (matrizAdy.getValor(nodo.getId(), j) == 1) {
				
				// Evaluo color de nodo adyacente
				
				int colorNodoAdyacente = nodos.get(j).getColor();
				
				// Si el nodo adyacente todavia no tiene un color asignado o si ya tiene uno asignado pero es distinto al que quiero asignar
				
				if ( colorNodoAdyacente != 0 && colorNodoAdyacente == colorAAsignar) {
					
					return false;
					
				}				
				
			}			
			
		}
		
		// Si recorri todos los nodos adyacentes y no encontre ninguno que tenga ese color asignado, entonces se puede asignar dicho color.
		
		return true;
	}
	
	
	public void mostrarGrafoColoreado(String fileName) throws IOException {
		
		PrintWriter output = new PrintWriter(new FileWriter(fileName));
		
		// Linea 1
		
		output.println(cantNodos + " " + cantidadColoresAsignados + " " + cantAristas + " " + porcentajeAdyacencia + " " + gradoMax + " " + gradoMin);
		
		// Linea 2 hasta cantNodos
		
		for (Nodo nodo : nodos) {
			
			output.println(nodo.getId() + " " + nodo.getColor());
			
		}
		
		output.close();
		
	}
	

}
