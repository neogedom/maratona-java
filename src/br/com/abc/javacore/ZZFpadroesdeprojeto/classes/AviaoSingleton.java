package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * AvisaoSingleton
 * Com o atributo static final e o construtor privado, estamos tentando bloquear a criação de múltiplas
 * instâncias de uma classe, fazendo com que todas as pessoas acessem um único espaço na memória
 */
public class AviaoSingleton {

    // Inicializar diretamente aqui se chama EAGER (GULOSA) INITIALIZATION
    // ela inicializa junto com a classe, mesmo se não for usar o atributo
    //  private static final AviaoSingleton INSTANCE = new AviaoSingleton();

    // LAZY (Preguiçosa) INITIALIZATION
    // Ela inicializa apenas se for usar o atributo. Ele verifica se a instância é nula
    // no getInstance
    private static AviaoSingleton INSTANCE = new AviaoSingleton();
    private Set<String> assentosDisponiveis;


    private AviaoSingleton() {
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    // Dando acesso à instância
    public static AviaoSingleton getInstance() {
        // Lazy Initialization
        // Essa implementação não é thread-safe
        // pois há a possibilidade de, se dois clientes chegarem ao mesmo tempo,
        // a instancia vai passar no teste de nulidade e cada uma vai instanciar
        // um objeto
        // Uma forma de resolver (dolorosamente, pois apenas um cliente pode escolher assento
        // enquanto os outros devem esperar) esse problema é usar synchronized
        if (INSTANCE == null) {

            // uma forma menos dolorosa de usar o sincronismo
            // fazer um double check, fazendo o teste de nulidade duas vezes,
            // uma dela sendo sincronizada. Dessa forma, ele só vai sincronizar a classe
            // se a instância for nula
            synchronized (AviaoSingleton.class) {
                // Se a instância for realmente nula
                if (INSTANCE == null) {
                    INSTANCE = new AviaoSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public boolean bookAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }

    
}