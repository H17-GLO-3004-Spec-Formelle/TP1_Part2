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
	
	public void release() {
		isAvailable = true;
	}
}
