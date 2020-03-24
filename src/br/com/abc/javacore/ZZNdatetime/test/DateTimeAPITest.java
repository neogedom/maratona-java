package br.com.abc.javacore.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

import br.com.abc.javacore.Gassociacao.exercicios.classes.Local;

/**
 * DateTimeAPITest
 */
public class DateTimeAPITest {

    public static void main(String[] args) {
        //Criando uma data específica
        LocalDate date = LocalDate.of(2020, Month.MARCH, 24);
        // Pegando mês e ano
        System.out.println(date.getYear());
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.getMonth());
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));

        // Pega valor numérico do mês (diferente do Calendar e Date, o ano começa do 1)
        System.out.println(date.getMonthValue());
        // Pega o dia do mês
        System.out.println(date.getDayOfMonth());
        // Pega o dia da semana
        System.out.println(date.getDayOfWeek());
        // Tamamho do mês em dias
        System.out.println(date.lengthOfMonth());
        // verifica se é ano bissexto ou não
        System.out.println(date.isLeapYear());
        // Pegando a data de hoje
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
        System.out.println("----------------------------------------------------");
        // Classe para trabalhar com horas
        LocalTime time = LocalTime.of(23, 2, 15);
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        // Mínimo e máximo que se pode usar no LocalTime para pegar hora
        System.out.println(LocalTime.MAX);
        System.out.println("----------------------------------------------------");
        // Classe para trabalhar com datas e horas
        // Pegando a data e hora de agora
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        // Pegando data e hora determinada
        LocalDateTime ldt2 = LocalDateTime.of(2017, Month.APRIL, 13, 10, 55, 15);
        System.out.println(ldt2);
        // Adcionando Time a um Date
        LocalDateTime ldt3 = date.atTime(10, 20, 20);
        System.out.println(ldt3);
        LocalDateTime ldt4 = date.atTime(LocalTime.now());
        System.out.println(ldt4);
        // Adicionando Date a um Time
        // LocalDateTime ldt5 = time.atDate(2012,20,12); não aceita inteiros como parâmetros
        LocalDateTime ldt5 = time.atDate(LocalDate.now());
        System.out.println("----------------------------------------------------");
        // Parse de datas String para o formato DateTime
        LocalDate parseDate = LocalDate.parse("2020-03-24");
        LocalTime parseTime = LocalTime.parse("23:59:59");
        
        System.out.println(parseDate);
        System.out.println(parseTime);
    }
}