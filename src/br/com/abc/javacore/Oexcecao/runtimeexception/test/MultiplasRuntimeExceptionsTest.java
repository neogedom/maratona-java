package br.com.abc.javacore.Oexcecao.runtimeexception.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * MultiplasRuntimeExceptionsTest
 */
public class MultiplasRuntimeExceptionsTest {

    public static void main(String[] args) {
       // Múltiplo tratamento de execeção para tratar várias exceções que podem vir a acontecer
       // Cada uma com um tratamento difernte
        try {
            throw new ArrayIndexOutOfBoundsException();
            // throw new IllegalArgumentException();
            //throw new ArithmeticException();
        } //catch (RuntimeException e) {
            // Usar RuntimeException é ruim aqui, pq como ela é classe pai das outras
            // teremos um problema de código que nunca será alcançado
            // Só faria sentido se esse catch do RuntimeException fosse o último catch para capturar outra 
            // exceção que tbm é filha de RuntimeException mas não é nenhuma das tratadas abaixo
            //System.out.println("Dentro do RuntimeException");
        //}
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException e) {
            System.out.println("Dentro do ArithmeticException");
        } 

        // FOi necessário pq o método criado lança duas exeções que não estão debaixo da mesma classe pai
        // Nova forma de declarar excecao depois do Java 7
        try {
            talvezLanceExcecao();
            // o | significa ou, então o catch pega SQLException ou IOException e joga para a variável e
            //Não pode colocar exceções da mesma linha de herança nesse novo multi catch (ex.: FileNotFoundException | IOException)
            // Qualquer FileNotFoundException já será tratado em IOException
            // É possível resumir a chamada de multicatch com apenas Exception e, mas isso é uma prática ruim
            // pq no Java 6 você teria que colocar multiplos blocos e pode quebrar códigos feitos nessa versão do java  
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void talvezLanceExcecao() throws SQLException, FileNotFoundException {
        
    }
}