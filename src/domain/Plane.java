package domain;

public class Plane extends Thread {
	
	private final String name;
	private final Airport airport;

	private Direction direction = Direction.DEPARTURE;

	Plane(String name, Airport airport) {
		this.name = name;
		this.airport = airport;
	}

	private boolean use(Resource.Type type) {
		try {
			Resource resource = airport.getResource(type);

			System.out.println(String.format("%s is acquiring resource %s", this, resource));
			resource.acquire();
			System.out.println(String.format("%s acquired resource %s", this, resource));

			System.out.println(String.format("%s is using resource %s", this, resource));
			resource.use();
			System.out.println(String.format("%s finished using resource %s", this, resource));

			System.out.println(String.format("%s is releasing resource %s", this, resource));
			resource.release();
			System.out.println(String.format("%s released resource %s", this, resource));
			return true;

		} catch (Exception e) {
			System.out.println(String.format("%s encountered an error: %s", this, e.getMessage()));
			return false;
		}
	}

	@Override
	public void run() {
		while (true) {
			if (direction.equals(Direction.DEPARTURE)) {

				while (!use(Resource.Type.TECHNIQUE)) {}
				while (!use(Resource.Type.FUEL)) {}
				while (!use(Resource.Type.GATE)) {}
				while (!use(Resource.Type.RUNWAY)) {}

				direction = Direction.ARRIVAL;

			} else if (direction.equals(Direction.ARRIVAL)) {

				while (!use(Resource.Type.RUNWAY)) {}
				while (!use(Resource.Type.GATE)) {}

				direction = Direction.DEPARTURE;
			}
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	private enum Direction {
		DEPARTURE,
		ARRIVAL
	}
}
