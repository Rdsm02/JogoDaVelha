package principal;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Login{

	private JFrame TelaInicio;
	private JTextField Jogador1;
	private JTextField Jogador2;
	private static Point point = new Point();
	String Inicia = "Selecione o Jogador", nomeJogador1 = "Digite o Nome do Jogador 1", nomeJogador2 = "Digite o Nome do Jogador 2";
	
	public static void main(String[] args) {
		Login login = new Login();
		login.TelaInicio.setVisible(true);
	} 

	public Login() {
		chamarTelaDeLogin();
	}


	private void chamarTelaDeLogin() {
		
		TelaInicio = new JFrame();		
		TelaInicio.setUndecorated(true);
		TelaInicio.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		TelaInicio.getContentPane().setBackground(Color.WHITE);		
		TelaInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TelaInicio.setSize(350, 631);
		TelaInicio.setLocationRelativeTo(null);
		
		JPanel Jpanel_Autenticacao = new JPanel();
		Jpanel_Autenticacao.setBackground(new Color(34, 139, 34));
		Jpanel_Autenticacao.setLayout(null);
		Jpanel_Autenticacao.addMouseListener(new MouseAdapter() {
			
		      public void mousePressed(MouseEvent e) {
		    	  
		        point.x = e.getX();
		        point.y = e.getY();
		      }
		    });
		
		Jpanel_Autenticacao.addMouseMotionListener(new MouseMotionAdapter() {
		      public void mouseDragged(MouseEvent e) {
		        Point p = TelaInicio.getLocation();
		        TelaInicio.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
		      }
		    });
		
		JLabel LabelAutenticacao = new JLabel("JOGO DA VELHA #");
		LabelAutenticacao.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelAutenticacao.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAutenticacao.setForeground(Color.WHITE);
		LabelAutenticacao.setFont(new Font("Calibri", Font.BOLD, 40));
		LabelAutenticacao.setBounds(10, 11, 330, 78);
		Jpanel_Autenticacao.add(LabelAutenticacao);
		
		JLabel TextoPrincipal = new JLabel("Digite o Nome dos Jogadores!");
		TextoPrincipal.setHorizontalTextPosition(SwingConstants.CENTER);
		TextoPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		TextoPrincipal.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton BotaoJogar = new JButton("Jogar!");
		BotaoJogar.setFont(new Font("Calibri", Font.PLAIN, 25));
		BotaoJogar.setBackground(new Color(255, 102, 0));
		BotaoJogar.setToolTipText("Clique aqui se estiver com todos os dados preenchidos para iniciar o jogo!");
		BotaoJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				BotaoJogar.setBackground(new Color(160,82,45));				
				
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				
				BotaoJogar.setBackground(new Color(255, 102, 0));
			}
		});
		BotaoJogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(nomeJogador1 == "" | nomeJogador2 == "" | nomeJogador1 == "Digite o Nome do Jogador 1" | nomeJogador2 == "Digite o Nome do Jogador 2"){
					
					JOptionPane.showMessageDialog(null, "Atenção!\n Por gentileza informar o nome dos dois Jogares!", "Campo Vazio", JOptionPane.ERROR_MESSAGE, null);
					
				}else if(Inicia == "Selecione o Jogador"){
					
					JOptionPane.showMessageDialog(null, "Atenção!\n Por gentileza informar o Jogador que irá iniciar a partida!", "Campo Vazio", JOptionPane.ERROR_MESSAGE, null);
					
					
				}else{
					
					Jogo inicio = new Jogo();
					TelaInicio.dispose();
					inicio.chamarTelaDeJogo(nomeJogador1, nomeJogador2, Inicia);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnSair.setBackground(new Color(255, 102, 0));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaInicio.dispose();
				
			}
		});
		
		Jogador1 = new JTextField(1);
		Jogador1.setFont(new Font("Calibri", Font.PLAIN, 15));
		Jogador1.setText("Digite o Nome do Jogador 1");
		Jogador1.setMinimumSize(new Dimension(15, 50));
		Jogador1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Jogador1.add(new JLabel("Nome:"));		
		Jogador1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if(Jogador1.getText().equals("Digite o Nome do Jogador 1")) {    
					Jogador1.setText("");        
				}				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(Jogador1.getText().equals("")) {
					Jogador1.setText("Digite o Nome do Jogador 1");
					nomeJogador1 = "";
				}else{
					nomeJogador1 = (String) Jogador1.getText();
					
				}
			}
		});
		
		
		
		JLabel ImagemPassword = new JLabel("");
		ImagemPassword.setIcon(new ImageIcon("C:\\Users\\Rodrigo Moreira\\Workspace\\Testes Pessoais\\Agenda_Telefonica\\src\\images\\login_ico_l_4.png"));
		
		Jogador2 = new JTextField();
		Jogador2.setText("Digite o Nome do Jogador 2");
		Jogador2.setFont(new Font("Calibri", Font.PLAIN, 15));
		Jogador2.setMinimumSize(new Dimension(15, 50));
		Jogador2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Jogador2.setColumns(10);
		Jogador2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Jogador2.getText().equals("Digite o Nome do Jogador 2")) {    
					Jogador2.setText("");        
				}
				
			}
		});
		Jogador2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {				
				
				if(Jogador2.getText().equals("")) {
					Jogador2.setText("Digite o Nome do Jogador 2");
					nomeJogador2 = "";
				}else{
					nomeJogador2 = (String) Jogador2.getText();
					
				}
				
			}
		});
		
		
		JLabel lblQuemInicia = new JLabel("Quem Inicia?");
		lblQuemInicia.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JComboBox Verificacaodeinicio = new JComboBox();
		Verificacaodeinicio.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Jogador", "Jogador1","Jogador2"}));
		Verificacaodeinicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				Inicia = (String) Verificacaodeinicio.getSelectedItem();				
			}
		});
		
		JButton Instruncao = new JButton("Instru\u00E7\u00F5es de Jogabilidade", new ImageIcon("src/depositphotos_145491147-stock-illustration-mark-pointer-sign-vector-green"));
		Instruncao.setToolTipText("Clique para ler as instruções do jogo!");
		Instruncao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Instruções de Jogabilidade", "Intrucao de Uso",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		});
		
		/*=====[INICIO DO LAYOUT DO PAINLE PRINCIPAL]=====*/
		GroupLayout groupLayout = new GroupLayout(TelaInicio.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(Jpanel_Autenticacao, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(TextoPrincipal, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(Jogador1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ImagemPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jogador2, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(Instruncao, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblQuemInicia)
					.addGap(12)
					.addComponent(Verificacaodeinicio, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(BotaoJogar, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(Jpanel_Autenticacao, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(TextoPrincipal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(Jogador1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(ImagemPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(Jogador2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(Instruncao, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuemInicia)
						.addComponent(Verificacaodeinicio, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(BotaoJogar, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
		);
		TelaInicio.getContentPane().setLayout(groupLayout);
		
		
		
	}
}
