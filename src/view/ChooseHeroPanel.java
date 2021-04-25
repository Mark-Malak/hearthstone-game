package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ChooseHeroPanel extends MyPanel {

	JLabel warlock, paladin, priest, mage, hunter,old;
	private String ChoosenHero;
	public ChooseHeroPanel() {
		super();
		this.setPreferredSize(new Dimension(300, 200));
		//setBackground(new Color(213, 134, 145, 123));
		this.setLayout(new GridLayout(2, 3));
		this.setOpaque(false);
		warlock = new JLabel(resize("images/warlockhero.png", 120, 100));
		this.add(warlock);
		warlock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(ChoosenHero!=null) {
					old.setBorder(null);
				}
				old = warlock ;
				warlock.setBorder(BorderFactory.createLineBorder(Color.white));
				ChoosenHero = "Warlock";
				
			}
		});
		paladin = new JLabel(resize("images/paladinhero.png", 120, 100));
		this.add(paladin);
		paladin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(ChoosenHero!=null) {
					old.setBorder(null);
				}
				old = paladin ;
				paladin.setBorder(BorderFactory.createLineBorder(Color.white));
				ChoosenHero = "Paladin";
				
			}
		});
		
		
		priest = new JLabel(resize("images/priesthero.png", 120, 100));
		this.add(priest);
		priest.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(ChoosenHero!=null) {
					old.setBorder(null);
				}
				old = priest ;
				priest.setBorder(BorderFactory.createLineBorder(Color.white));
				ChoosenHero = "Priest";
				
			}
		});
		
		
		
		
		mage = new JLabel(resize("images/magehero.png", 120, 100));
		this.add(mage);
		
		mage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(ChoosenHero!=null) {
					old.setBorder(null);
				}
				old = mage ;
				mage.setBorder(BorderFactory.createLineBorder(Color.white));
				ChoosenHero = "Mage";
				
			}
		});
		
		
		
		
		
		hunter = new JLabel(resize("images/hunterhero.png", 120, 100));
		this.add(hunter);
		hunter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(ChoosenHero!=null) {
					old.setBorder(null);
				}
				old = hunter ;
				hunter.setBorder(BorderFactory.createLineBorder(Color.white));
				ChoosenHero = "Hunter";
				
			}
		});

	}
	public String getChoosenHero() {
		return ChoosenHero;
	}
	
	
	
	

}
