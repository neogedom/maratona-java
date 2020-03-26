package br.com.abc.javacore.ZZNdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * DateTimeAPITest5
 */
public class DateTimeAPITest5 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        // Formatando LocalDate em String
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // Convertendo String em LocalDate
        String s4 = "20200326"; // o formatador padrão do LocalDate.parse() não aceita esse formato, para usá-lo deve-se
                                // informar qual DateTimeFormatter representa esse formato
        String s5 = "2020-03-26";
        String s6 = "2020-03-26+03:00";
        
       
        System.out.println(LocalDate.parse(s4, DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println( LocalDate.parse(s5));
        System.out.println(LocalDate.parse(s6, DateTimeFormatter.ISO_DATE));

        // Formatando DateTime em String
        LocalDateTime dateTime = LocalDateTime.now();
        String s7 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s7);
        System.out.println(LocalDateTime.parse("2020-03-26T14:27:53.101")); // O padrão é ISO_DATE_TIME

        // Colocando no formato brasileiro
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDate.parse("20/03/2020", formatterBR));
        System.out.println(date.format(formatterBR));

        // Colocando o nome do mês em extenso para francês
        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
        System.out.println(LocalDate.now().format(formatterFR));
        System.out.println(LocalDate.parse("26.mars.2020", formatterFR));
    }
}