package br.com.abc.javacore.Rwrappers.test;

public class WrappersTest {
    public static void main (String ... args) {
        // Temos oito tipos primitivos
        // neles não preciso do F, L e D por causa do cast
        byte bytePrimitivo = 1;
        short shortPrimitivo = 1;
        int intPrimitivo = 10;
        long longPrimitivo = 10;
        float floatPrimitivo = 10;
        double doublePrimitivo = 10; 
        char caracterePrimitivo = 'a';
        boolean booleanPrimitivo = true;

        // O Java criou classes que encapsulam os tipos primitivos
        // a fim de que seja dado mais poder aos tipos primitivos 
        // Eles são classes e as regras de herança e polimorfismo se aplicam a eles
        // de forma igual
       // Byte vai de 1 até 127, depois é considerado int
       // As classes numéricas são filhas de Number
        Byte byteWrapper = 127;
        Short shortWrapper = 1;
        Integer intWrapper = 10;
        // Colocar o L é fazer boxing. Sem ele, a classe Long acha que você está atribuindo um inteiro
        // Long e Int são irmãos e não há polimorfismo aí
        // AS classes que devem ser tomado cuidado: Long, Float e Double
        Long longWrapper = 10L;
        Float floatWrapper = 10.0f;
        Double doubleWrapper = 10.0;
        Character charWrapper = 'a';
        Boolean booleanWrapper = true;

        // Autoboxing = pegar um tipo primitivo e colocar em um wrapper
        // Unboxing abaixo
        int i = intWrapper;

        // Antes da versão 5 o unboxing era feito assim
        i = intWrapper.intValue();

        // tambem dá pra criar valores assim
        Integer inteiro = new Integer(10);
        // Eles aceitam String no construtor, exceto o Character
        Integer inteiro2 = new Integer("10");

        //Um método bem útil é o parse das classes wrappers
        String num = "10";
        Float f = Float.parseFloat(num);
        System.out.println(f);

        //Como retornar o wrapper (e não o tipo primitivo)
        // o método valueOf retorna o wrapper
        Long l = Long.valueOf(10L);

        // Verifica se um determinado caractere é um dígito
        System.out.println( Character.isDigit('a'));

        //Verificar se um determinado caractere é uma letra
        System.out.println(Character.isLetter('a'));

        //Verifica se é dígito ou letra
        System.out.println(Character.isLetterOrDigit('2'));

        //Verifica se está em maiúsculo
        System.out.println(Character.isUpperCase('A'));

        //Verifica se é minúsculo
        System.out.println(Character.isLowerCase('A'));

        //Transformar para maiúsculo
        System.out.println(Character.toUpperCase('a'));

        //Transformar para minúsculo
        System.out.println(Character.toLowerCase('A'));

    }
}