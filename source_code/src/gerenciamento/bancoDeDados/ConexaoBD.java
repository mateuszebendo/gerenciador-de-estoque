package gerenciamento.bancoDeDados;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class ConexaoBD {
    private String url = "jdbc:postgresql://localhost:5433/postgres";
    private String usuario = "postgres";
    private String senha = "1212";
    Statement stmt = null; 
    Connection conexao = null;
    PreparedStatement pstmt = null;
    
     public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            stmt = conexao.createStatement();
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        } 
        
    }
    
    public String conectarUsuario(String login, String senha) {
        ResultSet usuarioConectado = null;
        try {
        	String sql = "SELECT email, senha FROM postgres.public.funcionarios WHERE email = '" + login + "' AND senha = '" + senha + "';";
        	Statement stmt = conexao.createStatement();
        	usuarioConectado = stmt.executeQuery(sql);
        	
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
    
    public void cadastrarUsuario(String nome, String email, String senha) {
        try {
            String sql = "INSERT INTO postgres.public.funcionarios (nome, email, senha) "
                    + "VALUES ('" + nome + "', '" + email + "', '" + senha + "');";
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        } finally {
            // No PreparedStatement to close here
        }
    }
    
    public void fechaConexao () {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
        }
    }
}
