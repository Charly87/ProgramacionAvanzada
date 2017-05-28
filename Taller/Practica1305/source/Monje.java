package source;

//https://markdownshare.com/view/2d5cd55a-04a4-4636-a157-6808fdd9a5bb

public class Monje {

	protected Estado estado;
	protected int salud;
	protected int defensa;
	protected int ataque;

	public Monje() {
		this.estado = new Normal();
		this.salud = 100;
		this.defensa = 10;
		this.ataque = 10;
	}

	public int getSalud() {
		return this.salud;
	}

	public int getDefensa() {
		return this.estado.getDefensa(this);
	}

	public int getAtaque() {
		return this.estado.getAtaque(this);
	}

	public Tipo getEstado() {
		return this.estado.getEstado();
	}

	public void serAtacado(int valor) {
		this.estado = this.estado.serAtacado(valor, this);
	}
	
	public void calmar()
	{
		this.estado = this.estado.calmar(this);
	}
	
	public void atacar(Monje atacado)
	{
		this.estado.atacar(this, atacado);
	}

}
