package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

/**
 * TesteConexao
 */
public class TesteConexao {

    public static void main(String[] args) {
        ConexaoFactory conexaoFactory = new ConexaoFactory();
        conexaoFactory.getConexao();
    }
}