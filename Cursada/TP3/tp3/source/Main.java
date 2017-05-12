package tp3.source;

import java.io.FileNotFoundException;

public class Main {
	private static String path = "TP3/tp3/source/test/casos/";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Polinomio p1 = new Polinomio(path + "trivial.in");
		System.out.println(p1);

		long now = System.nanoTime();
		System.out.println("MSucesivas:\t" + p1.evaluarMSucesivas(p1.getValorX()));
		// System.out.println(p1.evaluarPow());
		// System.out.println(p1.evaluarDinamica());
		// System.out.println(p1.evaluarRecursiva());
		long end = System.nanoTime();

		long diff = end - now;
		System.out.println("Tiempo: " + diff);

		System.out.println("MSucesivas:\t" + p1.evaluarMSucesivas(p1.getValorX()));
		System.out.println("Recursiva:\t" + p1.evaluarRecursiva( p1.getValorX()));
		System.out.println("RecursivaPar:\t" + p1.evaluarRecursivaPar(p1.getValorX()));// Revisar
		System.out.println("ProgDinamica:\t" + p1.evaluarProgDinamica(p1.getValorX()));
	}
}