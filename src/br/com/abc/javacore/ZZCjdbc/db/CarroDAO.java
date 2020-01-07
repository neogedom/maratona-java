package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Carro;
import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

/**
 * CarroDAO
 */
public class CarroDAO {

    public static void save(Carro carro) {
        String sql = "INSERT INTO `agencia`.`carro` (`placa`, `nome`, comprador_id) VALUES ( ? , ? , ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, carro.getPlaca());
            pstmt.setString(2, carro.getNome());
            pstmt.setInt(3, carro.getComprador().getId());
            pstmt.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`carro` WHERE (`id` = ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, carro.getId());
            pstmt.executeUpdate();
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        String sql = "UPDATE `agencia`.`carro` SET `placa` = ? , `nome` = ? WHERE (`id` = ?);\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, carro.getPlaca());
            pstmt.setString(2, carro.getNome());
            pstmt.setInt(3, carro.getId());
            pstmt.executeUpdate();
            System.out.println("Registro alterado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> selectAll() {
        String sql = "SELECT id, nome, placa, comprador_id FROM carro;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql); 
        ResultSet rs = pstmt.executeQuery();) {
            
            List<Carro> carroList = new ArrayList<>();
            while (rs.next()) {
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), CompradorDAO.searchById(rs.getInt("comprador_id"))));
            }
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Carro> searchByName(String nome) {
        String sql = "SELECT id, nome, placa, comprador_id FROM carro WHERE nome LIKE ?;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, "%"+nome+"%");
            ResultSet rs = pstmt.executeQuery();
            List<Carro> carroList = new ArrayList<>();
            while (rs.next()) {
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), CompradorDAO.searchById(rs.getInt("comprador_id"))));
   
            }
            ConexaoFactory.close(rs);
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}