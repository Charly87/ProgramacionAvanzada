package TP2.Test;

import java.util.Scanner;

import org.junit.Test;
import org.junit.Assert;

import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

public class VectorMathTest {

	private String path = "src/TP2/Test/Lotes/";

	@Test
	public void suma() {
		VectorMath v1 = new VectorMath(new double[] { 1, 1 });
		VectorMath v2 = new VectorMath(new double[] { 1, 1 });

		VectorMath v3 = v1.sumar(v2);

		VectorMath v4 = new VectorMath(new double[] { 2, 2 });
		Assert.assertEquals(v3, v4);
	}

	@Test
	public void resta() {
		VectorMath v1 = new VectorMath(new double[] { 1, 1 });
		VectorMath v2 = new VectorMath(new double[] { 1, 1 });

		VectorMath v3 = v1.restar(v2);

		VectorMath v4 = new VectorMath(new double[] { 0, 0 });
		Assert.assertEquals(v3, v4);
	}

	@Test
	public void productoEscalar() {
		VectorMath v1 = new VectorMath(new double[] { 1, 1 });
		VectorMath v2 = new VectorMath(new double[] { 2, 3 });

		double aux = v1.producto(v2);

		Assert.assertEquals(5.0, aux, 0.1);
	}

	@Test
	public void productoPorEscalar() {
		VectorMath v1 = new VectorMath(new double[] { 1, 2 });

		VectorMath v2 = v1.producto(2);

		VectorMath v3 = new VectorMath(new double[] { 2, 4 });
		Assert.assertEquals(v2, v3);
	}

	@Test
	public void productoPorMatriz() {
		VectorMath v1 = new VectorMath(new double[] { 1, 2, 3 });
		MatrizMath m1 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } });

		VectorMath v2 = v1.producto(m1);

		VectorMath v3 = new VectorMath(new double[] { 14, 14 });
		Assert.assertEquals(v2, v3);
	}

	@Test
	public void normaUno() {
		VectorMath v1 = new VectorMath(new double[] { 1, 2 });
		double aux = v1.normaUno();
		Assert.assertEquals(3.0, aux, 0.1);
	}

	@Test
	public void normaDos() {
		VectorMath v1 = new VectorMath(new double[] { 1, 2 });
		double aux = v1.normaDos();
		Assert.assertEquals(2.0, aux, 0.5);
	}

	@Test
	public void normaInfinito() {
		VectorMath v1 = new VectorMath(new double[] { 1, 2 });
		double aux = v1.normaInfinito();
		Assert.assertEquals(2, aux, 0.1);
	}
}
