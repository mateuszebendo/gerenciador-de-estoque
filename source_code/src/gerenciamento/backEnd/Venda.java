package gerenciamento.backEnd;

import java.time.LocalDate;

public class Venda {
	private LocalDate data; 
	private Funcionario vendedor;
	private Cliente cliente;
	private Item item;
	private double precoTotal;
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public Funcionario getVendedor() {
		return vendedor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Item getItem() {
		return item;
	}
	
	public double getPrecoTotal() {
		return precoTotal;
	}
	
	
}
