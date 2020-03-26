package br.com.abc.javacore.ZZNdatetime.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import br.com.abc.javacore.ZZNdatetime.test.util.ObterProximoDiaUtil;

/**
 * DateTimeAPITest4
 */
public class DateTimeAPITest4 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());
        // Indo para a próxima quinta feira (ou, se hoje é quinta, ficará na data de hoje)
        localDate = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());

         // Indo para a próxima quinta feira, independente se hoje é quinta feira
         localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
         System.out.println(localDate);
         System.out.println(localDate.getDayOfWeek());

          // Indo para a quinta feira anterior (ou, se hoje é quinta, ficará na data de hoje)
        localDate = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());


        // Indo para a quinta feira anterior, independente se hoje é quinta feira
        localDate = localDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());


        // Para saber o primeiro dia do mês
        localDate = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());

        // Para saber o último dia do mês
        localDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());

        // Para saber o primeiro dia do próximo ano
        localDate = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());

        localDate = localDate.with(new ObterProximoDiaUtil());
        System.out.println(localDate);

    }
}