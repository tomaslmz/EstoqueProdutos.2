
public class Produto {
	private int codigo;
	private String nome;
	private float preco;
	
	public Produto(int codigo, String nome, float preco) {
		setCodigo(codigo);
		setNome(nome);
		setPreco(preco);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
