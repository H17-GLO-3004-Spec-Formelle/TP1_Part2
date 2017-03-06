package resources;

public abstract class Resource {
	
	protected boolean isAvailable;
	protected String name;
	
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
	
	@Override
	public String toString() {
		return name;
	}
}
