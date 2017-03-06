package resources;


public class Fuel {
	
	private boolean isAvailable;
	private String name;
	
	public Fuel(String name) {
		isAvailable = false;
		this.name = name;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void acquire() throws ResourceNotAvailableException {
		if (!isAvailable) {
			throw new ResourceNotAvailableException(name);
		}
		isAvailable = false;
	}
	
	public void use() {
		System.out.println("Utilisation de la ressource " + this.toString() + " en cours.");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt(); //Should happen only when killing the execution
		}
	}
	
	public void release() {
		isAvailable = true;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
