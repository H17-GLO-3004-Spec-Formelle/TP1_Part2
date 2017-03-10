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

		// Temporaire jusqu'à ce qu'on lise à partir d'un fichier de config ->
		configs.put("authorities", 1);
		configs.put("fuels", 3);
		configs.put("gates", 3);
		configs.put("techniques", 3);
		configs.put("runways", 3);

		configs.put("planes", 3);
		// <- Temporaire jusqu'à ce qu'on lise à partir d'un fichier de config

		final Airport airport = new Airport();
		airport.addResource(Resource.Type.AUTHORITY, configs.get("authorities"));
		airport.addResource(Resource.Type.FUEL, configs.get("fuels"));
		airport.addResource(Resource.Type.GATE, configs.get("gates"));
		airport.addResource(Resource.Type.TECHNIQUE, configs.get("techniques"));
		airport.addResource(Resource.Type.RUNWAY, configs.get("runways"));

		airport.addPlanes(configs.get("planes"));

		airport.start();
	}
}
