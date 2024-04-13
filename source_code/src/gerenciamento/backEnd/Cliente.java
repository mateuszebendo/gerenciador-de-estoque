package gerenciamento.backEnd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gerenciamento.DAO.ClienteDAO;
import gerenciamento.DAO.VendaDAO;

public class Cliente {
	private String nome; 
	private String endereco; 
	private float creditoDisponivel; 
	private float divida; 
	private List <Venda> compras = new ArrayList<>();
	
	public Cliente (String nome, String endereco, float creditoDisponivel, float divida, List <Venda> compras) {
		this.nome = nome; 
		this.endereco = endereco; 
		this.creditoDisponivel = creditoDisponivel; 
		this.divida = divida;
		this.compras = compras;
	}
	
	public double verificarCredito() {
		ResultSet resultado = ClienteDAO.informacoesCliente(nome);
		double credito = 0;
		try {
		if(resultado.next()) {
			credito = resultado.getDouble("credito_disponivel");
			return credito;
		}
		} catch(SQLException e) {
			System.out.println("Erro: " + e);
		}
		return credito;
	}
	
	public List <Venda> mostrarCompras() {
		VendaDAO.informacoesVenda(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public float getCreditoDisponivel() {
		return creditoDisponivel;
	}
	
	public float getDivida() {
		return divida;
	}
	
	public List<Venda> getCompras() {
		return compras;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCreditoDisponivel(float creditoDisponivel) {
		this.creditoDisponivel = creditoDisponivel;
	}
	
	public void setDivida(float divida) {
		this.divida = divida;
	}
	
	public void setCompras(List<Venda> compras) {
		this.compras = compras;
	}
	
}
