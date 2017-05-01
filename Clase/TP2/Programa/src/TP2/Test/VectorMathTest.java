package TP2.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

public class VectorMathTest {
	
	private String path = "src/TP2/Test/Lotes/";
	
	@Test
	public void suma() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		VectorMath v2 = new VectorMath(path + "v2.in");
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);

		VectorMath v3 = v1.sumar(v2);
		System.out.println("Suma: " + v3);
	}
	
	@Test
	public void resta() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		VectorMath v2 = new VectorMath(path + "v2.in");
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);

		VectorMath v3 = v1.restar(v2);
		System.out.println("Resta: " + v3);
	}
	
	@Test
	public void productoEscalar() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		VectorMath v2 = new VectorMath(path + "v2.in");
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);

		double resProdEscalar = v1.productoEscalar(v2);
		System.out.println("Producto escalar: " + resProdEscalar);
	}
	
	@Test
	public void productoPorEscalar() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		System.out.println("Vector 1: " + v1);

		VectorMath v2 = v1.productoPorEscalar(3);
		System.out.println("Producto por escalar:" + v2);
	}
	
	@Test
	public void productoPorMatriz() throws FileNotFoundException, InvalidInputException {		
		VectorMath v6 = new VectorMath(path + "v6.in");
		MatrizMath m16 = new MatrizMath(path + "m16.in");
		
		System.out.println("Vector 6: " + v6);
		System.out.println("Matriz 16:" + m16);
		
		VectorMath v7 = v6.productoPorMatriz(m16);
		System.out.println("Vector 6 * Matriz 16: " + v7);
	}
	
	@Test
	public void normaUno() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		double normaUnoVector = v1.normaUno();
		System.out.println("Norma Uno Vector 1: " + normaUnoVector);
	}
	
	@Test
	public void normaDos() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		double normaDosVector = v1.normaDos();
		System.out.println("Norma Dos Vector 1: " + normaDosVector);
	}
	
	@Test
	public void normaInfinito() throws FileNotFoundException, InvalidInputException {		
		VectorMath v1 = new VectorMath(path + "v1.in");
		double normaInfinitoVector = v1.normaInfinito();
		System.out.println("Norma Infinito Vector 1: " + normaInfinitoVector);
	}	
}
