package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

/**
 * CompradorDB
 */
public class CompradorDB {

    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '"
                + comprador.getNome() + "');\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            // - Para mudar o estado do banco de dados, usar executeUpdate que retorna a
            // quantidade de linhas alteradas (int)
            // - Se não tiver certeza de qual instrução SQL virá, usar execute que retorna
            // true caso tenha algum resultSet e false caso tenha apenas alterado o estado
            // do banco
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = '" + comprador.getId() + "');\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '"
                + comprador.getNome() + "' WHERE (`id` = '" + comprador.getId() + "');\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        // É uma boa prática não usar o * para que seja possível lembrar quais atributos
        // na hora de chamar o resultSet
        String sql = "SELECT id, nome, cpf FROM comprador;\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            // - Se você quiser fazer uma consulta que terá vários resultados, usar o
            // executeQuery que retorna um resultSet
            ResultSet rs = stmt.executeQuery(sql);
            // O resultSet retorna uma lista
            List<Comprador> compradorList = new ArrayList<>();
            // Para andar no resultSet, use next(). O resultSet sempre aponta para antes do
            // primeiro
            // registro no começo. O next() avança para o próximo registro
            while (rs.next()) {
                // O java converte o tipo do banco de dados para o tipo mais próximo no java
                // cuidado com o TimeStamp, Time e o Date, pois eles são do pacote java.sql e
                // não
                // java.util. Se ele não tiver um tipo específico, retorna Object
                // o getInt() recebe o nome da coluna ou a posição dela partindo do 1 ( e não do
                // 0)
                // System.out.println(rs.getInt(1));
                // System.out.println(rs.getString("nome"));
                // System.out.println(rs.getString(3));

                // Cada vez que iterarmos sobre o resultSet, cada novo elemento da lista é um
                // novo objeto
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Comprador> searchByName(String nome) {
        String sql = "SELECT id, nome, cpf FROM comprador WHERE nome LIKE '%" + nome + "%';\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Suponha que você que você está realizando uma consulta, mas não tem poder
    // sobre o SQL que está executando
    // Nisso, os metadados podem ser úteis
    public static void selectMetadata() {
        String sql = "SELECT * FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Pegando os metadados do resultSet
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // Movendo o cursor para a primeira posição
            // Para navegar por cada registro, use o while
            rs.next();
            int qtdColunas = resultSetMetaData.getColumnCount();
            System.out.println("Quantidade Coluna: " + qtdColunas);

            // Lembrando que o resultSet começa do 1, então i = 1
            // cada i se refere a uma coluna daquele registro do resultSet
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("Tabela: " + resultSetMetaData.getTableName(i));
                System.out.println("Nome coluna: " + resultSetMetaData.getColumnName(i));
                System.out.println("Tamanho da coluna: " + resultSetMetaData.getColumnDisplaySize(i));
            }

            ConexaoFactory.close(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void checkDriverStatus() {
        Connection conn = ConexaoFactory.getConexao();
        try {
            // Pegando os metadados não do resultSet, mas da conexão
            // Constantes do ResultSet TYPE_FOWARD, TYPE_SCROLL_INSENSITIVE e TYPE_SENSITIVE
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            // Se o driver suporta apenas ir do início e ir até o final sem poder voltar
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                // Se o driver suporta a atualização do registro com o resultSet aberto ou se o
                // transforma em somente leitura
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");
                }

            }

            // Se o driver suporta deixar o registro do resultSet inalterado mesmo que haja alterações no banco de dados
            // O resultSet cacheado na memória
            // O resultSet pode ir para frente e para trás ou acessar alguma posição em particular
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                // Se o driver suporta a atualização do registro com o resultSet aberto ou se o
                // transforma em somente leitura
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");
            
                }
            }

            // Se o driver suporta replicar qualquer alteração do estado do banco de dados no resultSet automaticamente
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                // Se o driver suporta a atualização do registro com o resultSet aberto ou se o
                // transforma em somente leitura
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");
            
                }
            }

            ConexaoFactory.close(conn);
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }
}