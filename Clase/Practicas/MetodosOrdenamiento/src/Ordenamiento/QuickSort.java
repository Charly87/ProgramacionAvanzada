package Ordenamiento;
/*
 * Se para en un item y verifica para la izquierda y para la derecha.
 * Hay que elegir bien el pivot
 * Ej:
 * 1 2 3 4
 * 
 * Ordeno uno y luego tengo que ordenar los demas, entonces degenera en un O(n^2)
 * 12..
 * 123.
 * 1234
 * 
 * Teniendo:
 * 8 38 4 7 14 5 2 12 4
 * 
 * Elegir el pivot, por ahora solo la del medio. pero lo mejor es tomar uno al azar
 * 
 * . . . . 14 . . . .
 * . . . .  4 . . .14
 * 
 * Sensible a la eleccion del pivot... igual decimos que es no sensible
 * Estable? no pq cambio items de cualquier posiciones y no consecutivos
 * complejidad: O(n*log(n))
 * 
 * Sacar recursividad
 * tomar mediana de tres
 * o cambiar de metodo de ordenamiento cuando me quedan pocos elementos.
 * 
 */

public class QuickSort {

}
