/*
 *  chopsticksDecorator extends from NoodleDecorator
 *  get super 4 fields from Noodledecorator
 */
package Decorator;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class chopsticksDecorator extends NoodleDecorator{
	
	public chopsticksDecorator(CookedNoodleInterface baseNoodle , float x, float y, double size) {
		super(baseNoodle, x, y, size);
		img = ImageLoader.loadImage("assets/chops.png");
	}
	
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		drawCilantroDecorator(g2);
	}
	
	public void drawCilantroDecorator(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(pos.x,pos.y);
		g2.scale(size,size);
		g2.drawImage(img, -img.getWidth()/4, -img.getHeight()/4, null);
		g2.setTransform(at);
	}
}
