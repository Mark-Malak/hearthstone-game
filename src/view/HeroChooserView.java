package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.heroes.Hero;

@SuppressWarnings("serial")
public class HeroChooserView extends JFrame {

	private ChooseHeroPanel p1;
	private ChooseHeroPanel p2;
	JPanel Heroes;
	JPanel players; 
	private JTextField player1;
	private JTextField player2;
	Hero One,Two;
	private JLabel start;
	
	public HeroChooserView() {

		super("HearthStone : Welcome !");
		
		//resizing method for images
		
		
		
		// setTitle("HearthStone : Welcome !");
		// for setting the icon of the window border
		ImageIcon i = new ImageIcon("images/logo.png");
		setIconImage(i.getImage());
		JLabel background = new JLabel(MyPanel.resize("images/herochooser.png",800,600));
		setContentPane(background);
		this.setLayout(new BorderLayout());
		setSize(800, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setResizable(false);
		setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//heroes panels
		JLabel h1 = new JLabel("Player 1 :");
		h1.setFont(MyPanel.gameFont(18f));
		h1.setForeground(Color.white);
		
		JLabel h2 = new JLabel("Player 2 :");
		h2.setFont(MyPanel.gameFont(18f));
		h2.setForeground(Color.white);
		p1 = new ChooseHeroPanel();
		p2 = new ChooseHeroPanel();
		Heroes = new JPanel();
		Heroes.setLayout(null);
		h1.setBounds(50,70,140,75);
		p1.setBounds(50,120,400,200);
		h2.setBounds(50,295,140,75);
		p2.setBounds(50,340,400,200);
		Heroes.add(p1);
		Heroes.add(p2);
		Heroes.add(h1);
		Heroes.add(h2);
		Heroes.setPreferredSize(new Dimension(400,600));
		Heroes.setOpaque(false);
	
		this.add(Heroes,BorderLayout.CENTER);
		
		
		//players panel 
		JPanel players = new JPanel(new BorderLayout());
		players.setOpaque(false);
		//players.setBackground(new Color(133, 200, 145, 123));
		players.setPreferredSize(new Dimension(300,600));
		this.add(players,BorderLayout.EAST);
		
		
		//jpanels for buttons 
		JPanel buttons = new JPanel(new BorderLayout());
		buttons.setOpaque(false);
		start = new JLabel("Start");
		start.setName("start");
		start.setIcon(MyPanel.resize("images/button.png",95, 40));
		start.setFont(MyPanel.gameFont(18f));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.CENTER);
		
		
		
		//back button to welcome screen or exit button as u like 
		JLabel exit = new JLabel("Exit");
		exit.setPreferredSize(new Dimension(95,40));
		exit.setIcon(MyPanel.resize("images/button.png",95, 40));
		exit.setFont(MyPanel.gameFont(18f));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.CENTER);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		//exit button in jpanel
		JPanel end = new JPanel(new BorderLayout());
		end.setOpaque(false);
		
		/** optional exit button at top left corner 
		JLabel exit = new JLabel("x");
		exit.setIcon(MyPanel.resize("images/button.png",25, 25));
		exit.setFont(MyPanel.gameFont(18f));
		exit.setHorizontalTextPosition(JButton.CENTER);
		exit.setVerticalTextPosition(JButton.CENTER);
		end.add(exit,BorderLayout.EAST);
		players.add(end,BorderLayout.NORTH);
		**/
		
		buttons.add(exit,BorderLayout.WEST);
		buttons.add(start,BorderLayout.EAST);
		players.add(buttons,BorderLayout.SOUTH);
		
		//players text optional fields
		JLabel pl1 = new JLabel("Player 1 :");
		pl1.setFont(MyPanel.gameFont(18f));
		pl1.setForeground(Color.white);
		pl1.setBounds(80,230,140,20);
		JLabel pl2 = new JLabel("Player 2 :");
		pl2.setFont(MyPanel.gameFont(18f));
		pl2.setForeground(Color.white);
		pl2.setBounds(80,280,140,20);
		JPanel names = new JPanel();
		names.setLayout(null);
		names.setOpaque(false);
		player1 = new JTextField();
		// Listen for changes in the text
		
		
		
		
		
		
		
		
		player2 = new JTextField();
		player1.setBounds(80,250,130,20);
		player2.setBounds(80,300,130,20);
		names.add(pl1);
		names.add(pl2);
		names.add(player1);
		names.add(player2);
		players.add(names,BorderLayout.CENTER);
		repaint();
		revalidate();
		
		
	}
	
	
	


	public JLabel getStart() {
		return start;
	}


	public ChooseHeroPanel getP1() {
		return p1;
	}


	public ChooseHeroPanel getP2() {
		return p2;
	}


	public JPanel getHeroes() {
		return Heroes;
	}


	public JPanel getPlayers() {
		return players;
	}


	public JTextField getPlayer1() {
		return player1;
	}


	public JTextField getPlayer2() {
		return player2;
	}


	public Hero getOne() {
		return One;
	}


	public Hero getTwo() {
		return Two;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
