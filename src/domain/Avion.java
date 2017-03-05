package domain;

public class Avion extends Thread {
	
	private String name;
	
	public Avion(String name) {
		this.name = name;
	}
	
	public void run() {
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
