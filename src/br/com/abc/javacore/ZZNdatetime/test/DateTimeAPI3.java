package br.com.abc.javacore.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * DateTimeAPI3
 */
public class DateTimeAPI3 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, Month.FEBRUARY, 25);
        System.out.println(localDate);
        // Mudar o ano, no entando tome cuidado pois o localDate é imutável(thread-safe)
        LocalDate localDate1 = localDate.withYear(2020);
        System.out.println(localDate);
        System.out.println(localDate1);
        // Mudar o mês
        localDate = localDate.withMonth(Month.AUGUST.getValue());
        System.out.println(localDate);
        // Mudar o dia do mês
        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);
        localDate = localDate.with(ChronoField.DAY_OF_MONTH, 15);
        System.out.println(localDate);
        // Adicionando 2 meses ao mês vigente de forma relativa
        localDate = localDate.plusMonths(2);
        System.out.println(localDate);
        localDate = localDate.plus(2, ChronoUnit.MONTHS);
        System.out.println(localDate);

        //Adicionando 2 meses e tirando 20 dias
        localDate = localDate.plusMonths(2).minusDays(6);
        System.out.println(localDate);

        //Operações com o Time
        LocalTime localTime = LocalTime.now();
        localTime = localTime.withHour(10);
        System.out.println(localTime);
        localTime = localTime.plusHours(3).minusMinutes(10);
        System.out.println(localTime);
    }
}