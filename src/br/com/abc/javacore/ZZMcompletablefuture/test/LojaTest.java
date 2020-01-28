package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Loja;

/**
 * LojaTest CompletableFuture
 */
public class LojaTest {

    public static void main(String[] args) {
        Loja americanas = new Loja();
        Loja casaBahia = new Loja();
        Loja submarino = new Loja();
        Loja wallmart = new Loja();
        long start = System.currentTimeMillis();
        // System.out.println(americanas.getPreco());
        // System.out.println(casaBahia.getPreco());
        // System.out.println(submarino.getPreco());
        // System.out.println(wallmart.getPreco());
        Future<Double> precoAsync = americanas.getPrecoArrayAsyncTunado();
        Future<Double> precoAsync1 = casaBahia.getPrecoArrayAsyncTunado();
        Future<Double> precoAsync2 = submarino.getPrecoArrayAsyncTunado();
        Future<Double> precoAsync3 = wallmart.getPrecoArrayAsyncTunado();
        long end = System.currentTimeMillis();
        System.out.println("Tempo de invocação: " + (end - start) + " ms");
        enrolando();
        
        try {
            // O método get espera, se necessário,
            // pelo resultado enviado para completar a computação
            // MAs como o resultado pode nunca vir, as boas práticas 
            // dizem que é necessário colocar argumentos setando um tempo
            // pois, independente do que aconteça, o método complete sempre
            // terá seu resultado ou o get lançará uma exceção e irá parar o 
            // programa
           System.out.println("Americanas: " +  precoAsync.get(3, TimeUnit.SECONDS));
           System.out.println("Casas Bahia: " + precoAsync1.get(3, TimeUnit.SECONDS));
           System.out.println("Submarino: " + precoAsync2.get(3, TimeUnit.SECONDS));
           System.out.println("Walmart: " + precoAsync3.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("Tempo que levou para pegar o resultado: "+ (System.currentTimeMillis() - start + " ms"));

    }

    public static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }

        System.out.println(soma);
    }
}