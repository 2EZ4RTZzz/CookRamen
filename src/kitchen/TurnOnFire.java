/*
 *  Water class extends from the superclass Button
 *  for read the Water image method.
 *  there's also setImg method for changing different images(with different states)
 */
package kitchen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import util.ImageLoader;

public class TurnOnFire extends Button {
	// constructor
	public TurnOnFire(float x, float y, double s) {
		super(x,y,s);
		img = ImageLoader.loadImage("assets/Cooktop-2.png");
		
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}

	
	public void setImg(int ovenState) {

	    if (ovenState == 0)

	        img = ImageLoader.loadImage("assets/Light-Off.png");  //closed oven

	    else if (ovenState == 1)
	    	
	        img = ImageLoader.loadImage("assets/water1.png");   //opened oven

	    else if (ovenState == 2)
	    	
	        img = ImageLoader.loadImage("assets/water2.png"); //closed oven with pizza

	}

	public double getY() {
		// TODO Auto-generated method stub
		return pos.y;
	}
	
	public double getX() {
		// TODO Auto-generated method stub
		return pos.x;
	}

}