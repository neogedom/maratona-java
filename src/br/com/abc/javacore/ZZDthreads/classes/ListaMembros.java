package br.com.abc.javacore.ZZDthreads.classes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ListaMembros
 */
//Tanto waits quanto notifyAll vêm do classe Object
public class ListaMembros {

    private final Queue<String> emails = new LinkedList<>();
    private boolean aberta;

    public int getEmailsPendentes(){
        synchronized (emails) {
            return this.emails.size();
        }
    }

    public boolean isAberta() {
        return aberta;
    }

    public void isAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public String obterEmailMembro(){
        String email = null;
        try {

            //USar o lock ou wait sempre em contexto sincronizado

            synchronized (this.emails) {
                while(this.emails.size() == 0) {
                    if (!aberta) return null;
                    System.out.println("Lista vazia, colocando a Thread: " + Thread.currentThread().getName() + " em modo wait");
                    //o wait coloca a thread em espera, aguardando qualquer sinal vindo de notify
                    this.emails.wait();
                }
                email = this.emails.poll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email;
    }

    //o notify notifica todas as threads que foram colocadas em wait
    public void adicionarEmailMembro(String email) {
        synchronized (this.emails) {
            this.emails.add(email);
            System.out.println("Email adicionado à lista: ");
            System.out.println("Notificando as threads que estão em espera");
            //O notifyAll notifica todas as threads que estão esperando
            // use ele sempre (ao invés do notify), pois você não sabe quantas threads estão esperando
            // as threads avisadas saem do estado blocked e voltam pro estado runnable
            this.emails.notifyAll();
            
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