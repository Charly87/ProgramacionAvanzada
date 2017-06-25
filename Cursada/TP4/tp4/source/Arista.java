package tp4.source;

public class Arista implements Comparable<Arista>{
	private int desde;
	private int hasta;
	private double probabilidad;

	public Arista(int a, int b,double p) {
		this.desde = a;
		this.hasta = b;
		this.probabilidad=p;
	}

	@Override
	public int compareTo(Arista a) {
		if(this.probabilidad==a.probabilidad){
			return 0;
		}else if(this.probabilidad>a.probabilidad){
			return 1;
		}
		return -1;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(double probabilidad) {
		this.probabilidad = probabilidad;
	}


}
