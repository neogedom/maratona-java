package br.com.abc.javacore.ZZGcomportamentoporparamentro.predicate;

import br.com.abc.javacore.ZZGcomportamentoporparamentro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparamentro.interfaces.CarroPredicate;

/**
 * CarrosCorVerdePredicate
 * Uma classe especializada em um teste de verificação para a cor verde
 */
public class CarrosCorVerdePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getCor().equals("verde");

    }

    
}