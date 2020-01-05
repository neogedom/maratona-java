package br.com.abc.javacore.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.ResultSet;

//JDBC = vem dos primórdios do Java e tem como objetivo abstrair você dos problemas de banco de dados
// Existem vários tipos de bancos de dados que podem ser usados
//A responsabilidade de criar um método que vai criar uma conexão com cada banco de dados e da empresa dona do banco de dados
//Interfaces do java.sql
//Connection (pegar a conexão), Cada empresa implementou essa interface com suas particularidades
// A implementação por parte da empresa é baixado em pacotes separados
// Statement (realizar operações que alterem o estado do banco), 
// ResultSet (executar consultas como SELECT)
// A conexão vem através de uma classe chamada DriverManager
public class ConexaoFactory {

    // Criando os métodos estáticos pq é apenas uma conexão para ser pega
    public static Connection getConexao() {
        // Precisamos de três coisas para obter uma conexão
        // Uma url, um usuário e uma senha
        // O driver manager devolve um conexão baseado na url especificada na variável
        // url
        // Para cada banco de dados, uma url diferente
        // No VSCode, editar o .classpath que fica na pasta JavaOnline inserindo um
        // classpathentry com o endereço do jdbc usando o type lib
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            // No JDBC3 era assim, no JDBC4 para frente a linha abaixo não é necessária
            // Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    // rowset = resultSet
    // rowSet é mais simples, encapsula a preparedStatement, etc. e não trabalha com
    // a interface Connection
    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    // Criando close aqui para não ter que ficar repetindo toda vez que eu precisar
    // pegar uma conexão
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Statement possui close
    public static void close(Connection connection, Statement statement) {
        close(connection);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ResultSet também possui close
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection, statement);
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(JdbcRowSet jrs) {
        try {
            if (jrs != null) {
                jrs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}