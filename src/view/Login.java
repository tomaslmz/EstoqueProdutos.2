package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswdSenha;
	private String login = "admin";
	private String password = "admin";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(103, 66, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(148, 63, 133, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(103, 113, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Um clique com o botão esquerdo do mouse
				if(txtUsuario.getText().equals(login) && String.valueOf(pswdSenha.getPassword()).equals(password)) {
					Principal main = new Principal();
					main.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Login incorreto!");
				}
			}
		});
		btnLogin.setBounds(162, 164, 89, 23);
		contentPane.add(btnLogin);
		
		pswdSenha = new JPasswordField();
		pswdSenha.setBounds(148, 110, 133, 20);
		contentPane.add(pswdSenha);
	}
}
