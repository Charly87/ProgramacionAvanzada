package tp4.source;

public class Main {

	public static void main(String[] args) {
		MatrizSimetrica ms = null;
		Generador gen;
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
			if (ms == null) {
				System.out.println("No se puede realizar un grafo N Partitos con nodos y aristas impares");
			} else
				ms.visualizar();

			ms = gen.generarGrafoRegularPorAdy(50, 50);
			ms.visualizarVector();
			ms.visualizar();
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
