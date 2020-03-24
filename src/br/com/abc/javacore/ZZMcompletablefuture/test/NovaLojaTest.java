package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Desconto;
import br.com.abc.javacore.ZZMcompletablefuture.classes.NovaLoja;
import br.com.abc.javacore.ZZMcompletablefuture.classes.Orcamento;

/**
 * NovaLojaTest
 */
public class NovaLojaTest {

    public static void main(String[] args) {
        List<NovaLoja> lojas = NovaLoja.lojas();
        // lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
        //acharPrecos(lojas);

        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

       // acharPrecosAsync(lojas, executor);
       long start = System.currentTimeMillis();
       CompletableFuture [] completableFuture = acharPrecosStream(lojas, executor)
                .map(f -> f.thenAccept(s -> System.out.println(s + "( finalizado em: " + 
                    (System.currentTimeMillis() - start + " ) "))))
                .toArray(CompletableFuture[]::new);

       // Recebe um array de CompletableFutures
       // Retorna um CompletableFuture que é completado quando todos os CompletableFuture dados são completados
      // CompletableFuture.allOf(completableFuture).join();
      // anyOf retorna quando um dos CompletabkeFuture dados é completado. Útil para pegar apenas a resposta do serviço
      // mais rápido
       CompletableFuture.anyOf(completableFuture).join();
       System.out.println("Todas as lojas responderam em: " + (System.currentTimeMillis() - start + " ms"));

    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println(" Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream().map(NovaLoja::getPreco).map(Orcamento::parse)
                .map(Desconto::calcularDesconto).collect(Collectors.toList());

        System.out.println("Tempo total: " + (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }


// Encadeando chamadas síncronas e assíncronas 
    private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
        System.out.println(" Completable Future Async");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> completableFutures = lojas.stream()
        // Pegando o preço original de forma assíncrona
        .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
        // Transforma a string em um Orçamento no momento em que ele se torna disponível
        // Uso thenApply quando tenho um processamento síncrono na sequência
        .map(future -> future.thenApply(Orcamento::parse))
        // Compõe o primeiro future com mais um async para pegar os descontos
        // no momento que a primeira requisição assíncrona estiver disponível
        // Uso thenCompose quando tenho um processamento assíncrono na sequência
        .map(future -> future.thenCompose(orcamento -> 
        CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
            .collect(Collectors.toList());

        // espera todos os futures no stream finalizarem para terem seus resultados extraídos
        List<String> collect = completableFutures.stream()
            .map(CompletableFuture::join).collect(Collectors.toList());
        
        System.out.println("Tempo total: " + (System.currentTimeMillis() - start + " ms"));
        System.out.println(collect);
        return collect;
    }

    private static Stream<CompletableFuture<String>> acharPrecosStream(List<NovaLoja> lojas, Executor executor) {
        System.out.println(" Completable Future Async Stream");
        long start = System.currentTimeMillis();
        Stream<CompletableFuture<String>> completableFutureStream = lojas.stream()
        .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
         .map(future -> future.thenApply(Orcamento::parse))
          .map(future -> future.thenCompose(orcamento -> 
                CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)));

        
        System.out.println("Tempo total: " + (System.currentTimeMillis() - start + " ms"));
        return completableFutureStream;
    }
}