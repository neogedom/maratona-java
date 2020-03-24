package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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
        acharPrecos(lojas);

        // final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
        //     Thread t = new Thread(r);
        //     t.setDaemon(true);
        //     return t;
        // });

        // acharPrecosAsync(lojas, executor);

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
        .map(future -> future.thenApply(Orcamento::parse))
        // Compõe o primeiro future com mais um async para pegar os descontos
        // no momento que a primeira requisição assíncrona estiver disponível
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
}