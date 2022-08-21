/*
 *  Sentences class
 *  for making a in game texts , only needs a location variables pos x/y 
 *  and set font size / name
 */
package kitchen;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Sentences {
	protected PVector pos;
	
	public Sentences(float x , float y) {
		pos=new PVector(x,y);
	}
	
	public void display(Graphics2D g2 , String text) {
		AffineTransform at = g2.getTransform();
		Font f = new Font("Garamond", Font.BOLD, 25);
		g2.setFont(f);
		g2.translate(pos.x, pos.y);
		g2.drawString(text,0,0);
		g2.setTransform(at);
	}
}
