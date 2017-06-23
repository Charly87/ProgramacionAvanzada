package tp4.source;

public class Main {

	public static void main(String[] args) {
		MatrizSimetrica ms;
		try {
			ms = new MatrizSimetrica(4);
			ms.setValor(1,2, 4);
			ms.visualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
