# Armada
Esta vez vamos a modelar distintas acciones de una armada de soldados griegos. Está compuesta por muchos soldados, y éstos pueden ser hoplitas, lanzadores de jabalinas, honderos, arqueros y caballeros.
> Nota: al agregar soldados a la armada sólamente se podrán guardar todos en una misma lista. No se permite tener más colecciones como atributos de la clase.

## RQ1: Formaciones
Toda armada debe poder formarse. Implementaremos estas tres formaciones:
1. Formación por rango. Los soldados tienen un rango, y los soldados de mayor rango deben ir al frente para alentar al resto de la armada.
2. Formación por velocidad. Se busca que los soldados más veloces vayan por detrás, para no dejar rezagadas a las unidades más lentas.
3. Formación por tropa. Primero marchan los hoplitas, de mayor a menor rango. Luego los honderos y lanzadores de jabalinas. Luego saldrán a combate los caballeros y por último los arqueros, disparando desde la retaguardia.
> Pista: u??q??? '??os?suo????llo? ? ?o???? ns s? ?o????d?o?

## RQ2: Grupos
Debe poder pedírsele a la armada que nos otorgue una serie de pares (tipo de unidad; listado). Los mismos deben poder calcularse de tal manera que los soldados de distintos rangos estén mezclados entre sí.
> Pista: ?d?? un u? sol??dn??? o??nl ? so?u???l? sol sopo? ??l?z?? u?q?p

## RQ3: Representantes
Si a la armada se le pide sus representantes, ésta debe devolver un soldado, cualquiera sea su rango y tipo, por región. Es una forma de ayudar a arengar al grupo.
> Pista: sop???d?? u?s op??s?l un ??u??qo ??????d sou ??s un