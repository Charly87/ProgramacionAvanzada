package parcial1;

public class Mezcla {
	public static void Ordenar(int[] matrix, int init, int n) {
		int n1;
		int n2;
		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			Ordenar(matrix, init, n1);
			Ordenar(matrix, init + n1, n2);
			merge(matrix, init, n1, n2);
		}
	}

	private static void merge(int[] matrix, int init, int n1, int n2) {
		int[] buffer = new int[n1 + n2];
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int i;
		while ((temp1 < n1) && (temp2 < n2)) {
			if (matrix[init + temp1] < matrix[init + n1 + temp2])
				buffer[temp++] = matrix[init + (temp1++)];
			else
				buffer[temp++] = matrix[init + n1 + (temp2++)];
		}
		while (temp1 < n1)
			buffer[temp++] = matrix[init + (temp1++)];
		while (temp2 < n2)
			buffer[temp++] = matrix[init + n1 + (temp2++)];
		for (i = 0; i < n1 + n2; i++)
			matrix[init + i] = buffer[i];
	}
}
