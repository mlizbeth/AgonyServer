package io.valhala.agonyredux;

import java.util.Random;
import io.valhala.agonyredux.framework.entity.Weapon;
import io.valhala.agonyredux.framework.graphics.ImageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CharacterMovement extends Pane {
//DFA
	
	private int count = 3;
	private int columns = 3;
	private int offsetX = 0;
	private int offsetY = 0;
	private int dir;
	private int width = 32;
	private int height = 32;
	

	
	private ImageView imageView;
	private SpriteAnimation animation;
	
	
	public boolean dead = false;
	Weapon axe;


	
	public CharacterMovement(String string, int x,int  y){
		
		
		weaponinit();
		this.relocate(x,y);
		imageView = ImageLoader.loadImg( string);
		
		animation = new SpriteAnimation(imageView, Duration.millis(300), count, columns, offsetX, offsetY, width, height);
		getChildren().addAll(imageView);
	}
	
	public void moveX(int x) {
		
		boolean right = x>0?true:false;
		
		for(int i = 0; i < Math.abs(x); i++) {
			
			if(right && this.getLayoutX() < 1490)
			{
				this.setLayoutX(this.getLayoutX() +1);
				if(Game.camera.getLayoutX() < 750 && this.getLayoutX() > Game.camera.getLayoutX() + 450)
				Game.camera.setLayoutX(Game.camera.getLayoutX() +1);
			}
			else if(this.getLayoutX() > 10) {
				this.setLayoutX(this.getLayoutX() -1);
				if(Game.camera.getLayoutX() > -5 && this.getLayoutX() < Game.camera.getLayoutX() + 350)
				Game.camera.setLayoutX(Game.camera.getLayoutX() -1);
			}
				
		}
	}
	
	public void moveY(int y) {
		boolean right = y>0?true:false;
		
		
		for(int i = 0; i < Math.abs(y); i++) {
			if (right && this.getLayoutY() < 1490) {
				this.setLayoutY(this.getLayoutY() +1);
				if(Game.camera.getLayoutY() < 750 && this.getLayoutY() > Game.camera.getLayoutY() + 450)
					Game.camera.setLayoutY(Game.camera.getLayoutY() +1);
			}
				else if(this.getLayoutY() > 10 ){ 
					this.setLayoutY(this.getLayoutY() -1);
					if (Game.camera.getLayoutY() >= -5 && this.getLayoutY() < Game.camera.getLayoutY() +350)
						Game.camera.setLayoutY(Game.camera.getLayoutY() -1);
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
		
		
		if(isPressed(KeyCode.UP) || isPressed(KeyCode.W)) {
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
		weaponthrow();
		
	}
	

			
	public boolean isPressed(KeyCode key) {
		return Game.keys.getOrDefault(key, false);
	}
		
	public void weaponinit() {
		for (int i = 0; i < 3; i++) {
			axe = new Weapon("/images/throwing_axe.png", 0, 0);
		}
	}
	public void weaponthrow() {
		axe.update(dir);
	}
}

