package source;

public class Normal implements Estado {

	@Override
	public Estado serAtacado(int valor, Monje monje) {
		int salud = (int) (monje.salud * 0.75);

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
			monje.ataque *= 3;
			return new Berserker();
		}
		return this;
	}

	@Override
	public Estado calmar(Monje monje) {		
		return new Meditacion();
	}
	@Override
	public void atacar(Monje atacante, Monje atacado) {
		atacado.serAtacado(atacante.ataque);
	}
	@Override
	public Tipo getEstado()
	{
		return Tipo.NORMAL;
	}
	@Override
	public int getDefensa(Monje monje) {
		return monje.defensa;
	}
	@Override
	public int getAtaque(Monje monje) {
		return monje.ataque;
	}
}
