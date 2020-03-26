package br.com.abc.javacore.ZZNdatetime.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.util.Map;

/**
 * DateTimeAPI6
 */
public class DateTimeAPI6 {
    public static void main(String[] args) {
        // TOdas as zonas disponíveis no Java
        for(Map.Entry<String, String> zonas : ZoneId.SHORT_IDS.entrySet()) {
            System.out.println(zonas.getKey() + " " + zonas.getValue());
        }
        
        System.out.println("-------------------------");
        // Pegando a Zona Default
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime); 
        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        // Instant: datas para computadores
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime2 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);

        //Não sei exatamente o código da Zona, mas sei a diferença em horas do fuso
        ZoneOffset zoneOffset = ZoneOffset.of("-04:00");
        LocalDateTime dateTime2 = LocalDateTime.now();
        OffsetDateTime odt = OffsetDateTime.of(dateTime2, zoneOffset);
        System.out.println(odt);
        OffsetDateTime odt2 = dateTime2.atOffset(zoneOffset);
        System.out.println(odt2);
        Instant instant2 = Instant.now();
        System.out.println(instant2.atOffset(zoneOffset));


        // Calendário Japonês
         JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
         System.out.println(japaneseDate);
         LocalDate antigamente = LocalDate.of(1900, 2, 1);
         System.out.println(JapaneseDate.from(antigamente));
    }

    
}