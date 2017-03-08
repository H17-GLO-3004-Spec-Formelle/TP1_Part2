package domain;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		final HashMap<String, Integer> configs = new HashMap<>();
		
		for (int i = 0; i < args.length - 1; i++) {
			switch (args[i].charAt(0)) {
				case '-':
					String key = args[i].substring(1, args[i].length());
					int value = Integer.parseInt(args[i+1]);
					configs.put(key, value);
					break;
			}
		}

		final Airport airport = new Airport();
		airport.addResource(Resource.Type.FUEL, 3);//configs.get("fuels"));
		airport.addResource(Resource.Type.GATE, 3);//configs.get("gates"));
		airport.addResource(Resource.Type.TECHNIQUE, 3);//configs.get("techniques"));
		airport.addResource(Resource.Type.RUNWAY, 3);//configs.get("runways"));

		airport.addPlanes(3);//configs.get("planes"));

		airport.start();
	}

}
