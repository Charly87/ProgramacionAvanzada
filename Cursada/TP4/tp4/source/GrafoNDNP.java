package tp4.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrafoNDNP {
	
	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private List<Nodo> nodos;
	private MatrizSimetrica matrizAdy;
	
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
		
	}

	private void agregarConexion(int idNodoOrigen, int idNodoDestino) {
			
		
	}
	
	
	
	
	
	

}
