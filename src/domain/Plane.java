package domain;

public class Plane extends Thread {
	
	private final String name;
	private final Airport airport;

	private Direction direction = Direction.DEPARTURE;

	Plane(String name, Airport airport) {
		this.name = name;
		this.airport = airport;
	}

	private void use(Resource.Type type) {
		boolean resourceAcquired = false;

		while (!resourceAcquired) {
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
				resourceAcquired = true;

			} catch (Exception e) {
				System.out.println(String.format("%s encountered an error: %s", this, e.getMessage()));
			}
		}
	}

	@Override
	public void run() {
		while (true) {

		    use(Resource.Type.AUTHORITY);

			if (direction.equals(Direction.DEPARTURE)) {
				use(Resource.Type.TECHNIQUE);
				use(Resource.Type.FUEL);
				use(Resource.Type.GATE);
				use(Resource.Type.RUNWAY);

				direction = Direction.ARRIVAL;

			} else if (direction.equals(Direction.ARRIVAL)) {
				use(Resource.Type.RUNWAY);
				use(Resource.Type.GATE);

				direction = Direction.DEPARTURE;
			}
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	enum Direction {
		DEPARTURE,
		ARRIVAL
	}
}
