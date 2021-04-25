package view;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FieldCard extends JLabel {

	private JLabel Hp , Atk , sleeping; 
	
	
	public FieldCard(Icon image) {
		super(image);
		setLayout(null);
		Hp = new JLabel();
		Hp.setForeground(Color.white);
		Hp.setFont(MyPanel.gameFont(16f));
		Hp.setBounds(59,52,45,20);
		add(Hp);
		
		Atk = new JLabel();
		Atk.setForeground(Color.white);
		Atk.setFont(MyPanel.gameFont(16f));
		Atk.setBounds(23,52,45,20);
		add(Atk);
		
		sleeping = new JLabel(MyPanel.resize("images/field/sleeping.png", 30, 35));
		sleeping.setOpaque(false);
		sleeping.setBounds(59,5,30,30);
		add(sleeping);
		
	}


	public JLabel getHp() {
		return Hp;
	}


	public JLabel getAtk() {
		return Atk;
	}


	public JLabel getSleeping() {
		return sleeping;
	}

	
	
	
}
