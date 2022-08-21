/*
 *  kITCHEN BACKGROUND class
 *  its only for the background setting.
 */
package kitchen;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.RamenPanel;
import util.ImageLoader;

public class Kitchen {
	private BufferedImage img;

	public Kitchen(String file) {
		img = ImageLoader.loadImage(file);
	}

	public void drawKitchen(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(0, 0);
		g2.scale(1, 1);
		
		g2.drawImage(img, 0, 0, RamenPanel.W_WIDTH, RamenPanel.W_HEIGHT, null);
		//图像，左上角坐标，宽高，null 6个值
		//System.out.println(PizzaPanel.W_HEIGHT);
		g2.setTransform(at);
	}

}
