package io.valhala.agonyredux.display;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class ViewManager {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		makeBtn();
		setBg();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void makeBtn() {
		GameButton b1 = new GameButton("New Game");
		GameButton b2 = new GameButton("Settings");
		GameButton b3 = new GameButton("Help");
		GameButton b4 = new GameButton("About");
		

		mainPane.getChildren().add(b1);
		mainPane.getChildren().add(b2);
		mainPane.getChildren().add(b3);
		mainPane.getChildren().add(b4);

		
		b1.setLayoutX(300);
		b1.setLayoutY(120);
		
		b2.setLayoutX(300);
		b2.setLayoutY(240);
		
		b3.setLayoutX(300);
		b3.setLayoutY(360);
		
		b4.setLayoutX(300);
		b4.setLayoutY(480);

	}
	
	private void setBg() {
		Image bg = new Image("img/bg.jpg", 640,480,false,true);
		BackgroundImage img = new BackgroundImage(bg, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(img));
	}
		
}
