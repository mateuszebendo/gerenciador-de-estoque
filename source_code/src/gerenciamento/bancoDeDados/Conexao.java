package gerenciamento.bancoDeDados;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class Conexao {
    private String url = "jdbc:postgresql://localhost:5432/gerenciamento";
    private String usuario = "postgres";
    private String senha = "1212";
    Connection conexao = null;
    
    public void conectar() {
        try {
            // Carrega o driver do banco de dados
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();
            ResultSet rsCliente = stmt.executeQuery("SELECT id, email from funcionario");
            while(rsCliente.next()) {
                System.out.print("ID: " + rsCliente.getString("id"));
                System.out.println("   Email: " + rsCliente.getString("email"));
            }
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        conexao.conectar();
    }
}
