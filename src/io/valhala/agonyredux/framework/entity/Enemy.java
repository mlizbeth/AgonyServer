package io.valhala.agonyredux.framework.entity;

import java.util.Random;

import io.valhala.agonyredux.Game;
import io.valhala.agonyredux.SpriteAnimation;
import io.valhala.agonyredux.framework.graphics.ImageLoader;
import javafx.util.Duration;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Enemy extends Pane{
	
	private int count = 3;
	private int columns = 3;
	private int offsetX = 0;
	private int offsetY = 0;
	private int dir;
	private int width = 32;
	private int height = 32;
	

	
	private ImageView imageView;
	private SpriteAnimation animation;
	
	private Random ran = new Random(System.currentTimeMillis());
	
	public boolean dead = false;
	
public Enemy(String string, int x,int  y){
		
		
		this.relocate(x,y);
		imageView = ImageLoader.loadImg( string);
		
		animation = new SpriteAnimation(imageView, Duration.millis(300), count, columns, offsetX, offsetY, width, height);
		this.getChildren().addAll(imageView);
	}
	
	
	
	
	public void enemyUpdate() {

	if (this.getLayoutX() < Game.player.getLayoutX()) {
		this.animation.setOffsetY(64);
		this.moveX(1);
	}
	 if (this.getLayoutX() > Game.player.getLayoutX()){
		this.animation.play();
		this.animation.setOffsetY(32);
		this.moveX(-1);
		
	}
	
	 if (this.getLayoutY() < Game.player.getLayoutY()) {
		this.animation.play();
		this.animation.setOffsetY(0);
		this.moveY(1);
	}
	 if  (this.getLayoutY() > Game.player.getLayoutY()) {
		this.animation.play();
		this.animation.setOffsetY(96);
		this.moveY(-1);
	}
	if (checkDead()) {
		respawn();
	}

}
	
	public int getOffsetX() {
		return offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	
	public void moveX(int x) {
		
		boolean right = x>0?true:false;
		
		for(int i = 0; i < Math.abs(x); i++) {
			
			if(right)
			{
				this.setLayoutX(this.getLayoutX() +1);
			}
			else {
				this.setLayoutX(this.getLayoutX() - 1);
			}
				
		}
	}
	
	public void moveY(int y) {
		boolean right = y>0?true:false;
		
		
		for(int i = 0; i < Math.abs(y); i++) {
			if (right) {
				this.setLayoutY(this.getLayoutY() +1);
			}
				else { 
					this.setLayoutY(this.getLayoutY() -1);
				}
		}
	
}
	
	public void respawn() {
		int spawn = ran.nextInt(4);
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
}
