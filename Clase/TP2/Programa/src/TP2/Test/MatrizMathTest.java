package TP2.Test;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

import TP2.DistDimException;
import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

public class MatrizMathTest {
	private String path = "src/TP2/Test/Lotes/";

	@Test
	public void suma() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(path + "m1.in");
		MatrizMath m2 = new MatrizMath(path + "m2.in");
		System.out.println("Matriz 1: " + m1);
		System.out.println("Matriz 2: " + m2);

		MatrizMath m3 = m1.sumar(m2);
		System.out.println("Matriz 1 + Matriz 2: " + m3);		
	}
	
	@Test
	public void resta() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(path + "m1.in");
		MatrizMath m2 = new MatrizMath(path + "m2.in");
		System.out.println("Matriz 1: " + m1);
		System.out.println("Matriz 2: " + m2);

		MatrizMath m3 = m1.restar(m2);
		System.out.println("Matriz 1 + Matriz 2: " + m3);		
	}
	
	@Test
	public void productoPorMatriz() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(path + "m1.in");
		MatrizMath m2 = new MatrizMath(path + "m2.in");
		System.out.println("Matriz 1: " + m1);
		System.out.println("Matriz 2: " + m2);

		MatrizMath m3 = m1.productoPorMatriz(m2);
		System.out.println("Matriz 1 + Matriz 2: " + m3);		
	}
	
	@Test
	public void productoPorMatriz2() throws FileNotFoundException, InvalidInputException {
		MatrizMath m6 = new MatrizMath(path + "m6.in");
		MatrizMath m7 = new MatrizMath(path + "m7.in");
		MatrizMath m8 = m6.productoPorMatriz(m7);
		System.out.println("Matriz 6: " + m6);
		System.out.println("Matriz 7: " + m7);
		System.out.println("Matriz 6 * Matriz 7: " + m8);
	}
	
	@Test
	public void productoPorEscalar() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(path + "m1.in");
		MatrizMath m2 = m1.productoPorEscalar(5);
		System.out.println("Matriz 1 * 5: " + m2);
	}
	
	@Test
	public void determinante() throws FileNotFoundException, InvalidInputException, DistDimException, CloneNotSupportedException {
		MatrizMath m10 = new MatrizMath(path + "m10.in");
		System.out.println("Matriz 10: " + m10);
		double determinante = m10.determinante();
		System.out.println("Determinante Matriz 10: " + determinante + "\n");
	}

	@Test
	public void productoPorVector() throws FileNotFoundException, InvalidInputException{
		MatrizMath m11 = new MatrizMath(path + "m11.in");
		VectorMath v8 = new VectorMath(path + "v8.in");
		System.out.println("Matriz 11:" + m11);
		System.out.println("Vector 6: " + v8);
		VectorMath v18 = m11.productoPorVector(v8);
		System.out.println("Matriz 11 * Vector 3:" + v18);
	}
	
	@Test
	public void inversa() throws FileNotFoundException, InvalidInputException, CloneNotSupportedException{
		MatrizMath m13 = new MatrizMath(path + "m13.in");
		MatrizMath m14 = m13.inversa();
		System.out.println("Matriz 13:" + m13);
		System.out.println("Matriz inversa de la matriz 13:" + m14);
	}
	
	@Test
	public void normaUno() throws FileNotFoundException, InvalidInputException {
		MatrizMath m15 = new MatrizMath(path + "m15.in");
		double normaUnoMatriz = m15.normaUno();
		System.out.println("Norma Uno Matriz 15: " + normaUnoMatriz);
	}
	
	@Test
	public void normaDos() throws FileNotFoundException, InvalidInputException {
		MatrizMath m15 = new MatrizMath(path + "m15.in");
		double normaDosMatriz = m15.normaDos();
		System.out.println("Norma Dos Matriz 15: " + normaDosMatriz);
	}
	
	@Test
	public void normaInfinito() throws FileNotFoundException, InvalidInputException{
		MatrizMath m15 = new MatrizMath(path + "m15.in");
		double normaInfinitoMatriz = m15.normaInfinito();
		System.out.println("Norma Infinito Matriz 15: " + normaInfinitoMatriz);
	}
}
