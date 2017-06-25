package tp4bis.test.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import tp4bis.src.tp4.GeneradorAleatorioPorcentaje;

public class GeneradorAleatorioPorcentajeTest {

	@Test
	public void test() throws FileNotFoundException {
		GeneradorAleatorioPorcentaje g= new GeneradorAleatorioPorcentaje(12, 0.6);
		g.escribirArchivo("test/out/01.out");
	}
}
