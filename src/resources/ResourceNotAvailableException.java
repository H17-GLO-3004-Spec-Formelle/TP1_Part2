package resources;

public class ResourceNotAvailableException extends Exception {
	
	public ResourceNotAvailableException(String name) {
		super(name);
		System.out.println("This resource is not available : " + name);
	}

}
