package io.valhala.agonyserver;


import java.io.FileNotFoundException;
import java.util.HashMap;

import io.valhala.agonyserver.framework.entity.charactermovement;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application{
	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	Image image = new Image("/images/witch.png");
	ImageView imageView = new ImageView(image);
	charactermovement player = new charactermovement(imageView);
	static Pane root = new Pane();
	public static void main(String[] args) {
		launch (args);
	}
	
	public void update() {
		if (isPressed(KeyCode.UP)) {
			//starts the animation of the sprite
			player.animation.play(); 
			//picks the bottom Sprite
			player.animation.setOffsetY(96);
			//sets the range to decide direction of sprite
			player.moveY(-2);
			}
		else if (isPressed(KeyCode.DOWN)) {
			//starts the animation of the sprite
			player.animation.play();
			//picks the top sprite
			player.animation.setOffsetY(0);
			//sets range to decide direction of sprite
			player.moveY(2);
			}
		else if (isPressed(KeyCode.RIGHT)) {
			player.animation.play();
			player.animation.setOffsetY(64);
			player.moveX(2);
			}
		else if (isPressed(KeyCode.LEFT)) {
				player.animation.play();
				player.animation.setOffsetY(32);
				player.moveX(-2);
				}
		else
			player.animation.stop();
	}
	
	public boolean isPressed(KeyCode key) {
		return keys.getOrDefault(key, false);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		imageView.setX(640);
		imageView.setY(512);
		root.setPrefSize(1280, 1024);
		root.getChildren().addAll(player);
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event ->keys.put(event.getCode(), true));	
		scene.setOnKeyReleased(event-> {
			keys.put(event.getCode(), false);
		});
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
			}
		};
		timer.start();

		
		primaryStage.setTitle("Agony-Servers");
		primaryStage.setScene(scene);
		primaryStage.show()
;		
	}
		
	}


		
