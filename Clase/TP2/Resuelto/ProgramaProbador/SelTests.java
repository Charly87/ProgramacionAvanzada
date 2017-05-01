package Tests;
import java.io.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import sel.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SelTests 
{
	public static boolean selTester(String inRoot,String outRoot) throws IOException
	{
		
		Vector x= new Vector (outRoot);
		Sel sel=new Sel (inRoot);
		Matriz A= sel.getMatriz();
		Vector B=sel.getVector();
		Vector Baux=A.multiplicar(x);
		
		if(Math.abs(Baux.norma2()-B.norma2())<=0.000001d)
			 return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		String miPath = "ProbadorFalla.out";
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		boolean var = selTester("Falla.in","Falla.out");
		salida.print(var);
		salida.close();
	}
}
