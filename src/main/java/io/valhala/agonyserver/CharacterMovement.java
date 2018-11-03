package io.valhala.agonyserver;

import java.util.Random;
import io.valhala.agonyserver.framework.graphics.ImageLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CharacterMovement extends Pane {
//DFA
	ImageView imageView;
	Random ran = new Random(System.currentTimeMillis());
	int count = 3;
	int columns = 3;
	int offsetX = 0;
	int offsetY = 0;
	int width = 32;
	int height = 32;
	private int x = ran.nextInt(300);
	public boolean direction = true;
	public SpriteAnimation animation;
	Rectangle removeRect = null;
	
	public CharacterMovement(String string, int x,int  y){
		imageView = ImageLoader.loadImg(string);
		imageView.setX(x);
		imageView.setY(y);
		this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
		getChildren().addAll(imageView);
	}
	
	public void moveX(int x) {
		boolean right = x>0?true:false;
		this.x += x;
		if (this.x > 300)
			direction = false;
		else if (this.x < 0){
			direction = true;
		}
		for(int i = 0; i < Math.abs(x); i++) {
			if(right) this.setTranslateX(this.getTranslateX() + 1);
				else this.setTranslateX(this.getTranslateX() - 1);
		}
	}
	
	public void moveY(int y) {
		boolean right = y>0?true:false;
		
		this.x += y;
		if (this.x > 300)
			direction = false;
		else if (this.x < 0){
			direction = true;
		}
		
		for(int i = 0; i < Math.abs(y); i++) {
			if(right) this.setTranslateY(this.getTranslateY() + 1);
				else this.setTranslateY(this.getTranslateY() - 1);
		}
	
}
	public int getOffsetX() {
		return offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	
	public void update() {
		if(isPressed(KeyCode.UP)) {
			//starts the animation of the sprite
			this.animation.play(); 
			//picks the bottom Sprite
			this.animation.setOffsetY(96);
			//sets the range to decide direction of sprite
			this.moveY(-2);
		}
		else if(isPressed(KeyCode.DOWN)) {
			//starts the animation of the sprite
			this.animation.play();
			//picks the top sprite
			this.animation.setOffsetY(0);
			//sets range to decide direction of sprite
			this.moveY(2);
		}
		else if(isPressed(KeyCode.RIGHT)) {
			this.animation.play();
			this.animation.setOffsetY(64);
			this.moveX(2);
		}
		else if(isPressed(KeyCode.LEFT)) {
				this.animation.play();
				this.animation.setOffsetY(32);
				this.moveX(-2);
		}
		else
			this.animation.stop();
	}
	
	public void enemyUpdate( char temp) {
		if (temp == 'x') {
		if (direction) {
			this.animation.play();
			this.animation.setOffsetY(64);
			this.moveX(2);
		}
		else {
			this.animation.play();
			this.animation.setOffsetY(32);
			this.moveX(-2);
		}
		}
		else {
			if (this.direction) {
				this.animation.play();
				this.animation.setOffsetY(0);
				this.moveY(2);
			}
			else {
				this.animation.play();
				this.animation.setOffsetY(96);
				this.moveY(-2);
			}
			}
		}
	public boolean isPressed(KeyCode key) {
		return Game.keys.getOrDefault(key, false);
	}
		
}

