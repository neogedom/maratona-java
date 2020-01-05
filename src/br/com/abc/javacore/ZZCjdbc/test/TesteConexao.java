package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDB;
import java.util.List;

/**
 * TesteConexao
 */
public class TesteConexao {

    public static void main(String[] args) {
        // inserir();
        // deletar();
        // atualizar();
        // List<Comprador> compradorList = selecionarTudo();
        // List<Comprador> compradorList2 = listarPorNome("oão");
        
        // System.out.println(compradorList2);
        // CompradorDB.selectMetadata();
        // CompradorDB.checkDriverStatus();
        // CompradorDB.testTypeScroll();
        // CompradorDB.updateNomesToLowerCase();
        
        //Perigo: SQLInjection
        // System.out.println(CompradorDB.searchByNamePreparedStatement("oao' or 'X'='X"));
        // X = X elimina todo o where
        //O PreparedStatement não deixa colocar o apóstrofo e ao invés de colocar o parâmetro, troca por um
        // wildcard ?
        // System.out.println(CompradorDB.searchByNamePreparedStatement("oao"));
        // CompradorDB.updatePreparedStatement(new Comprador(1, "011.011.011-01", "Prepared Statement da Silva"));
        // System.out.println(CompradorDB.searchByNameCallableStatement("ao"));
        System.out.println(CompradorDB.searchByNameRowSet("oao"));
        // CompradorDB.updateRowSet(new Comprador(1, "011.011.011-01", "Row Set de Oliveira"));
       

    }

    public static void inserir() {
        Comprador comprador = new Comprador("111.111.111-11", "Priscila");
        CompradorDB.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDB.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador(1, "000.000.000-11", "MARIA");
        CompradorDB.update(comprador);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDB.selectAll();
    }

    public static List<Comprador> listarPorNome(String nome) {
        return CompradorDB.searchByName(nome);
    }
}