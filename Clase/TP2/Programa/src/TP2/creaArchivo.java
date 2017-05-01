package TP2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class creaArchivo {
 
	public static void crearVector(int dim) throws IOException {	
	PrintWriter salida = new PrintWriter(new FileWriter("salida.in")); // preparo el arch de salida
	Random rnd = new Random();
	int [] vec = new int [dim+1];
	vec[0]=dim;
	salida.println(vec[0]);
	System.out.println(vec[0]);
	for(int i=1; i<vec.length;i++){
		vec[i]=(rnd.nextInt(100)+1);
		salida.println(vec[i]);	
		System.out.println(vec[i]);
		
	}
	
	salida.close();
}
}
