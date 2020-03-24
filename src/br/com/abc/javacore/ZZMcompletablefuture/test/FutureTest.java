package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture para realizar programação assíncrona
 * O Future mantém o processador sempre ocupado
 * Não cria outra thread para ficar esperando o resultado do processamento
 * assíncrono, então não desperdiça performance
 */
public class FutureTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        // o método submit submete uma operação para execução no pool de threads
        // e devolve um valor no futuro
        Future<Double> future = executorService.submit(new Callable<Double>() {

            @Override
            public Double call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return 2000D;
            }

        });
        enrolando();

        // método get do future para pegar o valor
        // sem argumentos ele bloqueia o sistema até você ter o resultado
        // com argumentos ele lança uma exceção quando um limite de tempo é ultrapassado
        // com argumentos ele é assíncrono
        try {
            // Double resultado = future.get(1, TimeUnit.SECONDS);
            // Double resultado = future.get(3, TimeUnit.SECONDS);

            while(!future.isDone()){ // aguarda o future receber o valor
                // mas é meio redundante, pois o get() já faz isso
                // com isso o código fica síncrono novamente
                Double resultado = future.get(); 
                System.out.println(resultado);
            }
           
        } catch (InterruptedException | ExecutionException e ) {
        //TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }

        System.out.println(soma);
    }
}