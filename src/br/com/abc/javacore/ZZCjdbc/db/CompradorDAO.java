package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

/**
 * CompradorDAO
 */
public class CompradorDAO {

    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ( ? , ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, comprador.getCpf());
            pstmt.setString(2, comprador.getNome());
            pstmt.executeUpdate();
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
        String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, comprador.getId());
            pstmt.executeUpdate();
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

        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ? , `nome` = ? WHERE (`id` = ?);\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, comprador.getCpf());
            pstmt.setString(2, comprador.getNome());
            pstmt.setInt(3, comprador.getId());
            pstmt.executeUpdate();
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "SELECT id, nome, cpf FROM comprador;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql); 
        ResultSet rs = pstmt.executeQuery();) {
            
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Comprador> searchByName(String nome) {
        String sql = "SELECT id, nome, cpf FROM comprador WHERE nome LIKE ?;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
           // Por não poder colocar o ps.setString dentro do try-resources
           //o resultSet tbm fica de fora
            pstmt.setString(1, "%"+nome+"%");
            ResultSet rs = pstmt.executeQuery();
            List<Comprador> compradorList = new ArrayList<>();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));

            }
            ConexaoFactory.close(rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}