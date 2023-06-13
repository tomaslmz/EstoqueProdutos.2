package model;

public class Produto {
	private String nome;
	private float preco;
	private int estoque;
	
	public Produto(String nome, float preco, int estoque) {
		setEstoque(estoque);
		setNome(nome);
		setPreco(preco);
	}
	
	public Produto() {
		setEstoque(0);
	}
	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
