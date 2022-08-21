/*
 *  Basic abstract class
 *  included couple abstract method and normal method all shares for the subclass from the Kitchen package.
 *  there are 3 basic fields and couple different methods. 
 * 
 */
package kitchen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import processing.core.PVector;
import util.ImageLoader;

//draw the lamp 
public abstract class Button  {
	protected PVector pos;
	protected double scale;
	protected BufferedImage img;

	// constructor
	public Button(float x, float y,  double s) {
		pos = new PVector(x,y);
		this.scale = s;
	}
	public abstract void draw(Graphics2D g2);
	
	public boolean clicked(double x, double y){
		boolean clicked = false;
			if (x > (pos.x - ((double) img.getWidth()) / 2 *scale) 
					&& x < (pos.x + ((double) img.getWidth())/2*scale) 
					&& y > (pos.y - ((double) img.getHeight())/2*scale) 
					&& y < (pos.y + ((double) img.getHeight())/2*scale)) 
			clicked = true;
		return clicked;
	}
	
	
	public void setImage(int state) { 	
	}
	public void setPos(float mouseX,float mouseY) {
		pos.x = mouseX;
		pos.y = mouseY;
	}
	
	public boolean hit(Button other) {  //鍥剧墖鍜屽浘鐗囨槸鍚︽挒鍦ㄤ簡涓�璧� 
		boolean hit = false;
		
		if(Math.abs(pos.x-other.pos.x)<50 && Math.abs(pos.y-other.pos.y)<30) hit = true;
		
		return hit;
	}
}

