package tp4.source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generador {

	public void generarRandomPorcentaje(int nodos, int porcentaje) {
		// Creo la matriz con can
		MatrizSimetrica ms;
		try {
			ms = new MatrizSimetrica(nodos);			
			
			// Cargo todas las aristas con un % random
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					ms.setValor(i, j, (int) Math.random() * 100);
				}
			}
			
			// Calculo la cantidad de aristas totales
			int aristasTotales = nodos * (nodos - 1) / 2;
			int aristasAdyacentes = porcentaje * aristasTotales / 100;
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void guardarMatrizSimetrica(MatrizSimetrica ms,String path) throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("path/grafo.in"));
		out.print(ms.getCantidadNodos()+"");
		out.print(ms.getCantidadAristas()+"");
		out.print(ms.getPorcentajeAdyacencia()+"");
		out.print(ms.getGradoMax()+"");
		out.println(ms.getGradoMin());
	}
}
