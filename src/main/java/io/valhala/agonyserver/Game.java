package io.valhala.agonyserver;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
	CharacterMovement player1 = new CharacterMovement(imageView);
	CharacterMovement player2 = new CharacterMovement(imageView2);//needs improvement
	Scene selection;
	Scene scene;
	Scene scene2;//needs improvement
	static Pane root = new Pane();
	static Pane root2 = new Pane();//needs improvement

	
	public static void main(String[] args) {
		launch (args);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		
		
		imageView.setX(640);
		imageView.setY(512);
		imageView2.setX(640);//needs improvement
		imageView2.setY(512);//needs improvement
		root.setPrefSize(1280, 1024);
		root2.setPrefSize(1280, 1024);//needs improvement
		//root.getChildren().addAll(player);
		
		//Character Selection Screen Algorithm
		Label label1 = new Label("Please choose your character");
		Button btn1 = new Button("Viking");
		Button btn2 = new Button("Witch");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(scene);
				toon =1;
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(scene2);//needs improvement
				toon = 2;
			}
		});
		
		VBox layout1 = new VBox(20);
		layout1.setLayoutX(640);
		layout1.setLayoutY(512);
		layout1.getChildren().addAll(label1, btn1, btn2);
		selection = new Scene(layout1, 1280, 1024);
		
		root2.getChildren().addAll(player2); //needs improvement
		root.getChildren().addAll(player1);
		scene = new Scene(root);
		scene2 = new Scene(root2);//needs improvement
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));	
		scene.setOnKeyReleased(event-> {
			keys.put(event.getCode(), false);
		});
		
		//needs improvement
		scene2.setOnKeyPressed(event -> keys.put(event.getCode(), true));
		scene2.setOnKeyReleased(event-> {
			keys.put(event.getCode(), false);
		});
		
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (toon == 1) 
					update(player1);
				else
					update(player2);
					
			}
		};
		timer.start();

		primaryStage.setTitle("Agony Servers");
		primaryStage.setScene(selection);
		primaryStage.show();
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


		
