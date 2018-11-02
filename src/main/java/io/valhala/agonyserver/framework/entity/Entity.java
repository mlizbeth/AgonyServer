package io.valhala.agonyserver.framework.entity;

public abstract class Entity {
	
	private String name;
	//Position x, y;
	
	public Entity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
