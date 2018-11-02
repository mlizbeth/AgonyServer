package io.valhala.agonyserver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Game extends Application{
	public static void main(String[] args) {
		launch (args);
	}
	
	static String title = "Agony-servers";
	public void start(Stage primaryStage) throws FileNotFoundException {
		Image image = new Image(new FileInputStream("src\\main\\java\\io\\valhala\\agonyserver\\framework\\entity\\rpg.jpg"));
		primaryStage.setTitle(title);
		Button btn = new Button();
		btn.setText("Welcome to Agony");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent e) {
				System.out.println(title);
			}
		});
		
		Group root = new Group();
		ImageView play = new ImageView(image);
		play.setViewport(new Rectangle2D(0,47,30,47));
		root.getChildren().add(btn);
		root.getChildren().add(play);
		primaryStage.setScene(new Scene( root, 640, 480));
		primaryStage.show()
;		
	}
		
	}


		
