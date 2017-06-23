package tp4.source;

public class Generador {

	public void generarRandomPorcentaje(int nodos, int porcentaje) {
		// Creo la matriz con can
		MatrizSimetrica ms;
		try {
			ms = new MatrizSimetrica(nodos);			
			
			// Cargo todas las aristas con un % random
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					ms.setValor(i, j, (int) Math.random() * 100);
				}
			}
			
			// Calculo la cantidad de aristas totales
			int aristasTotales = nodos * (nodos - 1) / 2;
			int aristasAdyacentes = porcentaje * aristasTotales / 100;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
