/*
 *  FlowerBase class extends from the superclass Button
 *  for read the FlowerBase image method.
 */
package kitchen;

import static util.ImageLoader.loadImage;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class FlowerBase extends Button{
	public FlowerBase (float x , float y , double s) {
		super(x,y,s);
		img=loadImage("assets/Plant1.png");
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform(); // save(x~y)
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/4 , -img.getHeight()/4, null);
		g2.setTransform(transform);
	}

}
