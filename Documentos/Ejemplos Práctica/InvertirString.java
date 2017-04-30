public class Invertir {

public static void main(String[] args) {
	String a ="hola";
	String invertido="";
	for(int i=a.length()-1;i >= 0;i--){
		invertido+=a.charAt(i);
	}
	System.out.println("Palabra invertida: "+invertido);
	}
}
