package br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces;

import java.util.List;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Comprador;

/**
 * CompradorDAO
 * É possível ainda fazer o DAO genérico, chamando a classe só de DAO
 */
public interface CompradorDAO {

    void save(Comprador carro);
    void delete(Comprador carro);
    void update(Comprador carro);
    List<Comprador> selectAll();
    List<Comprador> searchByName(String nome);


    
}