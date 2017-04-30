package colaDePrioridad;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ColaDePrioridad {

	public static void main(String[] args) {
		Comparator<Integer> comparador = Collections.reverseOrder();
		//Collections.sort(arrayListInt, comparador);
		PriorityQueue<Integer> colaP = new PriorityQueue<Integer>(10, comparador);
		colaP.add(44);
		colaP.add(21);
		colaP.add(67);
		colaP.add(8);
		colaP.add(56);
		colaP.add(35);
		colaP.add(17);
		colaP.add(67);
		colaP.add(10);
		colaP.add(50);
		colaP.add(31);
		colaP.add(28);
		
	System.out.println(colaP);	
		
		
	}

}
