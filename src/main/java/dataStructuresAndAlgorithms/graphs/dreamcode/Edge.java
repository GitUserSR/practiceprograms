package dataStructuresAndAlgorithms.graphs.dreamcode;

public class Edge implements Comparable<Edge>{
	private Vertex one, two;
	private int weight;
	
	public Edge(Vertex one, Vertex two) {
		this(one,two,1);
	}
	
	public Edge(Vertex one, Vertex two, int weight) {
		this.one =  (one.getLabel)
	}
	
	@Override
	public int compareTo(Edge o) {
		return 0;
	}
}
