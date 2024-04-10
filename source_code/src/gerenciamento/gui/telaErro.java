package gerenciamento.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaErro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaErro frame = new telaErro();
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
	public telaErro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel erroLabel = new JLabel("ERRO");
		erroLabel.setFont(new Font("Tahoma", Font.PLAIN, 56));
		erroLabel.setBounds(139, 56, 141, 90);
		contentPane.add(erroLabel);
		
		JButton voltarBotao = new JButton("Tela de Login");
		voltarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin login = new telaLogin();
				login.setVisible(true);
				setVisible(false);
			}
		});
		voltarBotao.setBounds(149, 151, 114, 41);
		contentPane.add(voltarBotao);
	}
}
