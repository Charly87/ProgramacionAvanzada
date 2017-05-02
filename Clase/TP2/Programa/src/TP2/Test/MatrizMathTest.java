package TP2.Test;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

import TP2.DistDimException;
import TP2.InvalidInputException;
import TP2.MatrizMath;
import TP2.VectorMath;

public class MatrizMathTest {
	@Test
	public void suma() {
		MatrizMath m1 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 } });
		MatrizMath m2 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 } });
		MatrizMath m3 = m1.sumar(m2);
		MatrizMath m4 = new MatrizMath(new double[][] { { 2, 2 }, { 4, 4 } });
		Assert.assertEquals(m4, m3);
	}

	@Test
	public void resta() {
		MatrizMath m1 = new MatrizMath(new double[][] { { 3, 3 }, { 4, 4 } });
		MatrizMath m2 = new MatrizMath(new double[][] { { 1, 1 }, { 3, 3 } });
		MatrizMath m3 = m1.restar(m2);
		MatrizMath m4 = new MatrizMath(new double[][] { { 2, 2 }, { 1, 1 } });
		Assert.assertEquals(m4, m3);
	}

	@Test
	public void productoPorMatrizMxM() {
		MatrizMath m1 = new MatrizMath(new double[][] { { 3, 3 }, { 2, 2 } });
		MatrizMath m2 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 } });
		MatrizMath m3 = m1.productoPorMatriz(m2);
		MatrizMath m4 = new MatrizMath(new double[][] { { 9, 9 }, { 6, 6 } });
		Assert.assertEquals(m4, m3);
	}

	@Test
	public void productoPorMatrizMxN() {
		MatrizMath m1 = new MatrizMath(new double[][] { { 3, 3, 3 }, { 2, 2, 2 } });
		MatrizMath m2 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } });
		MatrizMath m3 = m1.productoPorMatriz(m2);
		MatrizMath m4 = new MatrizMath(new double[][] { { 18, 18 }, { 12, 12 } });
		Assert.assertEquals(m4, m3);
	}

	@Test
	public void productoPorEscalar() {
		MatrizMath m1 = new MatrizMath(new double[][] { { 3, 3, 3 }, { 2, 2, 2 } });
		MatrizMath m2 = m1.productoPorEscalar(2);
		MatrizMath m3 = new MatrizMath(new double[][] { { 6, 6, 6 }, { 4, 4, 4 } });
		Assert.assertEquals(m3, m2);
	}

	@Test
	public void determinante() throws DistDimException, CloneNotSupportedException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 2, 2 }, { 3, 4 } });
		double aux = m1.determinante();
		Assert.assertEquals(2, aux, 0.1);
	}

	@Test
	public void productoPorVector() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 3, 3 }, { 2, 2 }, { 1, 1 } });
		VectorMath v1 = new VectorMath(new double[] { 1, 2 });
		VectorMath v2 = m1.productoPorVector(v1);
		VectorMath v3 = new VectorMath(new double[] { 9, 6, 3 });
		Assert.assertEquals(v3, v2);
	}

	@Test
	public void inversa2x2() throws CloneNotSupportedException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 1, -2 }, { -3, 5 } });
		MatrizMath m2 = m1.inversa();
		MatrizMath m3 = new MatrizMath(new double[][] { { -5, -2 }, { -3, -1 } });
		Assert.assertEquals(m3, m2);
	}

	@Test
	public void inversa3x3() throws CloneNotSupportedException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 1, 0, 2 }, { 0, 1, 1 }, { 1, 0, 1 } });
		MatrizMath m2 = m1.inversa();
		MatrizMath m3 = new MatrizMath(new double[][] { { -1.0, 0.0, 2.0 }, { -1.0, 1.0, 1.0 }, { 1.0, 0.0, -1.0 } });
		Assert.assertEquals(m3, m2);
	}

	@Test
	public void normaUno() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 1, 1 }, { 2, 2 } });
		double aux = m1.normaUno();
		Assert.assertEquals(3.0, aux, 0.0001);
	}

	@Test
	public void normaDos() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 2, 2 }, { 2, 2 } });
		double aux = m1.normaDos();
		Assert.assertEquals(4.0, aux, 0.0001);
	}

	@Test
	public void normaInfinito() throws FileNotFoundException, InvalidInputException {
		MatrizMath m1 = new MatrizMath(new double[][] { { 2, 2 }, { 2, 2 } });
		double aux = m1.normaInfinito();
		Assert.assertEquals(4.0, aux, 0.0001);
	}
}
