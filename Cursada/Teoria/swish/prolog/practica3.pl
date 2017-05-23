hombre(pedro).
hombre(manuel).
hombre(arturo).

mujer(maría).

padre(pedro,manuel).
padre(pedro,arturo).
padre(pedro,maría).

niño(X,Y):-padre(Y,X),write(X),nl,fail.
hijo(X,Y):-padre(Y,X),hombre(X),write(X*Y),nl,fail.
hija(x,y):-padre(Y,X),mujer(X),write(X*Y),nl,fail.
hermanoOhermana(X,Y):-padre(Z,X),padre(Z,Y),dif(X,Y),write(X*Y),nl,fail.
hermano(X,Y):-padre(Z,X),padre(Z,Y),hombre(X),dif(X,Y),write(X*Y),nl,fail.
hermana(X,Y):-padre(Z,X),padre(Z,Y),mujer(X),dif(X,Y),write(X*Y),nl,fail.
