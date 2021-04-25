package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class HandPanel extends MyPanel {

	public HandPanel() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(300, 120));
		this.setOpaque(false);
		// this.setBackground(new Color(100, 200, 200, 123));

		
	}

}
