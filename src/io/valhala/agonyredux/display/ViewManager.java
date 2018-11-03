package io.valhala.agonyredux.display;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void makeBtn() {
		MenuButton b1 = new MenuButton("New Game");

		mainPane.getChildren().add(b1);

		
		b1.setLayoutX(250);
		b1.setLayoutY(250);

	}
		
}
