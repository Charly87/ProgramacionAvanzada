package tp4bis.test.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;
import tp4bis.src.tp4.ProgramaProbador;


public class ProgramaProbadorTest {

	@Test
	public void test() throws FileNotFoundException {
		ProgramaProbador p = new ProgramaProbador("test/out/GrafoNDNP.in", "test/out/GrafoNDNP.out");
		Assert.assertTrue(p.programaProbador());
	}

}
