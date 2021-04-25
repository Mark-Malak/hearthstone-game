package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardViewer extends MyPanel {
	JLabel card, endTurn,guide;
	JPanel buttons;
	
	public CardViewer() {
		super();
		//remove this and make size dynamically in gameview if u need
		this.setSize(190, 755);
		//setBackground(new Color(213, 134, 145, 123));
		this.setLayout(new BorderLayout());
		card = new JLabel(resize("images/cardBack.png",190, 280));
	
		endTurn = new JLabel("End Turn ");
		endTurn.setName("End Turn");
		endTurn.setIcon(resize("images/button.png",140, 75));
		endTurn.setFont(MyPanel.gameFont(18f));
		endTurn.setHorizontalTextPosition(JLabel.CENTER);
		endTurn.setVerticalTextPosition(JLabel.CENTER);
		
		guide = new JLabel("guide");
		guide.setName("guide");
		guide.setIcon(resize("images/button.png",140, 75));
		guide.setFont(MyPanel.gameFont(18f));
		guide.setHorizontalTextPosition(JLabel.CENTER);
		guide.setVerticalTextPosition(JLabel.CENTER);
		
		// card.setBackground(Color.blue);
		this.setLayout(new BorderLayout());
		
		buttons = new JPanel(new BorderLayout());
		buttons.setOpaque(false);
		// card.setBounds(0, 355, this.getWidth(),375);
		add(card, BorderLayout.CENTER);
		buttons.add(endTurn, BorderLayout.SOUTH);
		buttons.add(guide,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		this.setOpaque(false);
		revalidate();
		repaint();
	}
	public JLabel getCard() {
		return card;
	}
	public void setCard(JLabel card) {
		this.card = card;
	}
	public JLabel getEndTurn() {
		return endTurn;
	}
	public JLabel getGuide() {
		return guide;
	}

	

}
