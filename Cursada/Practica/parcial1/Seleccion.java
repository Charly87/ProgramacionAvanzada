package parcial1;

public class Seleccion {
	public int[] Ordenar(int[] vector) {
		int min;
		int aux;
		for (int i = 0; i < vector.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < vector.length; j++) {
				if (vector[min] > vector[j]) {
					min = j;
				}
			}
			if (min != i) {
				aux = vector[min];
				vector[min] = vector[i];
				vector[i] = aux;
			}
		}
		return vector;
	}
}
