package tp4.source;

public class Main {

	public static void main(String[] args) {

		String pathIn = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";
		int[] coloresAleatorio40;

		try {

			// Genero los 3 grafos (40% - 60% - 90% adyacencia)
			Generador g = new Generador();		

			System.out.println("Generando grafo aleatorio porcentaje 40...");
			g.generarGrafoAleatorioPorcentaje(600, 40, pathIn + "grafoAleatorioPorcentaje40.in");
			
			System.out.println("Generando grafo aleatorio porcentaje 60...");
			g.generarGrafoAleatorioPorcentaje(600, 60, pathIn + "grafoAleatorioPorcentaje60.in");
			
			System.out.println("Generando grafo aleatorio porcentaje 90...");
			g.generarGrafoAleatorioPorcentaje(600, 90, pathIn + "grafoAleatorioPorcentaje90.in");

			GrafoNDNP grafoAleatorio40 = new GrafoNDNP(pathIn + "grafoAleatorioPorcentaje40.in");

			System.out.println("Generando coloreo Secuencial Aleatorio porcentaje 40...");
			coloresAleatorio40 = new int[grafoAleatorio40.getCantidadNodos()];
			coloresAleatorio40[0] = grafoAleatorio40.generarColoreoSecuencialAleatorio();			
			grafoAleatorio40.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje40.out");
			
			Probador probadorAleatorio40 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in", pathOut + "coloreoAleatorioPorcentaje40.out");
			System.out.println("\n\nResultados coloreo Secuencial Aleatorio porcentaje 40:");			
			probadorAleatorio40.verificarSalida();
			
			
//			g.generarGrafoAleatorioProbabilidad(20, 50, pathIn + "prueba.in");
//			GrafoNDNP grafoPrueba = new GrafoNDNP(pathIn + "prueba.in");
//			grafoPrueba.generarColoreoSecuencialAleatorio();
//			grafoPrueba.guardarColoreo(pathOut + "prueba.out");
//			Probador probadorPrueba = new Probador(pathIn + "prueba.in", pathOut + "prueba.out");
//			probadorPrueba.verificarSalida();
			
			
		
//			GrafoNDNP grafoAleatorio60 = new GrafoNDNP(pathIn + "grafoAleatorioPorcentaje60.in");
//			GrafoNDNP grafoAleatorio90 = new GrafoNDNP(pathIn + "grafoAleatorioPorcentaje90.in");

//			System.out.println("Generando coloreo aleatorio porcentaje 40");
//			grafoAleatorio40.generarColoreoSecuencialAleatorio();
//			System.out.println("Generando coloreo aleatorio porcentaje 60");
//			grafoAleatorio60.generarColoreoSecuencialAleatorio();
//			System.out.println("Generando coloreo aleatorio porcentaje 90");
//			grafoAleatorio90.generarColoreoSecuencialAleatorio();
//
//			grafoAleatorio40.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje40.out");
//			grafoAleatorio60.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje60.out");
//			grafoAleatorio90.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje90.out");
//
//			Probador pAleatorio40 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in",
//					pathOut + "coloreoAleatorioPorcentaje40.out");
//			Probador pAleatorio60 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in",
//					pathOut + "coloreoAleatorioPorcentaje40.out");
//			Probador pAleatorio90 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in",
//					pathOut + "coloreoAleatorioPorcentaje40.out");
//
//			pAleatorio40.verificarSalida();
//			pAleatorio60.verificarSalida();
//			pAleatorio90.verificarSalida();
//
//			System.out.println("Generando coloreo welsh powel porcentaje 40");
//			grafoAleatorio40.generarColoreoWelshPowell();
//			System.out.println("Generando coloreo welsh powel porcentaje 60");
//			grafoAleatorio60.generarColoreoWelshPowell();
//			System.out.println("Generando coloreo welsh powel porcentaje 90");
//			grafoAleatorio90.generarColoreoWelshPowell();
//
//			System.out.println("Generando coloreo matula porcentaje 40");
//			grafoAleatorio40.generarColoreoMatula();
//			System.out.println("Generando coloreo matula porcentaje 60");
//			grafoAleatorio60.generarColoreoMatula();
//			System.out.println("Generando coloreo matula porcentaje 90");
//			grafoAleatorio90.generarColoreoMatula();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
