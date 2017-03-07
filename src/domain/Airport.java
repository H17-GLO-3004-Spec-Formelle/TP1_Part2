package domain;

import java.util.ArrayList;
import java.util.List;

import resources.Fuel;
import resources.Gate;
import resources.NoMoreResourceAvailable;
import resources.ResourceNotAvailableException;
import resources.Runway;
import resources.Technique;

public class Airport {

	private List<Plane> planes;
	private List<Fuel> fuels;
	private List<Gate> gates;
	private List<Technique> techniques;
	private List<Runway> runways;
	
	public Airport() {
		planes = new ArrayList();
		fuels = new ArrayList();
		gates = new ArrayList();
		techniques = new ArrayList();
		runways = new ArrayList();
	}

	public void addPlane(Plane plane) {
		this.planes.add(plane);
	}
	
	public void addFuel(Fuel fuel) {
		this.fuels.add(fuel);
	}
	
	public void addGate(Gate gate) {
		this.gates.add(gate);
	}
	
	public void addTechnique(Technique technique) {
		this.techniques.add(technique);
	}
	
	public void addRunway(Runway runway) {
		this.runways.add(runway);
	}
	
	public int acquireFuel() /*throws NoMoreResourceAvailable*/ {
		for (int i = 0; i < fuels.size(); i++) {
			if (fuels.get(i).isAvailable())
				return i;
		}
		
		//throw new NoMoreResourceAvailable("Fuel");
		return -1; //Vous donnerez votre avis concernant la valeur de retour en cas de manque de ressource
	}
	
	public void useFuel(int i) {
		try {
			fuels.get(i).use();
		} catch (ResourceNotAvailableException ex) {
			//TODO : Do something
		}
	}
	
	public void releaseFuel(int i) {
		fuels.get(i).release();
	}
	
	public int acquireGate() /*throws NoMoreResourceAvailable*/ {
		for (int i = 0; i < gates.size(); i++) {
			if (gates.get(i).isAvailable())
				return i;
		}
		
		//throw new NoMoreResourceAvailable("Gate");
		return -1;
	}
	
	public void useGate(int i) {
		try {
			gates.get(i).use();
		} catch (ResourceNotAvailableException ex) {
			//TODO : Do something
		}
	}
	
	public void releaseGate(int i) {
		gates.get(i).release();
	}
	
	public int acquireTechnique() /*throws NoMoreResourceAvailable*/ {
		for (int i = 0; i < techniques.size(); i++) {
			if (techniques.get(i).isAvailable())
				return i;
		}
		
		//throw new NoMoreResourceAvailable("Technique");
		return -1;
	}
	
	public void useTechnique(int i) {
		try {
			techniques.get(i).use();
		} catch (ResourceNotAvailableException ex) {
			//TODO : Do something
		}
	}
	
	public void releaseTechnique(int i) {
		techniques.get(i).release();
	}
	
	public int acquireRunway() /*throws NoMoreResourceAvailable*/ {
		for (int i = 0; i < runways.size(); i++) {
			if (runways.get(i).isAvailable())
				return i;
		}
		
		//throw new NoMoreResourceAvailable("Runway");
		return -1;
	}
	
	public void useRunway(int i) {
		try {
			runways.get(i).use();
		} catch (ResourceNotAvailableException ex) {
			//TODO : Do something
		}
	}
	
	public void releaseRunway(int i) {
		runways.get(i).release();
	}
	
	public void start() {
		System.out.println("Launching planes");
		
		for (Plane plane : planes) {
			plane.start();
		}
	}
}
