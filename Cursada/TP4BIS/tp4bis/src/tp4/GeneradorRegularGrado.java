package tp4bis.src.tp4;

public class GeneradorRegularGrado extends Generador {

	private int grado;

	public GeneradorRegularGrado(int nodos, int grado) {
		super(nodos);
		this.grado = grado;
		generarMatriz();
	}

	public void calcularGrado() {
		setGradoMinima(this.grado);
		setGradoMaximo(this.grado);
	}

	public void calcularPorcentajeAdyacencia() {
		double porcAdy = 0;
		porcAdy = this.grado / (double) (this.getCantNodos() - 1);
		setPorcAdyacencia(porcAdy);
	}

	private void generarMatriz() {
		int recorrido, salto = 1, cont = 0;
		boolean flag = false;

		if (grado % 2 == 0) {
			recorrido = grado / 2;
			for (int i = 0; i < recorrido; i++) {
				for (int j = 0; j < getCantNodos(); j++) {
					if (j + salto < getCantNodos())
						getMatrizDeAdyacencia().setValor(j, j + salto, true);
					else
						getMatrizDeAdyacencia().setValor(j, j + salto - getCantNodos(), true);
					cont++;
				}
				salto++;
			}
		} else {
			recorrido = (grado / 2) + 1;
			salto = getCantNodos() / 2;
			for (int i = 0; i < recorrido; i++) {
				for (int j = 0; j < getCantNodos() - salto + i; j++) {
					if (j + salto < getCantNodos())
						getMatrizDeAdyacencia().setValor(j, j + salto, true);
					else
						getMatrizDeAdyacencia().setValor(j, j + salto - getCantNodos(), true);
					cont++;
				}

				if (flag == false) {
					salto = 1;
					flag = true;
				} else
					salto++;
			}
		}
		setCantAristas(cont);
	}
}
