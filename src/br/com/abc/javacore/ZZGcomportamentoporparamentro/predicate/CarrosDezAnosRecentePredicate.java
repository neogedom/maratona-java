package br.com.abc.javacore.ZZGcomportamentoporparamentro.predicate;

import java.util.Calendar;

import br.com.abc.javacore.ZZGcomportamentoporparamentro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparamentro.interfaces.CarroPredicate;

/**
 * CarrosDezAnosRecentePredicate
 */
public class CarrosDezAnosRecentePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        // TODO Auto-generated method stub
        return carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10);
    }

    
}