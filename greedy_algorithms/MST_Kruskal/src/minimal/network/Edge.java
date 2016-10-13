package minimal.network;

public class Edge {
	private int u;
	private int v;
	private int w;
	
	public Edge(int u, int v, int w) {		
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int getEdgeSrc(){
		return u;
	}
	
	public int getEdgeDest(){
		return v;
	}
	
	public int getWeight(){
		return w;
	}
}
