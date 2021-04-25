package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")

// a panel which have useful methods one for resizing and other one for loading custom font and setting its size

public abstract class MyPanel extends JPanel {
	
	
	//loading custom game font 
	//reference : https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
	public static Font gameFont(float size) {
		Font myFont = null;
		
			try {
				myFont = Font.createFont(Font.TRUETYPE_FONT, new File("LHF Uncial Caps.ttf")).deriveFont(size);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LHF Uncial Caps.ttf")));
			} catch (FontFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return myFont;	
			
		
	}
	
	//resize method from stackoverflow
	
	//Reference :  https://stackoverflow.com/questions/5895829/resizing-image-in-java
	
	// method for resizing images
	public static ImageIcon resize(String path, int x, int y) {
		// method for resizing image icons
		// reading the image
		
		//Reference : https://stackoverflow.com/questions/2266777/reading-a-image-file-in-java
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// resize the image
		Image dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		// creating image icon
		ImageIcon myimg = new ImageIcon(dimg);
		return myimg;
	}
}
