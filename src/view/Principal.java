package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtArquivo;

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
		addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent e) {
//				Login login = new Login();
//				login.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 789, 502);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Registro de produtos", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(347, 5, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Visualizar produtos", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha um arquivo");
		lblNewLabel.setBounds(58, 40, 100, 14);
		panel_1.add(lblNewLabel);
		
		txtArquivo = new JTextField();
		txtArquivo.setBounds(58, 75, 247, 20);
		panel_1.add(txtArquivo);
		txtArquivo.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		
		btnAbrir.setBounds(137, 117, 89, 23);
		panel_1.add(btnAbrir);
		
		JLabel lbFoto = new JLabel("");
		lbFoto.setBounds(439, 58, 291, 266);
		panel_1.add(lbFoto);
		
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Abrir o arquivo:
				JFileChooser abrirArquivo = new JFileChooser();
				
				int status = abrirArquivo.showOpenDialog(getParent());
				
				
				txtArquivo.setText(abrirArquivo.getSelectedFile().toString());
				
				if(status == abrirArquivo.APPROVE_OPTION) {
					//ImageIcon imageicon = new ImageIcon(txtArquivo.getText()).getImage().getScaledInstance(300, 300, java.awt.Image);
					ImageIcon imageicon = new ImageIcon(txtArquivo.getText());
					Image image = imageicon.getImage().getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
//					Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
					imageicon = new ImageIcon(image);
					lbFoto.setIcon(imageicon);
				}
				
			}
		});
	}
}
