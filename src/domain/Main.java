package domain;

import java.util.HashMap;

import resources.Fuel;
import resources.Gate;
import resources.Runway;
import resources.Technique;

public class Main {
	
	private static HashMap<String, Integer> configs;
	private static Airport airport;

	public static void main(String[] args) {
		configs = new HashMap<>();
		airport = new Airport();
		
		for (int i = 0; i < args.length - 1; i++) {
			switch (args[i].charAt(0)) {
				case '-':
					String key = args[i].substring(1, args[i].length());
					int value = Integer.parseInt(args[i+1]);
					configs.put(key, value);
					break;
			}
		}
		
		for (int i = 0; i < configs.get("planes"); i++) {
			airport.addPlane(new Plane("Plane" + String.valueOf(i)));
		}
		for (int i = 0; i < configs.get("fuels"); i++) {
			airport.addFuel(new Fuel("Fuel" + String.valueOf(i)));
		}
		for (int i = 0; i < configs.get("gates"); i++) {
			airport.addGate(new Gate("Gate" + String.valueOf(i)));
		}
		for (int i = 0; i < configs.get("techniques"); i++) {
			airport.addTechnique(new Technique("Technique" + String.valueOf(i)));
		}
		for (int i = 0; i < configs.get("runways"); i++) {
			airport.addRunway(new Runway("Runway" + String.valueOf(i)));
		}
		
		airport.start();
	}

}
