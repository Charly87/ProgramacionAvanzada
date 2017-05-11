package programacionDinamica;
// Guardar soluciones para no calcularlas todas las veces que necesito
// Esto me va a ayudar a calcular la solucion total del problema.

// Ejemplo escalera
//          __ n
//       __|
//    __|
// __|
//|
// Subiendo de a 1 escalon o de a dos escalones.
// Cuantas formas diferentes hay?
//
// S(n) = S(n-1) + S(n-2)

// De aca ser arma un Arbol supononiendo que n=5
// S(5) = S(4) + S(3)
// donde cada S es una hoja y se va dividiendo.
// La idea es ir guardando los resultados de las hojas.
// Comienzo desde las hojas de mas abajo y las guardo en un vector:

// long fibo(n)
// vec[0]=1
// vec[1]=1
// for int i= 2; i <=n ; i++
//     vec[i] = vec[i-1] + vec[i-2]
// return vec[n];

// Este metodo es bottom-up

// Otro modo... top-down
// Solo calculo las que necesito
/* long fibo (int n) 
 * 	if(vector[n] != 0)
 *  	return vector [n];
 *  return vector[n] = fibo(n-1) + fibo(n-2);
 *  
 * 
 * 
 */
// Ejercicio
/*
 * 1  1  1 -2  2
 * 1  1  1  1  0
 * 2 -1  0  2  2
 * 1 -1  3 -2  2
 * 0  2 -1  2  0
 */
// Creamos otra matriz y vamos guardando las sumas.
// Lo que ahorro es volver a recorrer cada subatriz y calcular de nuevo, el calculo ya lo tengo.
/*
 * 1  2  3  1  3
 * 2  
 * 4
 * 5
 * 5  
 */

// 4 = 1 + 1 - 1 + 1
//11 = 4 + 3 - 2 + 6

/*
 * 1  2  3  1  3
 * 2  4  6  5  7   
 * 4  5  7  8 12
 * 5  5 10 (9)15
 * 5  7 11 12 18
 */

/*
*              
*                 
*    5  7  8  
*    5 10 (9)
*    
*/

// 9-5-5+2 = - ( los 5 es la suma de la fila de arriba y la columna de la izq, menos 2 que es donde se superponen la fila y col )

// Resolver Pedregal Haciendo programacion dinamica.

/*  1 0 0
 *  0 0 1
 *  0 0 1
 *  0 0 0
 */

/* 1 1 1
 * 1 1 2
 * 1 1 3
 * 1 1 3
 * 
 * si la casa es de 2 x 2, recorreo esta ultima matriz hasta que encuentre que la suma sea 0.
 * 
 * 
 * 
 * Resolver el problema de la mochila.
 * 
 * Tenemos 5 objetos con un determinado peso y valor
 * 
 * objeto 1 2  3  4  5
 * peso   1 2  5  6  7
 * valor  1 6 18 22 28
 * 
 * En la mochila podemos llevar el el peso 11.
 * 
 * Busco el valor de satisfaccion
 * n pes val | 0  1  2  3  4  5  6  7  8  9 10 11
 * 1  1   1  | 0  1  1  1  1  1  1  1  1  1  1  1    
 * 2  2   6  | 0  1  6  7  7  7  7  7  7  7  7  7
 * 3  5  18  | 0  1  6  7  7 18 19 24 25 25 25 25
 * 4  6  22  | 0  1  6  7  7 18 22 24 28 29 34 40
 * 5  7  28  | 0  1  6  7  7 18 22 28 29 34 35 40
 * 
 * tomo los ultimos 2 40
 * v(5,11) = v(4,11)
 * ambos tienen satisfaccion de 40 por lo que el obj 5 no entra, tomamos el obj 4 
 * y tratamos de ver por que objetos esta compuesto ademas del 4.
 * v(4,11) = v(3,11-w4) + v4
 *         = v(3, 11-6) + 22
 *         = v(3,5) + 22
 *         = 18 + 22 = 40 -- el objeto 3 va a estar en la mochila.
 * 
 * v(3,5) = v(2,0) + 18
 *        =  0 + 18 = 18 -- el obj 2 noo está en la mochila.
 *         
 * 
 */
public class Tecnica {

}
