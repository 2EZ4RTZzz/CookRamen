package kitchen;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class WaterBottle extends Button {
	public WaterBottle(float x, float y, double s) {
		super(x,y,s);
		img = ImageLoader.loadImage("assets/waterCup.png");
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x-90, pos.y-100);
		g2.scale(scale,scale);
		g2.drawImage(img, -img.getWidth() /4, -img.getHeight() / 4, null);
		g2.setTransform(transform);
	}

}
