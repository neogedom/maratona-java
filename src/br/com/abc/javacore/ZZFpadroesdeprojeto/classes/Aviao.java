package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * Aviao
 * Classe com o problema a ser resolvido pelo Singleton
 */
public class Aviao {

    private Set<String> assentosDisponiveis;

    
    public Aviao() {
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean bookAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }

	public Set<String> getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(Set<String> assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}

    
}