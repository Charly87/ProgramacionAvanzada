package tp3.source;

import java.io.FileNotFoundException;

public class Main {
	private static String path = "TP3/tp3/source/test/casos/";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Polinomio p1 = new Polinomio(path + "trivial.in");
		System.out.println(p1);
		
		long now = System.nanoTime();
		System.out.println(p1.evaluarMSucesivas());
		//System.out.println(p1.evaluarPow());
		//System.out.println(p1.evaluarDinamica());
		//System.out.println(p1.evaluarRecursiva());
		long end = System.nanoTime();
		
		long diff = end-now;
		System.out.println("Tiempo: " + diff);
		
		System.out.println(p1.evaluarMSucesivas());
		System.out.println(p1.evaluarRecursiva());
		System.out.println(p1.evaluarRecursivaPar());//Revisar
		System.out.println(p1.evaluarDinamica());
	}
}