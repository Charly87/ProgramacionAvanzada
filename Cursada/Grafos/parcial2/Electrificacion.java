package parcial2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Electrificacion {

	public int cantCiudades;
	public int cantCentrales;
	public HashSet<Integer> centrales;
	public int[][] matriz;

	public List<Integer> arbol;

	public SortedSet<Integer> ciudadesEvaluadas;
	public SortedSet<Integer> ciudadesNoEvaluadas;

	public Electrificacion(String file) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));

		this.cantCiudades = s.nextInt();
		this.cantCentrales = s.nextInt();

		// Cargo las centrales
		this.centrales = new HashSet<Integer>();
		for (int i = 0; i < this.cantCentrales; i++)
			this.centrales.add(s.nextInt());

		// Cargo las ciudades
		this.ciudadesNoEvaluadas = new TreeSet<Integer>();
		this.matriz = new int[this.cantCiudades][this.cantCiudades];
		for (int i = 0; i < this.cantCiudades; i++) {
			for (int j = 0; j < this.cantCiudades; j++)
				this.matriz[i][j] = s.nextInt();

			this.ciudadesNoEvaluadas.add(i + 1);
		}

		this.arbol = new ArrayList<Integer>();
		this.ciudadesEvaluadas = new TreeSet<Integer>();
	}

	public void resolver() {

		// Agrego las centrales como evaluadas
		for (int central : this.centrales) {
			this.ciudadesEvaluadas.add(central);
			this.ciudadesNoEvaluadas.remove(central);
		}

		int min = 0;
		int[] vector;
		int costoTotal = 0;

		while (this.ciudadesNoEvaluadas.size() > 0) {
			vector = new int[3];
			min = Integer.MAX_VALUE;
			for (Integer ciudadEvaluada : this.ciudadesEvaluadas) {
				for (Integer ciudadNoEvaluada : this.ciudadesNoEvaluadas) {
					if (this.matriz[ciudadEvaluada - 1][ciudadNoEvaluada - 1] <= min
							&& this.matriz[ciudadEvaluada - 1][ciudadNoEvaluada - 1] != 0) {
						vector[0] = ciudadEvaluada; // Origen
						vector[1] = ciudadNoEvaluada; // Destino
						vector[2] = this.matriz[ciudadEvaluada - 1][ciudadNoEvaluada - 1]; // Costo
						min = vector[2];
					}
				}
			}
			System.out.println(vector[1] + " " + vector[0]);

			costoTotal += vector[2];
			this.ciudadesEvaluadas.add(vector[1]);
			this.ciudadesNoEvaluadas.remove(vector[1]);
		}

		System.out.println("Costo Total:" + costoTotal);
	}

}