package br.com.abc.javacore.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public Connection getConexao() {
        // Precisamos de três coisas para obter uma conexão
        // Uma url, um usuário e uma senha
        // O driver manager devolve um conexão baseado na url especificada na variável
        // url
        // Para cada banco de dados, uma url diferente
        // No VSCode, editar o .classpath que fica na pasta JavaOnline inserindo um classpathentry com o endereço do jdbc usando o type lib
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            //No JDBC3 era assim, no JDBC4 para frente a linha abaixo não é necessária
           //  Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}