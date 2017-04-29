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
//			VectorMath v1 = new VectorMath("v1.in");
//			VectorMath v2 = new VectorMath("v2.in");
//			
//			System.out.println("Vector 1: " + v1);
//			System.out.println("Vector 2: " + v2);
//			
//			VectorMath v3 = v1.sumar(v2);
//			System.out.println("Suma: " + v3);
//			
//			VectorMath v4 = v1.restar(v2);
//			System.out.println("Resta: " + v4);			
//			
//			double resProdEscalar = v1.productoEscalar(v2);
//			System.out.println("Producto escalar: " + resProdEscalar);
//			
//			VectorMath v5 = v1.productoPorEscalar(3);
//			System.out.println("Producto por escalar:" + v5);
//			
//			double normaUno = v1.normaUno();
//			System.out.println("Norma Uno: " + normaUno);
//			
//			double normaDos = v1.normaDos();
//			System.out.println("Norma Dos: " + normaDos);
//			
//			double normaInfinito = v1.normaInfinito();
//			System.out.println("Norma Infinito: " + normaInfinito);
			
			// prueba matrices
			MatrizMath m1 = new MatrizMath("m1.in");
			MatrizMath m2 = new MatrizMath("m2.in");
			m1.mostrar();
			m2.mostrar();
			
			MatrizMath m3 = m1.sumar(m2);
			m3.mostrar();
			
			MatrizMath m4 = m1.restar(m2);
			m4.mostrar();
			
			MatrizMath m5 = m1.productoPorMatriz(m2);
			m5.mostrar();
			
			MatrizMath m6 = new MatrizMath("m6.in");
			MatrizMath m7 = new MatrizMath("m7.in");
			MatrizMath m8 = m6.productoPorMatriz(m7);
			m8.mostrar();
			
			
			
			
			
						
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
