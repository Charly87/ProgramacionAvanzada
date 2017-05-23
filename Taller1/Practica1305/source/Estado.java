package source;

public interface Estado {
	Estado serAtacado(int valor, Monje monje);
	Estado calmar(Monje monje);
	void atacar(Monje atacante, Monje atacado);
	Tipo getEstado();
	int getDefensa(Monje monje);
	int getAtaque(Monje monje);
}
