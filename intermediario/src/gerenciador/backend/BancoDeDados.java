package gerenciador.backend;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class BancoDeDados {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres";
    private String senha = "1212";
    
    public void conectarBanco() {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)){
            System.out.println("Conexão bem-sucedida");

            Statement statement = conexao.createStatement();

            String sql = "SELECT * from quizzes_empresas.public.funcionario";

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                System.out.println("ID: " + id + ", Nome: " + nome);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        bd.conectarBanco();
    }
}
