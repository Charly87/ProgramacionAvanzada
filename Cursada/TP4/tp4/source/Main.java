package tp4.source;

public class Main {

	public static void main(String[] args) {
		MatrizSimetrica ms;
		try {
			ms = new MatrizSimetrica(4);

			ms.setValor(0,1, 1);
			ms.setValor(0,2, 2);
			ms.setValor(0,3, 3);
			ms.setValor(1,2, 4);
			ms.setValor(1,3, 5);
			ms.setValor(2,3, 6);
			
			ms.visualizarVector();
			ms.visualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
