package floyd;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		Gusano g;
		try {
			g = new Gusano("Grafos/floyd/Gusano1.in");
			g.mostrarMatrizAdyacencia();
			//g.mostrarMatrizRecorrido();			
			g.resolver();
			g.mostrarReultado();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
