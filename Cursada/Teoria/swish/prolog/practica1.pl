%clauses

entrada(paella).
entrada(gazpacho).
entrada(consomé).

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
entradaConsome(Y,Z):-menu(consomé,Y,Z),write(consomé*Y*Z),nl,fail.
comidaSinFlan(X,Y,Z):-menu(X,Y,Z),dif(Z,flan),write(X*Y*Z),nl,fail.
menuConBebida(X,Y,Z,W):-entrada(X),platoPrincipal(Y),postre(Z),bebida(W),write(X*Y*Z*W),nl,fail.
% fin clauses
