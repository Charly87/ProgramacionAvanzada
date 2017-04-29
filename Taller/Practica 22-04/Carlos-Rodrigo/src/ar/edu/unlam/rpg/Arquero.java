package ar.edu.unlam.rpg;

public class Arquero extends Personaje {

	private int cant_flechas;

	public Arquero(int x, int y) {
		super(50, 5, 5, 2, x, y);
		this.cant_flechas = 20;
	}

	@Override
	protected boolean puedeAtacar(Personaje atacado) {
		double distancia = this.distancia(this, atacado);
		return this.min_distancia <= distancia && distancia <= this.max_distancia && this.cant_flechas > 0;
	}

	@Override
	public boolean atacar(Personaje atacado) {
		if (this.puedeAtacar(atacado)) {
			this.cant_flechas -= 1;
			atacado.salud -= this.daño;
			return true;
		}
		return false;
	}
	@Override
	public void recargar(Elemento elemento) {
		if(elemento.getClass().getSimpleName() == "Flechas")
		{
			
		}
	}	
}
