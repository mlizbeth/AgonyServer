package io.valhala.agonyredux.framework.entity;

public class NonPlayerCharacter extends Character {
	
	private boolean essential;
	
	public NonPlayerCharacter(String name, int attack, int strength, int defense, int magic, int ranged, int hp, int level, boolean essential) {
		super(name, attack, strength, defense, magic, ranged, hp, level);
		this.essential = essential;
	}

	public boolean isEssential() {
		return essential;
	}

	public void setEssential(boolean essential) {
		this.essential = essential;
	}

}
