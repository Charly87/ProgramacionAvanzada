package ar.edu.unlam.rpg.test;

import org.junit.Test;
import ar.edu.unlam.rpg.*;
import static org.junit.Assert.*;

public class PersonajeTest {
	
	@Test
	public void ArqueroAtacaArqueroTest()
	{
		Arquero a1 = new Arquero(1,2);
		Arquero a2 = new Arquero(4,2);
		
		a1.atacar(a2);
		assertEquals(a2.getSalud(), 45);		
		a2.atacar(a1);
		assertEquals(a2.getSalud(), 45);
	}
}
