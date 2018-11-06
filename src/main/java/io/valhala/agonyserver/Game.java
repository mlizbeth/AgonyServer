package io.valhala.agonyserver;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

import io.valhala.agonyserver.framework.PlayerCollision;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 public class Game extends Application {
	
	public static final int SCREENWIDTH = 800;
	public static final int SCREENHEIGHT = 800;
	private static int numEnemies = 4;
	
	Random ran = new Random(System.currentTimeMillis());
	
	private static final String PLAYER = "/images/Viking.png";
	private static final String ZOMBIE1 = "/images/Zombie1.png";
	private static final String ZOMBIE2 = "/images/Zombie2.png";
	private static final String EVILKING = "/images/EvilKing.png";
	private static final String REAPER = "/images/reaper.png";
	
	public static HashMap<KeyCode, Boolean> keys = new HashMap<>();
	
	public static Scene scene;
	public static Pane root;
	
	public static CharacterMovement player;
	public static CharacterMovement[] enemies = new CharacterMovement[numEnemies];

	
	public static void main(String[] args) {
		launch (args);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		init(primaryStage);
		enemyinit();
		playerinit();
		
		scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));	
		scene.setOnKeyReleased(event-> {
			keys.put(event.getCode(), false);
		});
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				player.update();
				enemytick();
				enemystrike();
				weopontick();
			}
		};
		timer.start();

		primaryStage.show();
	}
	
	public void init(Stage stage) {
		
		root = new Pane();
		scene = new Scene(root);
		root.setPrefSize(SCREENWIDTH, SCREENHEIGHT);
		
		stage.setTitle("Agony Servers");
		stage.setScene(scene);
		
	}
	
	public void enemyinit() {
		for (int i = 0; i < numEnemies; i++) {
			if (i == 0) 
				enemies[i] = new CharacterMovement(ZOMBIE1, SCREENWIDTH / 2, ran.nextInt(SCREENHEIGHT));
			else if (i == 1) 
				enemies[i] = new CharacterMovement(ZOMBIE2, 0, ran.nextInt(SCREENHEIGHT) );
			else if (i == 2)
				enemies[i] = new CharacterMovement(EVILKING, ran.nextInt(SCREENWIDTH) , 0);
			else 
				enemies[i] = new CharacterMovement(REAPER, SCREENWIDTH, ran.nextInt(SCREENHEIGHT));
			root.getChildren().addAll(enemies[i]);
		}
	}
	
	public void playerinit() {
		
		player = new CharacterMovement(PLAYER, SCREENWIDTH / 2, SCREENHEIGHT / 2);
		root.getChildren().addAll(player);
		
	}
	
	public void enemytick() {
		for (int i = 0; i < numEnemies; i++) {
			enemies[i].enemyUpdate();
		}
	}
	public void enemystrike() {
		for (int i = 0; i < numEnemies; i++) {
			PlayerCollision.collide(player, enemies[i]);
		}
	}
	public void weopontick() {
		for (int i = 0; i < numEnemies; i++) {
			for(int j = 0; j < 3; j++) {
				PlayerCollision.hit(enemies[i], player.axe[j]);
			}
		}
	}
}
		



		
