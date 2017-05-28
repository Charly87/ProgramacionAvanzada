package CarlosRodrigo;

public class Caballero extends Personaje {

	private int cant_ataques;

	public Caballero(int x, int y) {
		super(200, 50, 2, 1, x, y);
		this.cant_ataques = 3;
	}

	@Override
	protected boolean puedeAtacar(Personaje atacado) {
		double distancia = this.distancia(this, atacado);
		return this.min_distancia <= distancia && distancia <= this.max_distancia && this.cant_ataques > 0;
	}

	@Override
	public boolean atacar(Personaje atacado) {
		if (this.puedeAtacar(atacado)) {
			this.cant_ataques -= 1;
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
