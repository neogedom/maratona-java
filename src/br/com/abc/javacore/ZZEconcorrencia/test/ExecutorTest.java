package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ExecutorTest No Executor, a submissão das tarefas é desacoplado da execução
 * das tarefas Assim, o processador perde menos tempo organizando as threads
 */

 

class ThreadTrabalhadoraExecutor implements Runnable {
    private String num;

    public ThreadTrabalhadoraExecutor(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou: " + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " finalizou");
    }

   

 }

public class ExecutorTest {

    public static void main(String[] args) {

        //Descobrindo a quantidade de processadores
        //Geralmente cada processador pode executar duas threads paralelamente (ao mesmo tempo)
        // o resto das threads é liberando uma parcela de tempo para executar
        System.out.println(Runtime.getRuntime().availableProcessors());

        //Executor é uma interface. A classe concreta é Executors
        // O método newFixedThreadPool determina um número fixo de threads (um pool de threads)
        // O pool de threads fica vivo enquanto não der um shutdown por meio da ExecutorService
        // O número a ser determinado depende do número de cores do processador e de quantas
        // threads reais ele tem
        // ExecutorService executorService = Executors.newFixedThreadPool(4);

        // o newCachedThreadPool cria quantas threads forem necessárias
        // Se as threads forem ociosas por 60 segundos, elas são removidas do pool de threads
        // ExecutorService executorService = Executors.newCachedThreadPool();

        // o newSingleThreadExecutor retorna apenas uma thread
        // As threads que não estão sendo executadas são colocadas numa Queue sem limites
        // ao usar o newSingleThreadExecutor você não pode trocar o número de threads em tempo de execução
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //trocando o tamanho da threadPool em tempo de execução
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        // Dá pra monatar o ThreadPool baseado na quantidade de núcleos existentes na máquina
        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());

        //Tendo mais Threads pedindo execução que espaços disponíveis no ThreadPool
        // ele coloca as threads excedentes em espera e a executa apenas quando liberar
        // espaço no pool
        executorService.execute(new ThreadTrabalhadoraExecutor("1"));
        executorService.execute(new ThreadTrabalhadoraExecutor("2"));
        executorService.execute(new ThreadTrabalhadoraExecutor("3"));
        executorService.execute(new ThreadTrabalhadoraExecutor("4"));
        executorService.execute(new ThreadTrabalhadoraExecutor("5"));
        executorService.execute(new ThreadTrabalhadoraExecutor("6"));
        executorService.execute(new ThreadTrabalhadoraExecutor("7"));
        executorService.execute(new ThreadTrabalhadoraExecutor("8"));
        // Mesmo com o comando shutdown tendo sido dado, o executor só 
        // vai parar quando todas as threads terminarem de trabalhar
        executorService.shutdown();
        while(!executorService.isTerminated()) {}
        System.out.println(executorService.isTerminated());
        System.out.println("Finalizado");
    }
}