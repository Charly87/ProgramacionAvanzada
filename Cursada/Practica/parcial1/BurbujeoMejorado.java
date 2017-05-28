package parcial1;

public class BurbujeoMejorado {

	public int[] Ordenar(int[] vector) {

		int aux;
		for (int i = 1; i < vector.length; i++) {
			for (int j = 0; j < vector.length - i; j++) {
				if (vector[j] > vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
		return vector;
	}
}
