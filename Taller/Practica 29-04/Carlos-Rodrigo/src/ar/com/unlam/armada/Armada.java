package ar.com.unlam.armada;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Consigna:
 * https://markdownshare.com/view/6adc135b-dd79-4e61-b220-0ff418a06ca9
 */
public class Armada {
	private List<Soldado> soldados;

	public Armada() {
		this.soldados = new LinkedList<Soldado>();
	}

	public void agregar(Soldado s) {
		this.soldados.add(s);
	}

	public List<Soldado> formacion1() {
		List<Soldado> s = new LinkedList<Soldado>(this.soldados);
		Collections.sort(s, new OrdenarPorRango());
		return s;
	}

	public List<Soldado> formacion2() {
		List<Soldado> s = new LinkedList<Soldado>(this.soldados);
		Collections.sort(s, new OrdenarPorVelocidad());
		return s;
	}

	public List<Soldado> formacion3() {
		List<Soldado> s = new LinkedList<Soldado>(this.soldados);
		Collections.sort(s, new OrdenarPorTipo());
		return s;
	}

	public HashMap<TipoSoldado, List<Soldado>> Grupos() {
		// Sin Corrección
		HashMap<TipoSoldado, List<Soldado>> map = new HashMap<TipoSoldado, List<Soldado>>(this.soldados.size());
		for (Soldado s : this.soldados) {
			if (map.containsKey(s.getTipo()))
				map.get(s.getTipo()).add(s);
			else {
				List<Soldado> grupoSoldados = new LinkedList<Soldado>();
				grupoSoldados.add(s);
				map.put(s.getTipo(), grupoSoldados);
			}
		}
		return map;
	}

	public List<Soldado> Representantes() {
		// Sin Corrección
		HashMap<TipoRegion, Set<Soldado>> map = new HashMap<TipoRegion, Set<Soldado>>(this.soldados.size());
		for (Soldado s : this.soldados) {
			if (map.containsKey(s.getRegion()))
				map.get(s.getRegion()).add(s);
			else {
				Set<Soldado> reprSoldados = new HashSet<Soldado>();
				reprSoldados.add(s);
				map.put(s.getRegion(), reprSoldados);
			}
		}

		List<Soldado> regSoldados = new LinkedList<Soldado>();
		for (TipoRegion region : map.keySet())
			regSoldados.add(map.get(region).iterator().next());

		return regSoldados;
	}
	
	public List<Soldado> Representantes2() {
		// Sin Corrección
		Set<Soldado> repre  = new HashSet<Soldado>(this.soldados);
		return new LinkedList<Soldado>(repre);
	}
}
