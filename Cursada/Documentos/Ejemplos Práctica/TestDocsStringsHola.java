package javaDocs;

public class Test {

	
	/**
	 * desc
	 * @author leoblau
	 * 
	 * @param args
	 * @param a Valor numérico
 	 * @param b Cadena
 	 * @return Flag de error
 	 * 
	 */
	
	public boolean print(int a, String b){
			
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		int va=4;
		String miCadena="leoblau";
		if (t.print(va,miCadena));
		int [] vec;
		vec=new int[10];
		StringBuilder cad=new StringBuilder("[");
		
		for(int i=0;i<10;i++){
			cad.append(vec[i]);
			cad.append(";");
		}
			
		System.out.println(cad.toString());
		
		String saludo = "hola";
		String hola = new String("hola");
		
		System.out.println("hola" == "hola");//T
		System.out.println("hola" == saludo);//T
		System.out.println(saludo == hola);//F
		System.out.println(hola == "hola");//F
		String saludo2 = "hola";
		System.out.println(saludo == saludo2);//T
				

	}

}
