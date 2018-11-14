package io.valhala.agonyredux.framework.entity;

import javafx.scene.input.KeyCode;
import io.valhala.agonyredux.Game;
import io.valhala.agonyredux.SpriteAnimation;
import io.valhala.agonyredux.framework.graphics.ImageLoader;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Weapon extends Pane {
	
	public ImageView imageView;
	private int count = 3;
	private int columns = 4;
	private int offsetX = 0;
	private int offsetY = 0;
	private int width = 32;
	private int atk = 0;
	private int direction;
	private int height = 32;
	
	public boolean thrown = false;
	
	public SpriteAnimation animation;

	
	public Weapon(String string, double x, double y){
		
		imageView = ImageLoader.loadImg(string);
		imageView.relocate(x,y);
		
		animation = new SpriteAnimation(imageView, Duration.millis(300), count, columns, offsetX, offsetY, width, height);
		getChildren().addAll(imageView);
		
	}
	
	public void setcoords(double x, double y) {
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	public void moveX(int x) {
		boolean right = x>0?true:false;
		for(int i = 0; i< Math.abs(x); i++) {
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
		for(int i = 0; i< Math.abs(y); i++) {
			if(right) {
				this.setLayoutY(this.getLayoutY() +1);
			}
			else {
				this.setLayoutY(this.getLayoutY() - 1);
			}
		}
	}
	
	public void update(int direction) {
		if (isPressed(KeyCode.F))
		{
	
			atk ++;
		}
		if (atk == 1) {
			setcoords(Game.player.getLayoutX(), Game.player.getLayoutY());
			Game.root.getChildren().addAll(this);
			animation.play();
			this.direction = direction;
		}
		if (atk == 5)
			thrown = true;
		if (atk >0 && atk < 100) {
			if ( this.direction == 0) {
			moveX(2);
			this.animation.setOffsetY(0);
			}
			else if(this.direction == 1) {
				moveX(-2);
				this.animation.setOffsetY(32);
			}
			else if (this.direction == 2) {
				moveY(2);
				animation.setOffsetY(64);
			}
			else if (this.direction == 3) {
				moveY(-2);
				animation.setOffsetY(96);
			}
			atk++;
		}
		if (atk >= 100) {
			atk = 0;
			animation.stop();
			Game.root.getChildren().remove(this);
			this.relocate(1500, 1500);
			thrown = false;
		}
	}
	public boolean isPressed(KeyCode key) {
		return Game.keys.getOrDefault(key, false);
	}
}
