package prim;

public class Main {

	public static void main(String[] args) {	
		Prim p = new Prim(14);		
		p.agregarConexion(1, 2, 8);
		p.agregarConexion(2, 3, 10);
		p.agregarConexion(2, 4, 4);
		p.agregarConexion(4, 5, 7);
		p.agregarConexion(3, 5, 5);
		p.agregarConexion(4, 6, 2);
		p.agregarConexion(5, 8, 11);
		p.agregarConexion(6, 8, 12);
		p.agregarConexion(6, 9, 14);
		p.agregarConexion(6, 10, 6);
		p.agregarConexion(6, 11, 9);
		p.agregarConexion(11, 10, 3);
		p.agregarConexion(9, 10, 17);
		p.agregarConexion(8, 9, 20);
		
		p.resolver(1);
		p.mostrarArbol();
	}
}
