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

	public double getValorX() {
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
		for (int i = 0; i <= this.grado; i++) {
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * recursivaPar(x, this.grado - i);
		}
		return res;
	}

	public double evaluarProgDinamica(double x) {
		double res = 0;
		double[] potencias = new double[this.grado];
		potencias[0] = x;
		for (int i = 1; i < this.grado; i++)
			potencias[i] = x * potencias[i - 1];
		int i;
		for (i = 0; i < this.grado; i++)
			if (this.coheficientes[i] != 0)
				res += this.coheficientes[i] * potencias[this.grado - i - 1];
		res += this.coheficientes[i];
		return res;
	}

	public double evaluarMejorada(double x) {
		double res = 0;
		double[] potencias = new double[this.grado];
		potencias[0] = x;
		res += this.coheficientes[this.grado - 1] * x;
		int i;
		for (i = 1; i < this.grado; i++) {
			potencias[i] = x * potencias[i - 1];
			if (this.coheficientes[this.grado - i -1] != 0)
				res += this.coheficientes[this.grado - i -1] * potencias[i];
		}
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

	public double evaluarHorner(double x) {
		return horner(x, this.coheficientes, this.grado);
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

	private double recursivaPar(double x, int pot) {
		if (pot == 0)
			return 1;
		if (pot == 1)
			return x;
		if (pot % 2 == 0)
			return recursivaPar(x * x, pot / 2);
		else
			return recursiva(x, pot);
	}

	private double horner(double x, double[] coeficientes, int grado) {
		if (grado == 0)
			return coeficientes[0];
		return horner(x, coeficientes, grado - 1) * x + coeficientes[grado];
	}
}
