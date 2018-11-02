package io.valhala.agonyserver;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application{
	public static void main(String[] args) {
		launch (args);
	}
	
	static String title = "Agony-servers";
	public void start(Stage primaryStage) {
		primaryStage.setTitle(title);
		Button btn = new Button();
		btn.setText("Welcome to Agony");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent e) {
				System.out.println(title);
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene( root, 640, 480));
		primaryStage.show()
;		
	}
		
	}


		
