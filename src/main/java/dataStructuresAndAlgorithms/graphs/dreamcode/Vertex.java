package dataStructuresAndAlgorithms.graphs.dreamcode;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> neighborhood;
	private String label;
	
	public Vertex(String label) {
		this.label = label;
		this.neighborhood = new ArrayList<Edge>();
	}
	
	public void addNeighbor(Edge edge) {
		/*if(this.neighborhood.contains(o)) {
			
		}*/
	}
	
	public ArrayList<Edge> getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(ArrayList<Edge> neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
