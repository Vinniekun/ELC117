-- Vinicius Mateus Dreifke
-- T3

import Data.Char

userName :: String -> String
userName [] = []
userName n = toLower ((head n)) : reverse [toLower x | x <- (takeWhile (/=' ') ( reverse (tail n))) ]

-- Seu programa deverá ler um arquivo nomes.csv, contendo um nome por linha, e produzir um arquivo logins.csv, contendo um nome e um login por linha, separados por vírgula. O login deve ser obtido usando uma função criada por você.

main :: IO ()
main = do
    strcontent <- readFile "nomes.csv"
    let strlist = lines strcontent
        strnew = [n ++ "," ++ userName n | n <- strlist]
    writeFile "logins.csv" (unlines strnew)