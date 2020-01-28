package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Loja
 */
public class Loja {

    private String nome;

    
    public double getPreco() {
        // Vai pegar o preço onde Judas perdeu as botas
        return calcularPreco();
    }

    public Future<Double> getPrecoArrayAsync() {
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        new Thread(() -> {
            // Há um problema com exceções ao usar o CompletableFuture
            // Se uma exceção é lançada, o complete nunca é executado
            // QUando não se tem acesso ao código para colocar o tempo de espera
            // antes de lançar exceção no método get, pode-se usar um try-catch
            // com o método completeExceptionally sendo chamado no catch
            try{precoFuturo.complete(calcularPreco()); }
            catch (Exception e) {
                precoFuturo.completeExceptionally(e);
            }
            
        }).start();

        return precoFuturo;
    }

    public Future<Double> getPrecoArrayAsyncTunado() {
        // Uma maneira menos verbosa de se criar um completableFuture
        // todo o código de getPrecoArrayAsync foi substituído pela linha abaixo
        return CompletableFuture.supplyAsync(this::calcularPreco);
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public double calcularPreco() {
        delay();
        //System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    public Loja(String nome) {
        this.nome = nome;
    }

    public Loja() {
    }

    public String getNome() {
        return nome;
    }

}