package tp4bis.test.test;

import org.junit.Test;

import tp4bis.src.tp4.GeneradorRegularGrado;


public class GeneradorRegularGradoTest {

	@Test
	public void test() {
		GeneradorRegularGrado g = new GeneradorRegularGrado(8,2);
		g.escribirArchivo("test/out/GeneradorRegularGrado.out");
	}

}
