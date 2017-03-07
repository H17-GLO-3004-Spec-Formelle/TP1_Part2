package resources;

public class NoMoreResourceAvailable extends Exception {
	
	public NoMoreResourceAvailable(String name) {
		super(name);
		System.out.println("All resources of this type are occupied : " + name);
	}

}
