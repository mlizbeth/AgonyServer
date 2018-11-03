package io.valhala.agonyredux.display;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

public class MenuButton extends Button {

	private final String FONT_PATH = "res/fonts/Mael.ttf";
	private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/img/blue_button00.png');";
	private final String BUTTON_STYLE_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('/img/blue_button01.png');";
	private final String BUTTON_STYLE_HOVER = "-fx-background-color: transparent; -fx-background-image: url('/img/blue_button02.png');";

	
	public MenuButton(String title) {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 16));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		setStyle(BUTTON_STYLE);
		setText(title);
		setPrefHeight(49);
		setPrefWidth(190);
		initListeners();
	}
	
	private void setPressedStyle() {
		setStyle(BUTTON_STYLE_PRESSED);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setReleasedStyle() {
		setStyle(BUTTON_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}
	
	private void setHoverStyle() {
		setStyle(BUTTON_STYLE_HOVER);
	}
	
	private void initListeners() {
		setOnMousePressed(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				setPressedStyle();
			}
		});
		
		setOnMouseReleased(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				setReleasedStyle();
				setHoverStyle();
			}

		});
		
		setOnMouseEntered(e -> {
			setHoverStyle();
		});
		
		setOnMouseExited(e -> {
			setStyle(BUTTON_STYLE);
		});
	}
	
	
	
}
