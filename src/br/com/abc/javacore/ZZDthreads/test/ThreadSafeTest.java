package br.com.abc.javacore.ZZDthreads.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ThreadSafeTest
 */
class ListaNomes {

    //synchronizedList retorna listas que são threads-safe (ou seja, que possuem seus métodos sincronizados)
    // private List<String> nomes = Collections.synchronizedList(new LinkedList<>());
    private List<String> nomes = new LinkedList<>();

    //Embora os métodos das listas sejam sincronizados, não há garantias do que acontece entre as chamadas
    // de instrução da classe ListaNomes. Então os métodos que usam as classes thread-safe também devem ser
    // syncronizados
    public synchronized void addNome(String nome) {
       
        nomes.add(nome);
    }

    public synchronized void removerPrimeiro() {
        if(nomes.size() > 0) {
             //O problema vai estar aqui, pq os métodos size() e remove() são sincronizados
             // mas o que há entre eles não
            System.out.println(nomes.remove(0));
        }
    }
}
public class ThreadSafeTest {

    public static void main(String[] args) {
        ListaNomes nome = new ListaNomes();
        nome.addNome("Vinícius Gomes");
        
        class RemovedorDeNomes extends Thread {
            public void run() {
                nome.removerPrimeiro();
            }
        }

        new RemovedorDeNomes().start();
        new RemovedorDeNomes().start();
    }
}