package views;

import model.Produto;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtEstoque;
	private JTable tbProduto;
	private JButton btnApagar;
	private JButton btnEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(65, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbPreco = new JLabel("Preço");
		lbPreco.setBounds(65, 94, 46, 14);
		contentPane.add(lbPreco);
		
		JLabel lbEstoque = new JLabel("Estoque");
		lbEstoque.setBounds(65, 156, 46, 14);
		contentPane.add(lbEstoque);
		
		txtNome = new JTextField();
		txtNome.setBounds(121, 33, 198, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(121, 91, 198, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtEstoque = new JTextField();
		txtEstoque.setBounds(121, 153, 198, 20);
		contentPane.add(txtEstoque);
		txtEstoque.setColumns(10);
		
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Pre\u00E7o", "Estoque"
			}
		));
		tbProduto.setBounds(41, 249, 392, 202);
		contentPane.add(tbProduto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtEstoque.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos!");
				} else {
					Produto p = new Produto(txtNome.getText(), Float.parseFloat(txtPreco.getText()), Integer.parseInt(txtEstoque.getText()));
					
					DefaultTableModel modelo = (DefaultTableModel) tbProduto.getModel();
					
					modelo.addRow(new Object[] {p.getNome(), p.getPreco(), p.getEstoque()});
					
					tbProduto.setModel(modelo);
					
					txtNome.setText("");
					txtPreco.setText("");
					txtEstoque.setText("");
				}
			}
		});
		btnSalvar.setBounds(344, 32, 89, 23);
		contentPane.add(btnSalvar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbProduto.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para apagar!");
				} else {
					DefaultTableModel modelo = (DefaultTableModel) tbProduto.getModel();
					modelo.removeRow(tbProduto.getSelectedRow());
				}
//				System.out.println(modelo.getRowCount());
				
			}
		});
		btnApagar.setBounds(344, 152, 89, 23);
		contentPane.add(btnApagar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbProduto.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para editar");
				} else {
					String nome;
					String preco;
					String estoque;
					
					if(txtNome.getText().isEmpty()) {
						nome = tbProduto.getModel().getValueAt(tbProduto.getSelectedRow(), 0).toString();
					} else {
						nome = txtNome.getText();
					}
					
					if(txtPreco.getText().isEmpty()) {
						preco = tbProduto.getModel().getValueAt(tbProduto.getSelectedRow(), 1).toString();
					} else {
						preco = txtPreco.getText();
					}
					
					if(txtEstoque.getText().isEmpty()) {
						estoque = tbProduto.getModel().getValueAt(tbProduto.getSelectedRow(), 2).toString();
					} else {
						estoque = txtEstoque.getText();
					}
					
					Produto p = new Produto(nome, Float.parseFloat(preco), Integer.parseInt(estoque));
					DefaultTableModel modelo = (DefaultTableModel) tbProduto.getModel();
					
					modelo.setValueAt(p.getNome(), tbProduto.getSelectedRow(), 0);
					modelo.setValueAt(p.getPreco(), tbProduto.getSelectedRow(), 1);
					modelo.setValueAt(p.getEstoque(), tbProduto.getSelectedRow(), 2);
				}
				}
		});
		btnEditar.setBounds(344, 90, 89, 23);
		contentPane.add(btnEditar);
	}
}
