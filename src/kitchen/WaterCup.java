/*
 *  WaterCup class extends from the superclass Button
 *  for read the WaterCup image method.
 */
package kitchen;

import static util.ImageLoader.loadImage;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WaterCup extends Button{

	public WaterCup(float x, float y, double sca) {
		super(x,y,sca);
		img = loadImage("assets/waterCup.png");

	}

	
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(0.4, 0.4);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}

//	public void setPos(float x, float y) {
//		pos.x=x;
//		pos.y=y;
//	}
}

