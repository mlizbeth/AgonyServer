package io.valhala.agonyserver;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CharacterMovement extends Pane {
//DFA
	ImageView imageView;
	int count = 3;
	int columns = 3;
	int offsetX = 0;
	int offsetY = 0;
	int width = 32;
	int height = 32;
	public SpriteAnimation animation;
	Rectangle removeRect = null;
	
	public CharacterMovement(ImageView imageView) {
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
		getChildren().addAll(imageView);
	}
	
	public void moveX(int x) {
		boolean right = x>0?true:false;
		for(int i = 0; i < Math.abs(x); i++) {
			if(right) this.setTranslateX(this.getTranslateX() + 1);
				else this.setTranslateX(this.getTranslateX() - 1);
		}
	}
	
	public void moveY(int y) {
		boolean right = y>0?true:false;
		for(int i = 0; i < Math.abs(y); i++) {
			if(right) this.setTranslateY(this.getTranslateY() + 1);
				else this.setTranslateY(this.getTranslateY() - 1);
		}
	
}
}