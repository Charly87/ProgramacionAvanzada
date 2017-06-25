package tp4bis.src.tp4;

public class GeneradorRegularPorcentaje extends GeneradorRegularGrado {

	private double porcentaje;

	public GeneradorRegularPorcentaje(int nodos, double porcentaje) {
		super(nodos,(int) (porcentaje * (nodos - 1)));	
		this.porcentaje = porcentaje;
	}
}
