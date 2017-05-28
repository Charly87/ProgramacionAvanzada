package parcial1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Generador {

	public static void main(String[] args) {

//		Generador g = new Generador();
//		int[] vector = g.generate(10000);
//		for (int i = 0; i < vector.length; i++)
//			System.out.println(vector[i]);
//		g.write(vector, "Practica/parcial1/vector.txt");
	}

	public int[] generate(int size) {
		int[] vector = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++)
			vector[i] = r.nextInt(1000);
		return vector;

	}

	public int[] read(String file) {
		int[] vector = null;
		try {
			Scanner s = new Scanner(new File(file != null || file != "" ? file : "vector.txt"));
			s.useLocale(Locale.ENGLISH);

			vector = new int[s.nextInt()];

			for (int i = 0; i < vector.length; i++)
				vector[i] = s.nextInt();
			s.close();
		} catch (Exception e) {
		}
		return vector;
	}

	public void write(int[] vector, String file) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file != null || file != "" ? file : "vector.txt"));

			pw.println(vector.length);
			for (int i = 0; i < vector.length; i++)
				pw.println(vector[i]);
			pw.flush();
			pw.close();

		} catch (Exception e) {
		}
	}

}
