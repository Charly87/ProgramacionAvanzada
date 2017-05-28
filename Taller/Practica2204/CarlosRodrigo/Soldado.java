package CarlosRodrigo;

public class Soldado extends Personaje {

	private int energia;

	public Soldado(int x, int y) {
		super(200, 10, 1, 0, x, y);
		this.energia = 100;
	}

	@Override
	protected boolean puedeAtacar(Personaje atacado) {
		double distancia = this.distancia(this, atacado);
		return this.min_distancia <= distancia && distancia <= this.max_distancia && this.energia >= 10;
	}

	@Override
	public boolean atacar(Personaje atacado) {
		if (this.puedeAtacar(atacado)) {
			this.energia -= 10;
			atacado.salud -= this.daño;
			return true;
		}

		return false;
	}

	@Override
	public void recargar(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}
}
