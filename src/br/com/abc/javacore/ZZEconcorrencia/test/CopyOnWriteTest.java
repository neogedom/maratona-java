package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//Uma classe imutável é final e seus atributos tbm são final e não têm nenhum modificador set
// Objetos imutáveis são por natureza thread-safe, pq os problemas de concorrência são quando
// você altera o estado de um objeto
final class Pessoa {
    private final String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

public class CopyOnWriteTest implements Runnable {

    // O objeto CopyOnWriteArrayList é parcialmente imutável (somente leitura)
    // parcialmente pq os objetos que vão dentro do array não são imutáveis
    // Ao adicionar novo elemento ou excluir elemento, o CopyOnWriteArrayList
    // (CopyOnWriteArraySet) cria outro array
    // Por isso, o CopyOnWriteArrayList não é indicado se você for fazer mais
    // add/remove do que leitura
    private List<Integer> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteTest() {
        for (int i = 0; i < 9000; i++) {
            list.add(i);
        }
    }

    @Override
    public void run() {
        Iterator<Integer> iterator = list.iterator();
        // o sleep de TimeUnit executa o sleep de uma Thread
        // Antes de inicar o while mostrando os números, dorme por 2 segundos
        // e o removedor entra em ação
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }

        // Não faça remoção nem adição usando o iterator
        // Ele tira uma snapshot da lista/set no momento em que é chamado para ser iterado
        // durante a iteração, os elementos podem mudar, pq outras threads podem acessar
        // pois as listas em CopyOnWriteArrayList não ganham lock ao serem modificadas
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + " " + iterator.next());
        }

    }

    public List<Integer> getList() {
        return list;
    }

    public static void main(String[] args) {
        CopyOnWriteTest ct = new CopyOnWriteTest();
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);
        Thread removedor = new Thread(new RemoverMembros(ct.getList()));
        t1.start();
        t2.start();
        removedor.start();
    }

    private static class RemoverMembros implements Runnable {

        private List<Integer> list;

        @Override
        public void run() {
            // TODO Auto-generated method stub

            for (int j = 0; j < 500; j++) {
                System.out.println(Thread.currentThread().getName() + " removeu " + list.remove(j));

            }
        }

        public RemoverMembros(List<Integer> list) {
            this.list = list;
        }

    }

    

}