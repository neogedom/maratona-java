package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZAgenerics.classes.Carro;
import br.com.abc.javacore.ZZAgenerics.classes.Computador;

/**
 * ClasseGenericaTest
 */

 //Usando classes genéricas posso escolher facilmente o tipo da classe com base em objetos passados
public class ClasseGenericaTest {

    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));

        ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis<>(carrosDisponiveis);
        //Devolverá um objeto do tipo Carro, pq na classe onde tem T vai ser trocado por carro
        Carro carro = carroAlugavel.getObjetoDisponivel();
        carroAlugavel.devolverObjeto(carro);

        System.out.println("-----------------");

        List<Computador> computadoresDisponiveis = new ArrayList<>();
        computadoresDisponiveis.add(new Computador("Alienware"));
        computadoresDisponiveis.add(new Computador("HP"));

        ObjetosAlugaveis<Computador> computadorAlugavel = new ObjetosAlugaveis<>(computadoresDisponiveis);
        Computador computador = computadorAlugavel.getObjetoDisponivel();
        computadorAlugavel.devolverObjeto(computador);
    }
}

//T = Type. Com a notação T no generics declaro que espero um tipo que será definido (que será passado)
// Nas coleções utiliza E, de elemento. Fora das coleções utiliza T
class ObjetosAlugaveis <T> {

    private List<T> objetosDiponiveis = new ArrayList<>();
    //Posso ter outros atributos além do T
    // Long numero;

    public ObjetosAlugaveis(List<T> objetosDisponiveis) {
        this.objetosDiponiveis = objetosDisponiveis;
    }

    //Alugar
    public T getObjetoDisponivel() {
        T t = objetosDiponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis: " + objetosDiponiveis);
        return t;
    }

    public void devolverObjeto(T t) {
        System.out.println("Devolvendo carro: " + t);
        objetosDiponiveis.add(t);
        System.out.println("Carros disponíveis: " + objetosDiponiveis);
    }

    
}

// É possível passar dois tipos diferentes pelo Generics
class DoisAtributos<T,X> {
    T um;
    X dois;

    public DoisAtributos(T um, X dois) {
        this.um = um;
        this.dois = dois;
    }

    public T getUm() {
        return um;
    }

    public void setUm(T um) {
        this.um = um;
    }

    public X getDois() {
        return dois;
    }

    public void setDois(X dois) {
        this.dois = dois;
    }

    
    
}

