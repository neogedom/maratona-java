package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;

class Contador {
    private int contador;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void increment() {
        //Pense sempre como se uma única linha do Java 
        // fosse uma instrução com mais passos
        contador++;
        //incrementa atomicamente um inteiro
        //Faz isso por meio de CAS (compare and swap)
        // CAS = atribui o valor a uma variável temporária, 
        // compara ela com a variável original.
        // Se o valor for diferente, ele faz o swap
        // É muito melhor que usar o synchronized em performance
        // O problema ocorre justamente pq ele guarda numa variável temporária
        // e o valor original é alterado, então nunca dá 20000
        atomicInteger.getAndIncrement();
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