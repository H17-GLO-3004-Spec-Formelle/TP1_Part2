package domain;

public class Plane extends Thread {

    private final int number;
	private final Airport airport;
	private boolean paused;
	private Direction direction = Direction.DEPARTURE;

	Plane(int number, Airport airport) {
		this.number = number;
		this.airport = airport;
		this.paused = false;
	}

	@SuppressWarnings("deprecation")
	public void pause(boolean paused) {
		//this.paused = paused;
		if (paused == true)
			this.suspend();
		else 
			this.resume();
	}

	private void use(Resource.Type type) {
		boolean resourceAcquired = false;

		while (!paused && !resourceAcquired) {
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

				if (resource.getType().equals(Resource.Type.AUTHORITY)) {
				    airport.incrementCounter();
                }

			} catch (Exception e) {
				System.out.println(String.format("%s encountered an error: %s", this, e.getMessage()));
			}
		}
	}

	@Override
	public void run() {
		while (!paused) {

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
        return "PLANE" + String.valueOf(number);
	}

	enum Direction {
		DEPARTURE,
		ARRIVAL
	}
}
