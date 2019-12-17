package br.com.abc.javacore.Sstrings.test;


public class StringBuilderTest {
    public static void main (String args []){
        //O StringBuilder não é uma string
        String s = "Uma frase comum";
        //StringBuilder sb = s;

        //Criando uma string de 10 caracteres. Se não passar nada pro construtor
        // a capacidade é de 16 caracteres
        StringBuilder sb = new StringBuilder(16);

        // Para adicionar uma String ao stringBuilder você precisa usar o append
        // e não sb = "string" ou sb.concat("string")
        //Com o append você reaproveita o mesmo objeto e não cria um monte de objetos na memória
        sb.append("Uma frase comum");

        //O stringBuilder consegue ser impresso como uma string comum por causa do toString
        System.out.println(sb);


        //Métodos do StringBuilder
        // Trocar a ordem dos caracteres da String
        System.out.println(sb.reverse());

        //Excluir uma substring
        //Lembrando que começa do início, mas o valor definido pra fim não é contado
        StringBuilder sb1 = new StringBuilder();
        sb1.append("0123456789");
        System.out.println(sb.delete(0, 2));

        //Inserir strings dentro de strings
        System.out.println(sb1.insert(2, "##"));

        //Pegadinha possível na certificação
        StringBuilder sb2 = new StringBuilder();
        sb2.append("df").insert(2,"ghi").reverse().delete(2, 4);
        System.out.println(sb2);

    }
}