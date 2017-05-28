package threads;

public class Main {

	public static void main(String[] args) {
		new PrimerThread("Carlos").start();
		new PrimerThread("Pepe").start();
	}
}
