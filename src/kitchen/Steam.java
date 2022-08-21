/*
 * This is a smoke class  (perlin noise)
 * setup a new style smoke with red colour.
 */
package kitchen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;



import processing.core.PApplet;
import util.Util;

public class Steam {
	private float xPos, yPos;
	private int width, height;

	private float xstart;
	private float xnoise;
	private float ynoise;
	private PApplet pa;

	public Steam(float x , float y, int w, int h) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		xstart = Util.random(10);
		xnoise = xstart;
		ynoise = Util.random(10);
		pa = new PApplet();
	}
	public void drawSteam(Graphics2D g2) {
		float noiseFactor;
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos); 
		//lower to upper
		for(int y=height; y >= 0; y -= 10) {  //howmany teals
			ynoise += 1;
			xnoise = xstart;
			for(int x= 0; x<=width; x+=10) {
				xnoise+= 1;
				noiseFactor = pa.noise(xnoise,ynoise);
				AffineTransform at1 = g2.getTransform();
				g2.translate(x, y);
				g2.rotate(noiseFactor*Util.radians(200));
				float edgeSize = noiseFactor * 65;
				int r = (int) (255 + (noiseFactor));
				int g = (int) (0 +(noiseFactor*30));
				int b = (int) (0 +(noiseFactor*40));
				int alph = (int) (80 +(noiseFactor*90));
				g2.setColor(new Color(r,g,b,alph));
				g2.fill(new Ellipse2D.Float(-edgeSize/2, -edgeSize/2, edgeSize, edgeSize/2*noiseFactor*2));
				g2.fill(new Ellipse2D.Float(-edgeSize/2, -edgeSize/2, edgeSize*2-100, edgeSize/2*noiseFactor));
				g2.setTransform(at1);
			}
		}
		g2.setTransform(at);
	}
	public void setWidth(int i) {
		width = i;
	}
	public void setHeight(int i) {
		// TODO Auto-generated method stub
		height = i;
		
	}
}