package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Jogo {

	public JFrame janelaPrincipal;
	public static Point point = new Point();	
	int playerX = 0;
	int playerY = 0;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void chamarTelaDeJogo(String jogador1, String jogador2, String comeca) {
		
		String Jogador1 = jogador1;
		String Jogador2 = jogador2;		
		
		if(comeca == Jogador1){
			
			playerX = 1;
			
		}else{
			
			playerY = 1;
		}

		janelaPrincipal = new JFrame();
		janelaPrincipal.getContentPane().setBackground(Color.ORANGE);
		janelaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Jogo.class.getResource("/resources/images/iconeprincipal35x40.png")));
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setUndecorated(true);
		janelaPrincipal.setLocation(100, 100);
		janelaPrincipal.setSize(1000, 800);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setVisible(true);
		janelaPrincipal.setTitle("Jogo da Velha - Jogando...");
		
		JPanel Panel_BarradeFerramentas = new JPanel();
		Panel_BarradeFerramentas.setBackground(Color.WHITE);
		Panel_BarradeFerramentas.setLayout(null);
		Panel_BarradeFerramentas.addMouseListener(new MouseAdapter() {
			
		      public void mousePressed(MouseEvent e) {
		    	  
		        point.x = e.getX();
		        point.y = e.getY();
		      }
		    });
		
		Panel_BarradeFerramentas.addMouseMotionListener(new MouseMotionAdapter() {
		      public void mouseDragged(MouseEvent e) {
		        Point p = janelaPrincipal.getLocation();
		        janelaPrincipal.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
		      }
		    });
		
		
		
		
		JButton Botao_Fechar = new JButton("");
		Botao_Fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				janelaPrincipal.dispose();
				
			}
		});
		Botao_Fechar.setOpaque(false);
		Botao_Fechar.setIcon(new ImageIcon(Jogo.class.getResource("/resources/images/botaoFecharok.png")));  
		
		
		Botao_Fechar.setBounds(965, 0, 35, 40);
		Botao_Fechar.setBorder(null);
		Panel_BarradeFerramentas.add(Botao_Fechar);
		
		JButton Botao_Maximizar = new JButton("");
		Botao_Maximizar.setIcon(new ImageIcon(Jogo.class.getResource("/resources/images/botaoMaximizar_35x40.jpg")));
		Botao_Maximizar.setOpaque(false);
		Botao_Maximizar.setBounds(930, 0, 35, 40);
		Botao_Maximizar.setBorder(null);
		Panel_BarradeFerramentas.add(Botao_Maximizar);
		
		JButton Botao_Minimizar = new JButton("");
		Botao_Minimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				janelaPrincipal.dispose();
				janelaPrincipal.setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		Botao_Minimizar.setIcon(new ImageIcon(Jogo.class.getResource("/resources/images/botaoMinimizarok.png")));
		Botao_Minimizar.setOpaque(false);
		Botao_Minimizar.setBounds(895, 0, 35, 40); //botaoMinimizarok
		Botao_Minimizar.setBorder(null);
		Panel_BarradeFerramentas.add(Botao_Minimizar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Jogo.class.getResource("/resources/images/iconeprincipal35x40.png")));
		label.setBounds(2, 0, 35, 40);
		Panel_BarradeFerramentas.add(label);
		
		JLabel lblTelaInicial = new JLabel("Jogo da Velha - Jogando...");
		lblTelaInicial.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTelaInicial.setBounds(45, 11, 201, 19);
		Panel_BarradeFerramentas.add(lblTelaInicial);
		
		JPanel PainelLateralEsquerdo = new JPanel();
		PainelLateralEsquerdo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PainelLateralEsquerdo.setBackground(new Color(220, 220, 220));
		PainelLateralEsquerdo.setLayout(null);
		
		JLabel EstatticasDoJogo = new JLabel("Estat\u00EDticas da Partida");
		EstatticasDoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		EstatticasDoJogo.setHorizontalTextPosition(SwingConstants.CENTER);
		EstatticasDoJogo.setFont(new Font("Calibri", Font.BOLD, 30));
		EstatticasDoJogo.setBounds(10, 11, 311, 37);
		PainelLateralEsquerdo.add(EstatticasDoJogo);
		
		JLabel Labeljogador1 = new JLabel("Jogador 1:");
		Labeljogador1.setFont(new Font("Calibri", Font.BOLD, 20));
		Labeljogador1.setBounds(10, 145, 87, 26);
		PainelLateralEsquerdo.add(Labeljogador1);
		
		JTextArea nomejogador1 = new JTextArea(Jogador1);
		nomejogador1.setFont(new Font("Calibri", Font.PLAIN, 20));
		nomejogador1.setBounds(107, 143, 150, 30);
		nomejogador1.setEditable(false);
		PainelLateralEsquerdo.add(nomejogador1);
		
		JLabel Labeljogador2 = new JLabel("Jogador 2:");
		Labeljogador2.setFont(new Font("Calibri", Font.BOLD, 20));
		Labeljogador2.setBounds(10, 186, 87, 26);
		PainelLateralEsquerdo.add(Labeljogador2);
		
		JTextArea nomejogador2 = new JTextArea(Jogador2);
		nomejogador2.setFont(new Font("Calibri", Font.PLAIN, 20));
		nomejogador2.setBounds(107, 184, 150, 30);
		nomejogador2.setEditable(false);
		PainelLateralEsquerdo.add(nomejogador2);
		
		JLabel Simbolodejogo = new JLabel("S\u00EDmbolo");
		Simbolodejogo.setFont(new Font("Calibri", Font.BOLD, 15));
		Simbolodejogo.setBounds(270, 116, 51, 19);
		PainelLateralEsquerdo.add(Simbolodejogo);
		
		JLabel simbolox = new JLabel("X");
		simbolox.setHorizontalAlignment(SwingConstants.CENTER);
		simbolox.setFont(new Font("Calibri", Font.BOLD, 20));
		simbolox.setBounds(267, 145, 54, 26);
		PainelLateralEsquerdo.add(simbolox);
		
		JLabel simboloo = new JLabel("O");
		simboloo.setHorizontalAlignment(SwingConstants.CENTER);
		simboloo.setFont(new Font("Calibri", Font.BOLD, 20));
		simboloo.setBounds(267, 186, 54, 26);
		PainelLateralEsquerdo.add(simboloo);
		
		JLabel lblPontuao = new JLabel("PONTUA\u00C7\u00C3O");
		lblPontuao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPontuao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontuao.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPontuao.setBounds(10, 261, 311, 37);
		PainelLateralEsquerdo.add(lblPontuao);
		
		JLabel lblX = new JLabel("X =");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Calibri", Font.BOLD, 30));
		lblX.setBounds(10, 324, 54, 26);
		PainelLateralEsquerdo.add(lblX);
		
		JLabel lblO = new JLabel("O =");
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setFont(new Font("Calibri", Font.BOLD, 30));
		lblO.setBounds(10, 365, 54, 26);
		PainelLateralEsquerdo.add(lblO);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JButton A0 = new JButton("");		
		A0.setBorder(null);
		A0.setBackground(Color.WHITE);
		A0.setFont(new Font("Calibri", Font.PLAIN, 220));
		A0.setBounds(10, 11, 200, 200);
		panel.add(A0);
		
		
		
		JButton A1 = new JButton("");
		A1.setBackground(Color.WHITE);
		A1.setBorder(null);
		A1.setFont(new Font("Calibri", Font.PLAIN, 220));
		A1.setBounds(220, 11, 200, 200);
		panel.add(A1);
		
		JButton A2 = new JButton("X");
		A2.setBorder(null);
		A2.setBackground(Color.WHITE);
		A2.setFont(new Font("Calibri", Font.PLAIN, 220));
		A2.setBounds(430, 11, 200, 200);
		panel.add(A2);
		
		JButton B0 = new JButton("");
		B0.setBorder(null);
		B0.setBackground(Color.WHITE);
		B0.setFont(new Font("Calibri", Font.PLAIN, 220));
		B0.setBounds(10, 229, 200, 200);
		panel.add(B0);
		
		JButton B1 = new JButton("");
		B1.setBackground(Color.WHITE);
		B1.setBorder(null);
		B1.setFont(new Font("Calibri", Font.PLAIN, 220));
		B1.setBounds(220, 229, 200, 200);
		panel.add(B1);
		
		JButton B2 = new JButton("X");
		B2.setBorder(null);
		B2.setBackground(Color.WHITE);
		B2.setFont(new Font("Calibri", Font.PLAIN, 220));
		B2.setBounds(430, 229, 200, 200);
		panel.add(B2);
		
		JButton C0 = new JButton("O");
		C0.setBorder(null);
		C0.setBackground(Color.WHITE);
		C0.setFont(new Font("Calibri", Font.PLAIN, 220));
		C0.setBounds(10, 450, 200, 200);
		panel.add(C0);
		
		JButton C1 = new JButton("");
		C1.setBackground(Color.WHITE);
		C1.setBorder(null);
		C1.setFont(new Font("Calibri", Font.PLAIN, 220));
		C1.setBounds(220, 450, 200, 200);
		panel.add(C1);
		
		JButton C2 = new JButton("X");
		C2.setBorder(null);
		C2.setBackground(Color.WHITE);
		C2.setFont(new Font("Calibri", Font.PLAIN, 220));
		C2.setBounds(430, 450, 200, 200);
		panel.add(C2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 212, 620, 20);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 431, 620, 20);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(206, 12, 15, 638);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(417, 11, 15, 638);
		panel.add(panel_4);
		
		A0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(A0.getText() == ""){
					
					if(playerX == 1){
						
						A0.setText("X");
						
						if(A0.getText() == "X" && A1.getText() == "X" && A2.getText() == "X"){
							
							
						}else if(A0.getText() == "X" && B0.getText() == "X" && C0.getText() == "X"){
							
							
						}else{
							
							playerX = 0;
							playerY = 1;							
						}						
						
					}else{						
						
						A0.setText("O");
						
						if(A0.getText() == "O" && A1.getText() == "O" && A2.getText() == "O"){
							
							
						}else if(A0.getText() == "O" && A1.getText() == "O" && A2.getText() == "O"){
							
							
						}else{
							
							playerX = 0;
							playerY = 1;							
						}
					}
					
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Atenção!\nEste espaço já foi ocupado!\nESCOLHA OUTRO", "Atenção", JOptionPane.ERROR_MESSAGE, null);
					
				}
				
				
				
			}
		});
		
		JButton botaoiniciar = new JButton("<html><center>Iniciar<br> <center>Jogo</html>");
		botaoiniciar.setIcon(new ImageIcon("C:\\Users\\Rodrigo Moreira\\Workspace\\Testes Pessoais\\Interface_Grafica\\bin\\Agenda\\Images\\icon-1498823_960_720.png"));
		botaoiniciar.setBorder(null);
		botaoiniciar.setBackground(Color.ORANGE);
		botaoiniciar.setFont(new Font("Calibri", Font.BOLD, 17));
		
		JButton btnreiniciarjogo = new JButton("<html><center>Reiniciar<br> <center>Jogo</html>");
		btnreiniciarjogo.setFont(new Font("Calibri", Font.BOLD, 17));
		
		JButton btnresetarpontuao = new JButton("<html><center>Resetar<br> <center>Pontua\u00E7\u00E3o</html>");
		btnresetarpontuao.setFont(new Font("Calibri", Font.BOLD, 17));
		
		
		/*=====[INICIO DO LAYOUT DO PAINLE PRINCIPAL]=====*/
		GroupLayout groupLayout = new GroupLayout(janelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(Panel_BarradeFerramentas, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(botaoiniciar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnreiniciarjogo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnresetarpontuao, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(PainelLateralEsquerdo, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(Panel_BarradeFerramentas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoiniciar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnreiniciarjogo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnresetarpontuao, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(PainelLateralEsquerdo, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)))
		);
		janelaPrincipal.getContentPane().setLayout(groupLayout);
	}
	
	
}

