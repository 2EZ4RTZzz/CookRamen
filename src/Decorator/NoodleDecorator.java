//baisc noodle decorator part "base part" with 4 fields one of them are interface 
package Decorator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import processing.core.PVector;

public class NoodleDecorator implements CookedNoodleInterface{
	
	CookedNoodleInterface baseNoodle;
	protected PVector pos;
	protected double size;
	protected BufferedImage img;
	
	public NoodleDecorator(CookedNoodleInterface baseNoodle,float x, float y,double size) {
		this.baseNoodle = baseNoodle;
		pos = new PVector(x,y);
		this.size = size;
		
	}
	public void decorate(Graphics2D g2) {
		baseNoodle.decorate(g2);	
	}

}
