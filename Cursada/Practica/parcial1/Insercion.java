package parcial1;

public class Insercion {
	public int[] Ordenar(int[] vector) {
		int aux;
		int j;
		for (int i = 1; i < vector.length; i++) {
			j = i;
			aux = vector[i];

			while (j > 0 && aux < vector[j - 1]) {
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
		}
		return vector;
	}
}
