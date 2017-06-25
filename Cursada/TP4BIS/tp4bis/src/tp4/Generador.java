package tp4bis.src.tp4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class Generador {

	private MatrizSimetrica matrizDeAdyacencia;
	private int cantNodos;
	private int cantAristas;
	private int gradoMaximo;
	private int gradoMinimo;
	private double porcAdyacencia;

	public Generador(int nodos) {
		this.cantNodos = nodos;
		matrizDeAdyacencia = new MatrizSimetrica(nodos);
	}

	public MatrizSimetrica getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(MatrizSimetrica matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int getGradoMaximo() {
		return gradoMaximo;
	}

	public void setGradoMaximo(int gradoMax) {
		this.gradoMaximo = gradoMax;
	}

	public int getGradoMinima() {
		return gradoMinimo;
	}

	public void setGradoMinima(int gradoMin) {
		this.gradoMinimo = gradoMin;
	}

	public double getPorcAdyacencia() {
		return porcAdyacencia;
	}

	public void setPorcAdyacencia(double porcAdyacencia) {
		this.porcAdyacencia = porcAdyacencia;
	}

	public void calcularPorcentajeAdyacencia() {
		this.porcAdyacencia = (double) this.cantAristas / ((this.cantNodos * (this.cantNodos - 1) )/ 2);
	}

	public void escribirArchivo(String path) {
		FileWriter archivo = null;
		PrintWriter pw = null;
	
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			calcularGrado();
			calcularPorcentajeAdyacencia();
			String adyac= String.format(Locale.ROOT, "%.2f", this.porcAdyacencia);
			pw.println(this.cantNodos + " " + this.cantAristas + " " + adyac + " "
					+ this.gradoMaximo + " " + this.gradoMinimo);
			for (int i = 0; i < this.cantNodos; i++) {
				for (int j = i + 1; j < this.cantNodos; j++) {
					if (matrizDeAdyacencia.getValor(i, j))
						pw.println((i + 1) + " " + (j + 1));
				}
			}
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

	public void setearAnillo(){
		for (int i = 0; i < this.cantNodos-1; i++) 
			this.matrizDeAdyacencia.setValor(i, i+1, true);
		this.matrizDeAdyacencia.setValor(this.cantNodos,0,true);
	}
	
	protected void calcularGrado() {

		int max = 0;
		int min = Integer.MAX_VALUE;
		int cont;
		for (int i = 0; i < this.cantNodos; i++) {
			cont = 0;
			for (int j = 0; j < this.cantNodos; j++) {
				if (i != j && this.matrizDeAdyacencia.getValor(i, j)) {
					cont++;
				}
			}
			if (cont > max)
				max = cont;
			if (cont < min)
				min = cont;
		}
		this.gradoMaximo = max;
		this.gradoMinimo = min;
	}
}
