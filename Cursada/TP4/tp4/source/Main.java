package tp4.source;

public class Main {

	public static void main(String[] args) {
		
		final int CANTIDAD_EJECUCIONES = 1000;
		
		String pathIn = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";

		try {

			// Genero los 3 grafos aleatorios (40% - 60% - 90% adyacencia)
			Generador g = new Generador();		

			System.out.println("Generando grafo aleatorio porcentaje 40...");
			g.generarGrafoAleatorioPorcentaje(600, 40, pathIn + "grafoAleatorioPorcentaje40.in");
			
			System.out.println("Generando grafo aleatorio porcentaje 60...");
			g.generarGrafoAleatorioPorcentaje(600, 60, pathIn + "grafoAleatorioPorcentaje60.in");
			
			System.out.println("Generando grafo aleatorio porcentaje 90...");
			g.generarGrafoAleatorioPorcentaje(600, 90, pathIn + "grafoAleatorioPorcentaje90.in");

			// Realizo las ejecuciones del grafo aleatorio al 40
			GrafoNDNP grafoAleatorio40 = new GrafoNDNP(pathIn + "grafoAleatorioPorcentaje40.in");
			
			//// Coloreo Secuencial Aleatorio			
			int[] coloresColoreoSecuencialAleatorio40 = new int[CANTIDAD_EJECUCIONES];
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Secuencial Aleatorio porcentaje 40...");						
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
								
				coloresColoreoSecuencialAleatorio40[grafoAleatorio40.generarColoreoSecuencialAleatorio()]++;			
				grafoAleatorio40.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje40.out");
				Probador probadorColoreoSecuencialAleatorio40 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in", pathOut + "coloreoAleatorioPorcentaje40.out");
				probadorColoreoSecuencialAleatorio40.verificarSalida();
				
			}
			
			for (int i = 0 ; i < coloresColoreoSecuencialAleatorio40.length ; i++)
				System.out.println(coloresColoreoSecuencialAleatorio40[i]);
			
			
			//// Coloreo Welsh-Powell
			int[] coloresColoreoWelshPowell40 = new int[CANTIDAD_EJECUCIONES];
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Welsh-Powell porcentaje 40...");
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
				
				coloresColoreoWelshPowell40[grafoAleatorio40.generarColoreoWelshPowell()]++;			
				grafoAleatorio40.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje40.out");										
				Probador probadorColoreoWelshPowell40 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in", pathOut + "coloreoAleatorioPorcentaje40.out");
				probadorColoreoWelshPowell40.verificarSalida();				
				
			}
			
			for (int i = 0 ; i < coloresColoreoWelshPowell40.length ; i++)
				System.out.println(coloresColoreoWelshPowell40[i]);
			
			
			//// Coloreo Matula
			int[] coloresColoreoMatula40 = new int[CANTIDAD_EJECUCIONES];
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Matula porcentaje 40...");
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
				
				coloresColoreoMatula40[grafoAleatorio40.generarColoreoMatula()]++;
				grafoAleatorio40.guardarColoreo(pathOut + "coloreoAleatorioPorcentaje40.out");
				Probador probadorColoreoMatula40 = new Probador(pathIn + "grafoAleatorioPorcentaje40.in", pathOut + "coloreoAleatorioPorcentaje40.out");
				probadorColoreoMatula40.verificarSalida();				
				
			}
			
			for (int i = 0 ; i < coloresColoreoMatula40.length ; i++)
				System.out.println(coloresColoreoMatula40[i]);
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
