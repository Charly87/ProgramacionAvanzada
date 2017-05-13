package tp3.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class BinomioDeNewton {

	private double a;
	private double b;
	private int n;
	
	public BinomioDeNewton(String path) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.US);
		this.a = input.nextDouble();
		this.b = input.nextDouble();
		this.n = input.nextInt();
		input.close();
	}
	
	public String obtenerTermino(int k)
	{
		String aux;
		int comb;
		double factor;
		comb = combinatoria(this.n,k);
		factor = comb * Math.pow(this.a, k)* Math.pow(this.b, (this.n)-k);
		aux = "x^"+k+"*"+factor;
		return aux;
		
	}
	
	public int combinatoria(int n,int k)
	{
		return factorial(n)/(factorial(k)*factorial(n-k));
	}
	
	public int factorial(int valor)
	{
		if(valor == 0)
			return 1;
		return valor * factorial(valor-1);
	}
	
	// Optimizar este metodo usando tartaglia.
	// Metricas
	public String calcularBinomioCompleto()
	{
		String aux="P[x]: ";
		int comb;
		double factor;
		for(int k = this.n; k >= 0 ; k--)
		{
			comb = combinatoria(this.n,k);
			factor = comb * Math.pow(this.a, k)* Math.pow(this.b, (this.n)-k);
			if(k != 0)
				aux += "x^"+k+"*"+factor+"+";
			else
				aux += "x^"+k+"*"+factor;
		}
		return aux;
	}
	
	public double calcularXPolinomioCompleto(double x)
	{
		double total = 0;
		for(int k = this.n; k >= 0 ; k--)
			total += Math.pow(x, k)*combinatoria(this.n,k)*Math.pow(this.a, k)* Math.pow(this.b, (this.n)-k);
		return total;
	}	
}
