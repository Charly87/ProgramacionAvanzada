package dijktra;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
//		Dijktra d = new Dijktra(5);
//
//		d.agregarNodo(1);
//		d.agregarNodo(2);
//		d.agregarNodo(3);
//		d.agregarNodo(4);
//		d.agregarNodo(5);
//
//		d.conectarNodos(1, 2, 1);
//		d.conectarNodos(1, 3, 3);
//		d.conectarNodos(1, 4, 5);
//		d.conectarNodos(2, 3, 2);
//		d.conectarNodos(3, 4, 1);
//		d.conectarNodos(3, 5, 3);
//		d.conectarNodos(4, 5, 1);
//
//		d.mostrarMatrizAdyacencia();
//		d.ejecutar(5);

		RescatandoPrincesa r;
		try {
			r = new RescatandoPrincesa("Grafos/dijktra/Princesa1.in");
			r.mostrarMatriz();
			r.resolver();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
