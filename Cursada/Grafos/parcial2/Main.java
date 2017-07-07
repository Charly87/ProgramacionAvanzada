package parcial2;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
//			Electrificacion e = new Electrificacion("Grafos/parcial2/Prueba1.in");
//			e.resolver();		
			Electrificacion e2 = new Electrificacion("Grafos/parcial2/Prueba2.in");
			e2.resolver();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
