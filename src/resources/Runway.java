package resources;

public class Runway {
	private boolean isAvailable;
	private String name;
	
	public Runway(String name) {
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
