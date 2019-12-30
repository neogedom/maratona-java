package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * WildCardTest
 */
abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando cachorro");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando gato");
    }

}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = { new Cachorro(), new Cachorro() };
        Gato[] gatos = { new Gato(), new Gato() };
        // consultarAnimais(cachorros);
        // consultarAnimais(gatos);
        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());
        // Ao usar collections, você é obrigado a passar uma collection exatamente do
        // mesmo tipo da que se pede como argumento do método invocado
        consultarAnimaisList(cachorroList);
        consultarAnimaisList(gatoList);
        // List<Animal> animalList = new ArrayList<>();
        // consultarAnimaisList(animalList);
        
        //Dá erro em tempo de compilação pq não implementa comparable
        // ordenarLista(cachorroList);
    }

    // O argumento do tipo Animal [] pode receber Gato e Cachorro
    // Dá pra usar polimorfismo diretamento quando se está trabalhando com arrays
    public static void consultarAnimais(Animal[] animais) {
        for (Animal animal : animais) {
            animal.consulta();
        }

        // ArrayStoreException pq a JVM, quando lida com Arrays sabe o tipo do array em
        // tempo de execução, no entanto as collections não sabem
        // animais[1] = new Gato();
    }

    // Por causa do type erasure (o Java apaga qualquer rastro do generics colocado
    // ao executar)
    // esse método não aceita collections com generics diferentes
    // Wildcard (coringa) para usar o polimofismo no generics ? extends, desde que
    // você não insira nada
    // leia-se algo que estende Animal
    public static void consultarAnimaisList(List<? extends Animal> animais) {
        for (Animal animal : animais) {
            animal.consulta();
        }

        // Embora não seja possível passar outro tipo de collection como parâmetro para
        // o argumento com generic <Animal>, é possível add uma classe filha usando
        // polimorfismo
        // Se eu tento inserir alguma coisa na lista, dá um erro
        // pq não há garantia de que a lista passada corresponde ao que quero inserir
        // e em tempo de execução o Java não consegue conferir isso (por causa da
        // retrocompatibilidade com as versões anteriores do Java)
        // animais.add(new Cachorro());
        // animais.add(new Gato());

    }

    // ? super para receber parâmetros da classe Cachorro e das superclasses dela
    // leia-se algo que é classe pai de Cachorro
    public static void consultarCachorrosList(List<? super Cachorro> cachorroList) {
        // Usando a palavra cachorro há a garantia de que você inserirá cachorro
        cachorroList.add(new Cachorro());
        // Mas não dá pra adicionar animal, pq gato pode ser animal e gato não pode ser
        // adicionado
        // cachorroList.add(new Animal());
    }

    // Quando se quer testar se a classe implementa uma interface, mesmo assim se
    // usa extends
    // No caso do método abaixo, eu garanto que a lista que estou recebendo passa
    // no teste de ser comparable
    public static void ordenarLista (List <? extends Comparable> lista) {
        Collections.sort(lista);
    } 

}