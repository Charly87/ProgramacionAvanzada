package tp4bis.src.tp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaProbador {

	private MatrizSimetrica matriz;
	private int cantidadAristas;
	private double porcentaje, adyacenciaOut;
	private int gradoMax, gradoMin, cantColoresOut;
	private int nodosOut, aristasOut, gradoMaxOut, gradoMinOut;
	private String salida;
	private int[] nodosColores, nodosSecuencia;

	public ProgramaProbador(String pathIn, String pathOut) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(pathIn));
		scanner.useLocale(Locale.ENGLISH);
		matriz = new MatrizSimetrica(scanner.nextInt());
		cantidadAristas = scanner.nextInt();
		porcentaje = scanner.nextDouble();
		gradoMax = scanner.nextInt();
		gradoMin = scanner.nextInt();

		while (scanner.hasNext())
			matriz.setValor(scanner.nextInt() - 1, scanner.nextInt() - 1, true);

		scanner.close();
		Scanner sc = new Scanner(new File(pathOut));
		nodosOut = sc.nextInt();
		cantColoresOut = sc.nextInt();
		aristasOut = sc.nextInt();
		adyacenciaOut = sc.nextDouble();
		gradoMaxOut = sc.nextInt();
		gradoMinOut = sc.nextInt();
		nodosColores = new int[nodosOut];
		nodosSecuencia = new int[nodosOut];
		for (int i = 0; i < nodosColores.length; i++) {
			nodosSecuencia[i] = sc.nextInt() - 1;
			nodosColores[i] = sc.nextInt();
		}
		sc.close();
	}

	public boolean programaProbador() {
		int color, nodo, indice = 0;

		if (matriz.getCantNodos() != nodosOut || cantidadAristas != aristasOut || gradoMax != gradoMaxOut
				|| gradoMin != gradoMinOut)
			return false;

		for (int i = 0; i < nodosColores.length; i++) {
			color = nodosColores[i];
			nodo = nodosSecuencia[i];
			for (int j = 0; j < nodosColores.length; j++) {
				if (nodo != j && matriz.getValor(nodo, j) == true) {
					indice = 0;
					while (nodosSecuencia[indice] != j)
						indice++;
					if (nodosColores[indice] == color)
						return false;
				}
			}
		}
		return true;
	}
}