package tp3.source;

import java.io.FileNotFoundException;

public class Main {
	private static String path = "TP3/tp3/test/";

	public static void main(String[] args) throws FileNotFoundException {
		
		Polinomio p1 = new Polinomio(path + "06_Fatiga.in");
		long ini;
		long fin;
		long dif;
		
		// Muestro polinomio
		System.out.println(p1);
		
		System.out.println();
				
		// Tiempo metodo "evaluarMSucesivas"
		ini = System.nanoTime();
		System.out.println("MSucesivas:\t" + p1.evaluarMSucesivas(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarRecursiva"
		ini = System.nanoTime();
		System.out.println("Recursiva:\t" + p1.evaluarRecursiva( p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarRecursivaPar"
		ini = System.nanoTime();
		System.out.println("RecursivaPar:\t" + p1.evaluarRecursivaPar(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarProgDinamica"
		ini = System.nanoTime();
		System.out.println("ProgDinamica:\t" + p1.evaluarProgDinamica(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarMejorada"
		ini = System.nanoTime();
		System.out.println("Mejorada:\t" + p1.evaluarMejorada(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarPow"
		ini = System.nanoTime();
		System.out.println("Pow:\t\t" + p1.evaluarPow(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
		System.out.println();
		
		// Tiempo metodo "evaluarHorner"
		ini = System.nanoTime();
		System.out.println("Horner:\t\t" + p1.evaluarHorner(p1.getValorX()));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:\t\t" + dif);
		
	}
}