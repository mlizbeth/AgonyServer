package io.valhala.agonyserver;

import javax.swing.*;

public class Game extends JFrame{
	static String title = "Agony-servers";
	public Game() {
		super(title);
		System.out.println(title);
		setSize(640,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
}

		
