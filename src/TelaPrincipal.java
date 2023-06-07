import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
//	Declaração das listas
	public static ArrayList<ProdutoAlimenticio> produtosAli = new ArrayList<ProdutoAlimenticio>();
	public static ArrayList<ProdutoVestuario> produtosVest = new ArrayList<ProdutoVestuario>();
	public static ArrayList<ProdutoEletronico> produtoEle = new ArrayList<ProdutoEletronico>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);
		
		JPanel criar = new JPanel();
		criar.setToolTipText("Criar");
		tabbedPane.addTab("Criar", null, criar, null);
		criar.setLayout(null);
		
		JTabbedPane tipos = new JTabbedPane(JTabbedPane.TOP);
		tipos.setBounds(0, 0, 429, 23);
		criar.add(tipos);
		
		JPanel inicio = new JPanel();
		tipos.addTab("Início", null, inicio, null);
		
		JPanel eletronico = new JPanel();
		tipos.addTab("Eletrônico", null, eletronico, null);
		
		JPanel alimenticio = new JPanel();
		tipos.addTab("Alimentício", null, alimenticio, null);
		
		JPanel vestuario = new JPanel();
		tipos.addTab("Vestuário", null, vestuario, null);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo ao sistema de registro de produtos feito em Java!\r\n");
		lblNewLabel.setBounds(42, 51, 350, 23);
		criar.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Para usar o nosso sistema, basta usar as abas disponíveis.");
		lblNewLabel_1.setBounds(42, 95, 328, 14);
		criar.add(lblNewLabel_1);
		
		JPanel ver = new JPanel();
		tabbedPane.addTab("Visualizar", null, ver, null);
	}
}
