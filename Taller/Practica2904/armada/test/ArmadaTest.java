package armada.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import armada.Armada;
import armada.Soldado;
import armada.TipoRegion;
import armada.TipoSoldado;

public class ArmadaTest {

	@Test
	public void OrdernarSoldadoPorRango() {
		Armada a = new Armada();
		a.agregar(new Soldado(TipoSoldado.Arquero, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Caballero, 20, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 30, 20));
		a.agregar(new Soldado(TipoSoldado.Jabalina, 40, 20));
		a.agregar(new Soldado(TipoSoldado.Hondero, 50, 20));

		List<Soldado> soldados = a.formacion1();

		Assert.assertEquals(50, soldados.get(0).getRango());
		Assert.assertEquals(40, soldados.get(1).getRango());
		Assert.assertEquals(30, soldados.get(2).getRango());
		Assert.assertEquals(20, soldados.get(3).getRango());
		Assert.assertEquals(10, soldados.get(4).getRango());
	}

	@Test
	public void OrdernarSoldadoPorVelocidad() {
		Armada a = new Armada();
		a.agregar(new Soldado(TipoSoldado.Arquero, 10, 5));
		a.agregar(new Soldado(TipoSoldado.Caballero, 10, 4));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 10, 3));
		a.agregar(new Soldado(TipoSoldado.Jabalina, 10, 2));
		a.agregar(new Soldado(TipoSoldado.Hondero, 10, 1));

		List<Soldado> soldados = a.formacion2();

		Assert.assertEquals(1, soldados.get(0).getVelocidad());
		Assert.assertEquals(2, soldados.get(1).getVelocidad());
		Assert.assertEquals(3, soldados.get(2).getVelocidad());
		Assert.assertEquals(4, soldados.get(3).getVelocidad());
		Assert.assertEquals(5, soldados.get(4).getVelocidad());
	}

	@Test
	public void OrdernarSoldadoPorTipo() {
		Armada a = new Armada();
		a.agregar(new Soldado(TipoSoldado.Arquero, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Caballero, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 20, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 30, 20));
		a.agregar(new Soldado(TipoSoldado.Jabalina, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Hondero, 10, 20));

		List<Soldado> soldados = a.formacion3();

		Assert.assertEquals(30, soldados.get(0).getRango());
		Assert.assertEquals(20, soldados.get(1).getRango());
		Assert.assertEquals(10, soldados.get(2).getRango());

		Assert.assertEquals(TipoSoldado.Hoplita, soldados.get(0).getTipo());
		Assert.assertEquals(TipoSoldado.Hoplita, soldados.get(1).getTipo());
		Assert.assertEquals(TipoSoldado.Hoplita, soldados.get(2).getTipo());
		Assert.assertEquals(TipoSoldado.Hondero, soldados.get(3).getTipo());
		Assert.assertEquals(TipoSoldado.Jabalina, soldados.get(4).getTipo());
		Assert.assertEquals(TipoSoldado.Caballero, soldados.get(5).getTipo());
		Assert.assertEquals(TipoSoldado.Arquero, soldados.get(6).getTipo());
	}
	
	@Test
	public void ObtenerGrupos() {
		Armada a = new Armada();
		a.agregar(new Soldado(TipoSoldado.Arquero, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Arquero, 20, 20));
		a.agregar(new Soldado(TipoSoldado.Arquero, 30, 20));
		
		a.agregar(new Soldado(TipoSoldado.Hoplita, 40, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 50, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, 60, 20));

		HashMap<TipoSoldado, List<Soldado>> map = a.Grupos();

		Assert.assertEquals(10, map.get(TipoSoldado.Arquero).get(0).getRango());
		Assert.assertEquals(20, map.get(TipoSoldado.Arquero).get(1).getRango());
		Assert.assertEquals(30, map.get(TipoSoldado.Arquero).get(2).getRango());
		
		Assert.assertEquals(40, map.get(TipoSoldado.Hoplita).get(0).getRango());
		Assert.assertEquals(50, map.get(TipoSoldado.Hoplita).get(1).getRango());
		Assert.assertEquals(60, map.get(TipoSoldado.Hoplita).get(2).getRango());
	}
	
	@Test
	public void ObtenerRepresentantes() {
		Armada a = new Armada();
		a.agregar(new Soldado(TipoSoldado.Arquero, TipoRegion.Region3, 30, 20));
		a.agregar(new Soldado(TipoSoldado.Arquero, TipoRegion.Region1, 10, 20));
		a.agregar(new Soldado(TipoSoldado.Arquero, TipoRegion.Region2, 20, 20));
		
		a.agregar(new Soldado(TipoSoldado.Hoplita, TipoRegion.Region3, 60, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, TipoRegion.Region1, 40, 20));
		a.agregar(new Soldado(TipoSoldado.Hoplita, TipoRegion.Region2, 50, 20));
		
		// Primer Solucion
		List<Soldado> soldados = a.Representantes();
		List<TipoRegion> regiones = new LinkedList<TipoRegion>();
		regiones.add(TipoRegion.Region1);
		regiones.add(TipoRegion.Region2);
		regiones.add(TipoRegion.Region3);
		
		Assert.assertEquals(3, soldados.size());
		for(Soldado s : soldados)
			if(s.getRegion() == regiones.get(0))
				regiones.remove(0);
			else if(s.getRegion() == regiones.get(1))
				regiones.remove(1);
			else if(s.getRegion() == regiones.get(2))
				regiones.remove(2);
		
		Assert.assertEquals(0, regiones.size());
		
		// Segunda Solucion
		soldados = a.Representantes2();
		regiones = new LinkedList<TipoRegion>();
		regiones.add(TipoRegion.Region1);
		regiones.add(TipoRegion.Region2);
		regiones.add(TipoRegion.Region3);
		
		Assert.assertEquals(3, soldados.size());
		for(Soldado s : soldados)
			if(s.getRegion() == regiones.get(0))
				regiones.remove(0);
			else if(s.getRegion() == regiones.get(1))
				regiones.remove(1);
			else if(s.getRegion() == regiones.get(2))
				regiones.remove(2);
		
		Assert.assertEquals(0, regiones.size());
	}
}
