package resources;

public class Technique {
	
	private boolean isAvailable;
	private String name;
	
	public Technique(String name) {
		isAvailable = true;
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
	
	public void use() throws ResourceNotAvailableException {
		System.out.println("This resource is being used : " + this.toString());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt(); //Should happen only when killing the execution
		}
	}
	
	public void release() {
		isAvailable = true;
		System.out.println("This resource is now free : " + this.toString());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
