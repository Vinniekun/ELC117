-- Vinicius Mateus Dreifke
-- T3

--
-- Este programa lê um arquivo CSV, com 2 dados por linha. Cada linha é transformada numa tupla. 
-- A lista de tuplas é passada para uma função que vai gerar uma longa string representando um
-- documento HTML.
--

main :: IO ()
main = do
    strcontent <- readFile infile
    let listofstrlist = map (splitOnChar ',') (lines strcontent)
        strtuplelist = map (\lis -> (head lis, last lis)) listofstrlist
    writeFile outfile (mkHtmlURLItemsDoc "Usuários Cadastrados no NCC" strtuplelist)
    where 
    infile = "logins.csv"
    outfile = "output.html"


-- Esta função deve ser alterada para chamar outras funções que vão
-- construir o documento HTML
mkHtmlURLItemsDoc :: String -> [(String,String)] -> String
--mkHtmlURLItemsDoc title lis = "Usuários Cadastrados no NCC\n" ++ unlines (map fst lis) ++ unlines (map snd lis)
mkHtmlURLItemsDoc title lis = "<body>\n <html>\n" ++ extrair lis ++ "</body>\n </html>"

extrair :: [(String,String)] -> String
extrair n = 
	let 
		nome = unlines (map (usuario) n)
	in nome

usuario :: (String, String) -> String
usuario lis = "<li><a href=http://www.inf.ufsm.br/~" ++ snd lis ++ ">" ++ fst lis ++ "</a></li>"

-- Decompoe string usando um caracter delimitador
splitOnChar :: Char -> String -> [String]
splitOnChar x y = auxSplitOnChar x y [[]]

auxSplitOnChar :: Char -> String -> [String] -> [String]
auxSplitOnChar x [] z = reverse (map reverse z)
auxSplitOnChar x (y:ys) (z:zs) = 
	if y == x then 
            auxSplitOnChar x ys ([]:(z:zs)) 
        else 
            auxSplitOnChar x ys ((y:z):zs)
