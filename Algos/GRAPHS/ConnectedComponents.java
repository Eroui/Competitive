import java.util.*;
import java.io.*;
import java.math.*;


/**
*  @Author = Eroui Abdelaziz (EAbdel)
*  @Email 	= kapi.abdel@gmail.com
*  
*  
*	
*/

public class ConnectedComponents {

	public static Vector< LinkedList< Integer>> cc(AdjList g, int _from, int _to) {

		DFS dfs = new DFS(g);
		Vector<LinkedList< Integer>> cc = new Vector<>();

		for(int i = _from; i <= _to; i++) {
			if(dfs.isVisited(i)) continue;
			cc.add(dfs.dfs(i));
		}

		return cc;
	}
	
	
	public static boolean areConnected(AdjList g, int i, int j) {
	    DFS dfs = new DFS(g);
	    LinkedList<Integer> cc = dfs.dfs(i);
	    
	    if(cc.contains(j)) return true;
	    return false;
	}
}


/****************************************************************
****************************************************************/


class DFS { // DFS implementation Using Stack 

	private AdjList _g;
	private boolean[] _visited;
	private int _v;

	public DFS(AdjList g) { 
		_g = g;
		_v = g._V;
		_visited = new boolean[_v];
	}


	public LinkedList<Integer> dfs(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		LinkedList<Integer> cc = new LinkedList<Integer>();

		stack.push(v);

		while(!stack.empty()) {
			int u = stack.pop();
			if(!isVisited(u)) {
				setVisited(u);
				cc.add(u);
				Iterator it = _g.adjacent(u).iterator();
				while(it.hasNext()) {
					Pair<Integer, ?> p = (Pair) it.next();
					stack.push(p.first());
				}
			}
		}
		
		return cc;
	}


	public boolean isVisited(int i) {return _visited[i];}
	public void setVisited(int i) {_visited[i] = true;}
	public int _v() {
		return _v;
	}

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

class AdjList <W>{ // W is the weight Data type 

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

    
}