package tp4.source;

public class Main {

	public static void main(String[] args) {
//		MatrizSimetrica ms;
		
		String pathIn  = "TP4/tp4/entrada/";
		String pathOut = "TP4/tp4/salida/";
		
		try {
			
//			ms = new MatrizSimetrica(4);
//			ms.setValor(1,2, 4);
//			ms.visualizar();
			
			GrafoNDNP g = new GrafoNDNP(pathIn + "grafo.in");
			g.aplicarColoreoSecuencialAleatorio();
			g.mostrarGrafoColoreado(pathOut + "grafoSecuencialAleatorio.out");
			
			GrafoNDNP g2 = new GrafoNDNP(pathIn + "grafo.in");
			g2.aplicarColoreoWelshPowell();
			g2.mostrarGrafoColoreado(pathOut + "grafoWelshPowell.out");
			
			GrafoNDNP g3 = new GrafoNDNP(pathIn + "grafo.in");
			g3.aplicarColoreoMatula();
			g3.mostrarGrafoColoreado(pathOut + "grafoMatula.out");
			
			
						
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
