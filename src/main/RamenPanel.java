/*
 * WangYuyao 301290067 IAT 265 D102 Assignment4_FinalAssignment
 * This is a process of making ramen
 * user have to follow the steps to cook a good ramen.
 * 
 * About ECO part
 * 1. i drawed all the images by myself on the ipad , you can see the video last secs is about the reference  (i think it will worth 2 points)
 * 2. i create a butterfly , the butterfly will fly to the recusion plant for few secs and leave it (i think it will worth 2 points) (animation as well)
 * 3. i create a musicKit , user can click the musickit to start the background music or pause it , and when musickit is playing the sound , it will have some animation  (i hope i can get 2 point) (great background music and nice boiling water sound)
 * 4. there will be a day to night animation in the background window (i hope i can get 2 point )
 * 5. about FSM , there are actually 15 stpes, which is more than 4 FSM as requirement (i think this will be another 2 points)
 * 6. a fancy fire (created by palin noise) and there will be a timecount down for the cooking time ( i hope those two can get 2 points together)
 * 7. sophisticated complex shapes that are well polished and sensible to the app (maybe 1 point?) 
 * 8. about the arraylist , i sorting the arraylist well ( i hope i can get 1 point for it)
 * 9. about the decorator , user can pick a single cilantro from the recursion plants and drag it to the cooked noodle on the top (which i think i can also get 1 point for it as well)
 * 
 * for the sound reference(background sound)
 * https://downloads.khinsider.com/game-soundtracks/album/la-tale-gamerip/22%2520Yongkung%2520-%2520Wind%2520From%2520The%2520Far%2520East.mp3 
 * this is the download link that i used
 * Album name: La Tale (Windows) (gamerip) (2005)
 * Song name: Yongkung - Wind From The Far East
 * 
 * Thank you so much to read my comments ! hope you like my final project
 * Thank you Quang and Andrey!!!!!you guys are the best!!!! ^.^
 */


package main;
import static util.ImageLoader.loadImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;

import Decorator.BasicNoodle;
import Decorator.CookedNoodleInterface;
import Decorator.chopsticksDecorator;
import Decorator.cilantroDecorator;
import ECO.Butterfly;
import ECO.MusicKits;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import kitchen.Button;
import kitchen.Cilantro;
import kitchen.Egg;
import kitchen.FireButton;
import kitchen.Flower;
import kitchen.FlowerBase;
import kitchen.GreenOnion;
import kitchen.HitBox;
import kitchen.Kitchen;
import kitchen.Light;
import kitchen.PlayButton;
import kitchen.Pot;
import kitchen.RamenFactory;
import kitchen.ReplayButton;
import kitchen.Sauce;
import kitchen.Sentences;
import kitchen.SingleMeat;
import kitchen.SingleNoodle;
import kitchen.Steam;
import kitchen.TurnOnFire;
import kitchen.Water;
import kitchen.WaterBottle;
import kitchen.WaterCup;
import kitchen.WaterSmoke;
import kitchen.chopsticks;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.ImageLoader;
import util.MinimHelper;
import util.Util;

public class RamenPanel extends JPanel implements ActionListener {
	public static int W_WIDTH = 1220;
	public static int W_HEIGHT = 937;   
	// variables for holding mouse position
	private float mouseX;
	private float mouseY;

	// Fields for state and transitions
	private Kitchen IntroPage, KitchenOff, KitchenOn, EndPage, fillWater, fireOn, LeftFireOn;
	private Kitchen sun1 , sun2 , sun3 , sun4 , sun5 , sun6 , sun7, sun8 , sun9;
	private Button light;
	private TurnOnFire fire;
	private WaterCup waterPot;
	private Timer timer;
	private Minim minim;
	private AudioPlayer bkmusic, click, close, drag, tap, daoshui , waterBoil;

	private JFrame jframe;

	private Steam steam;
	private boolean cooking = false;
	private int boiling = 0;

	private Button flowerBase;
	private int index;
	private int frameCount;
	private boolean kits = false;

	private Button playButton;
	private Button waterBottle;
	private Button emptyBox;
	private Button water;
	private Button fireButton;
	private Button OneNoodle;
	private Button pot;
	private Button sauce;
	private Button meat;
	private Button onion;
	private Button egg;
	private Sentences sentence,countdownTimeCheck;
	private Button replay;
	private Flower flower;
	private Button musicKit;
	private Button Watersmoke;

	// eco butterfly
	private Butterfly butterflies;
	private int butterflyMoveX, butterflyMoveY;
	private boolean changePic = false; 
	// factory mode
	RamenFactory factory;
	//////////////// deco
	private CookedNoodleInterface Noodle;
	private Cilantro cilantro;
	private chopsticks chops;
	///////////////
	//change boilwater smoke pic
	private int timeCount = 300;

	private final int Intro = 0;
	private final int LightOff = 1;
	private final int LightOn = 2;
	private final int dragWater = 3, turnOnFire = 4, dragNoodle = 5, dragSauce = 6, dragMeat = 7, dragOnion = 8,
			dragEgg = 9, cookTime = 10, finish = 11, deco1 = 12;
	private final int noodleWithCilantro = 13 , noodleWithChops=14 , finalDone=15;
	private int state = 0;
	
	
	private ArrayList<Button> packs = new ArrayList<Button>();
	// missing one deco

	RamenPanel(JFrame frame) {
		jframe = frame;
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
		IntroPage = new Kitchen("assets/startPage.png");
		EndPage = new Kitchen("assets/RestartPage.png");
		KitchenOff = new Kitchen("assets/LightOff.png");
		KitchenOn = new Kitchen("assets/Light-On.png");
		fillWater = new Kitchen("assets/FillWater.png");
		fireOn = new Kitchen("assets/FireOn.png");
		LeftFireOn = new Kitchen("assets/OpenFireLeft.png");
		
		sun1= new Kitchen("assets/sun1.png");
		sun2= new Kitchen("assets/sun2.png");
		sun3= new Kitchen("assets/sun3.png");
		sun4= new Kitchen("assets/sun4.png");
		sun5= new Kitchen("assets/sun5.png");
		sun6= new Kitchen("assets/sun6.png");
		sun7= new Kitchen("assets/sun7.png");
		sun8= new Kitchen("assets/sun8.png");
		sun9= new Kitchen("assets/sun9.png");

		factory = new RamenFactory();
		light = factory.createNewButton("light");
		waterBottle = factory.createNewButton("waterBottle");
		emptyBox = factory.createNewButton("emptyBox");
		water = factory.createNewButton("water");
		fireButton = factory.createNewButton("fireButton");
		OneNoodle = factory.createNewButton("OneNoodle");
		pot = factory.createNewButton("pot");
		sauce = factory.createNewButton("sauce");
		meat = factory.createNewButton("meat");
		onion = factory.createNewButton("onion");
		egg = factory.createNewButton("egg");
		playButton = factory.createNewButton("playButton");
		replay = factory.createNewButton("replay");
		flower = new Flower(1025, 200);
		flowerBase = factory.createNewButton("flowerBase");
		musicKit = factory.createNewButton("musicKit");
		Watersmoke = factory.createNewButton("Watersmoke");
		// deco 1 + 2 
		cilantro = new Cilantro(1000, 120, 0.1);
		chops = new chopsticks(900,580,0.4);
		// one noodle without any decorations
		Noodle = new BasicNoodle(115, 600, 0.4);
		// with decorations
		Noodle = new cilantroDecorator(Noodle, 120, 580, 0.1);
		
		steam = new Steam((float) ((Pot)pot).getXPos()-20, (float) ((Pot)pot).getYPos() + 110, 100, 30);
		sentence = new Sentences(90, 180);
		countdownTimeCheck = new Sentences(165,700);
		minim = new Minim(new MinimHelper());

		bkmusic = minim.loadFile("shangjing.mp3");
		click = minim.loadFile("tap.mdp3");
		close = minim.loadFile("close.mp3");
		drag = minim.loadFile("drag.mp3");
		tap = minim.loadFile("tap.mp3");
		daoshui = minim.loadFile("daoshui.wav");
		waterBoil = minim.loadFile("boiled-water.mp3");
 
		//arraylist part for state 1
		packs.add(flowerBase);
		packs.add(musicKit);
		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);
		MyMouseMotionAdapter m2 = new MyMouseMotionAdapter();
		addMouseMotionListener(m2);
		timer = new Timer(30, this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (state == Intro) { // 0
			((Light) light).setLightOn(false);
			IntroPage.drawKitchen(g2);
			playButton.draw(g2);
		} else if (state == LightOff) { // 1
			KitchenOff.drawKitchen(g2);
			sentence.display(g2, "Please turn on the light!");
			for(Button i : packs) {
				i.draw(g2);
			}
			g2.setColor(new Color(0, 0, 0, 150));
			g2.fill(new Rectangle2D.Double(0, 0, 1220, 937));
		} else if (state == LightOn) { // 2
			sun1.drawKitchen(g2);
			items(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			sentence.display(g2, "Fill the water in the left pot , Thank you");
			flower.draw(g2);
			butterflies.draw(g2);
		} else if (state == dragWater) { // 3
			sun2.drawKitchen(g2);
			items(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			sentence.display(g2, "Turn on the fire and start boil the water");
			flower.draw(g2);
			butterflies.draw(g2);
			waterBoil.loop();
		} else if (state == turnOnFire) { // 4
			sun3.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			items(g2);

			sentence.display(g2, "Please put the noodles into the pot");
			flower.draw(g2);
			butterflies.draw(g2);
		} else if (state == dragNoodle) { // 5
			sun4.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}

			sentence.display(g2, "Please, put sauce into the pot");
			flower.draw(g2);
			butterflies.draw(g2);
		} else if (state == dragSauce) { // 6
			sun5.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}

			sentence.display(g2, "Please, put meat into the pot");
			flower.draw(g2);
			butterflies.draw(g2);
			
		} else if (state == dragMeat) { // 7
			sun6.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			sentence.display(g2, "Please, put green onion into the pot");
			flower.draw(g2);
			butterflies.draw(g2);
			
		} else if (state == dragOnion) { // 8
			sun7.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			sentence.display(g2, "Please, put egg into the pot");
			flower.draw(g2);
			butterflies.draw(g2);

		} else if (state == dragEgg) { // 9
			sun8.drawKitchen(g2);
			for(Button i : packs) {
				i.draw(g2);
			}
			steam.drawSteam(g2);
			sentence.display(g2, "wait wait wait...");
			flower.draw(g2);
			butterflies.draw(g2);
			countdownTimeCheck.display(g2, timeCount/30+"");

			
			
		} else if (state == cookTime) { // 10
			sun9.drawKitchen(g2);
			pot.setImage(5);	
			pot.draw(g2);
			flowerBase.draw(g2);
			sentence.display(g2, "Congratulations! Click one more time go to the Decorator part");
			musicKit.draw(g2);
			flower.draw(g2);
			butterflies.draw(g2);
			waterBoil.pause();
		}
		else if (state == finish) { // 11
			EndPage.drawKitchen(g2);
			replay.draw(g2);
		}
		else if (state == deco1) { // 12
			sun9.drawKitchen(g2);
			pot.draw(g2);
			flowerBase.draw(g2);
			sentence.display(g2, "Please drag some cilantro from the plant");
			musicKit.draw(g2);
			flower.draw(g2);
			cilantro.draw(g2);
			butterflies.draw(g2);
		} else if (state == noodleWithCilantro) { // 13
			sun9.drawKitchen(g2);
			pot.draw(g2);
			flowerBase.draw(g2);
			sentence.display(g2, "great work! now click the chopsicks!");
			musicKit.draw(g2);
			flower.draw(g2);
			Noodle.decorate(g2);
			butterflies.draw(g2);
			chops.draw(g2);
		} else if (state == noodleWithChops) {  //14
			sun9.drawKitchen(g2);
			pot.draw(g2);
			flowerBase.draw(g2);
			musicKit.draw(g2);
			flower.draw(g2);
			Noodle = new chopsticksDecorator(Noodle ,50,550,0.4);
			Noodle.decorate(g2);
			butterflies.draw(g2);
			sentence.display(g2, "well done! Now turn off the Light");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(state == dragEgg) {
			timeCount--;
		}
//		System.out.println(state);
		randomSpeed();
		butterflies = new Butterfly(butterflyMoveX, butterflyMoveY, 0.15);
		update();
		if (index == 0) {
			butterflies.setImg(0);
		}
		if (index == 1) {
			butterflies.setImg(1);
		}
		if (butterflyMoveX == 1050) {
			butterflies.setImg(3);
		}

		if (state == dragEgg) {
			steam.setWidth(boiling / 2); // width
			steam.setHeight(boiling / 10); // height
			if (!cooking) {
				boiling++;
				if (boiling >= 150) {
					boiling = 150;
					cooking = true;
				}
			} else {
				boiling--;
				if (boiling <= 0) {
					boiling = 0;
					state = cookTime;
				}
			}
		}
		if (kits == true) {
			update();
			if (index == 0) {
				((MusicKits)musicKit).setImg(1);
			}
			if (index == 1) {
				((MusicKits)musicKit).setImg(2);
			}
		}
		repaint();
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			if (state == Intro && playButton.clicked(mouseX, mouseY)) {
				state = LightOff;
			} else if (state == LightOff && light.clicked(mouseX, mouseY)) {
				state = LightOn;
				packs.clear();
				packs.add(waterBottle);
				packs.add(flowerBase);
				packs.add(musicKit);
			} else if (state == LightOn && light.clicked(mouseX, mouseY)) {
				state = LightOff;
			} else if (state == dragWater && fireButton.clicked(mouseX, mouseY)) {
				state = turnOnFire;
				packs.clear();
				packs.add(Watersmoke);
				packs.add(flowerBase);
				packs.add(musicKit);
			} else if (state == cookTime) {
				state = deco1;
			}
			else if (state == deco1 && flower.clicked(mouseX, mouseY)) {
				cilantro.setImage(0);
				state = noodleWithCilantro;
			}else if (state == finish && replay.clicked(mouseX, mouseY)) {
				jframe.dispose();
				jframe = new RamenApp("RamenApp");
				bkmusic.pause();
			}
			else if(state == finish && replay.clicked(mouseX, mouseY)) {
				bkmusic.pause();
			}
			else if(state ==noodleWithCilantro && chops.clicked(mouseX, mouseY)) {
				state = noodleWithChops;
			}
			else if(state == noodleWithChops && light.clicked(mouseX, mouseY)) {
				state = finish;
			}

			if (musicKit.clicked(mouseX, mouseY) && kits == false) { // 如果点击 则true
				kits = true;
				bkmusic.loop();
			} else if (kits == true && musicKit.clicked(mouseX, mouseY)) { // else 当kits 是true 同时且 点击了kits
				kits = false;
				System.out.println(kits);
				((MusicKits)musicKit).setImg(0);
				bkmusic.pause();
			}
			
		}
	}

	public class MyMouseMotionAdapter extends MouseMotionAdapter {

		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			if (state == LightOn && waterBottle.clicked(mouseX, mouseY)) {
				waterBottle.setPos(e.getX(), e.getY()); // 位置改到鼠标的位置！！！！x ,y就对应的鼠标xy轴				
				drag.loop();
				if (waterBottle.hit(emptyBox)) { // 如果pizza值撞到了烤箱 ， 那么变化状态，增加音乐等。
					state = dragWater;
					packs.clear();
					packs.add(water);
					packs.add(flowerBase);
					packs.add(musicKit);
					drag.pause();
				}
			}
			if (state == turnOnFire && OneNoodle.clicked(mouseX, mouseY)) {
				OneNoodle.setPos(e.getX(), e.getY());
				if (OneNoodle.hit(emptyBox)) {
					state = dragNoodle;
					packs.clear();
					packs.add(egg);
					packs.add(meat);
					packs.add(onion);
					packs.add(flowerBase);
					packs.add(musicKit);
					packs.add(pot);
					packs.add(sauce);
				}
			}

			if (state == dragNoodle && sauce.clicked(mouseX, mouseY)) {
				sauce.setPos(e.getX(), e.getY());
				if (sauce.hit(pot)) {
					state = dragSauce;		       //6
					packs.clear();
					pot.setImage(1);
					packs.add(pot);
					packs.add(onion);
					packs.add(meat);
					packs.add(egg);
					packs.add(flowerBase);
					packs.add(musicKit);
 
				}
			}

			if (state == dragSauce && meat.clicked(mouseX, mouseY)) {
				meat.setPos(e.getX(), e.getY());
				if (meat.hit(pot)) {
					state = dragMeat;                //7
					packs.clear();
					pot.setImage(2);
					packs.add(pot);
					packs.add(onion);
					packs.add(egg);
					packs.add(flowerBase);
					packs.add(musicKit);

				}
			}

			if (state == dragMeat && onion.clicked(mouseX, mouseY)) {
				onion.setPos(e.getX(), e.getY());
				if (onion.hit(pot)) {                 //8
					state = dragOnion;
					packs.clear();
					pot.setImage(3);
					packs.add(pot);
					packs.add(egg);
					packs.add(flowerBase);
					packs.add(musicKit);					

				}
			}

			if (state == dragOnion && egg.clicked(mouseX, mouseY)) {
				egg.setPos(e.getX(), e.getY()); 
				if (egg.hit(pot)) {
					state = dragEgg;		         //9
					packs.clear();
					pot.setImage(4);
					packs.add(pot);
					packs.add(flowerBase);
					packs.add(musicKit);	
				}
			}
			if (state == deco1 && cilantro.clicked(mouseX, mouseY)) {
				cilantro.setPos(e.getX(), e.getY());
				if (cilantro.hit(pot)) {
					state = noodleWithCilantro;
				}
			}
		}

	}

	public void update() {
		frameCount++;
		if (frameCount % 20 == 0) {
			index++;
			index = index % 2;
		}
	}

	public void items(Graphics2D g2) {
		OneNoodle.draw(g2);
		meat.draw(g2);
		sauce.draw(g2);
		egg.draw(g2);
		onion.draw(g2);
	}

	public void randomSpeed() {
		// move x
		if (butterflyMoveX < 1050 && state >= 2 && state < 6) {
			butterflyMoveX = (int) (0 + Util.random(4, 5)) + butterflyMoveX;
		}

		// move y
		if (butterflyMoveY < 120) {
			butterflyMoveY = (int) (0 + Util.random(9, 10)) + butterflyMoveY;
		}
		if (state >= 2 && butterflyMoveX < 1050) {
			butterflyMoveY = (int) (butterflyMoveY - Util.random(2, 2));
		}
		if (state > 7) {
			butterflyMoveX = (int) (butterflyMoveX + Util.random(2, 3));
			butterflyMoveY = (int) (butterflyMoveY - Util.random(2, 2));
		}
	}

}
