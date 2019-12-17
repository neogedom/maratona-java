package br.com.abc.javacore.Sstrings.test;

//Pensar em performance das strings desde o começo faz o seu sistema escalável
// Imagina o sistema nível facebook
public class StringPerformanceTest {
    public static void main (final String args []) {
       long inicio = System.currentTimeMillis();
       concatString(30000);
       long fim = System.currentTimeMillis();
       System.out.println("Tempo usado: " + (fim - inicio) + " ms");

       inicio = System.currentTimeMillis();
       concatStringBuilder(1000000);
        fim = System.currentTimeMillis();
       System.out.println("Tempo usado com StringBuilder " + (fim - inicio) + " ms");

       inicio = System.currentTimeMillis();
       concatStringBuffer(1000000);
        fim = System.currentTimeMillis();
       System.out.println("Tempo usado com StringBuffer " + (fim - inicio) + " ms");
    }
    
    //Lembre-se: todas as vezes que o for adicionar um novo valor i à string, será criada uma nova String
    // afinal Strings são imutáveis no java
    public static void concatString(final int tam) {
        String string = "";
        for (int i = 0; i < tam; i++) {
            string += i;
        }
    }

    //StringBuilder e StringBuffer são a mesma classe com a diferença de que a StringBuffer
    //possui os métodos sincronizados, protegidos contra o acesso de múltiplas threads no mesmo 
    // método. Portanto o StringBuffer é usado em ambientes multi thread

    //Em questão de performance, o StringBuilder vai ser mais rápido pq não tem que se preocupar de
    // proteger os métodos em ambientes multi thread
    public static void concatStringBuilder (final int tam) {
        final StringBuilder stringBuilder = new StringBuilder(tam);
        for (int i = 0; i < tam; i++) {
            stringBuilder.append(i);
        }
    }


    public static void concatStringBuffer (final int tam) {
        final StringBuffer stringBuffer = new StringBuffer(tam);
        for (int i = 0; i < tam; i++) {
            stringBuffer.append(i);
        }
    }
}