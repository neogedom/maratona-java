package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.Moeda;

/**
 * MoedaFactory
 * Factory: facilita a implementação abstraindo o código interno
 */
public class MoedaFactory {

    public static Moeda criarMoeda(Pais pais) {

        if(pais.equals(Pais.BRASIL)) {
            return new Real();
        } else if (pais.equals(Pais.EUA)) {
            return new USDolar();
        }

        throw new IllegalArgumentException("Não existe esse país");
        
    }
    
}