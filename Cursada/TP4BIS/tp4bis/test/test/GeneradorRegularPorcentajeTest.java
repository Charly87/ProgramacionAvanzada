package tp4bis.test.test;

import org.junit.Test;

import tp4bis.src.tp4.GeneradorRegularPorcentaje;


public class GeneradorRegularPorcentajeTest {
	
	@Test
	public void test() {
		GeneradorRegularPorcentaje g = new GeneradorRegularPorcentaje(6,0.5);
		g.escribirArchivo("test/out/GeneradorRegularPorcentaje.out");
	}


}
