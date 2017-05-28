package source;

public class Berserker implements Estado {

	private int cantidadCalmado;

	@Override
	public Estado serAtacado(int valor, Monje monje) {
		if (monje.defensa > 0) {
			monje.defensa -= valor;
			monje.salud += monje.defensa;
			if (monje.defensa < 0)
				monje.defensa = 0;
		} else {
			monje.salud -= valor;
			if (monje.salud < 0)
				monje.salud = 0;
		}
		return this;
	}

	@Override
	public Estado calmar(Monje monje) {
		if (cantidadCalmado++ == 3) {
			monje.ataque = monje.ataque / 3;
			return new Normal();
		}
		return this;
	}

	@Override
	public void atacar(Monje atacante, Monje atacado) {
		atacado.serAtacado(atacante.ataque * 3);
	}

	@Override
	public Tipo getEstado() {
		return Tipo.BERSERKER;
	}

	@Override
	public int getDefensa(Monje monje) {
		return (int) (monje.defensa * 0.1);
	}

	@Override
	public int getAtaque(Monje monje) {
		return monje.ataque * 3;
	}
}
