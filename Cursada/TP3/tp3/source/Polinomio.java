package tp3.source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio {
	
	private int cantele;
	private double[] factores;
	private double x;
	
	public Polinomio(String path) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.US);
		this.cantele = input.nextInt();
		this.x = input.nextInt();
		factores = new double[cantele];
		for(int i = 0; i < this.cantele; i ++)
			factores[i] = input.nextDouble();
		input.close();
	}
	
	@Override
	public String toString()
	{
		Double aux;
		Integer pot;
		String cad="P[x]: ";
		for(int i = 0; i < this.cantele; i ++)
		{
			aux=factores[i];
			pot=(cantele-i)-1;
			if(aux!=0)
			{
				if(i<cantele-1)
					cad=cad+aux.toString()+"X^"+pot.toString()+" + ";
				else
					cad=cad+aux.toString()+" "+pot.toString();
			}
			
		}
		return cad;
	}
	
	public double evaluarPow()
	{
		double res=0;
		for(int i = 0; i < cantele; i++)
		{
			if(factores[i] != 0)
				res += factores[i] * Math.pow(x,cantele-i-1); 
		}
		return res;
	}
	
	public double evaluarMSucesivas()
	{
		double res=0;
		for(int i = 0; i < cantele; i++)
		{
			if(factores[i] != 0)
				res += factores[i] * producto(cantele-i-1,x); 
		}
		return res;
	}
	
	public double producto(int pot, double x)
	{
		double acu=1;
		for(int i = 0; i < pot; i++)
			acu*=x;
		return acu;
	}
	
	public double evaluarRecursiva()
	{
		double res=0;
		for(int i = 0; i < cantele; i++)
		{
			if(factores[i] != 0)
				res += factores[i] * recursiva(x,cantele-i-1); 
		}
		return res;
	}
	
	public double recursiva(double x, double pot)
	{
		if(pot==0)
			return 1;
		return x*(recursiva(x,pot-1));
	}
	
	public double evaluarRecursivaPar()
	{
		double res=0;
		int i;
		for(i = 0; i < cantele-1; i++)
		{
			if(factores[i] != 0)
			{
				if((cantele-i-1) % 2 == 0)
					res += factores[i] * recPar(x,cantele-i);
				else
					res += factores[i] * recursiva(x,cantele-i-1);
			}
				 
		}
		res += factores[i];
		return res;
	}
	
	public double recPar(double x, int pot)
	{
		if(pot == 1 || pot == 0)
			return x;
		return recPar(x*x , pot/2);
	}
	
	public double evaluarDinamica()
	{
		double res=0;
		double[] aux = new double[cantele-1];
		for(int i = 0; i < cantele-1; i++)
			aux[i]=1;
		aux[0]=x;
		for(int i = 1; i < cantele-1; i++)
			aux[i] = x * aux[i-1];
		int i;
		for(i = 0; i < cantele-1; i++)
			if(factores[i] != 0)
				res += factores[i] * aux[cantele-i-2];
		res += factores[i];
		return res;
	}
}
