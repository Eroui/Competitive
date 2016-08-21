import java.util.*;
import java.io.*;

/**
* @Author  Eroui Abdelaziz (EAbdel)
* @Email 	 kapi.abdel@gmail.com
*	
*	Graph Traversal Using Depth-First Search 
*/

public class DFS {
	 public static void main (String[] args) {
        Scanner in = new Scanner(new File(in.txt));
        int V = in.nextInt();
        int E = in.nextInt();
        
        AdjList<Integer> g = new AdjList<Integer>(V+1);
        for(int i =0; i < E; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
  
            g.addEdgeUndir(u, v, in.nextInt());
        }
        
        DFS_Recursive d = new DFS_Recursive(g);
        d.dfs(0); 
    }
}


/****************************************************************
****************************************************************/

class DFS_Recursive {// Recursive Implementation of Depth-First-Search

	private AdjList _g;
	private boolean[] _visited;
	private int _v;


	public DFS_Recursive(AdjList g) {
		_g = g;
		_v = g._V;
		_visited = new boolean[_v];
	}

	public void dfs(int v) {
		setVisited(v);
		System.out.print(v+", ");// remove of not needed
		Iterator it = _g.adjacent(v).iterator();
		while(it.hasNext()) {
			Pair p = (Pair) it.next();
			if(!isVisited((Integer) p.first())) dfs((Integer) p.first());
		}
	}

	public boolean isVisited(int i) {return _visited[i];}
	public void setVisited(int i) {_visited[i] = true;}

}


/****************************************************************
****************************************************************/

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


/****************************************************************
****************************************************************/

class AdjList <W>{// W is the weight Data type 

	int _V; //The number of Virtices
	Vector< Vector< Pair< Integer, W >>> g;//The adjacecy List

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

}