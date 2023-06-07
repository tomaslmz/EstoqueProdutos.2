package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(199, 186, 89, 23);
		panel_1.add(btnNewButton_1);
	}
}
