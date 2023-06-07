import java.util.ArrayList;

public class ProdutoVestuario extends Produto {

	private Tamanhos tamanho;
	
	
	public ProdutoVestuario(int codigo, String nome, float preco, Tamanhos tamanho) {
		super(codigo, nome, preco);
		setTamanho(tamanho);
	}
	
	public void setTamanho(Tamanhos tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getTamanho() {
		if(tamanho == Tamanhos.N) {
			return "Não definido";
		} else if(tamanho == Tamanhos.P) {
			return "P";
		} else if(tamanho == Tamanhos.M) {
			return "M";
		} else if(tamanho == Tamanhos.G) {
			return "G";
		} else {
			return "GG";
		}
	}
	
	public String getTipo() {
		return "Alimentício";
	}
}
