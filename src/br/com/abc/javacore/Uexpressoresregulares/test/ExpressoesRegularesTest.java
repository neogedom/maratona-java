package br.com.abc.javacore.Uexpressoresregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Regex são linguagens dentro da linguagem
// São úteis para buscar padrões dentro de grandes conjuntos de texto
// Exemplo, se você precisar pegar todos os CEPs em um documento e eles 
// estiverem seguindo um mesmo padrão, é possível fazer isso com regex
public class ExpressoesRegularesTest {
    // No java há duas classes para trabalhar com Expressões Regulares: Pattern e Matcher 
    public static void main (String ... args) {
        // Se você for usar o contrabarra, é preciso usar o caractere de espaço antes (contrabarra)
        // String regex = "\\W";

        //Usando os colchetes você indica que quer procurar apenas os caracteres que estão lá dentro
        // String regex = "[abcABC]";
        String regex = "[a-cA-C0-9]";

        // Expressão regular para verificar se o número é hexadecimal (com problema de agrupamento)
        // String regexHex = "0[xX][0-9a-fA-F]";

        //Expressão regular que encontra de 0 a 9 e de A (a) até F(f) uma ou mais vezes seguido de espaço
        // em branco ou fim de linha
        String regexHex =  "0[xX]([0-9a-fA-F])+(\\s|$)";

        //Regex para encontrar email
        String regexEmail = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; // ([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+
       
        //Regex para encontrar data no formato dd/MM/YYYY
        // usando os valores dentro de {} digo o quanto de repetição eu espero para uma determinada expressão
        String regexData = "\\d{2}/\\d{2}/(\\d{2}|\\d{4})(\\s|$)"; //"\\d\\d/\\d\\d/\\d\\d\\d\\d"

        //Regex para pegar todos os valores que tenham proj no nome
        String regexProj = "proj[\\d]*.[a-z]+";

        // String texto = "abaaaba"; 
        // String texto = "_$%hab230982sdjlsjd\r3009";

        String texto = "cafeBABE1";
        String textoHex = "12 0x 0X 0xFFABC 0x10G 0x1";
        String textoEmail = "fulano@hotmail.com, 102Abc@gmail.com.br, #@!abrao@mail, teste@gmail.br, teste@mail";
        String textoData = "05/10/2010 05/05/2015 1/1/01 01/05/95";
        String textoProj = "proj1.bkp, proj, proj123.java, proj.123, proj1.class, proj1final.java, proj2.bkp, proj3.java, diagrama, texto, foto";

        //Representando número hexadecimal no java
       //int numeroHex = 0x100;
        // Pattern da java.util.regex
        // As expressões regulares são um monte de meta caracteres que precisam ser
        // compilados
        Pattern pattern = Pattern.compile(regexProj);
        // Matcher procura o padrão dentro do texto. Ela recebe o texto onde vai ser procurado
        // aquele padrão
        Matcher matcher = pattern.matcher(textoProj);

        System.out.println("Texto: " + textoProj);
        System.out.println("Índice: 0123456789");
        System.out.println("expressão: " + matcher.pattern());
        System.out.println("Posições encontradas");

        //Enquanto o matcher for encontrando padrão dentro do texto
        // imprima onde ele foi encontrado
        while(matcher.find()) {
            //matcher.group() toda vez que ele achar um valor que bate, ele vai pegar o valor inteiro
            System.out.println(matcher.start() + " " + matcher.group());

        }
        //System.out.println("Número hexadecimal:" + numeroHex);

          //Validando string usando o matches (dá pra fazer com o Pattern tbm, mas aí teria que criar uma variável
        // de referência para isso)
        System.out.println("Email válido? " + "#@!abrao@mail".matches(regexEmail));
    }
}

// Algo importante sobre as expressões regulares. Ele não usa os valores duplicadamente
// Se um valor já foi usado em um padrão encontrado, o caractere não pode ser usado em outro padrõ
// Ex.: abababa teria só dois "aba" e não três, pois não há sobreposição / repetição

//Metacaracteres:
// \d - todos os dígitos
// \D - tudo o que não for dígito
// \s - procura por espaços em branco
// \S - caractere que não é branco
// \w - alfanuméricos e _ a-z,  A-Z, dígitos e _  
// \W - tudo que não for uma palavra
// . caractere coringa que pode ser substituído por qualquer coisa
// ^ - negação - Exemplo: ^[abc] - não quero nada que seja a, b ou c 
// inclua as expressões em []


 //Quantificadores: procurar por uma ou mais ocorrência de uma determinada expressão
// ? - 0 ou 1 ocorrência  
// * - 0 ou mais ocorrências
// + - 1 ou mais ocorrências
// {n,m} - ocorrências customizáveis. De n até m ocorrências

// Agrupamento
// ( ) - usado para agrupar expressões
// | - representa OU
// $ - representa fim de linha (para encontrar algo no fim da linha)

// Exemplo do agrupamento:
// o(v|c)o - procure algo que comece com o, que tenha v ou c e que termine com o. Casa com ovo ou oco
//maca(rr|c)ão - casa com macarrão ou macacão