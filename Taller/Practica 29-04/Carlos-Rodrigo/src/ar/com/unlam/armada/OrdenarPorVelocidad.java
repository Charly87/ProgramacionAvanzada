package ar.com.unlam.armada;

import java.util.Comparator;

public class OrdenarPorVelocidad implements Comparator<Soldado> {

	@Override
	public int compare(Soldado s1, Soldado s2) {
		return s1.getVelocidad() - s2.getVelocidad();
	}

}
