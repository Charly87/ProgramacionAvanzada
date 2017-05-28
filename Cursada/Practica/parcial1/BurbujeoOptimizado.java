package parcial1;

public class BurbujeoOptimizado {

	public int[] Ordenar(int[] vector) {
		int aux;
		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = i + 1; j < vector.length; j++) {
				if (vector[j] < vector[i]) {
					aux = vector[j];
					vector[j] = vector[i];
					vector[i] = aux;
				}
			}
		}
		return vector;
	}

	public int[] Ordenar2(int[] vector) {

		int aux;
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vector[i] < vector[j]) {
					aux = vector[j];
					vector[j] = vector[i];
					vector[i] = aux;
				}
			}
		}
		return vector;
	}
}
