import java.util.*;


/**
*	@Author = Eroui Abdelaziz (EAbdel)
*   @Email 	= kapi.abdel@gmail.com
*	
*	This is an implementation of graphs using adjacency List (Generic) 
*/

class Pair <X, Y>{
	X _first;
	Y _second;

	public Pair(X f, Y s) {
		_first = f;
		_second = s;
	}

	X first() 	{ return _first; 	}
	Y second() 	{ return _second;	}

	void setFirst(X f) { _first = f;}
	void setSecond(Y s) { _second = s;}
	
	public boolean equals(Object o) {    //needed for the adjacency List
	    Pair _p = (Pair) o;
	    return this.first().equals(_p.first());
	}

}

public class AdjList <W>{ // W is the weight Data type 

	int _V; 	//The number of Virtices
	Vector< Vector< Pair< Integer, W >>> g; //The adjacecy List

	public AdjList(int V) {
		_V = V;
		g = new Vector< Vector< Pair< Integer, W>>>(V);
		for(int i = 0; i < V; i++) { // Initialising The Graph (Empty)
			Vector< Pair< Integer, W>> _Neighbor = new Vector< Pair< Integer, W>>();
			g.add(_Neighbor);
		}
	}


	public void addEdgeDir(int i, int j, W w) {
		Pair<Integer, W> _pair = new Pair<>(j, w);
		g.get(i).add(_pair);
	}

	public void addEdgeUndir(int i, int j, W w) {
		addEdgeDir(i, j, w);
		addEdgeDir(j, i, w);
	}

	public void addEdgeDir(int i, int j) { addEdgeDir(i, j, null); }
	public void addEdgeUndir(int i, int j) { addEdgeUndir(i, j, null); }

	public Vector< Pair< Integer, W>> adjacent(int i) {
		return g.get(i);
	}
	
	public boolean edgeIn(int i, int j) {
	    Pair<Integer, W> _p = new Pair(j, null);
	    Vector _adj = adjacent(i);
	    
	    return _adj.contains(_p);
	}

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        
        AdjList<Integer> g = new AdjList<Integer>(V+1);
        for(int i =0; i < E; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
  
            g.addEdgeUndir(u, v, in.nextInt());
        }
        
        for(int i = 1; i <= V; i++) {
            System.out.println("Adjacent of "+i+" --->");
            System.out.print("[");
            Iterator it = g.adjacent(i).iterator();
            while(it.hasNext()) {
                Pair p = (Pair) it.next();
                System.out.print("("+p.first()+", "+p.second()+")");
                if(it.hasNext()) System.out.print(", ");
            }
            
            System.out.println("]");
        }
        
    }
}