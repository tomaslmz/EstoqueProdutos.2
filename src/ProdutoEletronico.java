import java.util.ArrayList;

import model.Produto;

public class ProdutoEletronico extends Produto {
	
	private String marca;
	
	
	public ProdutoEletronico(int codigo, String nome, float preco, String marca) {
		super(codigo, nome, preco);
		setMarca(marca);
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}

}
