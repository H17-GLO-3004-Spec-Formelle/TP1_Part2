package domain;

import java.util.ArrayList;
import java.util.List;

import exception.NoMoreResourceAvailableException;

class Airport {

    private List<Resource> resources = new ArrayList<>();
	private List<Plane> planes = new ArrayList<>();

	private Counter counter = new Counter();

	public void addResource(Resource.Type type, int amount) {
        for (int i = 0; i < amount; i++) {
            resources.add(new Resource(type, i));
        }
	}

    Resource getResource(Resource.Type type) throws NoMoreResourceAvailableException {
	    return resources.stream()
                .filter(x -> x.getType().equals(type) && x.isAvailable())
                .findAny()
                .orElseThrow(() -> new NoMoreResourceAvailableException(type));
    }

    public void addPlanes(int amount) {
        for (int i = 0; i < amount; i++) {
            planes.add(new Plane(i, this));
        }
    }

    public void start() {
		System.out.println("Launching planes");
		for (Plane plane : planes) {
			plane.start();
		}
	}
    
    public void pause(boolean paused) {
    	System.out.println("Unpause/Pause planes");
    	for (Plane plane : planes) {
    		plane.pause(paused);
    	}
    }
    
	public void destroy() {
		for (Plane plane : planes) {
    		plane.pause(true);
    	}
		planes = null;
		resources = null;
		counter = null;
	}

	public void incrementCounter() {
        counter.increment();
    }
	
    private class Counter {
        int value = 0;

        synchronized void increment() {
            ++value;
            System.out.println("Counter: " + value);
        }
    }
}
