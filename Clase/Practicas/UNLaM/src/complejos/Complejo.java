package complejos;

public class Complejo implements Comparable<Complejo> {

	private double r;
	private double i;

	public Complejo(double real, double imaginario) {
		this.r = real;
		this.i = imaginario;
	}

	public Complejo sumar(Complejo complejo) {
		return new Complejo(this.r + complejo.r, this.i + complejo.r);
	}

	public Complejo restar(Complejo complejo) {
		return new Complejo(this.r - complejo.r, this.i - complejo.r);
	}

	public Complejo multiplicar(Complejo complejo) {
		return new Complejo(r * complejo.r - i * complejo.i, r * complejo.i + i * complejo.r);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Complejo aux = (Complejo) obj;
		if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(aux.r))
			return false;
		if (Double.doubleToLongBits(this.i) != Double.doubleToLongBits(aux.i))
			return false;
		return true;
	}

	public double modulo() {
		return Math.sqrt(Math.pow(this.r, 2) + Math.pow(this.i, 2));
	}

	@Override
	public int compareTo(Complejo o) {
		return this.modulo() == o.modulo() ? 0 : this.modulo() < o.modulo() ? -1 : 1;
	}
}
