-- Vinicius Mateus Dreifke
-- T3

import Data.Char

-- 1) Escreva uma função recursiva firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
firstName :: String -> String
firstName [] = []
firstName n
	| (head n) == ' ' = []
	| (head n) /= ' ' = (head n) : firstName(tail n)

-- 2) Escreva uma função firstName' :: String -> String com o mesmo resultado do exercício anterior, mas sem usar recursão.
firstName' :: String -> String
firstName' n = takeWhile(/= ' ')n

-- 3) Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
lastName :: String -> String
lastName [] = []
lastName n
	| filter (==' ') n == [] = n
	| otherwise = lastName (tail n)

-- 4) Escreva uma função não-recursiva userName :: String -> String que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por: primeira letra do nome seguida do sobrenome, tudo em minúsculas.
userName :: String -> String
userName [] = []
userName n = toLower ((head n)) : reverse [toLower x | x <- (takeWhile (/=' ') ( reverse (tail n))) ]



-- 5) Escreva uma função não-recursiva encodeName :: String -> String que substitua vogais em uma string, conforme o esquema a seguir: a = 4, e = 3, i = 1, o = 0, u = 00.
encodeName :: String -> String
encodeName n = 
	let change x
		| x == 'a' = "4"
		| x == 'e' = "3"
		| x == 'i' = "1"
		| x == 'o' = "0"
		| x == 'u' = "00"
		| otherwise = [x]
	in concat(map (change) n)

-- 6) Escreva uma função isElem :: Int -> [Int] -> Bool que verifique se um dado elemento pertence a uma lista, conforme os exemplos.
isElem :: Int -> [Int] -> Bool
isElem x y = any (==x) y


-- 7) Escreva uma função recursiva que retorne o número de vogais em uma string.
numVog :: String -> Int
numVog n
	| n == [] = 0
	| (head n) `elem` "aeiouAEIOU" = 1 + numVog (tail n)
	| otherwise = numVog (tail n)



-- 8) Escreva uma função não-recursiva que retorne o número de consoantes em uma string.
numCon :: String -> Int
numCon n = length [ x | x <- n, x `notElem` "aeiouAEIOU"]



-- 9) Escreva uma função não-recursiva isInt :: String -> Bool que verifique se uma dada string só contém dígitos (0 a 9).

isInt :: String -> Bool
isInt n = all ('9'<) n


-- 10) Escreva uma função não-recursiva strToInt :: String -> Int que converta uma string em um número inteiro, fazendo operações aritméticas com seus dígitos (p.ex.: "356" = 3*100 + 5*10 + 6*1 = 356). Considere que a string seja um número válido, isto é, só contenha dígitos de 0 a 9.

strToInt :: String -> Int
strToInt n = sum $ zipWith (*) (reverse $ map digitToInt n) $ map (10^) [0..]

--strToInt n = sum (zipWith (*) (reverse(map digitToInt n)) ( map (10^) [0..])) 

