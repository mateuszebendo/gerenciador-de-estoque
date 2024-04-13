package gerenciamento.backEnd;

public class Produtos {
	private String nome; 
	private String descricao; 
	private float precoUnitario;
	
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	
}
