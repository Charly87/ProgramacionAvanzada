package tp4bis.test.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import tp4bis.src.tp4.GeneradorAleatorioPorcentaje;
import tp4bis.src.tp4.GeneradorRegularPorcentaje;
import tp4bis.src.tp4.GrafoNDNP;

public class AnalisisEstadistico {

	@Test
	public void secuenciaAleatoriaParaGrafoAleatorio() throws FileNotFoundException {
		int nodos = 600;
		double adyacencia = 0.4;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 1000; i++) {

			coloreo.SecuenciaAleatorio();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

	@Ignore
	public void welshPowellParaGrafoAleatorio() throws FileNotFoundException {
		int nodos = 600;
		double adyacencia = 0.4;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 1000; i++) {

			coloreo.welshPowell();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

	@Ignore
	public void matulaParaGrafoAleatorio() throws FileNotFoundException {
		int nodos = 600;
		double adyacencia = 0.4;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 1000; i++) {

			coloreo.matula();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

	@Ignore
	public void secuenciaAleatoriaParaGrafoRegular() throws FileNotFoundException {
		int nodos = 1000;
		double adyacencia = 0.5;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorRegularPorcentaje generador = new GeneradorRegularPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 10000; i++) {

			coloreo.SecuenciaAleatorio();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

	@Ignore
	public void welshPowellParaGrafoRegular() throws FileNotFoundException {
		int nodos = 1000;
		double adyacencia = 0.5;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorRegularPorcentaje generador = new GeneradorRegularPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 500; i++) {

			coloreo.welshPowell();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

	@Ignore
	public void matulaParaGrafoRegular() throws FileNotFoundException {
		int nodos = 1000;
		double adyacencia = 0.5;
		int cantMenorColor = (int) Double.POSITIVE_INFINITY;
		int corridaMenorColor = 0;
		GeneradorRegularPorcentaje generador = new GeneradorRegularPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 1000; i++) {

			coloreo.matula();
			System.out.println(coloreo.getCantColores());
			if (cantMenorColor > coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

}
