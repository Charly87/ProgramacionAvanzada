package tp4.source;

public class Main {

	public static void main(String[] args) {
		MatrizSimetrica ms = null;
		Generador gen;
		
		String pathIn  = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";
		
		try {

			/*
			 * ms = new MatrizSimetrica(4); ms.setValor(0,1, 1);
			 * ms.setValor(0,2, 2); ms.setValor(0,3, 3);
			 * ms.setValor(1,2, 4); ms.setValor(1,3, 5);
			 * ms.setValor(2,3, 6); ms.visualizarVector();
			 * ms.visualizar();
			 */

			gen = new Generador();
			/*
			 * ms = gen.generarGrafoAleatorioProbabilidad(5, 70);
			 * ms.visualizarVector();
			 * ms.visualizar();
			 * ms = gen.generarGrafoAleatorioPorcentaje(3, 90);
			 * ms.visualizarVector();
			 * ms.visualizar(); ms =gen.generarGrafoRegular(4, 2);
			 * ms.visualizarVector();
			 * ms.visualizar();
			 */

			// A veces funciona bien y a veces no, debe haber alguna boludez por la que falla.
			ms = gen.generarGrafoRegularNPartitos(6, 5);
			/*if (ms == null) {
				System.out.println("No se puede realizar un grafo N Partitos con nodos y aristas impares");
			} else
				ms.visualizar();*/			

			/*ms = gen.generarGrafoRegularPorAdy(50, 50);
			ms.visualizarVector();
			ms.visualizar();*/
			
			ms = gen.generarGrafoAleatorioPorcentaje(1000, 80);
			gen.guardarMatrizSimetrica(ms, pathIn + "grafo2.in");
//			ms = gen.generarGrafoAleatorioProbabilidad(1000, 80);
//			gen.guardarMatrizSimetrica(ms, pathIn + "grafo3.in");
//			ms = gen.generarGrafoRegular(1000, 4);
//			gen.guardarMatrizSimetrica(ms, pathIn + "grafo4.in");
//			ms = gen.generarGrafoRegularPorAdy(1000, 60);
//			gen.guardarMatrizSimetrica(ms, pathIn + "grafo5.in");
//			
//			GrafoNDNP g = new GrafoNDNP(pathIn + "grafo2.in");
//			g.aplicarColoreoSecuencialAleatorio();
//			g.mostrarGrafoColoreado(pathOut + "grafoSecuencialAleatorio.out");
//			
//			GrafoNDNP g2 = new GrafoNDNP(pathIn + "grafo2.in");
//			g2.aplicarColoreoWelshPowell();
//			g2.mostrarGrafoColoreado(pathOut + "grafoWelshPowell.out");
//			
//			GrafoNDNP g3 = new GrafoNDNP(pathIn + "grafo2.in");
//			g3.aplicarColoreoMatula();
//			g3.mostrarGrafoColoreado(pathOut + "grafoMatula.out");
			
			GrafoNDNP g = new GrafoNDNP(pathIn + "grafo2.in");
			
			int[] coloresUtilizados = new int[g.getCantNodos()];
			
			int i = 0;
			
			while (i < 1000) {
				
				g.mezclarNodos();
				g.aplicarColoreoSecuencialAleatorio();
				coloresUtilizados[g.getCantidadColoresAsignados()-1]++;
				i++;
				
			}
			
			for (int j = 0 ; j < coloresUtilizados.length ; j++) {
				
				System.out.println(coloresUtilizados[j]);
			}
			

//			for (int j = 0 ; j < 3 ; j++) {
//				
//				g.mezclarNodos();
//				g.mostrarNodos();
//				
//			}
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
