package source;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Polinomio p1 = new Polinomio("raizirracional.in");
		System.out.println(p1);
		System.out.println(p1.evaluarPow());
		System.out.println(p1.evaluarMSucesivas());
		System.out.println(p1.evaluarRecursiva());
		System.out.println(p1.evaluarRecursivaPar());
	}

}
