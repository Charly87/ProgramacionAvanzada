package tp4bis.src.tp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class GrafoNDNP {

	private MatrizSimetrica matriz;
	private int[] nodosColoreados;
	private int cantidadAristas;
	private double porcentaje;
	private int gradoMax, gradoMin, cantColores;
	private ArrayList<Integer> nodosSecuencia;

	public GrafoNDNP(String archivo) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(archivo));
		scanner.useLocale(Locale.ENGLISH);
		matriz = new MatrizSimetrica(scanner.nextInt());
		cantidadAristas = scanner.nextInt();
		porcentaje = scanner.nextDouble();
		gradoMax = scanner.nextInt();
		gradoMin = scanner.nextInt();

		nodosColoreados = new int[matriz.getCantNodos()];
		nodosSecuencia = new ArrayList<Integer>();
		while (scanner.hasNext())
			matriz.setValor(scanner.nextInt() - 1, scanner.nextInt() - 1, true);

		scanner.close();
	}

	public void generarVectorSecuenciaAleatorio() {
		for (int i = 0; i < nodosColoreados.length; i++)
			nodosColoreados[i] = 0;
		nodosSecuencia.clear();
		for (int i = 0; i < nodosColoreados.length; i++)
			nodosSecuencia.add(i);
		final long seed = System.nanoTime();
		Collections.shuffle(nodosSecuencia, new Random(seed));
	}

	public int colorAPoner(ArrayList<Integer> color, SortedSet<Integer> auxiliar) {
		int indice = 0;
		if (color.size() == auxiliar.size())
			return color.size() + 1;

		for (Integer integer : auxiliar) {
			if (color.get(indice) != integer)
				return color.get(indice);
			indice++;
		}
		return color.get(indice);
	}

	public void algoritmoDeColoreo() {
		ArrayList<Integer> color = new ArrayList<Integer>();
		SortedSet<Integer> auxiliar = new TreeSet<Integer>();
		color.add(1);
		nodosColoreados[nodosSecuencia.get(0)] = color.get(0);
		for (int i = 1; i < nodosSecuencia.size(); i++) {
			for (int j = 0; j < matriz.getCantNodos(); j++) {
				if (j != nodosSecuencia.get(i) && matriz.getValor(j, nodosSecuencia.get(i)) == true) {
					if (nodosColoreados[j] != 0)
						auxiliar.add(nodosColoreados[j]);
				}
			}
			if (auxiliar.isEmpty())
				nodosColoreados[nodosSecuencia.get(i)] = color.get(0);
			else {
				nodosColoreados[nodosSecuencia.get(i)] = colorAPoner(color, auxiliar);
				if (nodosColoreados[nodosSecuencia.get(i)] == color.size() + 1)
					color.add(color.size() + 1);
				auxiliar.clear();
			}
		}
		cantColores = color.size();
	}

	public void SecuenciaAleatorio() {
		generarVectorSecuenciaAleatorio();
		algoritmoDeColoreo();
	}

	public void generarVectorWelshPowellAleatorio() {
		int cont, gradoMayor = gradoMax;
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();
		int[] grado = new int[matriz.getCantNodos()];
		for (int i = 0; i < nodosColoreados.length; i++)
			nodosColoreados[i] = 0;
		nodosSecuencia.clear();

		for (int i = 0; i < nodosColoreados.length; i++) {
			cont = 0;
			for (int j = 0; j < nodosColoreados.length; j++) {
				if (i != j && matriz.getValor(i, j) == true)
					cont++;
			}
			grado[i] = cont;
		}

		while (gradoMayor != 0) {
			for (int i = 0; i < grado.length; i++) {
				if (grado[i] == gradoMayor)
					auxiliar.add(i);
			}
			final long seed = System.nanoTime();
			Collections.shuffle(auxiliar, new Random(seed));
			nodosSecuencia.addAll(auxiliar);
			auxiliar.clear();
			gradoMayor--;
		}
	}

	public void welshPowell() {
		generarVectorWelshPowellAleatorio();
		algoritmoDeColoreo();
	}

	public void generarVectorMatulaAleatorio() {
		int cont, gradoMenor = gradoMin;
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();
		int[] grado = new int[matriz.getCantNodos()];
		for (int i = 0; i < nodosColoreados.length; i++)
			nodosColoreados[i] = 0;
		nodosSecuencia.clear();

		for (int i = 0; i < nodosColoreados.length; i++) {
			cont = 0;
			for (int j = 0; j < nodosColoreados.length; j++) {
				if (i != j && matriz.getValor(i, j) == true)
					cont++;
			}
			grado[i] = cont;
		}

		while (gradoMenor != gradoMax) {
			for (int i = 0; i < grado.length; i++) {
				if (grado[i] == gradoMenor)
					auxiliar.add(i);
			}
			final long seed = System.nanoTime();
			Collections.shuffle(auxiliar, new Random(seed));
			nodosSecuencia.addAll(auxiliar);
			auxiliar.clear();
			gradoMenor++;
		}
	}

	public void matula() {
		generarVectorMatulaAleatorio();
		algoritmoDeColoreo();
	}

	private void setCantidadColores() {
		int max = 0;
		for (int i = 0; i < nodosColoreados.length; i++) {
			if (max < nodosColoreados[i])
				max = nodosColoreados[i];
		}
		this.cantColores = max;
	}

	public void escribirArchivo(String path) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		setCantidadColores();
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			pw.println(matriz.getCantNodos() + " " + this.cantColores + " " + this.cantidadAristas + " "
					+ df.format(this.porcentaje) + " " + this.gradoMax + " " + this.gradoMin);
			for (int i = 0; i < nodosColoreados.length; i++)
				pw.println((nodosSecuencia.get(i) + 1) + " " + nodosColoreados[nodosSecuencia.get(i)]);

			archivo.close();
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - " + e.getMessage());
		} finally {
			if (null != archivo) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getCantColores() {
		return this.cantColores;
	}
}
