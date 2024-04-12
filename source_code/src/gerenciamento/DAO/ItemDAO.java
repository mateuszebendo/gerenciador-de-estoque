package gerenciamento.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
	PreparedStatement pstmt = null; 
	
	public void cadastrarItem (String nome, int estoque, double preco_custo, double preco_venda) {
		String query = "insert into Item (nome, estoque, preco_custo, preco_venda) " 
					+ "values (?, ?, ?, ?)";
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			
			pstmt.setString(1, nome);
			pstmt.setInt(2, estoque);
			pstmt.setDouble(3, preco_custo);
			pstmt.setDouble(4, preco_venda);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public ResultSet informacoesItem (String nome) {
		String query = "select * from Item where nome = ?";
		ResultSet informacaoItem = null;
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			informacaoItem = pstmt.executeQuery();
			
			return informacaoItem;
			
		} catch (SQLException g) {
			System.out.println("Erro: " + g);
			return null;
		}
	}
}
