package gerenciamento.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
	static PreparedStatement pstmt = null;
	
	static public String conectarUsuario(String login, String senha) {
        ResultSet usuarioConectado = null;
        try {
        	String query = "SELECT email, senha FROM Funcionario WHERE email = ? and senha = ?";
        	pstmt = ConexaoBD.conectar().prepareStatement(query);
        	
        	pstmt.setString(1, login);
        	pstmt.setString(2, senha);
        	
        	usuarioConectado = pstmt.executeQuery();
        	
            if (usuarioConectado.next()) {
                String email = usuarioConectado.getString("email");
                String senhaRegistrada = usuarioConectado.getString("senha");
                return email+senhaRegistrada;
            } else {
            	String usuarioNaoEncontrado = "Usuário não encontrado";
                return usuarioNaoEncontrado;
            }
        } catch (SQLException e) {
        	String erro = "Erro ao conectar usuário: " + e.getMessage();
            return erro;
        }
    }
    
	static public void cadastrarUsuario(String nome, String email, String senha) {
        try {
            String query = "INSERT INTO Funcionario (nome, email, senha) "
                    + "VALUES (?, ?, ?);";
  
            pstmt = ConexaoBD.conectar().prepareStatement(query);
            
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setString(3, senha);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        } 
    }
	
	public static void main(String[] args) {
		UsuarioDAO usuario = new UsuarioDAO();
		
		System.out.println(usuario.conectarUsuario("luiz.miele@hotmail.com", "1212"));
	}
}
