/*
 *  Light class extends from the superclass Button
 *  for read the Light image method.
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
public class Light extends Button {
	private boolean lightOn = false;

	// constructor
	public Light(float x, float y,  double s) {
		super(x,y,s);
		img = ImageLoader.loadImage("assets/lamp.png");  //导入的地址 是从assets 导入
	}
 
	// draw the lamp: it will be on once being clicked
	public void draw(Graphics2D g2) {

		AffineTransform transform = g2.getTransform(); // save(x~y)
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/4 , -img.getHeight()/4, null);
		//g2.drawImage(img, 1800, 3300, null);
		//-img.getWidth()/2-1000 , -img.getHeight()/2,
		//这个缺少了宽高，默认就用图片大小的宽高，如果图片自带宽100 高 100 ， 这个就默认宽高100 100
//		if (!lightOn){ //draw a white bulb using geoms on top to hide the light
//			g2.setColor(new Color(250, 250, 250));
//			Rectangle2D.Double tube = new Rectangle2D.Double(-20, 65, 37, 37*3);
//			g2.draw(tube);
//			Ellipse2D.Double bulb = new Ellipse2D.Double(-70, 140, 37*4, 51*4);
//			g2.fill(bulb);
//		}
		g2.setTransform(transform);
	}
	
	
	public void setLightOn(boolean on){
		lightOn = on;
	}
	
	
}