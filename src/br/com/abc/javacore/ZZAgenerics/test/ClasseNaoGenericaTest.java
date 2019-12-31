package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZAgenerics.classes.Carro;
import br.com.abc.javacore.ZZAgenerics.classes.Computador;

/**
 * ClasseGenericaTest
 */
public class ClasseNaoGenericaTest {

    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.getCarroDisponivel();
        System.out.println("Usando o carro por um mês");
        carroAlugavel.devolverCarro(carroAlugado);
        System.out.println("---------------------");
        ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
        Computador computador = computadorAlugavel.getComputadorDisponivel();
        System.out.println("Usando o PC");
        computadorAlugavel.devolverComputador(computador);
    }
}

/**
rClasseGenericaTest
 */
class CarroAlugavel {

    private List<Carro> carrosDisponiveis  = new ArrayList<>();
    
    { 
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));
    } 

    //Alugar
    public Carro getCarroDisponivel() {
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando o carro: " + c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
        return c;
    }

    public void devolverCarro(Carro c) {
        System.out.println("Devolvendo carro: " + c);
        carrosDisponiveis.add(c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
    }

    
}



class ComputadorAlugavel {

    private List<Computador> computadoresDisponiveis  = new ArrayList<>();
   
    { 
        computadoresDisponiveis.add(new Computador("Alienware"));
        computadoresDisponiveis.add(new Computador("HP"));
    } 

    //Alugar
    public Computador getComputadorDisponivel() {
        Computador c = computadoresDisponiveis.remove(0);
        System.out.println("Alugando o Computador: " + c);
        System.out.println("Computadores disponíveis: " + computadoresDisponiveis);
        return c;
    }

    public void devolverComputador(Computador c) {
        System.out.println("Devolvendo Computador: " + c);
        computadoresDisponiveis.add(c);
        System.out.println("Computadores disponíveis: " + computadoresDisponiveis);
    }

    
}
