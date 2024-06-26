package gerenciamento.gui;
import gerenciamento.DAO.ConexaoBD;
import gerenciamento.DAO.UsuarioDAO;
import gerenciamento.backEnd.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import java.awt.Choice;

public class telaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailTextField;
	private JTextField senhaTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
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
	public telaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		emailTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailTextField, 69, SpringLayout.NORTH, contentPane);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email:");
		sl_contentPane.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, emailTextField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, emailLabel, -6, SpringLayout.NORTH, emailTextField);
		contentPane.add(emailLabel);
		
		senhaTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, emailTextField, 0, SpringLayout.WEST, senhaTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, emailTextField, 0, SpringLayout.EAST, senhaTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, senhaTextField, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, senhaTextField, 306, SpringLayout.WEST, contentPane);
		contentPane.add(senhaTextField);
		senhaTextField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, senhaTextField, 2, SpringLayout.SOUTH, senhaLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, senhaLabel, 6, SpringLayout.SOUTH, emailTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, senhaLabel, 0, SpringLayout.WEST, emailTextField);
		contentPane.add(senhaLabel);
		
		JButton entrarButao = new JButton("Entrar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, entrarButao, 13, SpringLayout.SOUTH, senhaTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, entrarButao, 180, SpringLayout.WEST, contentPane);
		entrarButao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respostaBanco = UsuarioDAO.conectarUsuario(emailTextField.getText(), senhaTextField.getText());
				if(respostaBanco.equals(emailTextField.getText() + senhaTextField.getText())) {
					try {
						menuInicial menu = new menuInicial();
						menu.setVisible(true);
						setVisible(false);
					} catch (Exception r) {
						r.printStackTrace();
					}
				} else {
					try {
						telaErro erro = new telaErro();
						erro.setVisible(true);
						setVisible(false);
					} catch (Exception r) {
						r.printStackTrace();
					}
				}
			}
		});
		contentPane.add(entrarButao);
		
		JLabel cadastroButao = new JLabel("Cadastrar-se");
		cadastroButao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					telaCadastro cadastro = new telaCadastro();
					cadastro.setVisible(true);
					setVisible(false);
				}
				catch (Exception t) {
					telaErro erro = new telaErro();
					erro.setVisible(true);
					setVisible(false);
					t.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, cadastroButao, 12, SpringLayout.SOUTH, entrarButao);
		sl_contentPane.putConstraint(SpringLayout.WEST, cadastroButao, 180, SpringLayout.WEST, contentPane);
		contentPane.add(cadastroButao);
	}
}
