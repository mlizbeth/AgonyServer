package io.valhala.agonyredux.display;

import java.util.Random;

import io.valhala.agonyredux.Main;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ViewManager {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private GameSubScene temp = new GameSubScene();
	
	public ViewManager() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		makeBtn();
		setBg();
		initMedia();
		createSubScenes();
		
	}
	
	private void createSubScenes() {
		temp = new GameSubScene();
		mainPane.getChildren().add(temp);
	}
	
	private static MediaPlayer mp;
	private static Media m;
	
	private static void initMedia() {
		try {
			 m = new Media(Main.class.getResource("/audio/menu.mp3").toURI().toString());
			 mp = new MediaPlayer(m);
		} catch (Exception e) {e.printStackTrace();}
		mp.setAutoPlay(true);
		mp.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				mp.seek(Duration.ZERO);
//				Timeline timeline = new Timeline(
//					    new KeyFrame(Duration.seconds(10),
//					        new KeyValue(mediaPlayer.volumeProperty(), 0)));
//					timeline.play();
			}
		});
		mp.play();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void makeBtn() {
		GameButton b1 = new GameButton("New Game");
		//Load/Continue
		GameButton b2 = new GameButton("Settings");
		GameButton b3 = new GameButton("Help");
		GameButton b4 = new GameButton("About");
		

		mainPane.getChildren().add(b1);
		mainPane.getChildren().add(b2);
		mainPane.getChildren().add(b3);
		mainPane.getChildren().add(b4);

		
		b1.setLayoutX(100);
		b1.setLayoutY(120);
		
		b2.setLayoutX(100);
		b2.setLayoutY(240);
		
		b3.setLayoutX(100);
		b3.setLayoutY(360);
		
		b4.setLayoutX(100);
		b4.setLayoutY(480);
		
		b4.setOnAction(e -> {
			temp.moveSubScene();
		});

	}
	Image bg;
	private void setBg() {
		Random rand = new Random();
		int x = rand.nextInt(4);
		System.out.println(x);
		switch(x) {
		case 0:
			bg = new Image("img/bg.gif", 450,450,false,true);
			break;
		case 1:
			bg = new Image("img/bg_alt.gif", 480,360,false,true);
			break;
		case 2:
			bg = new Image("img/bg2.gif", 500,500,false,true);
			break;
		case 3:
			bg = new Image("img/bg3.gif", 480,480,false,true);
			break;
		}
		BackgroundImage img = new BackgroundImage(bg, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(img));
	}	
}
