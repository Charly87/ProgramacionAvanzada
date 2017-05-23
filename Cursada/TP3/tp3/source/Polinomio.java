package tp3.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio {

	private int grado;
	private double[] coeficientes;
	private double valorX;

	public Polinomio(String path) throws FileNotFoundException {
		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.US);
		this.grado = input.nextInt();
		this.valorX = input.nextDouble();
		this.coeficientes = new double[grado + 1];
		for (int i = 0; i <= this.grado; i++)
			coeficientes[i] = input.nextDouble();
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
			aux = this.coeficientes[i];
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
			if (this.coeficientes[i] != 0)
				res += this.coeficientes[i] * producto(this.grado - i, x);
		}
		return res;
	}

	public double evaluarRecursiva(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coeficientes[i] != 0)
				res += this.coeficientes[i] * recursiva(x, this.grado - i);
		}
		return res;
	}

	public double evaluarRecursivaPar(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coeficientes[i] != 0)
				res += this.coeficientes[i] * recursivaPar(x, this.grado - i);
		}
		return res;
	}
	//Corregir word
	public double evaluarProgDinamica(double x) {
		double res = 0;
		double acumulado = 1;
		for (int i = this.grado - 1; i >= 0; i--) {
			acumulado *= x;
			if (this.coeficientes[i] != 0)
				res += this.coeficientes[i] * acumulado;
		}
		res += this.coeficientes[this.grado];
		return res;
	}
	//Corregir
	public double evaluarMejorada(double x) {
		double res = 0;
		int i;
		for (i = 0; i < this.grado +1; i++) {
			res = res * x + this.coeficientes[i];
		}	
		return res;
	}

	public double evaluarPow(double x) {
		double res = 0;
		for (int i = 0; i <= this.grado; i++) {
			if (this.coeficientes[i] != 0)
				res += this.coeficientes[i] * Math.pow(x, this.grado - i);
		}
		return res;
	}

	public double evaluarHorner(double x) {
		return horner(x, this.coeficientes, this.grado);
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
	//Corregir: no debe llamar a recursiva
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
