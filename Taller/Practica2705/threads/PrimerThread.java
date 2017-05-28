package threads;

// Estados
// - Creacion
// - Ejecución 	-> Start();
// - Pausa		-> Sleep();
// - Muerto		-> Run();

//Syncronized va en la def de un metodo

public class PrimerThread extends Thread {
	
	
	public PrimerThread(String name) {
		super(name);
	}

	public void run() {
		this.hacerAlgo();
	}

	public synchronized  void hacerAlgo() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " " + getName());
		}
		System.out.println("Termino");
	}
}
