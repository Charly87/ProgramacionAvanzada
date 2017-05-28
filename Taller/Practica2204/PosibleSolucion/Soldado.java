package PosibleSolucion;

public class Soldado extends Personaje{
	private int energia;
	private final int energiaMaxima = 100;
	private final int pierdoEnergia = 10;
	
	public Soldado(int x, int y) {
		super(10, 1, 1, 200, x, y);
		
		this.energia = energiaMaxima;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= pierdoEnergia;
	}

	@Override
	protected void postAtaque() {
		energia -= pierdoEnergia;
	}
	
	public int getEnergia(){
		return energia;
	}

	@Override
	public void recibir(PocionAgua pocion) {
		energia = energiaMaxima;
	}
	
	

}
