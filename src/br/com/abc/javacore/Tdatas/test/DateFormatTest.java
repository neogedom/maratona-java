package br.com.abc.javacore.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * DateFormatTest
 */

   //Existem cinco classes que serão usadas em todas as vezes que se quiser trabalhar com
       //números, datas, moedas
public class DateFormatTest {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        // Há 6 formas possiveis de formatar a data
        // Só estou criando um new pq estou usando um array. Afinal, a classe Date é abstrata
        DateFormat [] dfs = new DateFormat[6];
        //DateFormat também é uma classe abstrata, por isso
        // usar o getInstance
        dfs[0] = DateFormat.getInstance();
        dfs[1] = DateFormat.getDateInstance();
        //getDateInstance mudando o estilo
        dfs[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfs[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfs[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfs[5] = DateFormat.getDateInstance(DateFormat.FULL);

        for(DateFormat df : dfs){
            //Usa-se o método format para formatar um tipo Date e devolver para a impressão
            // no sysout
            System.out.println(df.format(c.getTime()));
        }

    }
}