package io.valhala.agonyredux;

import io.valhala.agonyredux.display.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


//each stage can only have 1 scene
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.setTitle("Agony Server Preview");
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {e.printStackTrace();}
		
	}

}
