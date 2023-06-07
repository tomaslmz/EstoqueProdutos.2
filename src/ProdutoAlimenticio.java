import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ProdutoAlimenticio extends Produto {

	private Calendar dataValidade;
	
	
	public ProdutoAlimenticio(int codigo, String nome, float preco, String dataValidade) {
		super(codigo, nome, preco);
		setDataValidade(dataValidade);
	}
	
	public void setDataValidade(String dataValidade) {
		String array[] = new String[3];
		
		if(dataValidade.matches("\\d{2}/\\d{2}/\\d{4}")) {
			array = dataValidade.split("/");
			Calendar data = Calendar.getInstance();
			
			data.set(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
			
			this.dataValidade = data;
		}
	}
	
	public String getDataValidade() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "" + sdf.format(dataValidade);
	}
	
	public String getTipo() {
		return "Alimentício";
	}
}
