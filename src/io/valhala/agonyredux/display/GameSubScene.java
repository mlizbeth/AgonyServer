package io.valhala.agonyredux.display;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

//Think of this as an overlay on a scene!
public class GameSubScene extends SubScene {

	//private static final String FONT_PATH;
	private static final String BACKGROUND_IMG = "img/panel_blue.png";
	private boolean hidden;
	
	public GameSubScene() {
		super(new AnchorPane(), 400,200);
		prefWidth(400);
		prefHeight(200);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMG, 400,200,false,true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,null);
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		setLayoutX(1024);
		setLayoutY(180);
		hidden = true;
		
		root2.setBackground(new Background(image));
	}
	
	public void moveSubScene() {
		TranslateTransition t = new TranslateTransition();
		t.setDuration(Duration.seconds(0.3));
		t.setNode(this);
		if(hidden) {
			t.setToX(-676);
			hidden = false;
		}
		else {
			t.setToX(0);
			hidden = true;
		}
		
		t.play();
	}

}
