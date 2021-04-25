package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class FieldPanel extends MyPanel {

	public FieldPanel() {
		super();
		setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(650, 85));
		
		/*
		 * for (int n = 0; n < 3; n++) {
		 * 
		 * FieldCard i = new FieldCard(resize("images/field/Icehowl.png", 90, 100));
		 * this.add(i);
		 * 
		 * }
		 */

	}

}
