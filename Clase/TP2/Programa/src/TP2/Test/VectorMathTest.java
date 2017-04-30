package TP2.Test;

import java.io.FileNotFoundException;

import org.junit.Test;

import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

public class VectorMathTest {

	@Test
	public void PruebaVector() throws FileNotFoundException, InvalidInputException {
		// prueba vectores
		VectorMath v1 = new VectorMath("v1.in");
		VectorMath v2 = new VectorMath("v2.in");

		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);

		VectorMath v3 = v1.sumar(v2);
		System.out.println("Suma: " + v3);

		VectorMath v4 = v1.restar(v2);
		System.out.println("Resta: " + v4);

		double resProdEscalar = v1.productoEscalar(v2);
		System.out.println("Producto escalar: " + resProdEscalar);

		VectorMath v5 = v1.productoPorEscalar(3);
		System.out.println("Producto por escalar:" + v5);

		VectorMath v6 = new VectorMath("v6.in");
		MatrizMath m16 = new MatrizMath("m16.in");
		System.out.println("Vector 6: " + v6);
		System.out.println("Matriz 16:" + m16);
		VectorMath v7 = v6.productoPorMatriz(m16);
		System.out.println("Vector 6 * Matriz 16: " + v7);

		double normaUnoVector = v1.normaUno();
		System.out.println("Norma Uno Vector 1: " + normaUnoVector);

		double normaDosVector = v1.normaDos();
		System.out.println("Norma Dos Vector 1: " + normaDosVector);

		double normaInfinitoVector = v1.normaInfinito();
		System.out.println("Norma Infinito Vector 1: " + normaInfinitoVector);
	}
}
