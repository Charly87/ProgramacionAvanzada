package dfs;

public class Main {
	public static void main(String[] args) {

		Dfs d = new Dfs(7, true);
		
		d.agregarNodo(6);
		d.agregarNodo(3);
		d.agregarNodo(4);
		d.agregarNodo(1);
		d.agregarNodo(5);
		d.agregarNodo(2);
		d.agregarNodo(7);
		
		d.agregarConexion(1, 2, 1);
		d.agregarConexion(1, 3, 1);
		d.agregarConexion(2, 3, 1);
		d.agregarConexion(2, 4, 1);
		d.agregarConexion(3, 4, 1);
		d.agregarConexion(3, 7, 1);
		d.agregarConexion(4, 6, 1);
		d.agregarConexion(5, 4, 1);
		d.agregarConexion(5, 2, 1);
		d.agregarConexion(6, 5, 1);
		d.agregarConexion(6, 7, 1);
		d.agregarConexion(7, 4, 1);
		
		d.resolver(1);
		d.mostrarResultado();
	}
}
