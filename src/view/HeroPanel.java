package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HeroPanel extends MyPanel{
	
	
	private JLabel Hero,HeroHp,HeroPower;
	
	
	public HeroPanel() {
		super();
		setLayout(null);
		setPreferredSize(new Dimension(300,120));
		setOpaque(false);
		
		
		
		Hero = new JLabel();
		//Hero.setIcon(resize("images/hero/Mage.png",140, 150));
		Hero.setBounds(380,15,140,150);
		Hero.setLayout(null);
		
		
		//hero one hp (current and total)
		HeroHp = new JLabel("30");
		HeroHp.setForeground(Color.white);
		HeroHp.setFont(MyPanel.gameFont(18f));
		HeroHp.setBounds(112,87,45,20);
		Hero.add(HeroHp);
	//	this.add(HeroHp);
		this.add(Hero);
		//hero one power 
		HeroPower = new JLabel();
		HeroPower.setName("HeroPower");
		//HeroPower.setIcon(resize("images/heropower.png",80, 80));
		HeroPower.setBounds(520,35,80,80);
		this.add(HeroPower);
		
		
	}


	public JLabel getHero() {
		return Hero;
	}


	public void setHero(JLabel hero) {
		Hero = hero;
	}


	public JLabel getHeroHp() {
		return HeroHp;
	}


	public void setHeroHp(JLabel heroHp) {
		HeroHp = heroHp;
	}


	public JLabel getHeroPower() {
		return HeroPower;
	}


	public void setHeroPower(JLabel heroPower) {
		HeroPower = heroPower;
	}
	
	
	
}
