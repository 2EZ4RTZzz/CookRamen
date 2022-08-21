/*
 *  flower recursion class , 
 *  use recursion to create a pretty flower  and draw it  
 *  and there's a click method for the decorator part.
 */
package kitchen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.*;

import processing.core.PVector;
import util.Util;

public class Flower {
	private PVector pos;
	
	public Flower(float x , float y) {
		pos = new PVector(x,y);
	}
	public void drawFlower(Graphics2D g2, float len) {
		g2.setStroke(new BasicStroke(2));
		int z = (int) (17+Util.random(1, 2));
		int x = (int) (92+Util.random(1, 2));
		int y = (int) (53+Util.random(1, 2));
		g2.setColor(new Color(z, x, y));
		g2.draw(new Line2D.Float(0, 0, 0, -len)); // Draw the branch itself

		g2.translate(0, -len); // Move to the end of that line

		len *= 0.79; // Shrink the length of the branch 枝叶长度

		if (len > 5) { // Base case: exit when the length of the branch is 2
						// pixels or less
			AffineTransform at = g2.getTransform();
			// g2.setColor(Color.red);
			g2.rotate(Math.PI / 4); // Rotate to the right
			drawFlower(g2, len); // Call itself to draw two shorter branches!!
			g2.setTransform(at);

			// Repeat the same thing, only branch off to the "left" this time!
			at = g2.getTransform();
			g2.rotate(-Math.PI / 3); // 旋转角度
			drawFlower(g2, len);
			g2.setTransform(at);
		}
	}
	
	public void draw(Graphics2D g2) {
		AffineTransform at3 = g2.getTransform();
		g2.translate(pos.x, pos.y);
		drawFlower(g2,30);
		g2.setTransform(at3);
	}

	public void changeColor(Graphics2D g2) {
		int z = 17;
		int x = 92;
		int y = 53;
		if (z < 45) {
			z += 1;
		}
		if (x < 255) {
			x += 1;
		}
		if (y < 144) {
			y += 1;
		}
		g2.setColor(new Color(z, x, y));
	}
	
	public boolean clicked(double x, double y) {
		boolean clicked = false;

		if (x > (pos.x - 40) && x < (pos.x +40)
				&& y > (pos.y - 70 )
				&& y < (pos.y + 70))
			clicked = true;

		return clicked;
	}
	public void setPos(float mouseX,float mouseY) {
		pos.x= mouseX;
		pos.y= mouseY;	
	}
}
