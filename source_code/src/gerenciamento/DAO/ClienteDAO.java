package gerenciamento.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
	PreparedStatement pstmt = null;
	
	public void cadastrarCliente (String nome, String endereco, double credito_disponivel, double divida) {
		String query = "INSERT INTO Cliente (nome, endereco, credito_disponivel, divida) " +
						"VALUES (?, ?, ?, ?)";
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			
			pstmt.setString(1, nome);
			pstmt.setString(2, endereco);
			pstmt.setDouble(3, credito_disponivel);
			pstmt.setDouble(4, divida);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public ResultSet informacoesCliente (String nome) {
		String query = "SELECT * FROM CLIENTE where nome = ?";
		ResultSet informacaoCliente = null;
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			
			pstmt.setString(1, nome);
			
			informacaoCliente = pstmt.executeQuery();
			
			return informacaoCliente;
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
			return null;
		}
	}
}
