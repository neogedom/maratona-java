package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.classes.MyRowSetListener;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

/**
 * CompradorDB
 */
public class CompradorDBOLD {

    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '"
                + comprador.getNome() + "');\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement crs = conn.createStatement();
            // - Para mudar o estado do banco de dados, usar executeUpdate que retorna a
            // quantidade de linhas alteradas (int)
            // - Se não tiver certeza de qual instrução SQL virá, usar execute que retorna
            // true caso tenha algum resultSet e false caso tenha apenas alterado o estado
            // do banco
            crs.executeUpdate(sql);
            ConexaoFactory.close(conn, crs);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransaction() throws SQLException {
        String sql1 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES (' TESTE1', ' TESTE1');\n";
        String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES (' TESTE2', ' TESTE2');\n";
        String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES (' TESTE3', ' TESTE3');\n";
        Connection conn = ConexaoFactory.getConexao();
        // Para usar um savepoint, inicialize-o
        Savepoint savepoint = null;
        try {
            // Primeira coisa a se fazer para iniciar uma transação é colocar o autocommit
            // como falso
            conn.setAutoCommit(false);
            Statement crs = conn.createStatement();
            // - Para mudar o estado do banco de dados, usar executeUpdate que retorna a
            // quantidade de linhas alteradas (int)
            // - Se não tiver certeza de qual instrução SQL virá, usar execute que retorna
            // true caso tenha algum resultSet e false caso tenha apenas alterado o estado
            // do banco
            crs.executeUpdate(sql1);
            savepoint = conn.setSavepoint("One"); // usado para salvar um ponto na transação que deverá ser comitado
                                                  // mesmo se
            // a transação der errado. Não é obrigado passar nome no construtor
            // Apenas tome cuidado, pq alguns drivers não suportam muitos savepoints
            // por meio do DataBaseMetaData é possível ver se o driver suporta savepoint
            // Caso o driver do banco de dados só suporte um você pode reaproveitar o savepoint assim:
            // conn.releaseSavepoint(savepoint);

            if (true)
                throw new SQLException();
            crs.executeUpdate(sql2);
            crs.executeUpdate(sql3);

            // Para confirmar as alterações no estado do banco de dados
            conn.commit();
            // Caso formos continuar usando a conexão é importante voltá-la para true
            // mas se estivermos fechando a conexão, não tem problema deixar como false
            // conn.setAutoCommit(true);
            ConexaoFactory.close(conn, crs);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            // Quando se trabalha com transações no try é importante dar rollback no catch
            // É possível dar rollback até algum savepoint definido
            conn.rollback(savepoint);
            // Se eu voltar, é preciso que eu commite
            conn.commit();
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
            Statement crs = conn.createStatement();
            crs.executeUpdate(sql);
            ConexaoFactory.close(conn, crs);
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
            Statement crs = conn.createStatement();
            crs.executeUpdate(sql);
            ConexaoFactory.close(conn, crs);
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
            Statement crs = conn.createStatement();
            // - Se você quiser fazer uma consulta que terá vários resultados, usar o
            // executeQuery que retorna um resultSet
            ResultSet rs = crs.executeQuery(sql);
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
            ConexaoFactory.close(conn, crs, rs);
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
            Statement crs = conn.createStatement();
            ResultSet rs = crs.executeQuery(sql);
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(conn, crs, rs);
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
            Statement crs = conn.createStatement();
            ResultSet rs = crs.executeQuery(sql);
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

            ConexaoFactory.close(conn, crs, rs);

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
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");
                }

            }

            // Se o driver suporta deixar o registro do resultSet inalterado mesmo que haja
            // alterações no banco de dados
            // O resultSet cacheado na memória
            // O resultSet pode ir para frente e para trás ou acessar alguma posição em
            // particular
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                // Se o driver suporta a atualização do registro com o resultSet aberto ou se o
                // transforma em somente leitura
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");

                }
            }

            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("Também suporta CONCUR_UPDATABLE");

                }
            }

            ConexaoFactory.close(conn);
        } catch (SQLException e) {
        }
    }

    public static void testTypeScroll() {
        String sql = "SELECT id, nome, cpf FROM comprador;\n";
        Connection conn = ConexaoFactory.getConexao();
        try {
            // O correto é sempre definir no createStatement o que o resultSet será
            // Para informar o que o driver suporta
            // Em alguns bancos nem sequer funciona se não definir o tipo do resultSet
            Statement crs = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = crs.executeQuery(sql);

            // O que dá pra fazer com TYPE_SCROLL_INSENSITIVE
            // 1 - Ir direto para a última linha do select
            if (rs.last()) {

                System.out.println(
                        "Última linha " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
                System.out.println("Número da última linha " + rs.getRow());
            }
            // 2 - Ir direto para a primeira linha do select
            System.out.println("Retornou para a primeira linha? " + rs.first());
            System.out.println("Primeira linha " + rs.getRow());

            // 3 - Ir direto para a linha informada
            rs.absolute(4);
            System.out.println("Linha 4 " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            // 4 - Ir para alguma outra linha baseado na linha atual
            // Se voltarmos mais do que existe no resultSet (por exemplo, -5), ele dá um
            // erro em tempo de execução
            rs.relative(-1);
            System.out.println("Linha 3 " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            // 5 - Conferir se é a última linha (ou se já passou dela com isAfterLast(), ou
            // se já passou da primeira com isBeforeFirst())
            System.out.println(rs.isLast());
            System.out.println(rs.isFirst());
            System.out.println(rs.isAfterLast());
            System.out.println(rs.isBeforeFirst());

            // 6 - Iterar na forma inversa com previous()
            rs.afterLast();
            System.out.println("------------------------------");
            while (rs.previous()) {
                System.out.println(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(conn, crs, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fazendo updates por meio do ResultSet
    // Isso deixa os DBAs loucos
    public static void updateNomesToLowerCase() {

        String sql = "SELECT id, nome, cpf FROM comprador;\n";
        Connection conn = ConexaoFactory.getConexao();

        try {
            // DatabaseMetaData databaseMetaData = conn.getMetaData();
            // É importante marcar como Concur_UPDATABLE para dar certo a operação de update
            // pelo ResultSet
            Statement crs = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = crs.executeQuery(sql);

            // //Dá para detectar alterações no estado do BD por meio do
            // Mas depende do driver
            // System.out.println(databaseMetaData.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            // System.out.println(databaseMetaData.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            // System.out.println(databaseMetaData.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

            // ALTERANDO POR MEIO DO RESULTSET
            if (rs.next()) {
                // A atualização do registro é no resultSet, não no banco de dados
                // dois parâmetros: o label da coluna e o valor desejado
                // É possível ser usado para realizar operações e cálculos complicados e alterar
                // posteriormente no BD
                rs.updateString("nome", rs.getString("nome").toUpperCase());
                // Caso queira cancelar alguma atualização, a documentação não recomenda usar o
                // updateString() de novo
                // Nesse caso, usa-se o cancelUpdates()
                // O cancelRowUpdates() não pode ser chamado depois do updateRow() (não adianta
                // nada)
                // Atualizando no banco de dados
                rs.updateRow();
                // rowUpdated confere se a coluna foi atualizada
                // depende do driver
                // if (rs.rowUpdated()) {
                // System.out.println("Linha atualizada");
                // }
            }

            // INSERINDO POR MEIO DO RESULTSET
            // rs.absolute(2);
            // String nome = rs.getString("nome");
            // // Move o cursor para uma linha temporária onde não há valores
            // rs.moveToInsertRow();
            // // System.out.println(nome);
            // // System.out.println(rs.getString("nome"));
            // rs.updateString("nome", nome.toUpperCase());
            // rs.updateString("cpf", "999.999.999-99");
            // //insertRow para inserir nova linha depois de ter alterado ela no resultSet
            // rs.insertRow();
            // // Move para a linha que estava antes de mudar para a InsertRow
            // rs.moveToCurrentRow();
            // System.out.println(rs.getString("nome") + " row: " + rs.getRow());

            // DELETANDO POR MEIO DO RESULTSET
            rs.absolute(7);
            rs.deleteRow();

            // Será que depois de ter feito o update acima, o resultSet permance o mesmo?
            // rs.beforeFirst();
            // while (rs.next()) {
            // System.out.println(rs.getString("nome"));
            // }

            ConexaoFactory.close(conn, crs, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // PreparedStatement, filha de Statement, útil para quando se necessita de
    // performance
    // O PreparedStatement pré-compila o sql (que iria ser checado em termos de
    // sintaxe e plano
    // de execução)
    public static List<Comprador> searchByNamePreparedStatement(String nome) {
        String sql = "SELECT id, nome, cpf FROM comprador WHERE nome LIKE ?";
        Connection conn = ConexaoFactory.getConexao();
        try {
            // com PreparedStatement, primeiro preparamos o statement trocando os wildcards
            PreparedStatement crs = conn.prepareStatement(sql);
            crs.setString(1, "%" + nome + "%");
            // Ao usar o PreparedStatement, o executeQuery não recebe parâmetro
            ResultSet rs = crs.executeQuery();
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(conn, crs, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE (`id` = ?)";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement crs = conn.prepareStatement(sql);
            crs.setString(1, comprador.getCpf());
            crs.setString(2, comprador.getNome());
            crs.setInt(3, comprador.getId());
            crs.executeUpdate();
            ConexaoFactory.close(conn, crs);
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CallableStatement estendida da PreparedStatement e permite executar
    // Procedures no Banco de Dados
    public static List<Comprador> searchByNameCallableStatement(String nome) {
        String sql = "CALL `agencia`.`SP_getCompradoresPorNome`( ? );";
        Connection conn = ConexaoFactory.getConexao();
        try {
            CallableStatement crs = conn.prepareCall(sql);
            crs.setString(1, "%" + nome + "%");
            ResultSet rs = crs.executeQuery();
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(conn, crs, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // RowSet usa outro tipo de conexão. Não é Connection
    public static List<Comprador> searchByNameRowSet(String nome) {
        String sql = "SELECT id, nome, cpf FROM comprador WHERE nome LIKE ?";
        JdbcRowSet crs = ConexaoFactory.getRowSetConnection();

        // Adicionando um Listener para capturar os eventos que acontecerem no RowSet
        crs.addRowSetListener(new MyRowSetListener());
        try {
            // com rowSet o PreparedStatement não existe
            // PreparedStatement crs = conn.prepareStatement(sql);
            // Ao invés disso, usa o setCommand
            crs.setCommand(sql);
            crs.setString(1, "%" + nome + "%");
            // Ao usar o RowSet, se usa o execute ao invés de executeQuery
            crs.execute();
            List<Comprador> compradorList = new ArrayList<>();

            // com o RowSet, não é necessário nenhum resultSet. Está tudo já dentro do
            // JDBCRowSet
            while (crs.next()) {
                compradorList.add(new Comprador(crs.getInt("id"), crs.getString("cpf"), crs.getString("nome")));

            }
            ConexaoFactory.close(crs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Uma grande diferença entre o rowSet e o resultSet é que no primeiro não é
    // possível fazer insert e update direto no banco de dados
    // para isso, deve ser utilizar a estratégia do scroll_insensitive (alterando no
    // rowset e depois persistindo as alterações no banco)
    public static void updateRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        // Como fazer pra dar update? 1 - cria um sql de consulta
        String sql = "SELECT * FROM comprador WHERE id = ?";
        // String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE
        // (`id` = ?)";

        JdbcRowSet crs = ConexaoFactory.getRowSetConnection(); // JdbcRowSet é um rowSet conectado que dá pra fazer
                                                               // coisas em paralelo no banco de dados
        // Adicionando um Listener para capturar os eventos que acontecerem no RowSet
        crs.addRowSetListener(new MyRowSetListener());

        try {
            // Lembre-se, ao invés do preparedStatement, usar o setCommand
            crs.setCommand(sql);
            // crs.setString(1, comprador.getCpf());
            // crs.setString(2, comprador.getNome());
            crs.setInt(1, comprador.getId());
            crs.execute();

            // 2 - acessa os dados que vieram dentro do rowSet, anda com next
            crs.next();
            // 3 - atualiza a String dentro do rowSet (como no SCROLL_INSENSITIVE)
            crs.updateString("nome", "VINICIUS");
            // 4- Atualiza a linha inteira no banco de dados
            crs.updateRow();
            ConexaoFactory.close(crs);
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRowSetCached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        String sql = "SELECT * FROM comprador WHERE id = ?";

        CachedRowSet crs = ConexaoFactory.getRowSetConnectionCached(); // CachedRowSet é um rowSet desconectado que dá
                                                                       // pra fazer
        // coisas no banco de dados em cache

        try {
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();

            crs.next();
            crs.updateString("nome", "VVV");
            crs.updateRow();
            // acceptChages para mandar as alterações realizadas em cache para o banco de
            // dados
            crs.acceptChanges();

            // Por estar trabalhando com o chached, ele automaticamente fecha a conexão
            // não preciso fechar explicitamente
            // ConexaoFactory.close(crs);
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
