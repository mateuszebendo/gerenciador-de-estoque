package gerenciamento.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
	PreparedStatement pstmt = null; 
	
	public void cadastrarFuncionario (String nome, String email, String senha, double salario, double bonus_comissao) {
		String query = "INSERT INTO Funcionario (nome, email, senha, salario, bonus_comissao) "
					+ "values (?, ?, ?, ?, ?)";
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			
			pstmt.setString(1, nome);
			pstmt.setString(2, email);
			pstmt.setString(3, senha);
			pstmt.setDouble(4, salario);
			pstmt.setDouble(5, bonus_comissao);
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public ResultSet informacoesFuncionario (String nome) {
		String query = "SELECT * FROM Funcinario where nome = ?";
		ResultSet informacaoFuncionario = null;
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(query);
			
			informacaoFuncionario = pstmt.executeQuery();
			
			return informacaoFuncionario;
			
		} catch(SQLException e) {
			System.out.println("Erro: " + e);
			return null;
		}
	}
}
