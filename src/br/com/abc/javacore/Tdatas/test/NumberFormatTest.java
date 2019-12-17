package br.com.abc.javacore.Tdatas.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * NumberFormat
 */
public class NumberFormatTest {

    public static void main(String[] args) {
        float valor = 123212.4567f;
        Locale locJP = new Locale("jp");
        Locale locFR = new Locale("fr");
        Locale locIT = new Locale("it");
        // NumberFormat tbm é classe abstrata e tbm está no pacote java.text
        // Assim como no Date, só posso criar um new pq estou criando um array e não um
        // objeto NumberFormat
        NumberFormat[] nfa = new NumberFormat[6];
        nfa[0] = NumberFormat.getInstance();
        // Um dos getInstance do NumberFormat pede a localização
        nfa[1] = NumberFormat.getInstance(locFR);

        // Criando instâncias de moedas no numberFormat
        nfa[2] = NumberFormat.getCurrencyInstance();
        nfa[3] = NumberFormat.getCurrencyInstance(locIT);

        // Criando instâncias de porcentagens no numberFormat
        nfa[4] = NumberFormat.getPercentInstance();
        nfa[5] = NumberFormat.getPercentInstance(locJP);

        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
        }

        // métodos úteis da NumberFormat
        NumberFormat nf = NumberFormat.getInstance();
        // Descobrir a quantidade máxima de números fracionários da classe
        System.out.println(nf.getMaximumFractionDigits());
        // Mudando o valor máximo de dígitos
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(valor));

        String valorString = "210,456";
        try {
            System.out.println(nf.parse(valorString));
            // Ao setar ParseIntegerOnly, o formatter desconsidera os decimais
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
}