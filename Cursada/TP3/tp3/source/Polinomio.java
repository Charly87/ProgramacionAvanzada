package tp3.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio {

	private int grado;
	private double[] coheficientes;
	private double valorX;

	public Polinomio(String path) throws FileNotFoundException {
		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.US);
		this.grado = input.nextInt();
		this.valorX = input.nextDouble();
		this.coheficientes = new double[grado + 1];
		for (int i = 0; i <= this.grado; i++)
			coheficientes[i] = input.nextDouble();
		input.close();
	}
	
	public double getValorX()
	{
		return this.valorX;
	}
	
	@Override
	public String toString() {
		Double aux;
		Integer pot;
		String cad = "P[x]: ";
		for (int i = 0; i <= this.grado; i++) {
			aux = this.coheficientes[i];
			pot = this.grado - i;
			if (aux != 0) {
				if (i < this.grado)
					cad = cad + aux.toString() + "X^" + pot.toString() + " + ";
				else
					cad = cad + aux.toString() + " " + pot.toString();
			}

		}
		return cad;
	}

	public double evaluarMSucesivas(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * producto(this.grado - i, x);
		}
		return res;
	}
	
	public double evaluarRecursiva(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * recursiva(x, this.grado - i);
		}
		return res;
	}
	
	public double evaluarRecursivaPar(double x) {
		double res = 0;
		int i;
		for (i = 0; i < this.grado; i++) { // Quizas esté aca el problema
			if (this.coheficientes[i] != 0) {
				if ((this.grado - i) % 2 == 0)
					res += this.coheficientes[i] * recPar(x, this.grado - i + 1);
				else
					res += this.coheficientes[i] * recursiva(x, this.grado - i);
			}

		}
		res += this.coheficientes[i];
		return res;
	}
	
	public double evaluarProgDinamica(double x) {
		double res = 0;
		double[] aux = new double[this.grado];
		for (int i = 0; i < this.grado; i++)
			aux[i] = 1;
		aux[0] = x;
		for (int i = 1; i < this.grado; i++)
			aux[i] = x * aux[i - 1];
		int i;
		for (i = 0; i < this.grado; i++)
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * aux[this.grado - i - 1];
		res += this.coheficientes[i];
		return res;
	}
	
	public double evaluarPow(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * Math.pow(x, this.grado - i);
		}
		return res;
	}	

	private double producto(int pot, double x) {
		double acu = 1;
		for (int i = 0; i < pot; i++)
			acu *= x;
		return acu;
	}

	private double recursiva(double x, double pot) {
		if (pot == 0)
			return 1;
		return x * (recursiva(x, pot - 1));
	}	

	private double recPar(double x, int pot) {
		if (pot == 1 || pot == 0)
			return x;
		return recPar(x * x, pot / 2);
	}
}
