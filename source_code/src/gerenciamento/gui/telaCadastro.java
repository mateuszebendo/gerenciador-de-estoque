package gerenciamento.gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gerenciamento.DAO.UsuarioDAO;

public class telaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JTextField senhaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastro frame = new telaCadastro();
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
	public telaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(194, 22, 46, 14);
		contentPane.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(174, 47, 86, 20);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(194, 78, 46, 14);
		contentPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(174, 103, 86, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setBounds(194, 134, 46, 14);
		contentPane.add(senhaLabel);
		
		senhaTextField = new JTextField();
		senhaTextField.setBounds(174, 161, 86, 20);
		contentPane.add(senhaTextField);
		senhaTextField.setColumns(10);
		
		JButton cadastrarButao = new JButton("Cadastrar-se");
		cadastrarButao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novoNome = nomeTextField.getText();
				String novoEmail = emailTextField.getText();
				String novaSenha = senhaTextField.getText();
				UsuarioDAO.cadastrarUsuario(novoNome, novoEmail, novaSenha);
				
				try { 
					telaCadastrado cadastrado = new telaCadastrado();
					cadastrado.setVisible(true);
					setVisible(false);
				}
				catch(Exception r){
					telaErro erro = new telaErro();
					setVisible(false);
					erro.setVisible(true);
				}
			}
		});
		cadastrarButao.setBounds(153, 205, 127, 23);
		contentPane.add(cadastrarButao);
	}
}
