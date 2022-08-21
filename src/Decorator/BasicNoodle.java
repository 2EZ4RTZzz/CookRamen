/*
 *  BasicNoodle 
 *  with pos,size,img 3 fields and implement an interface.
 */
package Decorator;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import processing.core.PVector;
import util.ImageLoader;

public class BasicNoodle implements CookedNoodleInterface{
	private PVector pos;
	private double size;
	private BufferedImage img;
	
	public BasicNoodle(float x, float y,  double size) {
		pos = new PVector(x,y);
		this.size = size;
		img = ImageLoader.loadImage("assets/WellDone.png");
	}
	public void decorate(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(size, size);
		g2.drawImage(img, -img.getWidth() / 4, -img.getHeight() / 4, null);
		g2.setTransform(transform);
	}
}
