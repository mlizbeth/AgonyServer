package io.valhala.agonyredux.framework.entity;

public class PlayerCharacter extends Character {

	private int experience;
	
	public PlayerCharacter(String name, int attack, int strength, int defense, int magic, int ranged, int hp, int level, int experience) {
		super(name, attack, strength, defense, magic, ranged, hp, level);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	

}
