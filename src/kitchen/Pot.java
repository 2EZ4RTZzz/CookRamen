/*
 *  Pot class extends from the superclass Button
 *  for read the Pot image method.
 *  for the setImage method 
 *  there are 6 different pot images , images will change when the state changes
 */
package kitchen;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class Pot extends Button {
	public Pot(float x, float y, double s) {
		super(x,y,s);
		img = ImageLoader.loadImage("assets/NoodlePot.png");
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale,scale);
		g2.drawImage(img, -img.getWidth() /4, -img.getHeight() / 4, null);
		g2.setTransform(transform);
	}
	
	public void setImage(int stage) {

	    if (stage == 0)

	        img = ImageLoader.loadImage("assets/NoodlePot.png"); //off

	    else if (stage == 1)

	        img = ImageLoader.loadImage("assets/SaucePot.png");   //on
	    
	    else if (stage == 2)
	    	
	    	img = ImageLoader.loadImage("assets/MeatPot.png");   //on
	    
	    else if(stage == 3)
	    	
	    	img = ImageLoader.loadImage("assets/OnionPot.png");
	    
	    else if(stage == 4)
	    	
	    	img = ImageLoader.loadImage("assets/EggPot.png");
	    
	    else if(stage == 5)
	    	
	    	img = ImageLoader.loadImage("assets/WellDone.png");
	}
	
	public double getXPos(){
		return pos.x+30;
	}
	public double getYPos(){
		return pos.y+20;
	}

}
