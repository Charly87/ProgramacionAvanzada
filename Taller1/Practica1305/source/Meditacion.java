package source;

public class Meditacion implements Estado {

	@Override
	public Estado serAtacado(int valor, Monje monje) {
		int salud = (int) (monje.salud * 0.95);

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

		if (monje.salud <= salud) {
			monje.defensa *= 1.05;
			return new Normal();
		}
		return this;
	}

	@Override
	public Estado calmar(Monje monje) {
		return this;
	}

	@Override
	public void atacar(Monje atacante, Monje atacado) {
		atacado.serAtacado(atacante.ataque);
	}

	@Override
	public Tipo getEstado() {
		return Tipo.MEDITACION;
	}

	@Override
	public int getDefensa(Monje monje) {
		return monje.defensa * 5;
	}

	@Override
	public int getAtaque(Monje monje) {
		return (int) (monje.ataque * 0.1);
	}
}
