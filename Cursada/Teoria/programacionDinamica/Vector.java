package programacionDinamica;

// Sacar la longitud dela secuencia mas larga
// Secuencia creciente y no importa si hay que saltar lugares

// 8 5 4 3 7 8 4 10 8 6 5 6 2 4 7 11

// Solucion
// 8 5 4 3 7 8 4 10 8 6 5 6 2 4 7 11
// 1 1 1 1 2 3 2  4 3 3 3 4 1 2 5  6

public class Vector {
	private int[] vec;
	private int[] aux;

	public Vector() {
		vec = new int[] { 8, 5, 4, 3, 7, 8, 4, 10, 8, 6, 5, 6, 2, 4, 7, 11 };
		aux = new int[vec.length];
		aux[0] = 1;
		for (int i = 1; i < vec.length; i++) {
			int min=0;
			for (int j = i - 1; j >= 0; j--) {
				if (vec[i] > vec[j])
					min = vec[j];
			}
			aux[i] = min +1;
		}
	}
	
	public void Mostrar()
	{
		for (int i = 0; i < aux.length; i++) {
			System.out.println(aux[i] + " ");
		}		
	}

}
