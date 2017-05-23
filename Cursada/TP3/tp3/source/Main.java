package tp3.source;

import java.io.FileNotFoundException;

public class Main {
	private static String path = "TP3/tp3/test/";

	public static void main(String[] args) throws FileNotFoundException {
		
		Polinomio p1 = new Polinomio(path + "04_GradoTres.in");
		long ini;
		long fin;
		long dif;
		System.out.println(p1.evaluarRecursiva(20));
		System.out.println(p1.evaluarRecursivaPar(20));
		// Muestro polinomio
		/*System.out.println(p1);
		
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
		
		//// Tiempos Binomio de Newton
		System.out.println("\n\nTIEMPOS BINOMIO DE NEWTON");
		BinomioDeNewton bdn = new BinomioDeNewton(path + "10_BinomioFatiga.in");
		
		// Tiempo metodo "obtenerTermino"
		ini = System.nanoTime();
		System.out.println("\nObtener Termino:\n" + bdn.obtenerTermino(0));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:" + dif);
		
		// Tiempo metodo "calcularBinomioCompleto"
		ini = System.nanoTime();
		System.out.println("\nCalcular Binomio Completo:\n" + bdn.calcularBinomioCompleto());
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:" + dif);
		
		// Tiempo metodo "calcularBinomioCompletoOptimizado"
		ini = System.nanoTime();
		System.out.println("\nCalcular Binomio Completo Optimizado:\n" + bdn.calcularBinomioCompletoOptimizado());
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:" + dif);
		
		// Tiempo metodo "calcularXPolinomioCompleto"
		ini = System.nanoTime();
		System.out.println("\nCalcular X con Binomio de Newton:\n" + bdn.calcularXPolinomioCompleto(100));
		fin = System.nanoTime();
		dif = fin - ini;
		System.out.println("Tiempo:" + dif);*/
		
	}
}