package com.recursivechaos.xwing.main.objects;

public class Player {

	public enum Status {ALIVE,DEAD };
	String name;
	Status status;
	Ship ship;
	
	public Player(String name) {
		this.name = name;
		this.status = Status.ALIVE;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Ship getShip() {
		return ship;
	}


	public void setShip(Ship ship) {
		this.ship = ship;
	}

	
}
