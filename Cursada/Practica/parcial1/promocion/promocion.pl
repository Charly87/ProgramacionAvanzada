parcial1(carlos,7).
parcial1(ana,8).
parcial2(carlos,9).
parcial2(ana,2).

promocionaron(X,Y):-parcial1(X,A>=7),parcial2(X,B>=7),Y==(A+B/2).

entrada(paella).
entrada(gazpacho).
entrada(consome).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).

bebida(agua).
bebida(vino).
bebida(cerveza).

platoPrincipal(X):-carne(X);pescado(X).
menu(X,Y,Z):-entrada(X),platoPrincipal(Y),postre(Z).
comidas(X,Y,Z):-menu(X,Y,Z),write(X*Y*Z),nl,fail.
entradaConsome(Y,Z):-menu(consome,Y,Z),write(consome*Y*Z),nl,fail.
comidaSinFlan(X,Y,Z):-menu(X,Y,Z),dif(Z,flan),write(X*Y*Z),nl,fail.
menuConBebida(X,Y,Z,W):-entrada(X),platoPrincipal(Y),postre(Z),bebida(W),write(X*Y*Z*W),nl,fail.

