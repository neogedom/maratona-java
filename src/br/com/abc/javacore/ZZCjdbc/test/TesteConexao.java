package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDBOLD;

import java.sql.SQLException;
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
        // CompradorDBOLD.selectMetadata();
        // CompradorDBOLD.checkDriverStatus();
        // CompradorDBOLD.testTypeScroll();
        // CompradorDBOLD.updateNomesToLowerCase();

        // Perigo: SQLInjection
        // System.out.println(CompradorDBOLD.searchByNamePreparedStatement("oao' or
        // 'X'='X"));
        // X = X elimina todo o where
        // O PreparedStatement não deixa colocar o apóstrofo e ao invés de colocar o
        // parâmetro, troca por um
        // wildcard ?
        // System.out.println(CompradorDBOLD.searchByNamePreparedStatement("oao"));
        // CompradorDBOLD.updatePreparedStatement(new Comprador(1, "011.011.011-01",
        // "Prepared Statement da Silva"));
        // System.out.println(CompradorDBOLD.searchByNameCallableStatement("ao"));
        // System.out.println(CompradorDBOLD.searchByNameRowSet("oao"));
        // CompradorDBOLD.updateRowSet(new Comprador(1, "011.011.011-01", "Row Set de
        // Oliveira"));
        // Não deu certo por causa do autocommit
        // CompradorDBOLD.updateRowSetCached(new Comprador(1, "011.011.011-01", "Row Set de
        // Oliveira"));
        // try {
        //     CompradorDBOLD.saveTransaction();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
       

    }

    public static void inserir() {
        Comprador comprador = new Comprador("111.111.111-11", "Priscila");
        CompradorDBOLD.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDBOLD.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador(1, "000.000.000-11", "MARIA");
        CompradorDBOLD.update(comprador);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDBOLD.selectAll();
    }

    public static List<Comprador> listarPorNome(String nome) {
        return CompradorDBOLD.searchByName(nome);
    }
}