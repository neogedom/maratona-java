package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.Moeda;

public class Real implements Moeda {

    @Override
    public String getSimbolo() {
       return "R$";
    }

}
