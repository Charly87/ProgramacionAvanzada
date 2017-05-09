package juegoConLetras.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Juego {

	private String[] tablero;
	private String[] palabras;
	private String[] resultado;

	public Juego() throws FileNotFoundException {
	}

	public void Abrir(String file) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));
		s.useLocale(Locale.ENGLISH);

		int m = s.nextInt();
		int v = s.nextInt();

		tablero = new String[m];
		for (int i = 0; i < m; i++)
			tablero[i] = s.next();

		palabras = new String[v];
		for (int i = 0; i < v; i++)
			palabras[i] = s.next();
		s.close();
	}

	public void Buscar() {
		// Haace falta validar?

		resultado = new String[this.palabras.length];
		for (int i = 0; i < this.palabras.length; i++) {
			int f = 0;
			int c = 0;
			int p = 0;
			Boolean encontre = false;
			do {
				do {

					if (this.tablero[f].charAt(c) == this.palabras[i].charAt(p)) {

						// ESTE
						if (this.tablero[f].indexOf(this.palabras[i].substring(p), c + 1) > 0) {
							this.resultado[i] = i + "E";
						}

						// NORTE
						if (f - this.palabras[i].length() - 1 > 0) {
							int pc = 0;
							do {
								if (this.tablero[f - pc].charAt(c) == this.palabras[i].charAt(p + pc))
									encontre = true;
								pc++;
							}

							while (!encontre || !(pc < this.palabras[i].length() - 1));

							if (encontre)
								this.resultado[i] = i + "N";
						}

						// SUR
						if (f + this.palabras[i].length() - 1 < this.tablero.length) {
							int pc = 0;
							do {
								if (this.tablero[f + pc].charAt(c) == this.palabras[i].charAt(p + pc))
									encontre = true;
								pc++;
							}

							while (!encontre || !(pc < this.palabras[i].length() - 1));

							if (encontre)
								this.resultado[i] = i + "S";
						}

						// OESTE
						if (c - this.palabras[i].length() - 1 > 0) {
							int pc = 0;
							do {
								if (this.tablero[f].charAt(c - pc) == this.palabras[i].charAt(p + pc))
									encontre = true;
								pc++;
							}

							while (!encontre || !(pc < this.palabras[i].length() - 1));

							if (encontre)
								this.resultado[i] = i + "O";
						}
					}
					c++;
				} while (!encontre);

				f++;
			} while (!encontre);
		}

	}

	public String[] getTablero() {
		return tablero;
	}

	public void setTablero(String[] tablero) {
		this.tablero = tablero;
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public String[] getResultado() {
		return resultado;
	}

	public void Guardar() {
	}

	public void Mostrar() {
		for (int i = 0; i < tablero.length; i++)
			System.out.println(tablero[i]);

		for (int i = 0; i < palabras.length; i++)
			System.out.println(palabras[i]);

	}
}
