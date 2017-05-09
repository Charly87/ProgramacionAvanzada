package luchadoresJaponeses.src;

public class Main {

	public static void main(String[] args) {
		
		//PruebaLuchador();
		Torneo torneo = new Torneo();
			
				if(torneo.procesar2())				
					if(torneo.guardarResultado2())
						System.out.println("Torneo Procesado y Guardado Correctamente");
					else
						System.out.println("No se pudo guardar el torneo");		
				else
					System.out.println("No se pudo procesar el torneo");
	}
	
	public static void PruebaLuchador()
	{
		Luchador l1 = new Luchador(16,60);
		Luchador l2 = new Luchador(17,60);
		Luchador l3 = new Luchador(16,61);
		Luchador l4 = new Luchador(16,60);
		
		System.out.println(l1.domina(l2));		
		System.out.println(l1.domina(l3));
		System.out.println(l1.domina(l4));		
		
		System.out.println(l2.domina(l1));
		System.out.println(l2.domina(l3));
		System.out.println(l2.domina(l4));
	}
}
