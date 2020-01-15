package br.com.abc.javacore.ZZFpadroesdeprojeto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Carro;
import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.CarroDAO;
import br.com.abc.javacore.ZZFpadroesdeprojeto.db.CompradorDAOImpl;

/**
 * CarroDAO
 * Direct Access Object
 * DAO: Separação de responsabilidades (interface, implementação da interface, modelo)
 * Quando escrevemos o SQL direto na classe, ela se torna dependente da tecnologia (imagina se quero trocar BD por arquivo).
 * Por isso deve haver implementação de interface
 * As classes de implementação (onde vai o código SQL) devem  implementar a interface DAO
 */
public class CarroDAOImpl implements CarroDAO {

    @Override
    public void save(Carro carro) {
        final String sql = "INSERT INTO `agencia`.`carro` (`placa`, `nome`, comprador_id) VALUES ( ? , ? , ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, carro.getPlaca());
            pstmt.setString(2, carro.getNome());
            pstmt.setInt(3, carro.getComprador().getId());
            pstmt.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        final String sql = "DELETE FROM `agencia`.`carro` WHERE (`id` = ? );\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, carro.getId());
            pstmt.executeUpdate();
            System.out.println("Registro excluído com sucesso");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }

        final String sql = "UPDATE `agencia`.`carro` SET `placa` = ? , `nome` = ? WHERE (`id` = ?);\n";
        try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, carro.getPlaca());
            pstmt.setString(2, carro.getNome());
            pstmt.setInt(3, carro.getId());
            pstmt.executeUpdate();
            System.out.println("Registro alterado com sucesso");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carro> selectAll() {
        final String sql = "SELECT id, nome, placa, comprador_id FROM carro;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql); 
        ResultSet rs = pstmt.executeQuery();) {
            
            final List<Carro> carroList = new ArrayList<>();
            while (rs.next()) {
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), CompradorDAOImpl.searchById(rs.getInt("comprador_id"))));
            }
            return carroList;
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Carro> searchByName(String nome) {
        final String sql = "SELECT id, nome, placa, comprador_id FROM carro WHERE nome LIKE ?;\n";
        try (Connection conn = ConexaoFactory.getConexao(); 
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, "%"+nome+"%");
            final ResultSet rs = pstmt.executeQuery();
            final List<Carro> carroList = new ArrayList<>();
            while (rs.next()) {
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), CompradorDAOImpl.searchById(rs.getInt("comprador_id"))));
   
            }
            ConexaoFactory.close(rs);
            return carroList;
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}