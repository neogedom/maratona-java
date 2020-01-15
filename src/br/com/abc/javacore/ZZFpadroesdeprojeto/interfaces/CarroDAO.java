package br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces;

import java.util.List;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Carro;

/**
 * CarroDAO
 * É possível ainda fazer o DAO genérico, chamando a classe só de DAO
 */
public interface CarroDAO {

    void save(Carro carro);
    void delete(Carro carro);
    void update(Carro carro);
    List<Carro> selectAll();
    List<Carro> searchByName(String nome);


    
}