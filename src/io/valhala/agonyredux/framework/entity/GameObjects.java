package io.valhala.agonyredux.framework.entity;


import io.valhala.agonyredux.framework.graphics.ImageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GameObjects extends Pane{
	
	private static ImageView imageView;
	//public Rectangle r;
	
	public GameObjects(String string, int x, int y) {
		
		imageView = ImageLoader.loadImg(string);
		this.relocate(x, y);
		getChildren().addAll(imageView);
	}

}
