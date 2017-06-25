package tp4bis.test.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import tp4bis.src.tp4.GeneradorAleatorioPorcentaje;
import tp4bis.src.tp4.GeneradorRegularPorcentaje;
import tp4bis.src.tp4.GrafoNDNP;

public class Pruebas {

	@Test
	public void secuenciaAleatoriaParaGrafoAleatorio() throws FileNotFoundException {		
		GrafoNDNP coloreo = new GrafoNDNP("TP4BIS/prueba.in");
		coloreo.generarVectorSecuenciaAleatorio();
		coloreo.algoritmoDeColoreo();
		
		coloreo.generarVectorMatulaAleatorio();
		coloreo.matula();
		
		coloreo.generarVectorWelshPowellAleatorio();
		coloreo.welshPowell();
		
		
		System.out.println(coloreo.getCantColores());		
	}
}
