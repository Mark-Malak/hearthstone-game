package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import view.FieldCard;
import view.FieldPanel;
import view.GameView;
import view.HandPanel;
import view.HeroChooserView;
import view.HeroPanel;
import view.MyPanel;
import view.WelcomeView;

public class Controller implements GameListener, MouseListener {
	private WelcomeView w;
	private HeroChooserView h ;
	private GameView g = new GameView();
	private Game game;
	private Hero heroOne, heroTwo;
	private Minion minionAttacker ;
	private Minion minionTarget ;
	private Hero heroTarget,heroAttacker;
	private boolean powerAttack; 
	private boolean spellAttack;
	private Spell spellAttackerCard;
	private String playerOneName,playerTwoName;
	
	public Controller() {
		playerOneName = "Player 1 ";
		playerTwoName = "Player 2 ";		
		 w = new WelcomeView();
		 w.setVisible(true);
		 w.getP().addMouseListener(this);
		
		
		
	}

	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// case a jlabel is clicked so the source get typecasted
		if (e.getSource() instanceof JLabel) {
			switch (((JLabel) e.getSource()).getName()) {

			case ("p"):
				w.closeWindow();
				h = new HeroChooserView();
				h.setVisible(true);
				h.getStart().addMouseListener(this);
				break;

			case ("start"):
				if (h.getP1().getChoosenHero() == null || h.getP2().getChoosenHero() == null) {
					JOptionPane.showMessageDialog(h, "please choose a hero for each player !");
				} else {
					// creating the heroes and initializing the game model
					String heroOneName = h.getP1().getChoosenHero();
					String heroTwoName = h.getP2().getChoosenHero();
					heroOne = chooseHero(heroOneName);
					heroTwo = chooseHero(heroTwoName);
					// creating the game 
					try {
						game = new Game(heroOne, heroTwo);
						game.setListener(this);
					} catch (FullHandException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					h.dispose();
					g.setVisible(true);
					g.getCv().getEndTurn().addMouseListener(this);
					g.getCv().getGuide().addMouseListener(this);
					//setting up heroes 
					heroSetup(heroOne, heroOneName, g.getHeroOnePanel());
					heroSetup(heroTwo, heroTwoName, g.getHeroTwoPanel());
					
					
					//setting the player name 
					
					if (!h.getPlayer1().getText().equals("")) {
						playerOneName =h.getPlayer1().getText(); 
					}
					if (!h.getPlayer2().getText().equals("")) {
						playerTwoName = h.getPlayer2().getText();
					}
					g.getMv().getPlayers().setText(playerTwoName+" : \n" + heroTwo.getName()+"\n\n\n\n\n\n\n\n\n\n\n\n"+playerOneName+" : \n"+heroOne.getName());
				}
					break;
				
			case("End Turn"):
				
				try {
					game.getCurrentHero().endTurn();
					setMinionAttacker(null);

					setMinionTarget(null);

					updateHP(game.getCurrentHero());
				} catch (FullHandException e1) {
					ImageIcon icon;
					String name = e1.getBurned().getName();
					if(e1.getBurned() instanceof Minion) {
						 icon = MyPanel.resize("images/minions/"+name+".png",250,360);
					}else {
						 icon = MyPanel.resize("images/spells/"+name+".png",250,360);
					}
					//JOptionPane.showMessageDialog(g, e1.getBurned().getName()+"is buurrrned");
			JOptionPane.showMessageDialog(g,name+"  is burned",
			"Cant draw cards hand is full!",JOptionPane.INFORMATION_MESSAGE,
			icon);
						
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(g, e1.getMessage());
				}
				updateHand(game.getCurrentHero());
				updateHand(game.getOpponent());
				updateMana(game.getCurrentHero());
				updateDeck(game.getCurrentHero());
				updateField(heroOne);
				updateField(heroTwo);
				break;
			case("guide"):
				
				JOptionPane.showMessageDialog(g,"",
						"Legend",JOptionPane.INFORMATION_MESSAGE,
						MyPanel.resize("images/guide.png", 800, 600));
				break;
			
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Controller c = new Controller();
	}

	@Override
	public void onGameOver() {
		
		//declaring the winner and ending game , not done yet 
		g.dispose();
	
		if(heroOne.getCurrentHP()==0) {
			JOptionPane.showMessageDialog(g, playerTwoName+": "+heroTwo.getName()+"  has won the game!");
		}else {
			JOptionPane.showMessageDialog(g, playerOneName+": "+heroOne.getName()+"  has won the game!");
		}
		Controller n = new Controller();
		
		
	}

	public Hero chooseHero(String heroName) {

		switch (heroName) {
		case ("Mage"):
			try {
				Hero hero = new Mage();
				return hero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case ("Warlock"):
			try {
				Hero hero = new Warlock();
				return hero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case ("Hunter"):
			try {
				Hero hero = new Hunter();
				return hero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case ("Paladin"):
			try {
				Hero hero = new Paladin();
				return hero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case ("Priest"):
			try {
				Hero hero = new Priest();
				return hero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		return null;
	}

	public void heroSetup(Hero hero, String heroName, HeroPanel p) {
		// setting hero image
		p.getHero().setIcon(MyPanel.resize("images/hero/" + heroName + ".png", 140, 150));
		// setting hero power
		p.getHeroPower().setIcon(MyPanel.resize("images/power/" + heroName + ".png", 80, 80));
		
		p.getHeroPower().addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				g.getCv().getCard()
						.setIcon(MyPanel.resize("images/power/" + heroName + "power.png", 190, 280));
			}
			public void mouseClicked(MouseEvent e) {
				if (powerAttack) {
					p.getHeroPower().setBorder(null);
					powerAttack = false ;
				}else if(hero instanceof Hunter || hero instanceof Warlock || hero instanceof Paladin ) {	
					try {
						if(hero instanceof Hunter) {
							((Hunter)hero).useHeroPower();
						}else if(hero instanceof Warlock) {
							((Warlock)hero).useHeroPower();
							updateDeck(hero);
							updateHand(hero);
							
						}else {
							((Paladin)hero).useHeroPower();
							updateField(hero);
						}
						
						updateHP(heroOne);
						updateHP(heroTwo);
						updateMana(hero);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(g, e1.getMessage());
					}
				}else {
					p.getHeroPower().setBorder(BorderFactory.createLineBorder(Color.white));
					if (hero instanceof Mage || hero instanceof Priest) {
						heroAttacker = hero;
						powerAttack = true;
					}

				}
				
			}
		
		});
		p.getHero().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (heroAttacker != null) {
					if (powerAttack) {
						try {
							if(heroAttacker instanceof Mage) {
								((Mage)heroAttacker).useHeroPower(hero);
							}
							if(heroAttacker instanceof Priest) {
								((Priest)heroAttacker).useHeroPower(hero);
							}
							
							p.getHeroHp().setText(hero.getCurrentHP() + "");
							
						} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
								| FullHandException | FullFieldException | CloneNotSupportedException e1) {
							JOptionPane.showMessageDialog(g, e1.getMessage());
						}
						
						powerAttack=false;
						g.getHeroOnePanel().getHeroPower().setBorder(null);
						g.getHeroTwoPanel().getHeroPower().setBorder(null);
						updateMana(heroAttacker);
					}else if (spellAttack) { 
						
						try {
							game.getCurrentHero().castSpell((HeroTargetSpell)spellAttackerCard, hero);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(g, e1.getMessage());
						}catch(ClassCastException e1) {
							JOptionPane.showMessageDialog(g, "Cannot use this type of spell on a hero");
						}
						
						updateHP(hero);
						updateMana(game.getCurrentHero());
						updateHand(game.getCurrentHero());
						spellAttack = false ;
						
						
					}
					else {
						try {
							
							heroAttacker.attackWithMinion(minionAttacker, hero);
							p.getHeroHp().setText(hero.getCurrentHP() + "");

						} catch (CannotAttackException | NotYourTurnException | TauntBypassException
								| NotSummonedException | InvalidTargetException e1) {
							JOptionPane.showMessageDialog(g, e1.getMessage());
						}
						
						minionAttacker = null;
						updateField(heroOne);
						updateField(heroTwo);

					}
					heroAttacker = null;
				}
			}
			
			
			public void mouseEntered(MouseEvent e) {
				g.getCv().getCard().setIcon(MyPanel.resize("images/hero/" + heroName + ".png", 190, 300));
			}
		});
		
		// setting hero hand deck and mana 
		updateDeck(hero);
		updateHand(hero);
		updateMana(hero);
	}
	
	
	
	
	public void updateMana(Hero h) {
		//setting mana 
		if(h.equals(heroOne)) {
			g.getMv().getAcurrentMana().setText(heroOne.getCurrentManaCrystals()+"/"+heroOne.getTotalManaCrystals());
		}
		if(h.equals(heroTwo)) {
			g.getMv().getBcurrentMana().setText(heroTwo.getCurrentManaCrystals()+"/"+heroTwo.getTotalManaCrystals());
		}
		
	}
	
	
	public void updateHand(Hero hero  ) {
		HandPanel hand ;
		if(hero.equals(heroOne)) {
			hand = g.getHandOne();
		}else {
			hand = g.getHandTwo();
		}
		hand.removeAll();
		if(hero.equals(game.getOpponent())) {
			for(Card c : hero.getHand() ) {
				
				hand.add(new JLabel(MyPanel.resize("images/CardBack.png", 80, 110)));
				hand.add(Box.createRigidArea(new Dimension(10,5)));
			}
		}else {
			
		for (int i = 0; i < hero.getHand().size(); i++) {
			if (hero.getHand().get(i) instanceof Minion) {
				Minion m = (Minion) hero.getHand().get(i);
				String minionName = m.getName();
				JLabel minionCard = new JLabel(MyPanel.resize("images/minions/" + minionName + ".png", 90, 130));
				minionCard.setLayout(null);
				JLabel cardMana = new JLabel(MyPanel.resize("images/mana crystal.png", 25, 25));
				cardMana.setForeground(Color.white);
				cardMana.setFont(MyPanel.gameFont(16f));
				cardMana.setText(m.getManaCost()+"");
				cardMana.setBounds(0,2,25,25);
				cardMana.setHorizontalTextPosition(JLabel.CENTER);
				cardMana.setVerticalTextPosition(JLabel.CENTER);
				minionCard.add(cardMana);
				hand.add(minionCard);
				minionCard.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						// minionCard.setBorder(BorderFactory.createLineBorder(Color.white));
						g.getCv().getCard().setIcon(
								MyPanel.resize("images/minions/" + minionName + ".png", 190, 280));
					}
					public void mouseClicked(MouseEvent e) {
						try {
							//plays the minion on game field 
							hero.playMinion(m);
							//plays the minion on view field 
							updateField(hero);
							
							
						} catch (NotYourTurnException | NotEnoughManaException | FullFieldException e1) {
							JOptionPane.showMessageDialog(g, e1.getMessage());
							
						}
						
					}
				});
			}
			if (hero.getHand().get(i) instanceof Spell) {
				String spellName = hero.getHand().get(i).getName();
				JLabel spellCard;
				Spell spell= (Spell) hero.getHand().get(i);
				if (spellName.equals("Shadow Word: Death")) {
					spellCard = new JLabel(MyPanel.resize("images/spells/ShadowWord.png", 90, 130));
				} else {
					spellCard = new JLabel(MyPanel.resize("images/spells/" + spellName + ".png", 90, 130));
				}
				JLabel cardMana = new JLabel(MyPanel.resize("images/mana crystal.png", 25, 25));
				cardMana.setForeground(Color.white);
				cardMana.setFont(MyPanel.gameFont(16f));
				cardMana.setText(spell.getManaCost()+"");
				cardMana.setBounds(0,2,25,25);
				cardMana.setHorizontalTextPosition(JLabel.CENTER);
				cardMana.setVerticalTextPosition(JLabel.CENTER);
				spellCard.add(cardMana);
				hand.add(spellCard);
				spellCard.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						// spellCard.setBorder(BorderFactory.createLineBorder(Color.white));
						if (spellName.equals("Shadow Word: Death")) {
							g.getCv().getCard()
									.setIcon(MyPanel.resize("images/spells/ShadowWord.png", 190, 280));
						} else {
							g.getCv().getCard().setIcon(
									MyPanel.resize("images/spells/" + spellName + ".png", 190, 280));
						}

					}
					
					public void mouseClicked(MouseEvent e ) {
						if(spell instanceof AOESpell) {
							try {
								hero.castSpell( (AOESpell) spell , game.getOpponent().getField());
								updateField(heroOne);
								updateField(heroTwo);
								updateMana(heroOne);
								updateMana(heroTwo);
								updateHand(hero);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(g, e1.getMessage());
							}
							
						}else
						if(spell instanceof FieldSpell) {
							try {
								hero.castSpell((FieldSpell)spell);
								updateField(hero);
								updateMana(hero);
								updateHand(hero);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(g, e1.getMessage());
							}
						}else
						{
							
							// case using hero/minion or leeching spell 
							
							//if clicked before ---> deactivate 
							if(spellAttack) {
								heroAttacker = null ; 
								spellAttack = false;
								spellAttackerCard = null;
								spellCard.setBorder(null);
							}else {
							heroAttacker = hero ; 
							spellAttack = true;
							spellAttackerCard = spell;
							spellCard.setBorder(BorderFactory.createLineBorder(Color.white));
						}
						}
						
					}
					
					
					
				});
			}
		}
		
		}
		g.repaint();
		g.revalidate();
		
	}
	
	public void updateDeck(Hero h) {
		if(h.equals(heroOne)) {
		g.getMv().getCd().setText(heroOne.getDeck().size()+"");
		}
		if(h.equals(heroTwo)) {
		g.getMv().getOd().setText(heroTwo.getDeck().size()+"");
		}
	}
	
	public void updateField(Hero hero ) {
		FieldPanel field;
		
		if (hero.equals(heroOne)) {
			field = g.getFieldOne();
			
		}else {
			field = g.getFieldTwo();
			
		}
			field.removeAll();
			for (int i = 0; i < hero.getField().size(); i++) {
				Minion m = (Minion) hero.getField().get(i);
				String minionName = m.getName();
				FieldCard minionCard = new FieldCard(MyPanel.resize("images/field/"+minionName+".png", 90, 100));
				minionCard.getAtk().setText(m.getAttack()+"");
				minionCard.getHp().setText(m.getCurrentHP()+"");
				if(!m.sleeping) {
					minionCard.getSleeping().setVisible(false);
				}
				field.add(minionCard);
				updateHand(hero);
				minionCard.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						// minionCard.setBorder(BorderFactory.createLineBorder(Color.white));
						g.getCv().getCard().setIcon(
								MyPanel.resize("images/minions/" + minionName + ".png", 190, 280));
								
					}

					public void mouseClicked(MouseEvent e) {
						
						if (spellAttack==false && powerAttack == false && getMinionAttacker() == null ) {
							heroAttacker = hero;
							setMinionAttacker(m);
							minionCard.setBorder(BorderFactory.createLineBorder(Color.white));
							
							//detecting hero targets
							
						}else if(spellAttack==false && powerAttack == false && getMinionAttacker() != null && getMinionAttacker().equals(m) ) {
							heroAttacker = null;
							setMinionAttacker(null);
							minionCard.setBorder(null);
						} else {
							setMinionTarget(m);
							
							minionCard.setBorder(BorderFactory.createLineBorder(Color.red));
							
							if(powerAttack) {
								try {
									if(heroAttacker instanceof Mage) {
										((Mage)heroAttacker).useHeroPower(minionTarget);
									}
									if(heroAttacker instanceof Priest ) {
										((Priest)heroAttacker).useHeroPower(minionTarget);
									}
									
								} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
										| FullHandException | FullFieldException | CloneNotSupportedException e1) {
									JOptionPane.showMessageDialog(g, e1.getMessage());
								}
								g.getHeroOnePanel().getHeroPower().setBorder(null);
								g.getHeroTwoPanel().getHeroPower().setBorder(null);
								powerAttack = false;
							}else if(spellAttack){
								
								try {
									if(spellAttackerCard instanceof MinionTargetSpell) {
									heroAttacker.castSpell((MinionTargetSpell)spellAttackerCard, m);
									}else {
										heroAttacker.castSpell((LeechingSpell)spellAttackerCard, m);
										updateHP(heroAttacker);
									}
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(g, e1.getMessage());
								}
								
								spellAttack = false;
								updateHand(heroAttacker);
								
								
								
							}else {
								try {
									heroAttacker.attackWithMinion(getMinionAttacker(), getMinionTarget());
								} catch (CannotAttackException | NotYourTurnException | TauntBypassException
										| InvalidTargetException | NotSummonedException e1) {
									JOptionPane.showMessageDialog(g, e1.getMessage());
								}
							}
							setMinionAttacker(null);
							setMinionTarget(null);
							updateField(heroOne);
							updateField(heroTwo);
							
							
						}
						
						
						
					}
			});
		}
		 
		updateMana(hero);
		g.repaint();
		g.revalidate();
		
	}

	public void updateHP(Hero hero) {
		if (hero.equals(heroOne)) {
			g.getHeroOnePanel().getHeroHp().setText(heroOne.getCurrentHP() + "");

		} else {
			g.getHeroTwoPanel().getHeroHp().setText(heroTwo.getCurrentHP() + "");

		}
	}
	public Minion getMinionAttacker() {
		return minionAttacker;
	}

	public void setMinionAttacker(Minion minionAttacker) {
		this.minionAttacker = minionAttacker;
	}

	public Minion getMinionTarget() {
		return minionTarget;
	}

	public void setMinionTarget(Minion minionTarget) {
		this.minionTarget = minionTarget;
	}

	public Hero getHeroTarget() {
		return heroTarget;
	}

	public void setHeroTarget(Hero heroTarget) {
		this.heroTarget = heroTarget;
	}

	public Hero getHeroAttacker() {
		return heroAttacker;
	}

	public void setHeroAttacker(Hero heroAttacker) {
		this.heroAttacker = heroAttacker;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
