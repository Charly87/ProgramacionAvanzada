package dfs;

public class Nodo implements Comparable<Nodo>{
	private int id;
	private boolean visitado;
	
	public Nodo(int id)
	{
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	@Override
	public int compareTo(Nodo nodo) {		
		return Integer.compare(this.id, nodo.getId());
	}
}
