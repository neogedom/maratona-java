package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CallableTest é o Runnable com retorno Usamos generics para determinar o tipo
 * de retorno do método call (substituto do run)
 */
public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {

        // Duas formas de pegar números aleatórios: Math.random() e a classe abaixo
        // Usando o ThreadLocalRandom para ambientes concorrentes, pq é sincronizado
        // e cada thread tem seu número aleatório gerado pra ela
        // não sofrendo com problemas de lock
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + " executando...");
        }
        return "Trabalho finalizado, o número aleatório é: " + count;
    }

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        // É uma boa ideia evitar usar o wait, sleep, etc. que interferem na execução
        // das Threads
        // quando estiver usando algum Executor
        ExecutorService executorService = Executors.newCachedThreadPool();

        // executando o callable, chamar o método submit do executor
        Future<String> resultFuture = executorService.submit(callableTest);
        // Future espera pela computação do valor. O get bloqueia a thread e espera pelo
        // resultado
        try {
            String s = resultFuture.get(); 
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
           e.printStackTrace();
        }

        executorService.shutdown();

       
    }

    
}