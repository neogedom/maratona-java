package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// O ReadWriteLock trabalha com a noção de lock para escrita e lock para leitura
// o lock para escrita é crítico e enquanto uma classe escreve uma instância de objeto
// outras não podem acessá-la. No entanto, se uma classe apenas lê um objeto, não
// há problema e várias classes podem obter o lock ao mesmo tempo
// No entanto, quando aquela instância sob leitura é atualizada, todas as threads que estão
// lendo devem receber a atualização
class MapReadWrite {
    private final Map<String, String> map = new LinkedHashMap<>();

    public void put(final String key, final String value) {
        map.put(key, value);
    }

    public Object[] allKeys() {
        return map.keySet().toArray();
    }
}

public class MapReadWriteLockTest {
    private final static MapReadWrite mrw = new MapReadWrite();
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main (final String [] args) {
        Thread t1 = new Thread(new Write());
        Thread t2 = new Thread(new ReadA());
        Thread t3 = new Thread(new ReadA());
        t1.start();
        t2.start();
        t3.start();
    }

    static class Write implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                //Travando para escrita
                rwl.writeLock().lock();
                try {
                    mrw.put(String.valueOf(i), String.valueOf(i));
                } finally {
                    rwl.writeLock().unlock();
                }
            }

        }

    }

    static class ReadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                rwl.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mrw.allKeys()));
                } finally {
                    rwl.readLock().unlock();
                }
                
            }

        }

    }

    static class ReadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                rwl.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mrw.allKeys()));
                } finally {
                    rwl.readLock().unlock();
                }
                
            }

        }

    }


    
}