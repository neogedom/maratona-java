package br.com.abc.javacore.ZZIdefault.test;

/**
 * B
 */
public interface B extends A {

    default void oi (){
        System.out.println("Dentro do oi de B");
    }
}