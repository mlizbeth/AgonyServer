package io.valhala.agonyserver;

import java.util.Random;

import io.valhala.agonyserver.framework.PlayerCollision;
import io.valhala.agonyserver.framework.entity.Weapon;
import io.valhala.agonyserver.framework.graphics.ImageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CharacterMovement extends Pane {
//DFA
	public ImageView imageView;
	Random ran = new Random(System.currentTimeMillis());
	int atk = 1;
	int count = 3;
	int spawn;
	int columns = 3;
	int offsetX = 0;
	int offsetY = 0;
	int dir;
	int width = 32;
	int height = 32;
	private int num = ran.nextInt(300);
	public boolean direction = true;
	public boolean dead = false;
	public SpriteAnimation animation;
	Rectangle threat;
	Weapon axe;

	
	public CharacterMovement(String string, int x,int  y){
		
		axe = new Weapon("/images/throwing_axe.png", 0, 0);
		
		imageView = ImageLoader.loadImg( string);
		this.relocate(x,y);
		
		threat = new Rectangle(x -100, y -100, 200, 200);
		
		animation = new SpriteAnimation(imageView, Duration.millis(300), count, columns, offsetX, offsetY, width, height);
		getChildren().addAll(imageView);
		//Game.root.getChildren().addAll(axe);
	}
	
	public void moveX(int x) {
		boolean right = x>0?true:false;
		this.num += x;
		if (this.num > 300)
			direction = false;
		else if (this.num < 0){
			direction = true;
		}
		for(int i = 0; i < Math.abs(x); i++) {
			if(right) {
				this.setLayoutX(this.getLayoutX() +1);
			}
				else { 
					this.setLayoutX(this.getLayoutX() - 1);
				}
		}
	}
	
	public void moveY(int y) {
		boolean right = y>0?true:false;
		
		this.num += y;
		if (this.num > 300)
			direction = false;
		else if (this.num < 0){
			direction = true;
		}
		
		for(int i = 0; i < Math.abs(y); i++) {
			if (right) {
				this.setLayoutY(this.getLayoutY() +1);
			}
				else { 
					this.setLayoutY(this.getLayoutY() -1);
				}
		}
	
}
	public int getOffsetX() {
		return offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	
	public void update() {
		
		if(isPressed(KeyCode.W) && isPressed(KeyCode.D)) {
			//starts the animation of the sprite
			this.animation.play(); 
			//picks the bottom Sprite
			this.animation.setOffsetY(96);
			//sets the range to decide direction of sprite
			this.moveY(-2);
			this.moveX(2);
		}
		else if(isPressed(KeyCode.W) && isPressed(KeyCode.A)) {
			//starts the animation of the sprite
			this.animation.play();
			//picks the top sprite
			this.animation.setOffsetY(96);
			//sets range to decide direction of sprite
			this.moveY(-2);
			this.moveX(-2);
		}
		else if(isPressed(KeyCode.S) && isPressed(KeyCode.D)) {
			this.animation.play();
			this.animation.setOffsetY(0);
			this.moveX(2);
			this.moveY(2);
		}
		else if(isPressed(KeyCode.S) && isPressed(KeyCode.A)) {
				this.animation.play();
				this.animation.setOffsetY(0);
				this.moveX(-2);
				this.moveY(2);
		}
		
		else if(isPressed(KeyCode.UP) || isPressed(KeyCode.W)) {
			//starts the animation of the sprite
			this.animation.play(); 
			//picks the bottom Sprite
			this.animation.setOffsetY(96);
			//sets the range to decide direction of sprite
			this.moveY(-2);
			dir = 3;
		}
		else if(isPressed(KeyCode.DOWN) || isPressed(KeyCode.S)) {
			//starts the animation of the sprite
			this.animation.play();
			//picks the top sprite
			this.animation.setOffsetY(0);
			//sets range to decide direction of sprite
			this.moveY(2);
			dir = 2;
		}
		else if(isPressed(KeyCode.RIGHT) || isPressed(KeyCode.D)) {
			this.animation.play();
			this.animation.setOffsetY(64);
			this.moveX(2);
			dir = 0;
		}
		else if(isPressed(KeyCode.LEFT) || isPressed(KeyCode.A)) {
				this.animation.play();
				this.animation.setOffsetY(32);
				this.moveX(-2);
				dir = 1;
		}
		else
			this.animation.stop();
		PlayerCollision.collide(this, Game.EvilKing);
		PlayerCollision.collide(this, Game.zombie1);
		PlayerCollision.collide(this, Game.zombie2);
		PlayerCollision.collide(this, Game.reaper);
		
		
	}
	
	public void enemyUpdate( char temp) {
		//if (PlayerCollision.threatDetection(Game.player1, threat)){
			if (this.getLayoutX() < Game.player1.getLayoutX()) {
				this.animation.setOffsetY(64);
				this.moveX(1);
			}
			 if (this.getLayoutX() > Game.player1.getLayoutX()){
				this.animation.play();
				this.animation.setOffsetY(32);
				this.moveX(-1);
				
			}
			
			 if (this.getLayoutY() < Game.player1.getLayoutY()) {
				this.animation.play();
				this.animation.setOffsetY(0);
				this.moveY(1);
			}
			 if  (this.getLayoutY() > Game.player1.getLayoutY()) {
				this.animation.play();
				this.animation.setOffsetY(96);
				this.moveY(-1);
			}
			if (checkDead()) {
				respawn();
			}
		
}
	
	public void respawn() {
		spawn = ran.nextInt(4);
		if (spawn == 0) {
			this.relocate(0, ran.nextInt(Game.SCREENHEIGHT));
		}
		else if(spawn == 1) {
			this.relocate(Game.SCREENWIDTH, ran.nextInt(Game.SCREENHEIGHT));
		}
		else if (spawn == 2) {
			this.relocate(ran.nextInt(Game.SCREENWIDTH), 0);
		}
		else {
			this.relocate(ran.nextInt(Game.SCREENWIDTH), Game.SCREENHEIGHT);
		}
		dead = false;
		Game.root.getChildren().addAll(this);
	}
	
	public boolean checkDead() {
		return dead;
	}
			
	public boolean isPressed(KeyCode key) {
		return Game.keys.getOrDefault(key, false);
	}
		
}

