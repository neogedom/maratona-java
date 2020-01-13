package br.com.abc.javacore.ZZEconcorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolTest
 */
public class ScheduledThreadPoolTest {
    // o ScheduledExecutorService é Útil para criar tarefas agendadas
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private static void beep() {
        // Com a linha de código abaixo o Runnable vai executar uma vez a cada 5
        // segundos
        // scheduledExecutorService.schedule(Runnable, 5, TimeUnit.SECONDS)

        final Runnable beeper = new Runnable() {

            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " beep");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
           }

        
       };

       // Passando um beeper (que é Runnable) para esperar um segundo e executar a cada 5 segundos
       // quando começar
      // scheduledExecutorService.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS);

      //A diferença para o scheduleAtFixedRate é que ele considera o sleep dentro do try catch e soma
      // com os cinco segundos de delay marcados com argumento no construtor, ou seja o scheduleAtFixedRate
      // não para de contar o processamento durante o sleep e o scheduleWithFixedDelay para de contar e só 
      // começa depois de ter terminado o sleep
      final ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);

      //Cancelando depois de dez segundos
      scheduledExecutorService.schedule(new Runnable(){
      
          @Override
          public void run() {
              System.out.println("Cancelando");
              scheduledFuture.cancel(true);
              scheduledExecutorService.shutdown();
          }
      }, 10, TimeUnit.SECONDS);
       
    }

    public static void main(String[] args) {
        beep();
    }
}