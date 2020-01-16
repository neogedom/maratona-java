package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.Moeda;

public class USDolar implements Moeda {
   
        @Override
        public String getSimbolo() {
            return "USD";
        }

}
