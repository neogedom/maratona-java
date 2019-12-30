package br.com.abc.javacore.Zcolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * QueueTest
 */
// Ordena todos os elementos que forem colocados dentro do Queue
// É uma lista de prioridade, onde você define a prioridade
// A queue usa FIFO (primeiro a entrar, primeiro a sair)
public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        System.out.println(queue);
        // Métodos peek (pega o primeiro elemento e não remove),
        // offer, add um elemento dentro de um tamanho predefinido, desde que esse
        // tamanho não esteja estourado, se estiver estourado, devolve false (mesma
        // coisa que add, mas não lança exceção)
        // poll (pega o primeiro elemento e remove),
        // remove (retira o elemento da cabeça da fila, com argumento remove o elemento passado)
    }
}
