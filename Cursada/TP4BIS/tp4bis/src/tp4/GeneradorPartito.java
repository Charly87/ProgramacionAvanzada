package tp4bis.src.tp4;

public class GeneradorPartito extends Generador {

	private int CantidadGrupos;

	public GeneradorPartito(int nodos, int cantidadGrupos) {
		super(nodos);
		CantidadGrupos = cantidadGrupos;
		generarMatriz();
	}

	public void generarMatriz() {
		for (int i = 0; i < getCantNodos() - 1; i++)
			getMatrizDeAdyacencia().setValor(i, i + 1, true);
		setCantAristas(getCantNodos());
	}

}
