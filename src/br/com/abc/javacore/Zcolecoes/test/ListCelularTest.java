package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Celular;

public class ListCelularTest {
    public static void main (String [] args) {
        Celular celular1 = new Celular("Pocophone F1", "123456");
        Celular celular2 = new Celular("iPhone X", "852664");
        Celular celular3 = new Celular("Galaxy S10", "123896");
        //Lembre-se, trabalhar com listas orientado a interfaces
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular1);
        celulares.add(celular2);
        celulares.add(celular3);

        for (Celular celular : celulares) {
            System.out.println(celular);
        }

        //Verificar se um item já consta na lista
        // o método contains é baseado no equals
        Celular celular4 = new Celular("Xperia Z1", "123896");
        System.out.println(celulares.contains(celular4));
    }
}