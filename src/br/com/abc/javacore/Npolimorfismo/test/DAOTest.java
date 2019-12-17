package br.com.abc.javacore.Npolimorfismo.test;

import br.com.abc.javacore.Npolimorfismo.classes.DatabaseDAOImpl;
import br.com.abc.javacore.Npolimorfismo.classes.GenericDAO;

/**
 * DAOTest
 */
public class DAOTest {

    public static void main(String[] args) {

        // Na programação orientada a interfaces, crio uma interface genérica e escolho posteriormente
        // qual será o objeto
        // Assim fica fácil trocar a implementação (objeto depois do new) se não estivermos satisfeitos com algo
        // (ex.: não estamos satisfeitos com o desempenho)
        // Isso é útil em projetos com muitas classes, pois gera facilidade na manutenção
        GenericDAO genericDAO = new DatabaseDAOImpl();    
        genericDAO.save();
    }
}