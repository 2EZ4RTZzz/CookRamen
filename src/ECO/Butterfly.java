package ECO;

import static util.ImageLoader.loadImage;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import kitchen.Button;
import util.ImageLoader;

public class Butterfly extends Button {
	
	public Butterfly(float x , float y , double s) {
		super(x,y,s);
		img=loadImage("assets/butterfly3.png");

	}
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform(); // save(x~y)
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/4 , -img.getHeight()/4, null);
		g2.setTransform(transform);
	}
	
	
	public void setImg(int State) {
		
		if(State == 0) {
			img = ImageLoader.loadImage("assets/butterfly1.png");
		}
		
		else if (State == 1)
	    	
	        img = ImageLoader.loadImage("assets/butterfly2.png");   //opened oven

	    else if (State == 2)
	    	
	        img = ImageLoader.loadImage("assets/butterfly3.png"); //closed oven with pizza

	}
	

}
