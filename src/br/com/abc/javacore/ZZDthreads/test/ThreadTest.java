package br.com.abc.javacore.ZZDthreads.test;

/**
 * ThreadTest
 */
// Thread é um objeto do Java (classe) ou uma linha de execução
// As linhas de execução são o que permite o processamento paralelo
// Em sistemas Web significa que permite que várias pessoas façam operações
// diferentes na aplicação sem ter que
// esperar umas às outras
// A JVM monta como se fosse um "sistema operacional" particular para cuidar das
// suas próprias Threads
// Tipos de threads: Daemon e User
// A JVM só finaliza sua execução quando todas as threads user são finalizadas
// Se houver threads daemon rodando, a JVM não se importa de finalizar a
// execução
// O Garbage Collector é um exemplo de thread daemon
// Não dá pra prever o scheduler de uma thread (a ordem dos acontecimentos)
// O scheduler é quem controla quando uma thread começa, quando termina...
// A única garantia que temos é a de que todas as threads serão executadas até o
// fim
// A ordem não

// Criando uma thread do jeito errado sob o ponto de vista de OO
// estendendo a classe Thread do java.lang
// em OO, o correto seria estender apenas se fosse especializar ela
class ThreadExemplo extends Thread {
    private char c;

    public ThreadExemplo(char c) {
        this.c = c;
    }

    // A mágica da thread acontece nesse método
    // Se você que um código seja executado em paralelo, você deve colocar ele
    // dentro do run
    @Override
    public void run() {
        System.out.println("Thread executada: " + Thread.currentThread().getName());

        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
        }

    }
}

// Criando uma thread do jeito certo sob o ponto de vista de OO
// implementando a interface Runnable do java.lang
class ThreadExemploRunnable implements Runnable {

    private char c;

    public ThreadExemploRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("Thread executada: " + Thread.currentThread().getName());

        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
            //Provavelmente levará a Thread do estado running de volta para o runnable
            // e dará chance para outra thread de mesma prioridade ser executada
            if(!Thread.currentThread().getName().equals("T4")) {
                Thread.yield();
            }
            try {
                //Colocar a thread para dormir por 2 segundos
                // É a única maneira de forçar uma pausa entre as threads
                // Mas você só garante que ela vai dormir, você não garante que ela
                // vai voltar depois dos 2000 milissegundos. Ela dorme por pelo menos 2000 ms
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
      
    }

}

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        //Para descobrir o nome da thread que está executando nesse momento
        System.out.println(Thread.currentThread().getName());
        //Usando o jeito errado
        // ThreadExemplo t1 = new ThreadExemplo('A');
        // ThreadExemplo t2 = new ThreadExemplo('B');
        // ThreadExemplo t3 = new ThreadExemplo('C');
        // ThreadExemplo t4 = new ThreadExemplo('D');

        // usando o jeito certo
        //T1 é o nome da Thread
        Thread t1 = new Thread(new ThreadExemploRunnable('A'), "T1");
        Thread t2 = new Thread(new ThreadExemploRunnable('B'), "T2");
        Thread t3 = new Thread(new ThreadExemploRunnable('C'), "T3");
        Thread t4 = new Thread(new ThreadExemploRunnable('D'), "T4");

        
        //Definindo que a t4 tenha maior prioridade. Na maioria (não em todas) as JVM
        // a prioridade vai de 1 a 10. Como não é possível saber qual os valores de pioridade 
        // daquela JVM (que pode ser de várias empresas) é uma boa prática usar as constantes definidas
        // na classe Thread (MAX_PRIORITY, MIN_PRIORITY e NORM_PRIORITY)
        //Na maioria dos casos (não em todos) o scheduler vai escolher primeiro a Thread que tem maior 
        // prioridade
        t4.setPriority(Thread.MAX_PRIORITY);
        //Com o run inicia a mesma thread
        // Para iniciar uma thread usa o método start
        // Para executar uma thread, chame o start e não o run
        //Embora tenhamos uma ordem no código, o start dela não é pela mesma ordem
        t1.start();
        //O método join diz para a thread main esperar até t1 ser executado pra startar a próxima thread
        t1.join();
        t2.start();
        // t3.start();
        // t4.start();

        //Uma vez que você starta uma thread, você não pode startar ela de novo 
        // (nem mesmo ressuscitar ela) Se assim o fizer, terás uma exceção

        //Estados das Threads
    // New (Colocado em new é quando o objeto é criado. Não significa que ela será executada), 
    // Runnable (ela só é considerada vida a partir daqui. Acontece quando dá o start), 
    // Running (quando executa o método run), 
    // Waiting / blocking/ sleeping (esses estados podem acontecer por vontade do desenvolvedor ou por consequência da ação de sistemas de terceiros. Quando qualquer desses estados termina, a thread volta para o Runnable e não vai para o Running), 
    // Dead (Quando ela morre, o método run() foi completado. Não dá pra ressuscitar. Se quiser, tem que criar outro objeto)

    //Antes, uma thread dizia para a outra parar, mas esses métodos estão ficando depreciados
    //Agora é a própria thread que toma a decisão de parar ou não
    
    //O método sleep pode desativar temporariamente a Thread sem precisar matá-la
    }

}