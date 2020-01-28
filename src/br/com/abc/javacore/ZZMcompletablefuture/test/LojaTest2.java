package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Loja;

import static java.util.Arrays.asList;

/**
 * LojaTest2
 */
public class LojaTest2 {

    
    public static void main(String[] args) {
        List<Loja> lojas =  asList(
            new Loja("americanas"), 
            new Loja("submarino"), 
            new Loja("amazon"), 
            new Loja("walmart"));
        acharPrecos(lojas);
        acharPrecos2(lojas);
        acharPrecos3(lojas);
        acharPrecos4(lojas);
        //Use o executor com stream quando não estiver esperando dados da rede ou do HD
        // nesses casos, usar CompletableFuture é melhor
        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        acharPrecos4(lojas, executor);

    }   

    //Usando Stream Sequencial
    private static List<String> acharPrecos(List<Loja> lojas) {
        System.out.println(" Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream().map(loja -> String.format("%s o preco é : %.2f", loja.getNome(), loja.getPreco()))
                    .collect(Collectors.toList());

        System.out.println("Tempo total: "+ (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }

    //Usando Stream paralelo
    private static List<String> acharPrecos2(List<Loja> lojas) {
        System.out.println(" Stream paralelo");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.parallelStream().map(loja -> String.format("%s o preco é : %.2f", loja.getNome(), loja.getPreco()))
                    .collect(Collectors.toList());

        System.out.println("Tempo total: "+ (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }

    //Usando COmpletable Future Sequecial
    private static List<String> acharPrecos3(List<Loja> lojas) {
        System.out.println("Completable Future Sequencial");
        long start = System.currentTimeMillis();
        
        List<String> collect = lojas.stream()
                    .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é : %.2f", loja.getNome(), loja.getPreco()) // faz a invocação 
                    )).map(CompletableFuture::join) // join faz a mesma coisa que o get, só que não retorna exceção. Recebe a invocação
                    .collect(Collectors.toList());

         System.out.println("Tempo total: "+ (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos4(List<Loja> lojas) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();
        
        //Quebrando o CompletableFuture em dois. Invocação e recepção do resultado
        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                    .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é : %.2f", loja.getNome(), loja.getPreco()) // faz a invocação 
                    )).collect(Collectors.toList());
        
        System.out.println("Tempo de invocação: "+ (System.currentTimeMillis() - start + " ms"));
        
        List<String> collect = precoFuturo.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("Tempo total: "+ (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos4(List<Loja> lojas, Executor executor) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();
        
        //Quebrando o CompletableFuture em dois. Invocação e recepção do resultado
        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                    .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é : %.2f", loja.getNome(), loja.getPreco()),
                        executor)).collect(Collectors.toList());
        
        System.out.println("Tempo de invocação: "+ (System.currentTimeMillis() - start + " ms"));
        
        List<String> collect = precoFuturo.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("Tempo total: "+ (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }
}

//Fórmula para descobrir número de threads
// NumeroDeThreads = Ncpu * Ucpu * (1+W/C)
// Ncpu = nº de cores disponíveis (Runtime.getRuntime.avaliableProcessors())
// Ucpu = utilização da CPU (se quiser usar 100% da CPU coloca 1, se quiser 50% coloca 0.5)
//W/C = Wait time e Compute time (quanto tempo esperando e quanto tempo computando)
// Nthreads = 8 * 1 * (1 + 99) = 800 threads
