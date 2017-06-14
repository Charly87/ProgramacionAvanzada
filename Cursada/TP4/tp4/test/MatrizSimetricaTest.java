package tp4.test;

import org.junit.Assert;
import org.junit.Test;

import tp4.source.MatrizSimetrica;

public class MatrizSimetricaTest {

	@Test
	public void MatrizDeDimension1() {
		try {
			MatrizSimetrica ms = new MatrizSimetrica(1);
			// No se si los indices deben comenzar en 0 o en 1
			ms.setValor(1, 1, 1);
			
			// No se si los indices deben comenzar en 0 o en 1
			Assert.assertEquals(1, ms.getValor(1, 1));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
