package gerenciamento.DAO;

import java.time.LocalDate;

public class VendaDAO {
	PreparedStatement pstmt = null; 
	ResultSet resultado = null; 
	
	public void cadastrarVenda (LocalDate data, int idVendedor, int idCliente, int idItem, double precoTotal) {
		String query = "INSERT INTO Venda (data, id_vendedor, id_cliente, id_item, preco_total) "
						+ ""
	}
}
