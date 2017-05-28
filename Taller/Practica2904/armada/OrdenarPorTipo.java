package armada;

import java.util.Comparator;

public class OrdenarPorTipo implements Comparator<Soldado> {

	@Override
	public int compare(Soldado s1, Soldado s2) {
		if (s1.getTipo() == TipoSoldado.Hoplita && s2.getTipo() == TipoSoldado.Hoplita)
			return s2.getRango() - s1.getRango();
		return s2.getTipo().ordinal()- s1.getTipo().ordinal();
	}
}
