package gerenciamento.backEnd;

public class Item {
	private String nome;
	private int estoque; 
	private float precoCusto;
	private float precoVenda;
	
	public String getNome() {
		return nome;
	}
	public int getEstoque() {
		return estoque;
	}
	public float getPrecoCusto() {
		return precoCusto;
	}
	public float getPrecoVenda() {
		return precoVenda;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	
}
