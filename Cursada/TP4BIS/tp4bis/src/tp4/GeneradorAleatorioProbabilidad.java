package tp4bis.src.tp4;

public class GeneradorAleatorioProbabilidad extends Generador {

	private double probabilidad;

	public GeneradorAleatorioProbabilidad(int nodos, double p) {
		super(nodos);
		probabilidad = p;
		generarMatriz();
	}

	private void generarMatriz() {
		int cont = 0;
		for (int i = 0; i < getCantNodos() + 2; i++) {
			for (int j = i + 1; j < getCantNodos() ; j++) {
				if (probabilidad > Math.random()) {
					getMatrizDeAdyacencia().setValor(i, j, true);
					cont++;
				}
			}
		}
		setCantAristas(cont);
	}
}