package exception;

import domain.Resource;

public class ResourceNotAvailableException extends Exception {
	
	public ResourceNotAvailableException(Resource resource) {
		super("Resource not available: " + resource.toString());
	}

}
