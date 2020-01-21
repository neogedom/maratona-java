package br.com.abc.javacore.ZZJoptional.classes2;

import br.com.abc.javacore.ZZJoptional.classes2.Seguradora;

/**
 * Carro
 */
public class Carro {

    private Seguradora seguradora;
    private String nome;

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Como faríamos para pegar o nome de uma seguradora
    // por meio da pessoa que locou o carro sem o Optional
    // a quantidade de if para testar nulidade foi grande  
    // além disso, estamos afirmando que a seguradora sempre
    // terá um nome (regra de negócio não explícita)
    public String getNomeSeguradora(Pessoa pessoa) {
        if (pessoa != null) {
            Carro carro = pessoa.getCarro();
            if( carro != null) {
                Seguradora s = carro.getSeguradora();
                if (s != null) {
                    return s.getNome();
                }
            }
        }
        return "";
    }

    
}