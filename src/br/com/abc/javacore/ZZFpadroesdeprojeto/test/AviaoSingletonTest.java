package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingleton;

/**
 * AviaoSingletonTest
 */
public class AviaoSingletonTest {

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        agendarAssento("1A");
        agendarAssento("1A");

        //Infringindo a regra do singleton ao criar duas instâncias mesmo com o construtor privado
        AviaoSingleton aviaoSingleton = AviaoSingleton.getInstance();
        AviaoSingleton aviaoSingleton2 = null;
        // o getDeclaredConstructor retorna um array dos construtores da classe
        Constructor [] constructors = AviaoSingleton.class.getDeclaredConstructors();

        for (Constructor constructor: constructors) {
            //torna o construtor acessível
            constructor.setAccessible(true);
            //chama o construtor 
            aviaoSingleton2 = (AviaoSingleton) constructor.newInstance();
            break;
        }

        //Verificando os hashcodes para confirmar que são objetos diferentes
        System.out.println(aviaoSingleton.hashCode());
        System.out.println(aviaoSingleton2.hashCode());


    }


    public static void agendarAssento(String assento) {

        //Agora, pegamos a instância de apenas um avião
        AviaoSingleton a = AviaoSingleton.getInstance();
        System.out.println(a.bookAssento(assento));
    }
}