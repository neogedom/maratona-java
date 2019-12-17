package br.com.abc.javacore.Tdatas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//Criando formatação de datas personalizadas
public class SimpleDateFormatTest {
    public static void main (String [] args) {
        Calendar c = Calendar.getInstance();
        
        // Os parâmetros passíveis de serem passados para a SimpleDateFormat() seguem um padrão
        // que pode ser visto na documentação
        // Tudo o que estiver em aspas simples é desconsiderado do padrão da tabela da documentação
        // havendo o 'às' o Java ignora e não tenta converter para am e pm
       // String mascara = "yyyy.MM.dd G 'às' HH:mm:ss z";

       String mascara = "'Formosa,' dd 'de' MMMM 'de' YYYY";
        //Diferente de outros formatadores, a SimpleDateFormat não é abstrata
        SimpleDateFormat formatador = new SimpleDateFormat(mascara);

        //Formatando a data de Calendar c
        // O formatador não retorna Calendar, nem Date. Ele retorna String
        System.out.println(formatador.format(c.getTime()));
    }
}