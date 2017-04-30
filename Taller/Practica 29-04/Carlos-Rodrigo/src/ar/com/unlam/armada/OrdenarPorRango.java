package ar.com.unlam.armada;

import java.util.Comparator;

public class OrdenarPorRango implements Comparator<Soldado> {

	@Override
	public int compare(Soldado s1, Soldado s2) {
		return s2.getRango() - s1.getRango() ;
	}
}
