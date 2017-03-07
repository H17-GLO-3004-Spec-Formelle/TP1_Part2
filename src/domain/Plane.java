package domain;

import java.util.Random;


public class Plane extends Thread {
	
	private String name;
	private boolean onDeparture; //Tells if the plane is coming or going.
	private Airport airport;
	
	public Plane(String name, Airport airport) {
		this.name = name;
		this.airport = airport;
		
		onDeparture = true;
	}
	
	@Override
	public void run() {
		
		while (true) {
			if (onDeparture) {
				int techniqueNumber = -1;
				int fuelNumber = -1;
				int gateNumber = -1;
				int runwayNumber = -1;
				
				while (techniqueNumber == -1)
					techniqueNumber = airport.acquireTechnique();
				
				System.out.println(name + " acquired Technique" + String.valueOf(techniqueNumber));
				airport.useTechnique(techniqueNumber);
				airport.releaseTechnique(techniqueNumber);
				techniqueNumber = -1;
				
				while (fuelNumber == -1)
					fuelNumber = airport.acquireFuel();
				
				System.out.println(name + " acquired Fuel" + String.valueOf(fuelNumber));
				airport.useFuel(fuelNumber);
				airport.releaseFuel(fuelNumber);
				fuelNumber = -1;
				
				while (gateNumber == -1)
					gateNumber = airport.acquireGate();
				
				System.out.println(name + " acquired Gate" + String.valueOf(gateNumber));
				airport.useGate(gateNumber);
				airport.releaseGate(gateNumber);
				gateNumber = -1;
				
				while (runwayNumber == -1)
					runwayNumber = airport.acquireRunway();
				
				System.out.println(name + " acquired Runway" + String.valueOf(runwayNumber));
				airport.useRunway(runwayNumber);
				airport.releaseRunway(runwayNumber);
				runwayNumber = -1;
				
				onDeparture = false;
				
			} else {
				int runwayNumber = -1;
				int gateNumber = -1;
				
				while (runwayNumber == -1)
					runwayNumber = airport.acquireRunway();
				
				airport.useRunway(runwayNumber);
				airport.releaseRunway(runwayNumber);
				runwayNumber = -1;
				
				while (gateNumber == -1)
					gateNumber = airport.acquireGate();
				
				airport.useGate(gateNumber);
				airport.releaseGate(gateNumber);
				gateNumber = -1;
				
				onDeparture = true;
			}
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
