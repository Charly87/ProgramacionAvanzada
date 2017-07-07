package prim;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {	
		Prim p = new Prim(14);	
		// Prueba 1
//		p.agregarConexion(1, 2, 8);
//		p.agregarConexion(2, 3, 10);
//		p.agregarConexion(2, 4, 4);
//		p.agregarConexion(4, 5, 7);
//		p.agregarConexion(3, 5, 5);
//		p.agregarConexion(4, 6, 2);
//		p.agregarConexion(5, 8, 11);
//		p.agregarConexion(6, 8, 12);
//		p.agregarConexion(6, 9, 14);
//		p.agregarConexion(6, 10, 6);
//		p.agregarConexion(6, 11, 9);
//		p.agregarConexion(11, 10, 3);
//		p.agregarConexion(9, 10, 17);
//		p.agregarConexion(8, 9, 20);
		
		// Prueba 2
//		p.agregarConexion(1, 2, 5);
//		p.agregarConexion(1, 3, 8);
//		p.agregarConexion(1, 4, 7);
//		p.agregarConexion(3, 4, 6);
//		p.agregarConexion(4, 5, 3);
//		p.agregarConexion(4, 6, 5);
//		p.agregarConexion(5, 6, 9);
//		p.agregarConexion(5, 7, 5);
//		p.agregarConexion(7, 2, 3);
//		p.agregarConexion(4, 7, 6);
//		p.agregarConexion(2, 4, 9);
//		p.agregarConexion(3, 6, 4);
//		
//		p.resolver(6);
//		p.mostrarArbol();
		
		//Ejercicio Pelicula
		try {
			ReconstruyendoPelicula rp = new ReconstruyendoPelicula("Grafos/prim/Prueba1.in");
			rp.mostrarMatriz();
			rp.resolver(1);
			rp.mostrarResultado();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
