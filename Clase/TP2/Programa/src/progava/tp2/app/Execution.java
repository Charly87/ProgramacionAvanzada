package progava.tp2.app;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Execution
{

	public static void main(String[] args)
	{
		
		try
		{
			
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
						
			
			
			
			
			// prueba matrices
			MatrizMath m1 = new MatrizMath("m1.in");
			MatrizMath m2 = new MatrizMath("m2.in");
			System.out.println("Matriz 1: " + m1);
			System.out.println("Matriz 2: "+ m2);
			
			MatrizMath m3 = m1.sumar(m2);
			System.out.println("Matriz 1 + Matriz 2: " + m3);
			
			MatrizMath m4 = m1.restar(m2);
			System.out.println("Matriz 1 - Matriz 2: " + m4);
			
			MatrizMath m5 = m1.productoPorMatriz(m2);
			System.out.println("Matriz 1 * Matriz 2: " + m5);
			
			MatrizMath m6 = new MatrizMath("m6.in");
			MatrizMath m7 = new MatrizMath("m7.in");
			MatrizMath m8 = m6.productoPorMatriz(m7);
			System.out.println("Matriz 6: " + m6);
			System.out.println("Matriz 7: " + m7);
			System.out.println("Matriz 6 * Matriz 7: " + m8);
			
			MatrizMath m9 = m1.productoPorEscalar(5);
			System.out.println("Matriz 1 * 5: " + m9);
			
			MatrizMath m10 = new MatrizMath("m10.in");
			System.out.println("Matriz 10: " + m10);
			double determinante = m10.determinante();
			System.out.println("Determinante Matriz 10: "+ determinante + "\n");
								
			MatrizMath m11 = new MatrizMath("m11.in");
			VectorMath v8 = new VectorMath("v8.in");
			System.out.println("Matriz 11:" + m11);
			System.out.println("Vector 6: " + v8);
			MatrizMath m12 = m11.productoPorVector(v8);
			System.out.println("Matriz 11 * Vector 3:" + m12);
			
			MatrizMath m13 = new MatrizMath("m13.in");
			MatrizMath m14 = m13.inversa();
			System.out.println("Matriz 13:" + m13);
			System.out.println("Matriz inversa de la matriz 13:" + m14);
			
			MatrizMath m15 = new MatrizMath("m15.in");
			double normaUnoMatriz = m15.normaUno();
			System.out.println("Norma Uno Matriz 15: " + normaUnoMatriz);
			
			double normaDosMatriz = m15.normaDos();
			System.out.println("Norma Dos Matriz 15: " + normaDosMatriz);
			
			double normaInfinitoMatriz = m15.normaInfinito();
			System.out.println("Norma Infinito Matriz 15: " + normaInfinitoMatriz);
			
						
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Error al abrir archivo de entrada", JOptionPane.ERROR_MESSAGE);
		}
		catch (InvalidInputException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Error al leer archivo de entrada", JOptionPane.ERROR_MESSAGE);
		}
		catch (DistDimException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Error al realizar operación", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	
}
