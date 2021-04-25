package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WelcomeView extends JFrame {
	
	private AboutUsView about;
	private JLabel p ;
	public WelcomeView() {
		super("HearthStone : Welcome !");
		// setTitle("HearthStone : Welcome !");
		// for setting the icon of the window border
		ImageIcon i = new ImageIcon("images/logo.png");
		setIconImage(i.getImage());
		JLabel background = new JLabel(MyPanel.resize("images/welcome.png",800,600));
		setContentPane(background);

		setSize(800, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		 setResizable(false);
		 setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		
		 p = new JLabel("             PLAY");
		 p.setName("p");
		//325
		p.setFont(MyPanel.gameFont(18f));
		p.setBounds(300, 205, 240, 20);
		// a.setOpaque(false);
		JLabel b = new JLabel("                 About us");
		b.setFont(MyPanel.gameFont(18f));
		b.setBounds(260, 260, 260, 20);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				about = new AboutUsView();
				about.setVisible(true);
				
			}
		});
		JLabel c = new JLabel("                    Exit");
		c.setFont(MyPanel.gameFont(18f));
		c.setBounds(270, 315, 260, 20);
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(p);
		add(b);
		add(c);

		//setOpaque(false);

	}
	public void closeWindow() {
		if(about != null && about.isVisible()) {
			about.dispose();
		}
		this.dispose();
	}

	public static void main(String[] args) {
		//WelcomeView w = new WelcomeView();
		//w.setVisible(true);
		//GameView g = new GameView();
		//g.setVisible(true);
		//HeroChooserView h = new HeroChooserView();
		//h.setVisible(true);
	}

	
	
	
	public JLabel getP() {
		return p;
	}
	
	
	
	
	
	
	
}
