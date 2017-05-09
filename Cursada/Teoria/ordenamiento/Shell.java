package ordenamiento;

/*
 * H_Ordenados
 * Hi = Hi-1 * 3 + 1
 * H:1,4,13,40...
 * Ventajas contra el de inserci�n:
 * El numero muy bajo al final de todo implica que tenga que desplazar todo el vector para colocarlo al comienzo.
 * En cambio ac� se acomoda a la posici�n casi final al comienzo. HAsta 3 desplazamientos por elemento como maximo.
 * 
 * EJEMPLOAORDENAR
 * 15 ELEMENTOS, EL MAXIMO H=13
 * EMPIEZO COMPARANDO LOS ITEMS DE LA MISMA DISTANCIA
 * 
 * PASADA 1 - H=13
 * EJEMPLOAORDENAR
 * AJ ..........ER
 * 
 * PASADA 2 - H=4
 * AJEMPLOAORDENER
 * A...P
 * A...O...P 
 * A...N...O...P..
 * 
 * .J...L
 * .J...L...R
 * .E...J...L...R
 * 
 * ..E...O
 * ..D...E...O
 * ..D...E...O...R
 * 
 * ...A...M
 * ...A...E...M
 * 
 * UNIFICO
 * AEDANJEEOLOMPRR
 * 
 * PASADA 3 - H=1 ( PASARIA A SER INSERCI�N PURA )
 * AEDANJEEOLOMPRR
 * 
 * AE
 * ADE
 * AADEN
 * AADEJN
 * AADEEJN
 * AADEEJNO
 * AADEEJNNOO
 * AADEEJNNOOP
 * AADEEJNNOOPR
 * AADEEJNNOOPRR
 * 
 * Complejidad: O(n^3/2)
 * Sensible? si ya que realiza combinaciones demas
 * Estable? no pq mezclo
 */
public class Shell {

}
