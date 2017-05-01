package TP2.Test;

import java.io.FileNotFoundException;

import org.junit.Test;

import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class VectorMathTest {

	
	
	Calendar tIni = new GregorianCalendar();

	// start code
	@Test
	public void PruebaVector() throws FileNotFoundException, InvalidInputException {
		// prueba vectores
		
		VectorMath v1 = new VectorMath("dim500.in");
		VectorMath v2 = new VectorMath("dim500_2.in");
        
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);
        
		Calendar tIni = new GregorianCalendar();
		// start code SUMAR
		VectorMath v3 = v1.sumar(v2);
		System.out.println("Suma: " + v3);
		// end code SUMAR
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("El tiempo de ejecucion SUMA es= " +diff);
        
		Calendar tInir = new GregorianCalendar();
		// start code RESTAR
		VectorMath v4 = v1.restar(v2);
		System.out.println("Resta: " + v4);
		// end code RESTAR
		Calendar tFinr = new GregorianCalendar();
		long diffr = tFinr.getTimeInMillis() - tInir.getTimeInMillis();
		System.out.println("El tiempo de ejecucion RESTA es= " +diffr);
		
		Calendar tInipe = new GregorianCalendar();
		// start code P.ESCALAR
		double resProdEscalar = v1.productoEscalar(v2);
		System.out.println("Producto escalar: " + resProdEscalar);
		// end code P.ESCALAR
		Calendar tFinpe = new GregorianCalendar();
		long diffpe = tFinpe.getTimeInMillis() - tInipe.getTimeInMillis();
		System.out.println("El tiempo de ejecucion PE es= " +diffpe);
		
		Calendar tInippe = new GregorianCalendar();
		// start code P.por un ESCALAR
		VectorMath v5 = v1.productoPorEscalar(3);
		System.out.println("Producto por escalar:" + v5);
		// end code P.por un ESCALAR
		Calendar tFinppe = new GregorianCalendar();
		long diffppe = tFinppe.getTimeInMillis() - tInippe.getTimeInMillis();
		System.out.println("El tiempo de ejecucion PPE es= " +diffppe);
		
		VectorMath v6 = new VectorMath("v6.in");
		MatrizMath m16 = new MatrizMath("m16.in");
		System.out.println("Vector 6: " + v6);
		System.out.println("Matriz 16:" + m16);
		
		
		Calendar tIniVpM = new GregorianCalendar();
		// start code Vector por Matriz
		VectorMath v7 = v6.productoPorMatriz(m16);
		System.out.println("Vector 6 * Matriz 16: " + v7);
		// end code Vector por Matriz
		Calendar tFinVpM = new GregorianCalendar();
		long diffVpM = tFinVpM.getTimeInMillis() - tIniVpM.getTimeInMillis();
		System.out.println("El tiempo de ejecucion PPE es= " +diffVpM);
		
		double normaUnoVector = v1.normaUno();
		System.out.println("Norma Uno Vector 1: " + normaUnoVector);

		double normaDosVector = v1.normaDos();
		System.out.println("Norma Dos Vector 1: " + normaDosVector);

		double normaInfinitoVector = v1.normaInfinito();
		System.out.println("Norma Infinito Vector 1: " + normaInfinitoVector);
		
		
	}
}
