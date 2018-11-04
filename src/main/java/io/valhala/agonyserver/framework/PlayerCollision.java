package io.valhala.agonyserver.framework;

import io.valhala.agonyserver.CharacterMovement;
import io.valhala.agonyserver.Game;

public class PlayerCollision {
	
	



	public static void collide(CharacterMovement player1, CharacterMovement player2) {
		// TODO Auto-generated method stub
		if (player1.r.getBoundsInParent().intersects(player2.r.getBoundsInParent())) {
			Game.root.getChildren().remove(player2);
	}
}
}