package tp4.test;

import org.junit.Assert;
import org.junit.Test;

import tp4.source.MatrizSimetrica;

public class MatrizSimetricaTest {

	// Los indices arrancan en 0
	// Los valores a usar son con índice mayores a la diagonal
	// La matriz más chica debe ser de orden 4 -> Dimensiones 2 x 2
	
	@Test
	public void CrearMatrizDeDimension2x2() {
		try {
			MatrizSimetrica ms = new MatrizSimetrica(2);				
			ms.setValor(0, 1, 1);
			Assert.assertEquals(1, ms.getValor(0, 1));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void CrearMatrizDeDimension3x3() {
		try {
			MatrizSimetrica ms = new MatrizSimetrica(3);				
			ms.setValor(0, 1, 1);
			ms.setValor(0, 2, 2);
			ms.setValor(1, 2, 3);
			
			Assert.assertEquals(1, ms.getValor(0, 1));
			Assert.assertEquals(2, ms.getValor(0, 2));
			Assert.assertEquals(3, ms.getValor(1, 2));		
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
