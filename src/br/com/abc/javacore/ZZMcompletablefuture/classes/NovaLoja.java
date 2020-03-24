package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Loja
 */
public class NovaLoja {

    private String nome;

    public NovaLoja(String nome) {
        this.nome = nome;
    } 

    public NovaLoja() {
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        double preco = calcularPreco();
        Desconto.Codigo codigo = Desconto.Codigo.values() [
            ThreadLocalRandom.current().nextInt(Desconto.Codigo.values().length)];
        return String.format(Locale.US, "%s:%.2f:%s", nome, preco, codigo);
    }

         

    private static void delay() {
        try {
            int delay = ThreadLocalRandom.current().nextInt(500,2000);
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double calcularPreco() {
        delay();
        //System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    public static List<NovaLoja> lojas () {
        return Arrays.asList(
            new NovaLoja("americanas"),
            new NovaLoja("casas bahia"),
            new NovaLoja("best buy"),
            new NovaLoja("amazon")

        );
    }

   

   
}