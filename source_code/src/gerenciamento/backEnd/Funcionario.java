package gerenciamento.backEnd;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private String nome; 
	private String email; 
	private String senha;
	private double salario; 
	private double bonusComissao;
	List <Venda> vendas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public double getBonusComissao() {
		return bonusComissao;
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setBonusComissao(double bonusComissao) {
		this.bonusComissao = bonusComissao;
	}
	
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
}
