package tp4.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GrafoNDNP {
	
	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private List<Nodo> nodos;
	private int[][] matrizAdy;
	
	public GrafoNDNP(String fileName) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(fileName));
		
		cantNodos = input.nextInt();
		cantAristas = input.nextInt();
		porcentajeAdyacencia = input.nextInt();
		gradoMax = input.nextInt();
		gradoMin = input.nextInt();
		
		inicializarMatrizAdyacencia();
		
		while (input.hasNextLine()) {
						
			agregarConexion(input.nextInt(), input.nextInt());
			
		}
		
		input.close();
		
	}

	private void agregarConexion(int idNodoOrigen, int idNodoDestino) {
		
		matrizAdy[idNodoOrigen][idNodoDestino] = 1;		
		
	}

	private void inicializarMatrizAdyacencia() {
		
		for (int i = 0 ; i < cantNodos ; i++)
			for (int j = 0 ; j < cantNodos ; j++)
				matrizAdy[i][j] = 0;
		
	}
	
	
	
	
	
	

}
