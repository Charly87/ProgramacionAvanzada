package TP2;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	private static String path = "src/TP2/Test/Lotes/";

	public static void main(String[] args) throws IOException {

		try {
			SistemaEcuacionesLineales sel = new SistemaEcuacionesLineales(path + "04_caso2x2cCasiLDsimple.in");

			Calendar tIni = new GregorianCalendar();

			sel.resolver();

			Calendar tFin = new GregorianCalendar();

			sel.mostrarResultado(path + "04_caso2x2cCasiLDsimple.out");

			long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();			
			System.out.println(diff);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
