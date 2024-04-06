package gerenciamento.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;

public class menuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuInicial frame = new menuInicial();
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
	public menuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Menu Inicial");
		menuLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		menuLabel.setBounds(146, 42, 141, 41);
		contentPane.add(menuLabel);
		
		JButton vendasBotao = new JButton("Vendas");
		vendasBotao.setBounds(156, 94, 120, 23);
		contentPane.add(vendasBotao);
		
		JButton estoqueBotao = new JButton("Estoque");
		estoqueBotao.setBounds(157, 128, 119, 23);
		contentPane.add(estoqueBotao);
		
		JButton crediarioMenu = new JButton("Crediário");
		crediarioMenu.setBounds(156, 162, 120, 23);
		contentPane.add(crediarioMenu);
		
		JButton funcionarioBotao = new JButton("Funcionários");
		funcionarioBotao.setBounds(157, 196, 120, 23);
		contentPane.add(funcionarioBotao);
		
		JButton sairBotao = new JButton("Sair");
		sairBotao.setBounds(178, 261, 78, 23);
		contentPane.add(sairBotao);
	}
}
