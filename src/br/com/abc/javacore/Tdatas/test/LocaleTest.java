package br.com.abc.javacore.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * LocaleTest
 */
public class LocaleTest {

    public static void main(String[] args) {
        // Você passa a língua ou a língua e o país para o construtor da classe Locale
        // Ele segue o padrão da ISO 639 (pt - português, br - Brasil, en - inglês, us - EUA)
        Locale locItaly = new Locale("it", "IT");
        Locale locSuica = new Locale("it", "CH");
        Locale locIndia = new Locale("hi", "IN");
        Locale locJapao = new Locale("ja");
        Calendar c = Calendar.getInstance();
        // os meses vão de 0 a 11
        //criando uma data qualquer
        //c.set(2015, Calendar.DECEMBER, 23);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locSuica);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, locJapao);
        System.out.println(df.format(c.getTime()));
        System.out.println(df2.format(c.getTime()));
        System.out.println(df3.format(c.getTime()));
        System.out.println(df4.format(c.getTime()));

        //Métodos úteis da classe Locale
        //Mostrando na língua do sistema onde está rodando a classe
        System.out.println(locItaly.getDisplayLanguage());

        //Posso passar a língua em que quero que apareço também
        System.out.println(locJapao.getDisplayLanguage(locJapao));

        System.out.println(locSuica.getDisplayCountry(locSuica));
    }
}