import java.util.*;


/**
*	@Author 	= Eroui Abdelaziz (EAbdel)
*   @Email 		= kapi.abdel@gmail.com
*	
*	This is an implementation of graphs using adjacency Matrix 
*   Remove the weights if not needing them;
*/

public class AdjMat {
	int N; 				// number of vertexes
	int[][] weights ;	// Remove if not weighted
	boolean[][] g;		

	boolean directed;
	public AdjMat(int n) {
		this.N = n;
		g = new boolean[n+1][n+1];
		weights = new int[n+1][n+1];		//remove if not weigthed
		directed = false;
	}

	public AdjMat(int n, boolean directed) {
		this(n);
		this.directed = directed;
	}

	public void setEdge(int i, int j) {
		g[i][j] = true;
		if(!directed) g[j][i] = true;
	}

	public void setEdge(int i, int j, int w) { // Dont use if not weighted
		setEdge(i, j);
		weights[i][j] = w;
		if(!directed) weights[j][i] = w;
	}

	public void setWeight(int i, int j, int w) {
		setEdge(i, j, w);
	}


	public void removeEdge(int i, int j) {
		g[i][j] = false;
		if(!directed) g[j][i] = false;
	}


	public List<Integer> adjacent(int v) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i <= N; i++) {
			if(g[v][i]) l.add(i);
		}
		return l;
	}

	public boolean edgeIn(int v, int u) {
		return g[v][u];
	}

	public int wiegth(int i, int j) {//dont use if not weighted 
		/* remove comment if needed
			if(g[i][j] == false) throw new Exception("There is no edge between "+i+" and "+j);
		*/
		return weights[i][j];
	}

		public static void main(String[] args) {

			AdjMat m = new AdjMat(5, false);
			m.setEdge(1, 2, 1);
			m.setEdge(2, 3, 2);
			m.setEdge(3, 4, 3);
			m.setEdge(1, 5, 4);
			m.setEdge(2, 4, 5);
			
			
			for(int i: m.adjacent(1)) {
			    System.out.print(i+" ");
			}System.out.println();
			
			
			System.out.println(m.wiegth(2, 4));
			
		}




}