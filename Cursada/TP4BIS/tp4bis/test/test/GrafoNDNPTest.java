package tp4bis.test.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import tp4bis.src.tp4.GrafoNDNP;




public class GrafoNDNPTest {

	@Test
	public void queAndaElColoreoSecuenciaAleatorio() throws FileNotFoundException {
		GrafoNDNP grafo = new GrafoNDNP("test/out/GrafoNDNP.in");
		grafo.SecuenciaAleatorio();
		grafo.escribirArchivo("test/out/GrafoNDNPSecuenciaAleatoria.out");
	}
	
	@Test
	public void queAndaElColoreoWelshPowell() throws FileNotFoundException {
		GrafoNDNP grafo = new GrafoNDNP("test/out/GrafoNDNP.in");
		grafo.welshPowell();
		grafo.escribirArchivo("test/out/GrafoNDNPWelshPowell.out");
	}
	
	@Test
	public void queAndaElColoreoMatula() throws FileNotFoundException {
		GrafoNDNP grafo = new GrafoNDNP("test/out/GrafoNDNP.in");
		grafo.matula();
		grafo.escribirArchivo("test/out/GrafoNDNPMatula.out");
	}
}
