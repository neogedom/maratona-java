package br.com.abc.javacore.ZZNdatetime.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * DateTimeAPITest2
 */
public class DateTimeAPITest2 {

    public static void main(String[] args) {
        // Instant representa um ponto no tempo utilizando nanosegundos
        // ideal para cálculo computacionais
        Instant instant = Instant.now(); 

        //T - separador entre data e hora
        //Z - zulu time (horário padrão = UTC = tempo neutro)
        System.out.println(instant);
        System.out.println(LocalDateTime.now());

        // Pega a quantidade de segundos desde o Java Epoch (01-01-1970)
        System.out.println(instant.getEpochSecond());
        //Pega o número de nanosegundos 
        System.out.println(instant.getNano());
        System.out.println(Instant.ofEpochSecond(3));

        //Ajuste em nanossegundos
        System.out.println(Instant.ofEpochSecond(3,0));
        System.out.println(Instant.ofEpochSecond(2,90_000_000));
        System.out.println(Instant.ofEpochSecond(4,-1_000_000_000));

        System.out.println("-------------------Duration ----------------------");
        //Serve para pegar tempo entre intervalo de datas
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2017, 1, 1, 16, 00, 00);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5, 0, 0);

        Duration d1 = Duration.between(dt1, dt2);
        Duration d2 = Duration.between(time1, time2);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        // Não pode misturar LocalDateTime com LocalTime
        // Duration d4 = Duration.between(dt1, time1);
        // Nem pode usar LocalDate no Duration, pois LocalDate não trabalha com horas, minutos e segundos
        // Duration d5 = Duration.between(LocalDate.now(), LocalDate.now().plusDays(20));
        Duration d6 = Duration.between(dt2, time2.atDate(dt2.toLocalDate()));
        //Criando uma duração pré determinada
        Duration d8 = Duration.ofMinutes(3);


        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d6);
        System.out.println(d8);

        System.out.println("------------------- Period ----------------------");
        //Serve para pegar tempo entre intervalo de datas de uma forma mais fácil para humanos
        // O resultado será no formato de dias, meses e anos
        Period p1 = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58);
        Period p4 = Period.ofYears(3);
       
       
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
         // Convertendo semanas em meses
        // System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())).getMonths());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));
       
        System.out.println("------------------- ChronoUnit ----------------------");
        LocalDateTime aniversario = LocalDateTime.of(1991, 5, 24, 20, 0, 0);
        System.out.println(ChronoUnit.DAYS.between(aniversario, now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now)); 
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now));
        System.out.println(ChronoUnit.YEARS.between(aniversario, now));




        
    }
}