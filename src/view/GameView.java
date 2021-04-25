package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JFrame {

	private CardViewer cv;
	private ManaView mv;
	private JPanel Players, PlayerOne,PlayerTwo;
	private HeroPanel HeroOnePanel,HeroTwoPanel;
	private HandPanel HandOne,HandTwo;
	private FieldPanel FieldOne,FieldTwo;
	

	public GameView() {
		super("HearthStone");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// icon
		ImageIcon i = new ImageIcon("images/logo.png");
		setIconImage(i.getImage());
		// background
		JLabel background = new JLabel(MyPanel.resize("images/gameboard.png",1280,720));
		setContentPane(background);

		// ---------***sizing of the window***-----------
		// set to (1280,720) if undecorated is true
		setSize(1290, 760);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setResizable(false);
		//setUndecorated(true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));

		// adding cardview
		cv = new CardViewer();
		add(cv);

		// adding manaview
		mv = new ManaView();

		// players
		Players = new JPanel(new BorderLayout());
		Players.setOpaque(false);
		
		
		// player one
		PlayerOne = new JPanel(new BorderLayout());
		PlayerOne.setPreferredSize(new Dimension(900, 360));
		PlayerOne.setOpaque(false);
		// player one hand
		HandOne = new HandPanel();
		PlayerOne.add(HandOne, BorderLayout.SOUTH);
		// player one hero and power
		HeroOnePanel = new HeroPanel();
		PlayerOne.add(HeroOnePanel, BorderLayout.CENTER);
		// player one field
		FieldOne = new FieldPanel();
		JPanel wrapper = new JPanel();
		wrapper.add(FieldOne);
		wrapper.setOpaque(false);
		PlayerOne.add(wrapper, BorderLayout.NORTH);
		Players.add(PlayerOne, BorderLayout.SOUTH);
		
		
		//player two
		PlayerTwo = new JPanel(new BorderLayout());
		PlayerTwo.setPreferredSize(new Dimension(900, 360));
		PlayerTwo.setOpaque(false);
		// player two hand
		HandTwo = new HandPanel();
		PlayerTwo.add(HandTwo, BorderLayout.NORTH);
		// player two hero and power
		HeroTwoPanel = new HeroPanel();
		PlayerTwo.add(HeroTwoPanel, BorderLayout.CENTER);
		// player two field
		FieldTwo = new FieldPanel();
		JPanel wrapper2 = new JPanel();
		wrapper2.add(FieldTwo);
		wrapper2.setOpaque(false);
		PlayerTwo.add(wrapper2, BorderLayout.SOUTH);
		
		
		Players.add(PlayerOne, BorderLayout.SOUTH);
		Players.add(PlayerTwo, BorderLayout.NORTH);
		add(Players);
		add(mv);

	}

	

	public CardViewer getCv() {
		return cv;
	}

	public ManaView getMv() {
		return mv;
	}

	public JPanel getPlayers() {
		return Players;
	}

	public JPanel getPlayerOne() {
		return PlayerOne;
	}

	public JPanel getPlayerTwo() {
		return PlayerTwo;
	}

	public HeroPanel getHeroOnePanel() {
		return HeroOnePanel;
	}

	public HeroPanel getHeroTwoPanel() {
		return HeroTwoPanel;
	}

	public HandPanel getHandOne() {
		return HandOne;
	}

	public HandPanel getHandTwo() {
		return HandTwo;
	}

	public FieldPanel getFieldOne() {
		return FieldOne;
	}

	public FieldPanel getFieldTwo() {
		return FieldTwo;
	}
	
	
	

}
