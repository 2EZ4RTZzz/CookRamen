/*
 *  GreenOnion class extends from the superclass Button
 *  for read the GreenOnion image method.
 */
package kitchen;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class GreenOnion extends Button {
	public GreenOnion(float x, float y, double s) {
		super(x,y,s);
		img = ImageLoader.loadImage("assets/Onion.png");
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y-40);
		g2.scale(scale,scale);
		g2.drawImage(img, -img.getWidth() /4, -img.getHeight() / 4, null);
		g2.setTransform(transform);
	}

}

