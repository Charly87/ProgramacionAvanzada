package luchadoresJaponeses.src;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Torneo {
	Luchador[] luchadores;
	int[] resultado;


	public Torneo() {
		try {
			Scanner sc = new Scanner(new File("src\\LuchadoresJaponeses\\Input.txt"));
			sc.useLocale(Locale.ENGLISH);
			luchadores = new Luchador[sc.nextInt()];
			for (int i = 0; i < luchadores.length; i++)
				luchadores[i] = new Luchador(sc.nextInt(), sc.nextInt());
			sc.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	public boolean procesar2() {
		if (luchadores != null && luchadores.length > 0) {
			resultado = new int[luchadores.length];
			for (int i = 0; i < luchadores.length; i++) {
				for (int j = 0; j < luchadores.length; j++) {
					if (i < j) {
						if (luchadores[i].domina(luchadores[j]))
							resultado[i]++;
						if (luchadores[j].domina(luchadores[i]))
							resultado[j]++;
					}
				}
			}
			return true;
		}
		return false;
	}



	public boolean guardarResultado2() {
		if (resultado != null && resultado.length > 0) {
			try {
				PrintWriter pw = new PrintWriter(new FileWriter("src\\LuchadoresJaponeses\\Output.txt"));
				for (int i = 0; i < resultado.length; i++) {
					pw.println(resultado[i]);
					System.out.println(resultado[i]);
				}
				pw.close();
				return true;
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
		}
		return false;
	}
}
