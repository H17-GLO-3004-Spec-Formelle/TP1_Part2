package domain;

import java.util.HashMap;

public class Main {

	private static Airport airport;	
	
	public static void start(int pPlanes, int pAuth, int pFuel, int pGate, int pTech, int pRunaway) {
		airport = new Airport();
		
		airport.addResource(Resource.Type.AUTHORITY, pAuth);
		airport.addResource(Resource.Type.FUEL, pFuel);
		airport.addResource(Resource.Type.GATE, pGate);
		airport.addResource(Resource.Type.TECHNIQUE, pTech);
		airport.addResource(Resource.Type.RUNWAY, pRunaway);

		airport.addPlanes(pPlanes);

		airport.start();
	}
	
	public static void pause(boolean paused) {
		airport.pause(paused);
	}

	public static void stop() {
		airport.destroy();
		airport = null;
	}
	
	public static void exit() {
		System.exit(0);
	}
}
