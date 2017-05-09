package luchadoresJaponeses.src;

public class Luchador {

	private int peso;
	private int altura;

	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public boolean domina(Luchador luchador) {
		return (this.altura >= luchador.altura && this.peso > luchador.peso)
				|| (this.altura > luchador.altura && this.peso >= luchador.peso);
	}
}