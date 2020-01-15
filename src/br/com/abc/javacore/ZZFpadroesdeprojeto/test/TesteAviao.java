package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Aviao;

/**
 * TesteAviao
 * Padrão Singleton: Permitir a criação de apenas uma instância de uma classe
 * Há pelo menos três formas para se fazer: Lazy, Eager e com Enums
 */
public class TesteAviao {

    public static void main(String[] args) {
        // Os assentos deveriam ser únicos
        // mas o código abaixo permite que duas pessoas agendem o mesmo assento
        // Isso pq chamar o método agendarAssento duas vezes faz com que eu crie
        // duas instâncias de avião
        agendarAssento("1A");
        agendarAssento("1A");
    }

    public static void agendarAssento(String assento) {
        Aviao a = new Aviao();
        System.out.println(a.bookAssento(assento));
    }
}