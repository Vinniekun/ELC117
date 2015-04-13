-- Vinicius Mateus Dreifke
-- T3

-- 1) As funções de alta ordem any e all são pré-definidas na biblioteca Prelude do Haskell (veja seção Special Folds). Estude e teste essas funções e apresente 2 exemplos de uso de cada uma delas.

-- A função de alta ordem All serve para verificar se todos (all) elementos de uma lista são iguais a condição dada e por fim retorna true ou false. Ex:
-- Dada uma lista de inteiros: [4,5,6,7], verificar se todos são maiores que 5:

maior5 :: [Int] -> Bool
maior5 x = all (>5) x

-- A função all testa todos os elementos com o (>5), neste caso a resposta seria false pois nem todos elementos são maiores que 5. 
-- Outro exemplo do uso de All:

funcAll :: [Int] -> Bool
funcAll x = all (\x -> (x*3)  <30 ) x

-- Verificar apos fazer calculos.

-- A função de alta ordem Any é semelhante a função All. Any vai procurar em uma lista qualquer(any) elemento que se encaixe com a condição dada e por fim retorna true ou false. Ex:
-- Dada uma lista de inteiros: [4,5,6,7], verificar se qualquer um dos elementos é maior que 5:

qqlmaior5 :: [Int] -> Bool
qqlmaior5 x = any (>5) x

-- Any vai testar todos os elementos com o (>5), neste caso a resposta seria true pois existe elementos na lista que são maiores que 5.
-- Outro exemplo:

funcAny :: [Int] -> Bool
funcAny x = any (\x -> (x*3+1)  >16 ) x

-- Verificar apos fazer calculos.

-- 2) Em Haskell, o símbolo '$' pode ser usado para escrever códigos ainda mais curtos. Descubra seu significado e apresente 2 exemplos de uso.

-- O simbolo $ (dollar) serve para encurtar as funções tirando os parenteses. Ex:
-- Funções sem o uso do $:

dezChar :: [String] -> [String]
dezChar lis =  map(take 10)(map (++ repeat '.')lis) 

strToInt n = sum (zipWith (*) (reverse(map digitToInt n)) ( map (10^) [0..])) 

-- Funções com o uso do $:

dezChar' :: [String] -> [String]
dezChar' lis =  map(take 10) $ map (++ repeat '.')lis

strToInt n = sum $ zipWith (*) (reverse $ map digitToInt n) $ map (10^) [0..]

-- 3) Haskell permite composição de funções, exatamente como em matemática. Descubra como fazer isso e apresente 2 exemplos de aplicação de funções compostas.

-- O . (ponto) serve para fazer funções compostas em Haskell, pode ser inseridas varias funções que estejam dentro de outras ( f(g(x)) ). Tambem permite que o codigo fique mais limpo, isso é, sem usar os parenteses para dividir cada função.
-- Funções sem o uso de composição:

somaPares' :: [Int] -> Int
somaPares' x = sum ( take 3 ( filter even $ x))

strToInt :: String -> Int
strToInt n = sum $ zipWith (*) (reverse $ map digitToInt n) $ map (10^) [0..]

-- Funções com o uso de composição:

somaPares :: [Int] -> Int
somaPares x = sum . take 3 . filter even $ x

strToInt :: String -> Int
strToInt n = sum . zipWith (*) (reverse $ map digitToInt n) $ map (10^) [0..]

-- No caso do somaPares a função sum será a ultima a ser aplicada enquanto o take e filter estariam dentro dela. Com o uso do . fica mais facil para ler os passos da função.


