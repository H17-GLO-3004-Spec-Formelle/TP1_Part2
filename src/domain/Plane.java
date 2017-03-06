package domain;

import java.util.Random;

public class Plane extends Thread {
	
	private String name;
	private boolean onDeparture; //Tells if the plane is coming or going.
	
	public Plane(String name) {
		this.name = name;
		
		onDeparture = new Random().nextBoolean();
	}
	
	@Override
	public void run() {
		if (onDeparture) {
			
		} else {
			
		}
		System.out.println(name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
