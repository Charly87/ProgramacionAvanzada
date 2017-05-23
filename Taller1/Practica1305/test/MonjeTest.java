package test;

import org.junit.Assert;
import org.junit.Test;

import source.Monje;
import source.Tipo;

public class MonjeTest {

	// Patron State
	// Vida = 100
	// Defensa = 10
	// Ataque = 10

	@Test
	public void NormalAMonje() {
		Monje m = new Monje();
		m.calmar();
		Assert.assertEquals(Tipo.MEDITACION, m.getEstado());
	}

	@Test
	public void NormalABerserker() {
		Monje m = new Monje();
		m.serAtacado(30);
		Assert.assertEquals(Tipo.BERSERKER, m.getEstado());
	}

	@Test
	public void BerserkerANormal() {
		Monje m = new Monje();
		m.serAtacado(30);
		
		m.calmar();
		Assert.assertEquals(Tipo.BERSERKER, m.getEstado());
		m.calmar();
		Assert.assertEquals(Tipo.BERSERKER, m.getEstado());
		m.calmar();
		Assert.assertEquals(Tipo.NORMAL, m.getEstado());
	}

	@Test
	public void MeditacionANormal() {
		Monje m = new Monje();
		m.calmar();
		m.serAtacado(60);
		Assert.assertEquals(Tipo.NORMAL, m.getEstado());
	}

	@Test
	public void AtanqueEnBerserker() {
		Monje m = new Monje();
		m.serAtacado(30);
		Assert.assertEquals(30, m.getAtaque());
	}

	@Test
	public void AtanqueEnNormal() {
		Monje m = new Monje();
		Assert.assertEquals(10, m.getAtaque());
	}

	@Test
	public void AtanqueEnMeditacion() {
		Monje m = new Monje();
		m.calmar();
		Assert.assertEquals(50, m.getDefensa());
	}

}
