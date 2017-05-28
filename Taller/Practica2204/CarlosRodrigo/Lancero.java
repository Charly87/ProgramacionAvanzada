package CarlosRodrigo;

public class Lancero extends Personaje {

	public Lancero(int x, int y) {
		super(150, 25, 3, 1, x, y);
	}

	@Override
	protected boolean puedeAtacar(Personaje atacado) {
		double distancia = this.distancia(this, atacado);
		return this.min_distancia <= distancia && distancia <= this.max_distancia;
	}

	@Override
	public boolean atacar(Personaje atacado) {
		if (this.puedeAtacar(atacado)) {
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
