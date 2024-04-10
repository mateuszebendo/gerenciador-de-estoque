package gerenciamento.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaCadastrado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastrado frame = new telaCadastrado();
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
	public telaCadastrado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastradoLabel = new JLabel("Cadastrado com sucesso!");
		cadastradoLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		cadastradoLabel.setBounds(98, 109, 237, 42);
		contentPane.add(cadastradoLabel);
		
		JButton continuarButton = new JButton("Continuar");
		continuarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin login = new telaLogin();
				try {
					login.setVisible(true);
					setVisible(false);
				} catch (Exception t) {
					telaErro erro = new telaErro();
					erro.setVisible(true);
					setVisible(false);
					t.printStackTrace();
				}
			}
		});
		continuarButton.setBounds(172, 156, 89, 23);
		contentPane.add(continuarButton);
	}

}
