package dijktra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.SynchronousQueue;

public class RescatandoPrincesa {
	private int cantClaros;
	private int claroPrincesa;
	private int claroPrincipe;
	private SortedSet<Integer> claroDragones;
	private SortedSet<Integer> clarosEvaluados;
	private SortedSet<Integer> clarosNoEvaluados;
	private int[][] matrizAdyacencia;
	private int[] distancia;
	private int[] recorrido;

	public RescatandoPrincesa(String path) throws FileNotFoundException {
		Scanner s = new Scanner(new File(path));
		this.cantClaros = s.nextInt();
		int cantCaminos = s.nextInt();
		int cantDragones = s.nextInt();

		this.claroPrincesa = s.nextInt();
		this.claroPrincipe = s.nextInt();

		// Cargo los dragones
		this.claroDragones = new TreeSet<Integer>();
		int dragon;
		for (int i = 0; i < cantDragones; i++)
			this.claroDragones.add(s.nextInt());

		// Cargo matriz con valores iniciales
		this.inicializarMatriz();

		// Cargo los caminos
		this.clarosNoEvaluados = new TreeSet<Integer>();
		for (int i = 0; i < cantCaminos; i++)
			this.agregarCamino(s.nextInt(), s.nextInt(), s.nextInt());
		s.close();

		// Agrego claros sin caminos
		for (int i = 1; i <= this.cantClaros; i++)
			if (!this.clarosNoEvaluados.contains(i))
				this.clarosNoEvaluados.add(i);

	}

	private void agregarCamino(int claroOrigen, int claroDestino, int distancia) {
		if (this.clarosNoEvaluados.contains(claroOrigen))
			this.clarosNoEvaluados.add(claroOrigen);

		if (this.clarosNoEvaluados.contains(claroDestino))
			this.clarosNoEvaluados.add(claroDestino);

		this.matrizAdyacencia[claroOrigen - 1][claroDestino - 1] = distancia;
		this.matrizAdyacencia[claroDestino - 1][claroOrigen - 1] = distancia;
	}

	private void inicializarMatriz() {
		this.matrizAdyacencia = new int[this.cantClaros][this.cantClaros];
		for (int i = 0; i < this.cantClaros; i++)
			for (int j = 0; j < this.cantClaros; j++)
				this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;
	}

	public void mostrarMatriz() {
		System.out.print("    ");
		for (int i = 0; i < this.cantClaros; i++)
			System.out.printf("%3s", "[" + (i + 1) + "]");
		System.out.println();
		for (int i = 0; i < this.cantClaros; i++) {
			System.out.print("[" + (i + 1) + "]");
			for (int j = 0; j < this.cantClaros; j++)
				if (this.matrizAdyacencia[i][j] == Integer.MAX_VALUE)
					System.out.printf("%3s", "-");
				else
					System.out.printf("%3s", this.matrizAdyacencia[i][j]);
			System.out.println();
		}
	}

	public void dijktra(int idNodo) {

		this.clarosEvaluados.add(idNodo);
		this.clarosNoEvaluados.remove(idNodo);

		this.distancia = this.matrizAdyacencia[idNodo - 1];

		this.recorrido = new int[this.cantClaros];
		for (int i = 0; i < this.recorrido.length; i++)
			recorrido[i] = idNodo;

		while (this.clarosNoEvaluados.size() > 0) {

			int min = Integer.MAX_VALUE;
			int claroMin = 0;
			// Obtengo el claro adyacente con menor distancia
			for (int claro : this.clarosNoEvaluados) {
				if (this.distancia[claro - 1] < min) {
					min = this.distancia[claro - 1];
					claroMin = claro;
				}
			}

			// Verifico todos los claros adyacentes al claro mínimo
			for (int j = 0; j < this.cantClaros; j++) {
				if (this.matrizAdyacencia[claroMin - 1][j] != Integer.MAX_VALUE
						&& !this.clarosEvaluados.contains(j + 1)) {
					int directo = this.distancia[j];
					int indirecto = this.distancia[claroMin - 1] + this.matrizAdyacencia[claroMin - 1][j];

					if (indirecto > 0 && indirecto < directo) {
						this.distancia[j] = indirecto;
						this.recorrido[j] = claroMin;
					}
				}
			}

			// Marco al claro como evaluado
			this.clarosNoEvaluados.remove(claroMin);
			this.clarosEvaluados.add(claroMin);
		}
	}

	public String resolver() {
		// El nodo inicial es el de la princesa hacia el príncipe.
		this.dijktra(this.claroPrincesa);

		if (this.distancia[this.claroPrincipe - 1] == Integer.MAX_VALUE)
			return "NO HAY CAMINO";
		else if (this.fueInterceptado(this.claroPrincipe))
			return "INTERCEPTADO";
		return this.recuperarCamino(this.claroPrincesa, this.claroPrincipe);
	}

	public boolean fueInterceptado(int idClaro) {
		boolean interceptado = false;
		for (int claro : this.claroDragones)
			if (this.distancia[claro - 1] < this.distancia[idClaro])
				interceptado = interceptado || true;
		return interceptado;
	}

	public String recuperarCamino(int idNodoInicial, int idNodoFinal) {
		// TERMINAR

		// int nodoAnterior = idNodoFinal;
		// while(nodoAnterior != idNodoInicial)
		// {
		// int nodoAnterior = this.recorrido[idNodoFinal-1];
		// if( nodoAnterior != idNodoInicial)
		// idNodoFinal = nodoAnterior;
		// }
		return "";
	}
}
