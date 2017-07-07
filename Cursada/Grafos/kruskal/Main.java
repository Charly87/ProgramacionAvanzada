package kruskal;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		// Kruskal k = new Kruskal(4);
		//
		// k.añadirArista(1, 4, 1);
		// k.añadirArista(1, 2, 5);
		// k.añadirArista(4, 2, 2);
		// k.añadirArista(4, 3, 10);
		// k.añadirArista(2, 3, 7);
		// k.resolver();

		Minotauro m;
		try {
			m = new Minotauro("Grafos/kruskal/Minotauro.in");
			m.resolver();
			m.mostrarResultado();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
