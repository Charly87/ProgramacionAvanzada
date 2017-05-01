package TP2;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		
		try
		{
			SistemaEcuacionesLineales sel = new SistemaEcuacionesLineales("03_4x4_Normal.in");
			
			Calendar tIni = new GregorianCalendar();
			
			sel.resolver();
			
			Calendar tFin = new GregorianCalendar();
			
			sel.mostrarResultado("03_4x4_Normal.out");
			
			long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
			
			
			// Muestro tiempo de ejecucion en consola
			System.out.println(diff);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		

		
	}

}
