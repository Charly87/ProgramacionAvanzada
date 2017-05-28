package parcial1;

public class Main {

	public static void main(String[] args) {
		Generador g = new Generador();

		// ORDENANDO CORRECTAMENTE
		int[] vector = g.read("Practica/parcial1/vector.txt");
		int[] vectorCorrecto = ordenar(vector);
		System.out.println("Elementos: " + vectorCorrecto.length);

		// BURBUJEO
		vector = g.read("Practica/parcial1/vector.txt");
		BurbujeoSimple bs = new BurbujeoSimple();

		long ini = System.nanoTime();
		bs.Ordenar(vector);
		long end = System.nanoTime();
		System.out.println(
				"Burbujeo Simple: \t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		// BURBUJEO MEJORADO
		vector = g.read("Practica/parcial1/vector.txt");
		BurbujeoMejorado bm = new BurbujeoMejorado();

		ini = System.nanoTime();
		bm.Ordenar(vector);
		end = System.nanoTime();
		System.out.println(
				"Burbujeo Mejorado: \t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		// BURBUJEO OPTIMIZADO
		vector = g.read("Practica/parcial1/vector.txt");
		BurbujeoOptimizado bo = new BurbujeoOptimizado();

		ini = System.nanoTime();
		bo.Ordenar(vector);
		end = System.nanoTime();
		System.out.println(
				"Burbujeo Optimizado 1: \t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		ini = System.nanoTime();
		bo.Ordenar2(vector);
		end = System.nanoTime();
		System.out.println(
				"Burbujeo Optimizado 2: \t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		// INSERCION
		vector = g.read("Practica/parcial1/vector.txt");
		Insercion i = new Insercion();

		ini = System.nanoTime();
		i.Ordenar(vector);
		end = System.nanoTime();
		System.out
				.println("Inserción: \t\t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		// INSERCION
		vector = g.read("Practica/parcial1/vector.txt");
		Seleccion s = new Seleccion();

		ini = System.nanoTime();
		s.Ordenar(vector);
		end = System.nanoTime();
		System.out
				.println("Selección: \t\t" + (end - ini) / 1000000 + " ms \t -> " + verificar(vectorCorrecto, vector));

		// MEZCLA
		vector = g.read("Practica/parcial1/vector.txt");
		Mezcla m = new Mezcla();

		ini = System.nanoTime();
		m.Ordenar(vector, 0, vector.length);
		end = System.nanoTime();
		System.out.println("Mezcla: \t\t" + (end - ini) / 1000 + " us\t -> " + verificar(vectorCorrecto, vector));

		// QUICKSORT
		vector = g.read("Practica/parcial1/vector.txt");
		QuickSort q = new QuickSort();

		ini = System.nanoTime();
		q.Ordenar(vector, 0, vector.length -1);
		end = System.nanoTime();
		System.out.println("Quicksort: \t\t" + (end - ini)/1000 + " us\t -> " + verificar(vectorCorrecto, vector));

	}

	public static int[] ordenar(int[] vector) {
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

	public static boolean verificar(int[] vCorrecto, int[] vIncorrecto) {
		for (int i = 0; i < vCorrecto.length; i++)
			if (vCorrecto[i] != vIncorrecto[i])
				return false;
		return true;
	}
}
