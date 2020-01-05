package br.com.abc.javacore.ZZCjdbc.classes;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

/**
 * MyRowSetListener
 */

// Classe criada para definir métodos que serão chamados todas as vezes que um
// determinado
// evento acontecer na rowSet
public class MyRowSetListener implements RowSetListener {

    // Todas as vezes que o comando execute for executado
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("Comando execute executado");

    }

    // Chamado todas as vezes que a linha for atualizada, inserida ou deletada
    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Linha atualizada, inserida ou deletada");
        // Verificando se a fonte do evento é uma RowSet. getSource devolve o objeto
        // causador do evento
        if (event.getSource() instanceof RowSet) {
            try {
                // preciso de cast, pois o getSource retorna Object
                // chamando execute aqui, garanto que o execute será chamado sempre que algo for
                // atualizado no banco de dados
                // fazendo com que o rowSet e o banco permaneçam atualizados
                // afinal, atualizar no banco de dados não reflete diretamente no rowset
                // automaticamente
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // Todas as vezes que o cursor se mover (o que pode ser muitas vezes)
    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor moveu");

    }

}