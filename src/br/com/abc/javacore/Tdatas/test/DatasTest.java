package br.com.abc.javacore.Tdatas.test;

import java.util.Calendar;
import java.util.Date;

public class DatasTest {
     //A classe Date foi a primeira classe do java a trabalhar com datas
        // do pacote java.util
        // Como ela não era muito boa para trabalhar com internacionalização, 
        // foi desenvolvida a classe Calendar que durou até a versão 7
        // A partir do java 8 foi criado o pacote Time
        // Na classe Date quase todos os métodos são obsoletos (deprecated)
    public static void main (String args []){
       
        //Criando uma data. Não confunda o Date do java.util com o Date do java.sql
        //Os construtores que recebem ano, mês e dia estão obsoletos
        // A data é armazenada em milissegundos
        // Pegando a data atual é só criar o objeto
        Date date = new Date();
        System.out.println(date);

        //Para descobrir o valor em milissegundos desde 1970
        System.out.println(date.getTime());
        //Com o date para adicionar hora, segundos, dias, etc. tinha que fazer isso por meio de milissegundos
        // A partir do Java 7 é possível separar os números com underline como se fossem os pontos
        // 1_234_567_890_000L
        //Adicionando 1 hora
        date.setTime(date.getTime() + 3_600_000);
        System.out.println(date);

        //Usando o Calendar, substituto do Date que não é bom pra internacionalização nem pra 
        //operações com tempo
        //O Calendar é uma classe abstrata, portanto não é possível instanciá-la diretamente
        // Para pegar um objeto da classe Calendar, usa-se o método getInstance
        Calendar c = Calendar.getInstance();

        //Nas américas, usamos o calendário gregoriano
        System.out.println(c);

        //Para transformar um date de um código legado em Calendar 
        //c.setTime(date);
        System.out.println(c);

        //Verificando se domingo é o primeiro dia da semana (na França é segunda)
        if (Calendar.SUNDAY == c.getFirstDayOfWeek()) {
            System.out.println("Domingo é o primeiro dia da semana");
        }

        //Pegando o dia da mês, da semana e do ano
        //O método get recebe constantes. Se você colocar o valor int (5)
        // Você trará problemas semânticos para manutenibilidade
       System.out.println(c.get(Calendar.DAY_OF_MONTH));
       System.out.println(c.get(Calendar.DAY_OF_WEEK));
       System.out.println(c.get(Calendar.DAY_OF_YEAR));

       //Adicionar uma hora. Os argumentos são o campo (passado por meio da constante)
       // e a quantidade
       c.add(Calendar.HOUR, 24);

       //Se eu quiser alterar somente o campo que estou trabalhando sem alterar os outros
       //c.add(Calendar.MONTH, 2);
       // uso o roll ao invés do add
       c.roll(Calendar.MONTH, 2);

       //Transformar o Calendar em Date (O getTime do Calendar retorna um Date)
       Date date2 = c.getTime();
       System.out.println(date2);
        

    }
}