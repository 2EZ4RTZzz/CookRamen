/*
 * this is a factory mode class
 * which includes all the image's data pos x , y , and size 
 * for the factory part
 */

package kitchen;

import Decorator.BasicNoodle;
import ECO.MusicKits;

public class RamenFactory {
	public Button createNewButton(String type) {
		if (type == "light") {
			return new Light(930, 650, 0.4);
		} else if (type == "waterBottle") {
			return new WaterBottle(650, 560, 0.4);
		} else if (type == "emptyBox") {
			return new HitBox(150, 590, 0.15);
		} else if (type == "water") {
			return new Water(129, 595, 0.35);
		} else if (type == "fireButton") {
			return new FireButton(140, 805, 0.4);
		} else if (type == "OneNoodle") {
			return new SingleNoodle(200, 400, 0.4);
		} else if (type == "pot") {
			return new Pot(115, 600, 0.4);
		} else if (type == "sauce") {
			return new Sauce(150, 250, 0.4);
		} else if (type == "meat") {
			return new SingleMeat(405, 270, 0.4);
		} else if (type == "onion") {
			return new GreenOnion(405, 410, 0.4);
		} else if (type == "egg") {
			return new Egg(700, 290, 0.4);
		} else if (type == "playButton") {
			return new PlayButton(870, 800, 1.5);
		} else if (type == "replay") {
			return new ReplayButton(200, 750, 0.4);
		} else if (type == "flowerBase") {
			return new FlowerBase(860, 130, 0.2);
		} else if (type == "musicKit") {
			return new MusicKits(1130, 550, 0.3);
		} else if (type == "cilantro") {
			return new Cilantro(1000, 120, 0.1);
		} else if (type == "Watersmoke") {
			return new WaterSmoke(140, 540, 0.35);
		}
		else {
			return null;
		}

	}

}
