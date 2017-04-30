package ar.com.unlam.armada;

public class Soldado {
	private TipoSoldado tipo;
	private TipoRegion region;
	private int rango;
	private int velocidad;

	public Soldado(TipoSoldado tipo, int rango, int velocidad) {
		this(tipo, TipoRegion.Region1, rango, velocidad);
	}

	public Soldado(TipoSoldado tipo, TipoRegion region, int rango, int velocidad) {
		this.tipo = tipo;
		this.region = region;
		this.rango = rango;
		this.velocidad = velocidad;
	}

	public TipoSoldado getTipo() {
		return tipo;
	}

	public void setTipo(TipoSoldado tipo) {
		this.tipo = tipo;
	}

	public TipoRegion getRegion() {
		return region;
	}

	public void setRegion(TipoRegion region) {
		this.region = region;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soldado other = (Soldado) obj;
		if (region != other.region)
			return false;
		return true;
	}
}
