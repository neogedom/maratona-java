package br.com.abc.javacore.ZZJoptional.test;

import java.util.Optional;

/**
 * OptionalTest
 * Evitando NullPointerException com a classe Optional

 */
public class OptionalTest {
    private String nome;

    public static void main(String[] args) {

        // * Antes do java 8, a única coisa que poderíamos fazer para
        // * evitar o NullPointerException era verificar com if se o 
        // * atributo era null. O problema disso são as linhas extras
        // e o if gigantesco que pode virar se houver outros ifs encadeados
        // nos métodos chamados
        OptionalTest ot = new OptionalTest();
        if (ot.nome != null)
            System.out.println(ot.nome.toUpperCase());

        //usando Optional. Isso siginifica que a String abaixo
        // pode ou não ser opcional
        // Três formas de usar
        // 1 - quando tenho certeza de que a variável não vai ser nula
        // pois o of() precisa de um valor não nulo
        Optional<String> optional1 = Optional.of("Lala");

         // 2 - criando optional vazio
        Optional<String> optional2 = Optional.empty();

         // 2 - Quando a variável pode ou não ser nula. Se ela for nula, 
         // vai ser retornado Optional.empty
         Optional<String> optional3 = Optional.ofNullable(ot.nome);

        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);

        //Pegando o valor do Optional com get()
        if(optional2.isPresent()) // Importante verificar, pois se optional for empty, dá exceção
            System.out.println(optional1.get());

        //Pegando o valor com orElse(). Se não tiver nada no optional, 
        // declare o que ele deve retornar
        System.out.println(optional2.orElse("vazio"));


        
    }
}