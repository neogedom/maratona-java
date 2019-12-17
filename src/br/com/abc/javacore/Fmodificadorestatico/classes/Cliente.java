package br.com.abc.javacore.Fmodificadorestatico.classes;

/**
 * Cliente
 */
public class Cliente {
    // Regra de inicialização:
    // 0 - Bloco de inicialização é executado quando a JVM carregar a classe
    // 1 - Alocado espaço na memória para o objeto que será criado
    // 2 - Cada atributo de classe é criado e inicializado com seus valores default ou valores explícitos
    // 3 - Bloco de inicialização é executado
    // 4 - O construtor é executado
    private static int [] parcelas;


    //Um bloco de inicialização não estático pode acessar atributos estáticos porque ele vai existir também
    // antes do método ser criado
    // Para inicializar uma variável estática, voce pode usar um bloco de inicialização estática.
    // Útil para inicializar um array com muitos valores por meio de uma estrutura de repetição
    // O bloco de inicialização estático vai ser executado apenas uma vez, pois pertence à classe e não ao objeto.
    static {
        parcelas = new int [100];
        System.out.println("Dentro do bloco de inicialização");
        for(int i = 1; i <= 100; i++) {
            parcelas[i-1] = i;
        }
    }

    public Cliente () {
     
    }

    public static int[] getParcelas ()
    {
        return parcelas;
    }
}