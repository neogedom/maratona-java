package br.com.abc.javacore.Zcolecoes.test;

import br.com.abc.javacore.Zcolecoes.classes.Celular;

public class EqualsTest {
    public static void main(String[] args) {
        // Strings diferentes uma da outra
        // Isso pq eles estão em locais diferentes
        // se apenas fosse nome1 = "Vinícius Gomes", as duas variáveis estariam
        // refereciando o mesmo objeto
        String nome1 = "Vinícius Gomes";
        String nome2 = new String("Vinícius Gomes");

        Integer int1 = 5;
        Integer int2 = new Integer(5);

        // O == compara as referências (endereço de memória) e nome1 e nome2 estão em
        // lugares diferentes
        // System.out.println(nome1 == nome2);
        System.out.println(int1 == int2);

        // Para usar o significado da variável de referência e não o endereço de
        // memória?
        System.out.println(int1.equals(int2));

        // O equals é da classe Object e usamos ele com polimorfismo
        // O problema é que na classe Object, o método equals usa ==
        // Para tornar nossas classes comparáveis igual ao Integer, devemos criar nosso
        // próprio método equals
        Celular c1 = new Celular("iPhone", "1234");
        Celular c2 = new Celular("iPhone", "1234");
        System.out.println(c1.equals(c2));
        
        //O método equals é muito importante para as coleções, pq frequentemente devem comparar objetos
        // que seria classificados como diferentes
    }
}
