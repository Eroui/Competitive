import java.util.*;


/**
*	@Author 	= Eroui Abdelaziz (EAbdel)
*   @Email 		= kapi.abdel@gmail.com
*	
*	This is an implementation of graphs using adjacency Matrix 
*/

public class AdjMat {
	int N; 				// number of vertexes
	int[][] g;	

	boolean directed;
	public AdjMat(int n) {
		this.N = n;
		g = new int[N+1][N+1];

		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				g[i][j] = Integer.MAX_VALUE;
			}
		}
	}


	public void addEdgeDir(int i, int j, int w) {
		g[i][j] = w;
	}

	public void addEdgeUnDir(int i, int j, int w) {
		g[i][j] = g[j][i] = w;
	}

	public void addEdgeDir(int i, int j) {
		addEdgeDir(i, j, 0);
	}

	public voido addEdgeUnDir(int i, int j) {
		addEdgeUnDir(i, j, 0);
	}

	public void removeEdge(int i, int j) {
		g[i][j] = Integer.MAX_VALUE;
	}


	public List<Integer> adjacent(int v) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i <= N; i++) {
			if(g[v][i] != Integer.MAX_VALUE) l.add(i);
		}
		return l;
	}

	public boolean edgeIn(int v, int u) {
		return (g[v][u] != Integer.MAX_VALUE);
	}

	public int wiegth(int i, int j) {//dont use if not weighted 
		
		return g[i][j];
	}




}