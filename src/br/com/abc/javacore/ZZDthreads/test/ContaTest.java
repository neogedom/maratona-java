package br.com.abc.javacore.ZZDthreads.test;

import br.com.abc.javacore.ZZDthreads.classes.Conta;

/**
 * ContaTest
 */
public class ContaTest implements Runnable {
    private final Conta conta = new Conta();

    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest();
        Thread vinicius = new Thread(contaTest, "Vinícius");
        Thread william = new Thread(contaTest, "Willian");
        vinicius.start();
        william.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            saque(10);
            if (conta.getSaldo() < 0) {
                System.out.println("Oh, meu Deus!");
            }
        }
    }

    // Há um problema. Vinícius e William verificam o valor e reconhecem que há dez
    // reais na conta
    // portanto a condição do if se torna verdadeira e os dois vão sacar. Mas
    // acontece que um deles
    // irá sacar primeiro e retirar os dez reais e o outro irá sacar tbm, mas os dez
    // reais já foram
    // retirados
    // Para resolver esse problema, as transações na Thread devem ser atômicas (uma
    // thread deve lançar
    // um lock quando estiver acessando o valor). Isso chamamos de sincronismo de
    // código
    // Para tornar o método indivisível, é necessário que ele tenha na assinatura
    // private synchronized
    // Nesse caso, o primeiro que pega o código dá um lock e o outro só pode acessar
    // o código
    // quando o lock for liberado
    private void saque(int valor) {

        // sincronizando blocos de código
        // é bom que a variável (endereço de memória) que está submetida ao sincronismo
        // seja final, para que não seja possível atribuir nenhum outro objeto pra ela
        synchronized (conta) {
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar");
                // Ainda que haja pausas na thread, sendo sincronizada, a outra só poderá
                // acessar
                // quando esta terminar a execução do código
                try {
                    // sleep() não solta o lock
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                conta.saque(valor);
                System.out.println(Thread.currentThread().getName() + " completou o saque, saldo: " + conta.getSaldo());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: "
                        + conta.getSaldo());
            }
        }
    }

    //Usar synchronized em métodos estáticos é como se eu estivesse
    // sincronizando a classe inteira assim synchronized(ContaTest.class) {}
    public static synchronized void imprime() {
        
    }
}