package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador {
    private int contador;
    private AtomicInteger atomicInteger = new AtomicInteger();

    // Lock: tenta conseguir o lock desse bloco de código por x segundos
    // se não conseguir, continua a execução
    // melhora performance
    // O fairness (justiça) tenta entregar o lock para a thread a mais tempo
    // esperando
    // não é garantido
    // para habilitar o fairness passa true no construtor de ReentrantLock();
    // Dentro do ReentrantLock tbm há um método que possibilita encerrar uma thread
    // enquanto ela espera
    // um lock
    // É possível ver a quantidade de threads esperando pelo lock
    private Lock lock = new ReentrantLock(true);

    public void increment() {

        lock.lock(); // obtendo um lock. Usado para substituir o synchronized
        // Em performance é a mesma coisa que o sychronized
        // e o código ainda fica mais feio
        //escolha o synchronized ao lock a não ser que o problema demande coisas específicas
        // que só podem ser resolvidas pelo lock (como obter o lock de uma thread e liberar de outra)


        //liberando o lock
        // as boas práticas dizem para usar try-finally
        try {
            // Pense sempre como se uma única linha do Java
            // fosse uma instrução com mais passos
            contador++;
            // incrementa atomicamente um inteiro
            // Faz isso por meio de CAS (compare and swap)
            // CAS = atribui o valor a uma variável temporária,
            // compara ela com a variável original.
            // Se o valor for diferente, ele faz o swap
            // É muito melhor que usar o synchronized em performance
            // O problema ocorre justamente pq ele guarda numa variável temporária
            // e o valor original é alterado, então nunca dá 20000
            atomicInteger.getAndIncrement();
        } finally {
            lock.unlock();
        }
    }

    public int getContador() {
        return this.contador;
    }

    public int getAtomicInteger() {
        return this.atomicInteger.intValue();
    }
}

class IncrementadorThread extends Thread {
    private Contador contador;

    public IncrementadorThread(Contador contador) {
        this.contador = contador;
        this.start();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.increment();
        }
    }

}

public class ConcorrenciaTest {
    public static void main(String[] args) {
        Contador c = new Contador();
        IncrementadorThread it1 = new IncrementadorThread(c);
        IncrementadorThread it2 = new IncrementadorThread(c);
        // it1.start();
        // it2.start();
        try {
            it1.join();
            it2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(c.getContador());
        System.out.println(c.getAtomicInteger());

    }
}