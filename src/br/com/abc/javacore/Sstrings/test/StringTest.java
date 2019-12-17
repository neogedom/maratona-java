package br.com.abc.javacore.Sstrings.test;

public class StringTest {

    public static void main (String [] args) {
        
        String nome = "Vinícius";

    
        //Strings são imutáveis. O que acontece é que o Java cria uma nova string em memória (pool de strings)
        // O que aconteceu? O java agora tem três strings: Uma chamada "Vinícius", outra chamada "Gomes" 
        // e outra em memória chamada "Vinícius Gomes"
       // nome.concat("Gomes"); // Isso é a criaçã de "Vinícius Gomes" sem atribuir para nenhuma variável de referência
         //nome += " Gomes"; isso é a mesma coisa que a de cima
         //Assim a referência da variável muda de "Vinícius" para "Vinícius Gomes"
         nome = nome.concat(" Gomes"); 
         
         // O java tem um espaço especial para as Strings na memória. A string constant pool
         // Eu criando a variável nome2 e atribuindo "Vinicius" para ela, ela vai procurar na string constant pool
         // se tem outro objeto String "Vinícius" e apontar para ele
         // Assim ele enconomiza memória
         // Para que esse comportamento não seja mudado, a variável String é final
         String nome2 = "Vinícius";

         //Para criar uma String no pool de string
         // Então, por questões de performance, não é bom ficar usando new para criar String
         String nome3 = new String("Vinícius");

        System.out.println(nome2);


        // Métodos da classe String
        String nome4 = "Goku";
        String nome5 = "Goku";
        // Descobrir que caractere está em cada índice
        // Assim como o array, começa em 0
        System.out.println(nome4.charAt(3));

        //Compara strings ignorando o case
        // comparar assim nome4 == nome5 não é recomendável
        System.out.println(nome4.equalsIgnoreCase(nome5));

        //Para saber o tamanho da string
        // Cuidado: nos arrays lenght é um atributo, nas Strings é um método e termina com ()
        System.out.println(nome4.length());

        //Trocar caracteres na string
        System.out.println(nome4.replace("o", "a"));

        //Mudar tudo para maiúscula e tudo para minúsucula
        System.out.println(nome4.toLowerCase());
        System.out.println(nome4.toUpperCase());

        String nome6 = "0123456789";
        //Quebrar uma string e pegar apenas uma parte dela.
        // Pega o caractere do início e não pega o do fim
        // Quando começa, ele lida como se fosse um array, começando do 0
        // Para terminar, ele lida começando do 1
        System.out.println(nome6.substring(0,2));
        

        String nome7 = "        oooooo            ";
        //Tirar os espaços que estão no começo e no fim. Ele não tira do meio
        // O trim é bastante útil quando se trabalha com banco de dados e o usuário costuma colocar espaço depois do nome
        // Aí na hora de procurar o nome no banco de dados, ele não acha
        // Antes de salvar no banco de dados é uma boa prática usar o trim
        System.out.println(nome7.trim());
    }
}