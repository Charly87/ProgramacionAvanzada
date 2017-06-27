package tp4.source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DatosGraficos {

	String pathOut = "TP4/tp4/salida/Graficos/";

	public void generarDatosGrafico(List<Integer> coloresUsados, int[] repeticiones, String nombre) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(pathOut + nombre + ".txt"));

		for (int i = 0; i < repeticiones.length; i++) {
			if (coloresUsados.size() > i)
				out.print(coloresUsados.get(i) + "");
			out.println("   " + repeticiones[i]);
		}
		out.close();
	}

	public void estadisticas(int[] repeticiones,int cant, String nombre) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(pathOut + nombre + ".txt"));
		int primero =0;
		for(int i=0;i<repeticiones.length;i++){
			if(repeticiones[i]!=0){
				primero++;
				out.println("cantidad="+i+" "+"repeticiones="+repeticiones[i]);
				if(primero==1)
					out.println("MENOR= cantidad="+i+" "+"repeticiones="+repeticiones[i]+"en la corrida:"+cant);
			}
		}
		out.close();
	}
}
