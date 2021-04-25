package view;


import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ManaView extends MyPanel {

	private JLabel cd,od;
	
	private JLabel AcurrentMana;
	private JLabel BcurrentMana;
	private JTextArea players;

	public ManaView() {
		super();
		this.setPreferredSize(new Dimension(190, 755));
		setBackground(new Color(213, 134, 145, 123));
		this.setLayout(new BorderLayout());
		// player a /1
		//current deck size 
		cd = new JLabel(Integer.toString(20));
		cd.setForeground(Color.white);
		cd.setIcon(resize("images/deck.png", 170, 180));
		cd.setFont(MyPanel.gameFont(32f));
		cd.setHorizontalTextPosition(JLabel.CENTER);
		cd.setVerticalTextPosition(JLabel.CENTER);
		//Mana Crystals 
		AcurrentMana = new JLabel(MyPanel.resize("images/mana crystal.png", 60, 60));
		AcurrentMana.setOpaque(false);
		AcurrentMana.setForeground(Color.white);
		AcurrentMana.setFont(MyPanel.gameFont(30f));
		AcurrentMana.setHorizontalTextPosition(JLabel.CENTER);
		AcurrentMana.setVerticalTextPosition(JLabel.CENTER);
		// player b / 1
		// current deck size 
		od = new JLabel(Integer.toString(20));
		od.setForeground(Color.white);
		od.setIcon(resize("images/deck.png", 170, 180));
		od.setFont(MyPanel.gameFont(32f));
		od.setHorizontalTextPosition(JLabel.CENTER);
		od.setVerticalTextPosition(JLabel.CENTER);
		//Mana Crystals 
		BcurrentMana = new JLabel(MyPanel.resize("images/mana crystal.png", 60, 60));
		BcurrentMana.setOpaque(false);
		BcurrentMana.setForeground(Color.white);
		BcurrentMana.setFont(MyPanel.gameFont(30f));
		
		BcurrentMana.setHorizontalTextPosition(JLabel.CENTER);
		BcurrentMana.setVerticalTextPosition(JLabel.CENTER);
		
		
		players = new JTextArea();
		players.setEditable(false);
		players.setForeground(Color.white);
		players.setFont(MyPanel.gameFont(15f));
		players.setOpaque(false);
		players.setText("player 2 : herotwo \n\n\n\n\n\n\n\n\n\n\n\n\n\nplayer 1 : heroOne");
		
		
		JPanel mana = new JPanel(new BorderLayout());
		mana.setOpaque(false);
		add(od, BorderLayout.NORTH);
		add(cd, BorderLayout.SOUTH);
		add(mana, BorderLayout.CENTER);
		mana.add(AcurrentMana,BorderLayout.SOUTH);
		mana.add(players,BorderLayout.CENTER);
		mana.add(BcurrentMana,BorderLayout.NORTH);
		

		this.setOpaque(false);
		
		
	}

	public JLabel getCd() {
		return cd;
	}

	public JLabel getOd() {
		return od;
	}

	

	public JLabel getAcurrentMana() {
		return AcurrentMana;
	}

	public JLabel getBcurrentMana() {
		return BcurrentMana;
	}

	public JTextArea getPlayers() {
		return players;
	}

	
	
	
	
}
