package tp4.source;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		final int CANTIDAD_EJECUCIONES = 1000;
		List<Integer> coloresUsados = new ArrayList<Integer>();	
		
		String pathIn = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";

		try {

////			// Genero los 3 grafos aleatorios (40% - 60% - 90% adyacencia)
			Generador g = new Generador();		
////
//			System.out.println("Generando grafo aleatorio porcentaje 90...");
//		    g.generarGrafoAleatorioPorcentaje(900, 90, pathIn + "grafoAleatorioRegular75.in");
////			
//			System.out.println("Generando grafo aleatorio porcentaje 90...");
//		    g.generarGrafoAleatorioPorcentaje(900, 90, pathIn + "grafoAleatorioRegular75.in");
////			
//			System.out.println("Generando grafo aleatorio porcentaje 90...");
//	        g.generarGrafoAleatorioPorcentaje(600, 90, pathIn + "grafoAleatorioRegular75.in");
////
////	    
			//2 grafos regulares
			System.out.println("Generando grafo regular porcentaje 75...");
		    g.generarGrafoRegularPorAdy(1000, 45, pathIn + "grafoRegular75.in");
			
			// Realizo las ejecuciones del grafo aleatorio al 90
			GrafoNDNP grafoRegular75 = new GrafoNDNP(pathIn + "grafoRegular75.in");
			
			//// Coloreo Secuencial Aleatorio			
			int[] coloresColoreoSecuencialAleatorio90 = new int[CANTIDAD_EJECUCIONES];
			int corridamin=0;
			int min=10;
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Secuencial Aleatorio porcentaje 90...");						
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
								
				coloresColoreoSecuencialAleatorio90[grafoRegular75.generarColoreoSecuencialAleatorio()]++;			
				coloresUsados=grafoRegular75.getcUsados();
			    if(coloresColoreoSecuencialAleatorio90[e]!=0&&coloresColoreoSecuencialAleatorio90[e]<=min){
			    	corridamin=e;
			    	min=coloresColoreoSecuencialAleatorio90[e];
			    }
			    	
                grafoRegular75.guardarColoreo(pathOut + "coloreoRegular75.out");
				Probador probadorColoreoSecuencialAleatorio90 = new Probador(pathIn + "grafoRegular75.in", pathOut + "coloreoRegular75.out");
				probadorColoreoSecuencialAleatorio90.verificarSalida();
				System.out.println(e);
			}
			
            DatosGraficos dato = new DatosGraficos();
            dato.generarDatosGrafico(coloresUsados,coloresColoreoSecuencialAleatorio90,"grafoRegular75SECUENCIAL");
            dato.estadisticas(coloresColoreoSecuencialAleatorio90,corridamin,"grafoRegular75menorSEC");
			
			coloresUsados.clear();
			
			//// Coloreo Welsh-Powell
			int[] coloresColoreoWelshPowell90 = new int[CANTIDAD_EJECUCIONES];
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Welsh-Powell porcentaje 90...");
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
				
				coloresColoreoWelshPowell90[grafoRegular75.generarColoreoWelshPowell()]++;			
				coloresUsados=grafoRegular75.getcUsados();
				if(coloresColoreoWelshPowell90[e]!=0&&coloresColoreoWelshPowell90[e]<=min){
			    	corridamin=e;
			    	min=coloresColoreoWelshPowell90[e];
			    }
				System.out.println(e);
				grafoRegular75.guardarColoreo(pathOut + "coloreoRegular75.out");										
				Probador probadorColoreoWelshPowell90 = new Probador(pathIn + "grafoRegular75.in", pathOut + "coloreoRegular75.out");
				probadorColoreoWelshPowell90.verificarSalida();				
				
			}
			
            dato.generarDatosGrafico(coloresUsados,coloresColoreoWelshPowell90,"grafoRegular75POWELL");
            dato.estadisticas(coloresColoreoWelshPowell90,corridamin,"grafoRegular75menorPOWELL");
            coloresUsados.clear();
			
			//// Coloreo Matula
			int[] coloresColoreoMatula90 = new int[CANTIDAD_EJECUCIONES];
			System.out.println("Realizando " + CANTIDAD_EJECUCIONES + " ejecuciones de coloreo Matula porcentaje 90...");
			for (int e = 0 ; e < CANTIDAD_EJECUCIONES ; e++) {
				
				coloresColoreoMatula90[grafoRegular75.generarColoreoMatula()]++;
				coloresUsados=grafoRegular75.getcUsados();
				if(coloresColoreoMatula90[e]!=0&&coloresColoreoMatula90[e]<=min){
			    	corridamin=e;
			    	min=coloresColoreoMatula90[e];
			    }
				grafoRegular75.guardarColoreo(pathOut + "coloreoRegular75.out");
				Probador probadorColoreoMatula90 = new Probador(pathIn + "grafoRegular75.in", pathOut + "coloreoRegular75.out");
				probadorColoreoMatula90.verificarSalida();				
				System.out.println(e);
			}
			
			dato.generarDatosGrafico(coloresUsados,coloresColoreoMatula90,"grafoRegular75MATULA");
			dato.estadisticas(coloresColoreoMatula90,corridamin,"grafoRegular75menorMAT");
			coloresUsados.clear();
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
