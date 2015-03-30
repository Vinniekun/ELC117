-- Vinicius Mateus Dreifke
-- Paradigmas da Computacao

-- Parte 1: List comprehension

-- 1) Gerar uma lista de potencias de 2.
geraPotencias :: Int -> [Int]
geraPotencias 0  = [1]
--geraPotencias x = 2^x : geraPotencias (x-1)
geraPotencias x = [2^n | n <- [x,x-1..0] ]

-- 2) list comprehension para adicionar sufixo as strings. > addSuffix "@inf.ufsm.br" ["fulano","beltrano"]
addSuffix :: String -> [String] -> [String]
--addSuffix suf nome = map (++suf) nome
addSuffix suf nome = [x ++suf | x <- nome]

-- 3) Mostra o ano de nascimento para idades maiores que 20.
anosDeNascimento :: [Int] -> [Int]
anosDeNascimento lis = [ 2015-x  | x <- lis, x > 20 ]