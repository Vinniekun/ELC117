%Vinicius Mateus Dreifke
%T4

%dias
%segunda

segunda(pedro,sm).
segunda(caren,poa).
segunda(henrique,ap).
segunda(alice,ap).
segunda(bia,ap).
segunda(maria,ap).
segunda(bernardo,sm).

%terca

terca(caren,poa).
terca(pedro,sm).
terca(henrique,poa).
terca(bia,poa).
terca(adriano,ap).
terca(alice,poa).
terca(bernado,sm).
terca(maria,sm).

%quarta

quarta(pedro,poa).
quarta(caren,poa).
quarta(henrique,ap).
quarta(bia,poa).
quarta(adriano,sm).
quarta(alice,poa).
quarta(bernado,poa).
quarta(maria,sm).

%quinta

quinta(pedro,sm).
quinta(caren,sm).
quinta(henrique,ap).
quinta(bia,sm).
quinta(adriano,ap).
quinta(alice,ap).
quinta(bernado,sm).
quinta(maria,sm).

%sexta

sexta(caren,ap).
sexta(pedro,ap).
sexta(henrique,ap).

%$$$
%rico

rico(henrique).
rico(adriano).
rico(alice).
rico(caren).

%pobre

pobre(bernado).
pobre(bia).
pobre(pedro).
pobre(maria).


%caracteristica
%insano

insano(adriano).
insano(maria).

%casais
%relacionamento

relacionamento(bernardo, anita).
relacionamento(anita, bernardo).

relacionamento(bernardo, caren).
relacionamento(caren, bernardo).

relacionamento(pedro, anita).
relacionamento(anita, pedro).

relacionamento(pedro, alice).
relacionamento(alice, pedro).

relacionamento(henrique, alice).
relacionamento(alice, henrique).

relacionamento(henrique, maria).
relacionamento(maria, henrique).

relacionamento(adriano, maria).
relacionamento(maria, adriano).

relacionamento(maria, caren).
relacionamento(caren, maria).

%%%%%%

vitima(anita).

ciumes(X,Y) :- relacionamento(X,W), relacionamento(Y,W).

arma(X) :- quinta(X,poa); quarta(X,sm); quinta(X,ap); quarta(X,ap).

chave(X) :- segunda(X,sm); terca(X,poa).

motivo(X) :- ciumes(X,anita); insano(X); pobre(X).

acesso(X) :-  arma(X), chave(X), (sexta(X,ap); quinta(X,ap)).

assassino(X) :- motivo(X), acesso(X).


































