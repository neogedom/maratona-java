package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ListaMembros
 */
// Tanto waits quanto notifyAll vêm do classe Object
public class ListaMembros {

    private final Queue<String> emails = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionLock = lock.newCondition();

    private boolean aberta;

    public int getEmailsPendentes() {
        lock.lock();
        try {
            return this.emails.size();
        } finally {
            lock.unlock();
        }

    }

    public boolean isAberta() {
        return aberta;
    }

    public void isAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public String obterEmailMembro() {
        String email = null;
        try {
            lock.lock();
            while (this.emails.size() == 0) {
                if (!aberta)
                    return null;
                System.out.println(
                        "Lista vazia, colocando a Thread: " + Thread.currentThread().getName() + " em modo wait");
                // ao invés do wait do objeto que está sendo compartilhado para soltar o lock
                // e colocar em modo de espera
                // chamar o método await do conditionLock
                // não confundir com o wait do conditionLock
                conditionLock.await();
            }
            email = this.emails.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return email;
    }

    // o notify notifica todas as threads que foram colocadas em wait
    public void adicionarEmailMembro(String email) {
        
            lock.lock();
            try {
                this.emails.add(email);
                System.out.println("Email adicionado à lista: ");
                System.out.println("Notificando as threads que estão em espera");

                //singalAll ao invés do notifyAll para notificar as threads sobre eventos
                // quando está sendo usado o lock da classe ReentrantLock
                conditionLock.signalAll();
            } finally {
                lock.unlock();
            }
           

    }

    public void fecharLista() {
        System.out.println("Notificando todas as threads e fechando a lista");
        aberta = false;
        synchronized (this.emails) {
            this.emails.notifyAll();

        }
    }
}