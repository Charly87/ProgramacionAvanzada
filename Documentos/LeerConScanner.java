import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class LeerConScanner{

	/* este programa lee un archivo con el siguiente formato:
	   primera linea un entero n que indica la cantidad de numeros siguientes  que debo leer
	   seguido por  n numeros tipo  double
	   Ver mas ejemplos de Scanner en 
	   http://www.redeszone.net/2012/02/20/curso-de-java-entrada-y-salida-con-ficheros-clase-scanner/
    */

	public static void main(String[] args) throws FileNotFoundException {
	
		String miPath = "\\gus\\programas\\workspace\\";
		Scanner sc = new Scanner(new File(miPath+"datos.in"));
		sc.useLocale(Locale.ENGLISH);
		double [] vec = new double[sc.nextInt()]; // vector para almacenar la lectura
		
		for (int i = 0; i < vec.length ; i++) {
			vec[i] =sc.nextDouble() ;
			System.out.println( vec[i]);
		}
		
		sc.close();

	}

}
