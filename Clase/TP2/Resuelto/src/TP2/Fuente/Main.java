package TP2.Fuente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws IOException {
		Sel sistemasEcu = new Sel("04_caso2x2cCasiLDsimple.in"); 
		Calendar tIni = new GregorianCalendar();

		sistemasEcu.resolver();

		Calendar tFin = new GregorianCalendar();

		sistemasEcu.escribirSalida("salidaResultado.out"); 
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();

		///// Salida por pantalla/////
		System.out.println(sistemasEcu.n); // N
		System.out.println(sistemasEcu.resolverVector); // Vector resultado
		Vector Baux = sistemasEcu.matriz.multiplicar(sistemasEcu.resolverVector);
		System.out.println("Error: " + Math.abs(Baux.norma2() - sistemasEcu.vectorB.norma2())); // Error
		System.out.println("Tiempo en ms: " + diff + "ms");

	}

}
