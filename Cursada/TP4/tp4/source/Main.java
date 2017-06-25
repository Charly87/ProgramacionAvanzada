package tp4.source;

public class Main {

	public static void main(String[] args) {

		String pathIn = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";

		try {

//			GrafoNDNP g = new GrafoNDNP(pathIn + "grafo.in");
//			g.aplicarColoreoSecuencialAleatorio();
//			System.out.println("Cantidad de colores asignados: " + g.getCantidadColoresAsignados());
//			g.mostrarGrafoColoreado(pathOut + "pruebaProbador.out");
			
			
			Probador p = new Probador(pathIn + "grafo.in", pathOut + "pruebaProbador.out");
			p.verificarSalida();
			
			


			// A veces funciona bien y a veces no, debe haber alguna boludez por la que falla.
			 gen.generarGrafoRegularNPartitos(6, 5,"TP4/tp4/salida/partito.out");
			/*
			 * if (ms == null) {
			 * System.out.println("No se puede realizar un grafo N Partitos con nodos y aristas impares");
			 * } else
			 * ms.visualizar();
			 */

			/*
			 * ms = gen.generarGrafoRegularPorAdy(50, 50);
			 * ms.visualizarVector();
			 * ms.visualizar();
			 */

			/*ms = gen.generarGrafoAleatorioPorcentaje(1000, 80);
			gen.guardarMatrizSimetrica(ms, pathIn + "grafo2.in");*/
			// ms = gen.generarGrafoAleatorioProbabilidad(1000, 80);
			// gen.guardarMatrizSimetrica(ms, pathIn + "grafo3.in");
			// ms = gen.generarGrafoRegular(1000, 4);
			// gen.guardarMatrizSimetrica(ms, pathIn + "grafo4.in");
			// ms = gen.generarGrafoRegularPorAdy(1000, 60);
			// gen.guardarMatrizSimetrica(ms, pathIn + "grafo5.in");
			//
			// GrafoNDNP g = new GrafoNDNP(pathIn + "grafo2.in");
			// g.aplicarColoreoSecuencialAleatorio();
			// g.mostrarGrafoColoreado(pathOut + "grafoSecuencialAleatorio.out");
			//
			// GrafoNDNP g2 = new GrafoNDNP(pathIn + "grafo2.in");
			// g2.aplicarColoreoWelshPowell();
			// g2.mostrarGrafoColoreado(pathOut + "grafoWelshPowell.out");
			//
			// GrafoNDNP g3 = new GrafoNDNP(pathIn + "grafo2.in");
			// g3.aplicarColoreoMatula();
			// g3.mostrarGrafoColoreado(pathOut + "grafoMatula.out");

			/*GrafoNDNP g = new GrafoNDNP(pathIn + "grafo2.in");

			int[] coloresUtilizados = new int[g.getCantidadNodos()];

			int i = 0;
			int colores;
			int informe = 99;
			while (i < repeticiones) {
				System.out.println("Secuencial Aleatorio");
				long inicio = System.nanoTime();

				colores = g.aplicarColoreoSecuencialAleatorio();
				coloresUtilizados[colores - 1]++;
				i++;
				System.out.println();
			}*/

			/*for (int j = 0; j < coloresUtilizados.length; j++) {

				colores = g.aplicarColoreoWelshPowell();
				coloresUtilizados[colores - 1]++;
				i++;
				if (i > informe) {
					informe += 100;
					System.out.println("Pasadas: " + i + " Colores:" + colores + " Tiempo: "
							+ (System.nanoTime() - inicio) / 1000000 + "ms");
				}
			}
*/
			// for (int j = 0 ; j < 3 ; j++) {
			//
			// g.mezclarNodos();
			// g.mostrarNodos();
			//
			// }

//			for (int j = 0; j < coloresUtilizados.length; j++)
//				System.out.println(coloresUtilizados[j]);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
