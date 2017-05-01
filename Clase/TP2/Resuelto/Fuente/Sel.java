package sel;

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
		
		salida.println();
		salida.println(Math.abs(Baux.norma2() - this.vectorB.norma2()));
		
		
		salida.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {

		Sel sistemasEcu = new Sel("03_4x4_Normal.in"); //Creo el Sistema de Ecuaciones a partir de entrada.ini
		
		Calendar tIni = new GregorianCalendar();////INICIO TIMER////
		
		sistemasEcu.resolver();
		
		Calendar tFin = new GregorianCalendar();/////FIN TIMER//////

		sistemasEcu.escribirSalida("salidaResultado.out"); //Grabo resultado de sistema en archivo de salida
		
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		
		
		/////Salida por pantalla/////
		System.out.println(sistemasEcu.n); // N
		System.out.println(sistemasEcu.resolverVector); //Vector resultado
		Vector Baux=sistemasEcu.matriz.multiplicar(sistemasEcu.resolverVector); 
		System.out.println("Error: "+Math.abs(Baux.norma2() - sistemasEcu.vectorB.norma2())); //Error
		System.out.println("Tiempo en ms: " + diff + "ms");

	}

}


