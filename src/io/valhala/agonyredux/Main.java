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
	public void start(Stage menuStage) throws Exception {
		try {
			ViewManager manager = new ViewManager();
			menuStage = manager.getMainStage();
			menuStage.setTitle("Agony Server Preview");
			menuStage.show();
			menuStage.setResizable(false);
		} catch(Exception e) {e.printStackTrace();}
		
	}

}
