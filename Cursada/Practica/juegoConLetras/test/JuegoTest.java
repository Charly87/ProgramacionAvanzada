package juegoConLetras.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import juegoConLetras.src.Juego;

public class JuegoTest {
	@Test
	public void LeerArchivo() throws FileNotFoundException
	{
		Juego j =  new Juego();
		j.Abrir("rapigrama.in");
		j.Mostrar();
	}
	
	@Test
	public void Este() throws FileNotFoundException
	{
		Juego j =  new Juego();
		j.setTablero(new String[] {});
		j.Mostrar();
	}

}
