package br.com.abc.javacore.ZZJoptional.test;

import java.util.Optional;

import br.com.abc.javacore.ZZJoptional.classes.Carro;
import br.com.abc.javacore.ZZJoptional.classes.Pessoa;
import br.com.abc.javacore.ZZJoptional.classes.Seguradora;

/**
 * OptionalTest2
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        Seguradora s = new Seguradora("ACME Seguros");
        Carro c = new Carro(s, "Audi"); 
        Pessoa p = new Pessoa(c, "Carlos");
        obterNomeSeguradoraDePessoa(Optional.ofNullable(p));
        //System.out.println(obterNomeSeguradoraOptional(s));
        checarNomeSeguradora(s);
        checarNomeSeguradoraOptional(s);
        p.setIdade(19);
        System.out.println(obterNomeSeguradoraComIdade(p, 18));
        System.out.println(stringToInt("A"));
    }

    // public static String obterNomeSeguradoraOptional (Seguradora seguradora) {
    //     //flatMap() ao invés de map para pegar o valor da String e não um Optional de uma
    //     // String
    //     System.out.println(Optional.ofNullable(seguradora).flatMap(Seguradora::getNome));
    //     return "";
    // }

    public static String obterNomeSeguradoraDePessoa (Optional<Pessoa> pessoa) {
       return pessoa.flatMap(Pessoa::getCarro)
                        .flatMap(Carro::getSeguradora)
                        .map(Seguradora::getNome) // Como o getNome retorna String e não Optional  usar map()
                        .orElse("Não existe seguradora"); // orElse para retornar o valor dentro do Optional retornado por map()
        
    }


    public static String obterNomeSeguradora(Seguradora seguradora) {
        String nome = null;
        if(seguradora.getNome() != null) {
            // nome = seguradora.getNome();
        }

        return nome;
    }

    // Imprimir se contém um determinado valor dentro de seguradora
    private static void checarNomeSeguradora(Seguradora seguradora) {
        if(seguradora.getNome() != null && seguradora.getNome().equals("ACME Seguros")) {
            System.out.println("é da ACME");
        }

    }

    private static void checarNomeSeguradoraOptional (Seguradora seguradora) {
        // o filter recebe um Predicate para testar se existe algum valor dentro do 
        // Optional
        // o ifPresent recebe um Consumer para executar um trecho de código e retornar
        // void, se há um valor presente depois de passar pelo filtro
        Optional<Seguradora> seguradoraOptional = Optional.ofNullable(seguradora);
        seguradoraOptional.filter(s -> s.getNome().equals("ACME Seguros"))
                        .ifPresent(x -> {System.out.println("é a ACME");});;
    }

    //Optional para fazer teste de idade (retorna o nome da seguradora apenas se a idade
    // for acima de um limite especificado)
    private static String obterNomeSeguradoraComIdade(Pessoa p, int idadeMinima) {
       return Optional.ofNullable(p).filter(pessoa -> pessoa.getIdade() >= idadeMinima)
                            .flatMap(Pessoa::getCarro)
                            .flatMap(Carro::getSeguradora)
                            .map(Seguradora::getNome)
                            .orElse("Não existe seguradora ou a idade mínima não foi atingida");
    }

    //Evita lançar exceção e retorna Optional.empty
    // dá pra criar uma classe utilitária com vários optionals para resolver problemas comuns
    private static Optional<Integer> stringToInt(String numero) {
       try {
       return Optional.of(Integer.parseInt(numero));
       } catch (Exception e) {
           return Optional.empty();
       }
        
    }
}