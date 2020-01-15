package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * AviaoSingletonEnum A forma mais segura de se criar Singletons é usando enum
 * Não é possível criar um enum reflexivamente os enums são thread-safe, mas
 * seus métodos não Como diz a resposta a essa pergunta no StackOverflow, o enum
 * é thread-safe, mas seus métodos não. Como diz a resposta a essa pergunta no
 * StackOverflow, o enum é thread-safe, mas seus métodos não. Então acontece que
 * a thread-safety do singleton com enum não é tão verdadeira assim, a não ser
 * que você sincronize os métodos (e olha que nem assim dá pra garantir, por
 * causa dos casos onde o programa executa vários passos com uma única linha de
 * código, tipo i++;)
 * https://stackoverflow.com/questions/2531873/how-thread-safe-is-enum-in-java
 */
public enum AviaoSingletonEnum {

    INSTANCE;

    private Set<String> assentosDisponiveis;

    // Colocar privado em construtores de enum é redundante, pq todos os
    // construtores já vem privados
    AviaoSingletonEnum() {
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean bookAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }

    public static void agendarAssento(String assento) {

        AviaoSingletonEnum a = AviaoSingletonEnum.INSTANCE;
        System.out.println(a.bookAssento(assento));
    }

}