package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.List;
//Coleções é todas as classes que herdam da interface Collection (Set, List e Queue) e da classe Map( que não herda de Collection)
// Existe uma interface chamada Collection e uma classe abstrata chamada Collections (que possui alguns métodos úteis)
// Existem dois tipos de coleções: ordenadas (ordered) e classificadas (sorted)
// As classes ordenadas são ordenadas de uma forma específica (por algum critério), ex.: os arrays são ordenados por índice
// As coleções têm um tipo de performance para cada uma das operações (complexidade ciclomática, um big O diferente para cada uma)
// Complexidade Big O (da complexidade ciclomática) demonstra o pior caso em termos de performance (bigocheatsheet) 
// Muitos objetos: 50 pra cima

import br.com.abc.javacore.Oexcecao.checkedexceptions.classes.Pessoa;

public class ListTest {
    public static void main(String[] args) {
        // // Um ArrayList é um array que pode crescer de tamanho "infinitamente"
        // Ou seja, sua vantagem sobre o Array é que o ArrayList cresce dinamicamente e
        // não precisa definir um tamanho explicitamente
        // List nomes = new ArrayList();
        // nomes.add("Vinícius");
        // nomes.add("IFMS");
        // // Até a versão 4 do Java adicionar elementos heterogêneos herdados de Object
        // // era possível
        // // E isso era um problema
        // nomes.add(new Pessoa());

        // // Dessa forma, tínhamos que fazer o foreach usando Object por causa da
        // // heterogeneidade
        // for (Object nome : nomes) {
        // System.out.println(nome);

        // }

        // Como era muito raro fazer listagens heterogêneas, a partir da versão 5 os
        // generics foram introduzidos nas coleções
        // List com Generics
        // List<String> nomes = new ArrayList<String>();
        // A paritir da versão 7 começou a ser possível usar a sintaxe diamond (apenas
        // no que vem depois do new)
        // Não é possível usar tipos primitivos no Generics, pq o Java faz uso dos
        // métodos equals e hashcode dos tipos Wrapper
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();        
        nomes.add("Vinícius");
        nomes.add("IFMS");
        nomes2.add("Vinícius2");
        nomes2.add("IFMS2");
        


        //Removendo por índice
        // nomes.remove(0);

        System.out.println(nomes.size());
        //Removendo por objeto
        //Ao remover pelo objeto, as Collections fazem uso do equals
        System.out.println(nomes.remove("IFMS")); //esse método retorna boolean

        //Verificando o tamanho
        System.out.println(nomes.size());

        //Adicionando outro List sem usar for
        nomes.addAll(nomes2);


        // Com Generics no ArrayList é possível usar o foreach com o tipo do objeto do
        // elemento
        // for (String nome : nomes) {
        // System.out.println(nome);

        // }

        // nomes.add("Gomes");

        for (String nome : nomes) {

        // Não é possível chamar o add() dentro de um foreach
        // Isso pq ao entrar no foreach o java já sabe o tamanho (início e fim) dele
        // alterando alguma coisa na lista dentro do foreach, eu alteraria o tamanho
        // da
        // lista
        // e o foreach perderia a referência de tamanho que ele tem
        // nomes.add("Homem");
        System.out.println(nome);
        }

        // // Mostrando o problema do add dentro de um for
        // for (int i = 0; i < nomes.size(); i++) {
        //     System.out.println(nomes.get(i));
        //     nomes.add("Goku");
        // } // Para resolver isso, só criando um int size = nomes.size() fora do for
        //   // pq o objeto de comparação contra o qual a variável i está sendo comparado
        //   // não cresce indefinidamente

        // A partir do Java 8 é possível trocar o foreach por isso
        // nomes.forEach(System.out::println);

    }
}