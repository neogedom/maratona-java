package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * LinkedTransferQueue possui as mesmas características que todas essas:
 * ConcurrentLinkedQueue, SynchronousQueue e LinkedBlockingQueue
 *  Aconselha-se usar essa classe ao invés das especificadas acima pq foi adicionada depois
 * e tem um desempenho melhor, além de implementar tudo das outras
 */
public class LinkedTransferQueueTest {

    public static void main(String[] args) throws InterruptedException {

        TransferQueue <String> tq = new LinkedTransferQueue<>();
        //O LinkedTransferQueue tem uma capacidade que não precisa ser informada no construtor
        // para ver sua capacidade
        System.out.println(tq.remainingCapacity());
        //Adiciona novo elemento e retorna uma exceção se a capacidade estiver sido estourada
        System.out.println(tq.add("Vinícius"));
        // método put é daqueles que espera até que possa ser colocado (se a lista ficar disponível)
        tq.put("Jedi"); // retorna void

        //Offer retorna true se for adicionado ou falso se o limite tiver sido estourado (recomendado no lugar do add)
        System.out.println(tq.offer("Sayajin"));
        // Retorna true se for adicionado na janela de tempo especificada
        System.out.println(tq.offer("Slayer", 10, TimeUnit.MILLISECONDS));
        // Transfer bloqueia até que esse elemento seja consumido por outra thread
        // tq.transfer("Shinigami"); // retorna void, comentado pq não tem outra thread pra remover shinigami
        //tryTransfer retorna true se tiver outra thread esperando para consumir, inserindo o elemento
        // e falso se não tiver nenhuma thread esperando para consumir
        System.out.println(tq.tryTransfer("Shinigami"));
        // Versão com timeout do tryTransfer
        System.out.println(tq.tryTransfer("Shinigami", 10, TimeUnit.MILLISECONDS));

        // element pega o primeiro valor sem remover e retorna exceção se a queue estiver vazia
        // difere do peek somente pq lança exceção
        System.out.println(tq.element());

        // peek pega o primeiro valor e retorna null se a queue estiver vazia
        System.out.println(tq.peek());

        // poll pega e remove o primeiro valor, retorna null se tiver vazia
        System.out.println(tq.poll());

        //remove o primeiro valor e espera pelo tempo dado antes de retornar null se tiver vazio
        System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));
        
        //Difere do poll só pq lança uma exceção
        System.out.println(tq.remove());

        //take remove o primeiro valor ou bloqueia até que exista um elemento pronto a ser adicionado
        System.out.println(tq.take());

        
    }
}