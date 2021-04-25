package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
@SuppressWarnings("serial")
public class AboutUsView extends JFrame{
	public AboutUsView() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ImageIcon i = new ImageIcon("images/logo.png");
		setIconImage(i.getImage());
		setResizable(false);
		//setUndecorated(true); // gets rid of borders title bar etc (call before JFrame is visible)
		setSize(200, 150);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		JPanel p = new JPanel();
		 JTextArea j = new JTextArea("Made By:\nTeam 166 \nMark Malak \nYoussef Youhanna \nThomas Safwat ");
		 j.setOpaque(false);
		 j.setFont(MyPanel.gameFont(18f));
		 p.add(j);
		 add(p);
	}
}
