package io.valhala.agonyserver.framework.entity;

public abstract class Character extends Entity {
	
	private int attack, strength, defense, magic, ranged, hp, level;
	
	public Character(String name, int attack, int strength, int defense, int magic, int ranged, int hp, int level) {
		super(name);
		this.attack = attack;
		this.strength = strength;
		this.defense = defense;
		this.magic = magic;
		this.ranged = ranged;
		this.hp = hp;
		this.level = level;
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getRanged() {
		return ranged;
	}

	public void setRanged(int ranged) {
		this.ranged = ranged;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
