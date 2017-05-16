package tp3.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class BinomioDeNewton {

	private double a;
	private double b;
	private int n;

	public BinomioDeNewton(String path) throws FileNotFoundException {
		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.US);
		this.a = input.nextDouble();
		this.b = input.nextDouble();
		this.n = input.nextInt();
		input.close();
	}

	public String obtenerTermino(int k) {
		//if (this.n >= 0) {
			if (k >= 0 && k <= this.n) {
				int comb = this.combinatoria(this.n, k);				
				double factor = comb * Math.pow(this.a, k) * Math.pow(this.b, (this.n) - k);
				String aux = "x^" + k + "*" + factor;
				return aux;
			}
			return "El término " + k + " no es válido en un polinomio de grado " + this.n;
		//}
		//return "El binomio debe tener exponente positivo";
	}

	public String calcularBinomioCompleto() {
		//if (this.n >= 0) {
			String aux = "P[x]: ";
			int comb;
			int exp = Math.abs(this.n);
			double factor;
			for (int k = 0; k <= exp; k++) {
				comb = combinatoria(exp, k);
				factor = comb * Math.pow(this.a, this.n - k) * Math.pow(this.b, k);
				aux += "x^" + (this.n - k) + "*" + factor + (k < exp ? " + " : "");
			}
			return aux;
		//}
		//return "El binomio debe tener exponente positivo";
	}

	public double calcularXPolinomioCompleto(double x) {
		double total = 0;
		for (int k = this.n; k >= 0; k--)
			total += Math.pow(x, k) * combinatoria(this.n, k) * Math.pow(this.a, k) * Math.pow(this.b, (this.n) - k);
		return total;
	}

	public String calcularBinomioCompletoOptimizado() {
		//if (this.n >= 0) {
			int exp = Math.abs(this.n);
			int[][] tartaglia = new int[exp + 1][];
			tartaglia[0] = new int[] { 1 };
			int j;
			for (int i = 1; i <= exp; i++) {
				tartaglia[i] = new int[i + 1];
				tartaglia[i][0] = 1;
				for (j = 1; j < i; j++)
					tartaglia[i][j] = tartaglia[i - 1][j - 1] + tartaglia[i - 1][j];
				tartaglia[i][j] = 1;
			}

			String aux = "P[x]: ";
			int t;
			double factor;
			for (int k = 0; k <= exp; k++) {
				t = tartaglia[exp][k];
				factor = t * Math.pow(this.a, this.n - k) * Math.pow(this.b, k);
				aux += "x^" + (this.n - k) + "*" + factor + (k < exp ? " + " : "");
			}
			return aux;
		//}
		//return "El binomio debe tener exponente positivo";
	}

	private int combinatoria(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

	private int factorial(int valor) {
		if (valor == 0)
			return 1;
		return valor * factorial(valor - 1);
	}
}
