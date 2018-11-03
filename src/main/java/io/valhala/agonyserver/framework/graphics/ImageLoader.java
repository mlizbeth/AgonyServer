package io.valhala.agonyserver.framework.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {
	
private static ImageView imgView;
	
	public static ImageView loadImg(String path) {
		Image img = new Image(path);
		imgView = new ImageView(img);
		return imgView;
	}
}
