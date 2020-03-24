package br.com.abc.javacore.ZZMcompletablefuture.classes;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Desconto.Codigo;

/**
 * Orcamento
 */
public class Orcamento {

    private final String nomeLoja;
    private final double preco;
    private final Desconto.Codigo codigoDeCodigo;

    public Orcamento(String nomeLoja, double preco, Codigo codigoDeCodigo) {
        this.nomeLoja = nomeLoja;
        this.preco = preco;
        this.codigoDeCodigo = codigoDeCodigo;
    }

    public static Orcamento parse(String s) {
       
        String [] split = s.split(":");
        String nomeLoja = split[0];
        double preco = Double.parseDouble(split[1]);
        Desconto.Codigo codigoDesconto = Desconto.Codigo.valueOf(split[2]);
        return new Orcamento(nomeLoja, preco, codigoDesconto);
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getPreco() {
        return preco;
    }

    public Desconto.Codigo getCodigoDeCodigo() {
        return codigoDeCodigo;
    }

    
   
}