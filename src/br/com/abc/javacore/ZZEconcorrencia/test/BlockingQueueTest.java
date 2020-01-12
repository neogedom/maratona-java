package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Operações de produtor e consumidor, onde uma thread produz dados e outra consome
// os dados são passados de uma thread para a outra
// enquanto os dados estão sendo passados, a thread fica bloqueada

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // É necessária definir a capacidade da blocking queue durante a instanciação
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        Thread t1 = new Thread(new RemoveFromQueue(bq));
        bq.put("Vinícius"); // Lança InterruptedException pois trabalha bloqueando threads
        System.out.println(bq.peek()); // peek pega o valor mas não remove o valor da cabeça da queue
        System.out.println("Tentando colocar outro valor");
        t1.start();
        // Ao tentar colocar um novo valor nessa queue que tem capacidade um, ela vai
        // ficar esperando
        // alguma thread chegar e remover o valor que já tem lá dentro para conseguir
        // inserir esse valor
        // que estou tentando colocar agora
        bq.put("Bla bla bla bla bla");
        System.out.println("Inserido o último valor");
        System.out.println(bq);
    }

    static class RemoveFromQueue implements Runnable {
        BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " entrando em espera por dez segundos");
            try {
                TimeUnit.SECONDS.sleep(10);
                //take obtém e remove o valor
                System.out.println("Removendo o valor " + bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

		
    }

    //BlockingQueues especiais:
    // SynchronousQueue - ela tem a capacidade 0 e ao ser criada,
    // na primeira vez que tentar inserir ou remover, ela fica em espera até que outra thread
    // faça a operação oposta
    // DelayQueue - útil quando se tem objetos que não devem ser consumidos antes de uma determinada
    // quantidade de tempo
    
}