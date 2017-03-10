package domain;

import java.util.ArrayList;
import java.util.List;

import exception.NoMoreResourceAvailableException;

class Airport {

    private final List<Resource> resources = new ArrayList<>();
	private final List<Plane> planes = new ArrayList<>();

	private final Counter counter = new Counter();

	void addResource(Resource.Type type, int amount) {
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

    void addPlanes(int amount) {
        for (int i = 0; i < amount; i++) {
            planes.add(new Plane(i, this));
        }
    }

    void start() {
		System.out.println("Launching planes");

		for (Plane plane : planes) {
			plane.start();
		}
	}

    void incrementCounter() {
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
