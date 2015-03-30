-- Vinicius Mateus Dreifke
-- Paradigmas da Computacao

-- Soma os quadrados de 2 numeros
nosDobre :: Int -> Int -> Int   
nosDobre x y = x^2 + y^2
  
-- Verifica se um numero eh par (mod retorna resto da divisao inteira)
ehPar :: Int -> Bool
ehPar n = if mod n 2 == 0 then True else False
  
-- Gera um numero a partir de um caracter
mudeMe :: Char -> Int
mudeMe c 
  | c == 'S'  = 0
  | c == 'N'  = 1
  | otherwise = 2
  
-- Calcula o quadrado do primeiro elemento da lista
dobrarPrimeiro :: [Int] -> Int
dobrarPrimeiro lis = (head lis)^2

-- 1) Função que verifica se a head das duas listas sao iguais
mesmaHead :: [Int] -> [Int] -> Bool
mesmaHead x y = if (head x) == (head y) then True else False

-- 2) Eleva todos os elementos da lista ao cubo, produzindo outra lista
p3 :: [Int] -> [Int]
p3 [] = []
p3 ns = (head ns)^3 : p3 (tail ns)

-- 3) Adiciona a constante 10 a todos elementos da lista, produzindo outra lista
add10 :: [Int] -> [Int]
add10 [] = []
add10 lis = (head lis)+10 : add10 (tail lis)

-- 4) Adiciona uma virgula no final de cada string contida na lista 
addComma :: [String] -> [String]
addComma [] = []
addComma c = ((head c)++",") : addComma (tail c) 

-- 5) Fazer as duas funcoes anteriores usando map
add10m :: [Int] -> [Int]
add10m lis = map (+10) lis

addCommam :: [String] -> [String]
addCommam c = map (++",") c

-- 6) Recebe uma lista de string e retorna outra lista contendo as strings formatadas
-- como itens de lista em HTML
htmlListItems :: [String] -> [String]
htmlListItems lis = map ("</LI>"++) (map (++"<LI>") lis)

-- 7) Recebe uma letra e verifica se há a mesma em uma string.
charFound :: Char -> String -> Bool
charFound c s
  | s == [] = False
  | (head s) == c = True
  | otherwise = charFound c (tail s)

-- 8) Refazer a funcao 7 sem recursao.
temLetra :: Char -> String -> Bool
temLetra c s = if length ( filter (==c) s ) > 0 then True else False

-- 9) Usar a funcao zipWith para obter a diferenca, de par a par, entre duas lista.
difPar :: [Int] -> [Int] -> [Int]
difPar x y = zipWith (-) x y

-- Funcoes de alta ordem

-- 1) Dada uma lista de números, calcular 2*n+1 para cada número n contido na lista.

calcuLo1 :: [Int] -> [Int]
calcuLo1 x = map (\x -> 2* x +1) x

-- 2) Dadas duas listas X e Y de números inteiros, calcular 4*x+2*y+1 para cada par de números x e y
-- pertencentes às listas. 

calculoPar :: [Int] -> [Int] -> [Int]
--calculoPar [] [] = []
--calculoPar x y = (4*(head x)+2*(head y)+1) : calculoPar (tail x) (tail y)
calculoPar x y = zipWith (\x y -> 4*x+2*y+1) x y

-- 3) Dada uma lista de strings, produzir outra lista com strings de 10 caracteres, usando o seguinte
-- esquema: strings de entrada com mais de 10 caracteres são truncadas, strings com até 10 caracteres
-- são completadas com '.' até ficarem com 10 caracteres.

dezChar :: [String] -> [String]
dezChar lis =  map(take 10)(map (++ repeat '.')lis)

-- 4) Dada uma lista de idades, selecionar as que são maiores que 20 e, para cada uma, calcular o ano
-- de nascimento correspondente (aproximado, considerando o ano atual).

listaId :: [Int] -> [Int]
listaId lis = map (\lis -> 2015 - lis) (filter (>20)  lis)  