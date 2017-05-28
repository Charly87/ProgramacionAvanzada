package parcial1;

public class BurbujeoSimple {

	public int[] Ordenar(int[] vector) {

		int aux;
		for (int i = 1; i < vector.length; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
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
