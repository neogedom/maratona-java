package br.com.abc.javacore.ZZGcomportamentoporparamentro.test;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.abc.javacore.ZZGcomportamentoporparamentro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparamentro.interfaces.CarroPredicate;
import br.com.abc.javacore.ZZGcomportamentoporparamentro.predicate.CarrosCorVerdePredicate;
import br.com.abc.javacore.ZZGcomportamentoporparamentro.predicate.CarrosDezAnosRecentePredicate;

/**
 * CarroTest
 * * Parametrizando comportamentos
 * Justificativa: os requisitos vão mudar
 */
public class CarroTest {

    private static List<Carro> filtrarCarroVerde(List<Carro> carros) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro: carros) {
            if (carro.getCor().equals("verde")) {
                result.add(carro);    
            }
            
        }

        return result;
    }

    private static List<Carro> filtrarCarroVermelho(List<Carro> carros) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro: carros) {
            if (carro.getCor().equals("vermelho")) {
                result.add(carro);    
            }
            
        }

        return result;
    }

    // uma saída um pouco mais elegante, embora ruim tbm

    private static List<Carro> filtrarCarroPorCor(List<Carro> carros, String cor) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro: carros) {
            if (carro.getCor().equals(cor)) {
                result.add(carro);    
            }
        }

        return result;
    }

    private static List<Carro> filtrarCarrosDezAnosFabricados(List<Carro> carros) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro: carros) {
            if (carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10)) {
                result.add(carro);    
            }
        }

        return result;
    }

    public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro: carros) {
            if (carroPredicate.test(carro)) {
                result.add(carro);
            }
            
        }

        return result;
    }

    //método usando o Predicate introduzido no Java 8 para criar o padrão Strategy
    // deixando assim o teste genérico
    public static <T> List<T> filtrar (List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    } 
    public static void main(String[] args) {
        List<Carro> carros = asList(new Carro("verde", 2011), new Carro("vermelho", 1995), new Carro("preto", 2017));
        List<Integer> numeros = asList(1, 2, 3, 4, 6, 7, 8, 9, 10);
        // o número de linhas de código aumenta exponencialmente
        // // isso é uma má prática
        // System.out.println(filtrarCarroVerde(carros));
        // System.out.println(filtrarCarroVermelho(carros));
        // System.out.println(filtrarCarroPorCor(carros, "verde"));
        // System.out.println(filtrarCarroPorCor(carros, "vermelho"));
        // System.out.println(filtrarCarrosDezAnosFabricados(carros));

        //Filtrando os carros de cor verde com predicate
        System.out.println(filtrarCarros(carros, new CarrosCorVerdePredicate()));
        // Filtrando os carros dentro dos dez anos com predicate
        System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));
        // Usando predicate com classes anônimas
        System.out.println(filtrarCarros(carros, new CarroPredicate(){
        
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("vermelho");
            }
        }));
        // Usando a classe Predicate do Java 8 para fazer testes genéricos
        System.out.println(filtrar(carros, new Predicate<Carro>(){
        
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("verde");
            }
        }));

        // Com o método genérico de filtragem em lista é possível introduzir listas
        // com elementos diferentes e indicar um comportamento diferente para o método
        // a chamada anterior pede para filtrar por carros verdes e essa pede para filtrar
        // por números inteiros
        System.out.println(filtrar(numeros, new Predicate<Integer>(){
        
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }));
    }
}