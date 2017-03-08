package exception;

import domain.Resource;

public class NoMoreResourceAvailableException extends Exception {
	
	public NoMoreResourceAvailableException(Resource.Type type) {
		super(String.format("All resources of type %s are occupied.", type));
	}
}
