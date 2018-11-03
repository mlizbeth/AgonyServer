package io.valhala.agonyserver;

import java.io.FileNotFoundException;
import java.util.HashMap;


import io.valhala.agonyserver.framework.graphics.ImageLoader;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {
	
	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	int toon;
	ImageView imageView = ImageLoader.loadImg("/images/Viking.png");
	ImageView imageView2 = ImageLoader.loadImg("/images/witch.png");//needs improvement
	ImageView imageView3 = ImageLoader.loadImg("/images/EvilKing.png");
	ImageView imageView4 = ImageLoader.loadImg("/images/reaper.png");//needs improvement
	ImageView imageView5 = ImageLoader.loadImg("/images/Zombie1.png");
	ImageView imageView6 = ImageLoader.loadImg("/images/Zombie2.png");//needs improvement
	CharacterMovement player1 = new CharacterMovement(imageView);
	CharacterMovement player2 = new CharacterMovement(imageView2);//needs improvement
	CharacterMovement zombie1 = new CharacterMovement(imageView6);
	CharacterMovement zombie2 = new CharacterMovement(imageView5);//needs improvement
	CharacterMovement reaper = new CharacterMovement(imageView4);
	CharacterMovement EvilKing = new CharacterMovement(imageView3);//needs improvement
	Scene selection;
	Scene scene;
	static Pane root = new Pane();

	
	public static void main(String[] args) {
		launch (args);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		
		imageView.setX(640);
		imageView.setY(512);
		imageView2.setX(640);//needs improvement
		imageView2.setY(512);//needs improvement
		imageView3.setX(500);
		imageView3.setY(400);
		imageView4.setX(800);//needs improvement
		imageView4.setY(700);//needs improvement
		imageView5.setX(300);
		imageView5.setY(200);
		imageView6.setX(0);//needs improvement
		imageView6.setY(900);//needs improvement
		root.setPrefSize(1280, 1024);

		//Character Selection Screen Algorithm
		Label label1 = new Label("Please choose your character");
		Button btn1 = new Button("Viking");
		Button btn2 = new Button("Witch");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				root.getChildren().addAll(player1);
				primaryStage.setScene(scene);
				toon =1;
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				root.getChildren().addAll(player2);
				primaryStage.setScene(scene);//needs improvement
				toon = 2;
			}
		});
		root.getChildren().addAll(zombie1);
		root.getChildren().addAll(zombie2);
		root.getChildren().addAll(reaper);
		root.getChildren().addAll(EvilKing);
		
		VBox layout1 = new VBox(20);
		layout1.setLayoutX(640);
		layout1.setLayoutY(512);
		layout1.getChildren().addAll(label1, btn1, btn2);
		selection = new Scene(layout1, 1280, 1024);

		scene = new Scene(root);
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));	
		scene.setOnKeyReleased(event-> {
			keys.put(event.getCode(), false);
		});
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (toon ==1)
					update(player1);
				else
					update(player2);
				enemyUpdate(zombie1, 'x');
				enemyUpdate(zombie2, 'y');
				enemyUpdate(reaper, 'x');
				enemyUpdate(EvilKing, 'y');
			}
		};
		timer.start();

		primaryStage.setTitle("Agony Servers");
		primaryStage.setScene(selection);
		primaryStage.show();
	}
	public void enemyUpdate(CharacterMovement enemy, char temp) {
		if (temp == 'x') {
		if (enemy.direction) {
			enemy.animation.play();
			enemy.animation.setOffsetY(64);
			enemy.moveX(2);
		}
		else {
			enemy.animation.play();
			enemy.animation.setOffsetY(32);
			enemy.moveX(-2);
		}
		}
		else {
			if (enemy.direction) {
				enemy.animation.play();
				enemy.animation.setOffsetY(0);
				enemy.moveY(2);
			}
			else {
				enemy.animation.play();
				enemy.animation.setOffsetY(96);
				enemy.moveY(-2);
			}
			}
		}
	
	public void update(CharacterMovement player) {
		if(isPressed(KeyCode.UP)) {
			//starts the animation of the sprite
			player.animation.play(); 
			//picks the bottom Sprite
			player.animation.setOffsetY(96);
			//sets the range to decide direction of sprite
			player.moveY(-2);
		}
		else if(isPressed(KeyCode.DOWN)) {
			//starts the animation of the sprite
			player.animation.play();
			//picks the top sprite
			player.animation.setOffsetY(0);
			//sets range to decide direction of sprite
			player.moveY(2);
		}
		else if(isPressed(KeyCode.RIGHT)) {
			player.animation.play();
			player.animation.setOffsetY(64);
			player.moveX(2);
		}
		else if(isPressed(KeyCode.LEFT)) {
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
		
}


		
