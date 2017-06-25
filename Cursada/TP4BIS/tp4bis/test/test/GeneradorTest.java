package tp4bis.test.test;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import tp4bis.src.tp4.Generador;


public class GeneradorTest {
	
	@Test
	public void queAndaElGenerador(){
		
		Generador grafo = new Generador(5);
		
		grafo.getMatrizDeAdyacencia().setValor(0, 1, true);
		grafo.getMatrizDeAdyacencia().setValor(0, 2, true);
		grafo.getMatrizDeAdyacencia().setValor(1, 3, true);
		grafo.getMatrizDeAdyacencia().setValor(2, 3, true);
		grafo.getMatrizDeAdyacencia().setValor(3, 4, true);
		grafo.setCantAristas(5);
		grafo.escribirArchivo("test/out/Grafo.out");
		
		grafo.calcularPorcentajeAdyacencia();
		Assert.assertEquals(0.5, grafo.getPorcAdyacencia(),0);
	}

}
