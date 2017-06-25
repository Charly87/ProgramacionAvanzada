package tp4bis.src.tp4;

import java.util.ArrayList;
import java.util.Collections;

public class GeneradorAleatorioPorcentaje extends Generador {

	private ArrayList<Arista> aristas;
	private double porcentaje;

	public GeneradorAleatorioPorcentaje(int nodos, double p) {
		super(nodos);
		aristas = new ArrayList<Arista>();
		porcentaje = p;
		generarMatriz();
	}

	private void generarMatriz() {
		int cont = 0;
		for (int i = 0; i < getCantNodos() + 2; i++) {
			for (int j = i + 1; j < getCantNodos(); j++) {
				aristas.add(new Arista(i, j, Math.random()));
			}
		}
		Collections.sort(aristas);
		for (Arista arista : aristas) {
			if (arista.getProbabilidad() < this.porcentaje) {
				getMatrizDeAdyacencia().setValor(arista.getDesde(), arista.getHasta(), true);
				cont++;
			}
		}
		setCantAristas(cont);
	}
}