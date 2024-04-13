package gerenciamento.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenteDAO {
	PreparedStatement pstmt = null;
	ResultSet resultado = null;
	
	public void cadastrarSubordinado (String nomeFuncionario) {
		String queryFuncionario = "Select id_funcionario, email from Funcionario where nome = ?";
		String queryGerente = "INSERT INTO Gerente (id_funcionario, email) values (?, ?)";
	
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(queryFuncionario);
			
			pstmt.setString(1, nomeFuncionario);
			
			resultado = pstmt.executeQuery();
			
			int idFuncionario = 0;
			
			if(resultado.next()) {
				idFuncionario = resultado.getInt("id_funcionario");
			}
			
			pstmt = ConexaoBD.conectar().prepareStatement(queryGerente);
			
			pstmt.setInt(1, idFuncionario);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public ResultSet informacoesGerente (String email) {
		String queryGerent = "Select * from Gerente join Funcionario where email = ?"; 
		
		try {
			pstmt = ConexaoBD.conectar().prepareStatement(queryGerent);
			
			resultado = pstmt.executeQuery();
			
			return resultado;
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
			return null;
		}
	}
}
