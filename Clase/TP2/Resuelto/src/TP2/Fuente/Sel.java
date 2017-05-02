package TP2.Fuente;

import java.io.*;
import java.util.*;


public class Sel {

	int n;
	Vector vectorB, resolverVector;
	Matriz matriz;
	private double error = 0.000001;

	public Sel(String entrada) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(entrada));
		sc.useLocale(Locale.US);
		n = sc.nextInt();
		
		double mat[][] = new double[n][n];
		int i = 0;
		
		while (i < (n * n)) {
			
			
			mat[sc.nextInt()][sc.nextInt()] = sc.nextDouble();
			i++;
			
		}
		
		matriz = new Matriz(mat);

		double vecaux[] = new double[n];

		for (i = 0; i < n; i++) {
			vecaux[i] = sc.nextDouble();
		}
		this.vectorB = new Vector(vecaux);

		sc.close();

	}

	public Vector resolver() {

		Matriz inv = matriz.inversa(); // si la inversa es null no se puede resolver
		resolverVector = inv.multiplicar(vectorB);

		return resolverVector;
	}
	
	public Matriz getMatriz()
	{
		return this.matriz;
	}
	
	public Vector getVector()
	{
		return this.vectorB;
	}
	
	public void escribirSalida(String pathSalida) throws IOException{
		
		PrintWriter salida = new PrintWriter(new FileWriter(pathSalida));
		
		salida.println(this.n);
	
		for (int i = 0; i < resolverVector.getDimension(); i++) 
			salida.println(this.resolverVector.obtenerElemento(i));
			
		
		Vector Baux=this.matriz.multiplicar(resolverVector);
		double norma2a = Baux.norma2();
		double norma2b = this.vectorB.norma2();
		salida.println();
		salida.println(Math.abs(norma2a - norma2b));
		
		
		salida.close();
	}
	
}