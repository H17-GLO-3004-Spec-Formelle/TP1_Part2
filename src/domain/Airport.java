package domain;

import java.util.ArrayList;
import java.util.List;

import resources.Fuel;
import resources.Gate;
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
	
	public void start() {
		for (Plane plane : planes) {
			plane.start();
		}
	}
}
