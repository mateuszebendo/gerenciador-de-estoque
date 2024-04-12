package gerenciamento.DAO;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class ConexaoBD {
    static private String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.digweqngemctuqxdxymi&password=c4iX4zanot1!";
    static Connection conexao = null;
    
     public static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            return conexao = DriverManager.getConnection(url);
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado");
            return null;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
            return null;
        } 
        
    }
    
    public static void fechaConexao () {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
        }
    }
}
