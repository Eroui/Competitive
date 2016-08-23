import java.util.*;
import java.io.*;
import java.math.*;


/**
*  @Author = Eroui Abdelaziz (EAbdel)
*  @Email 	= kapi.abdel@gmail.com
*  
*  Topoloical Sort for a directed unWeighted graph
*	
*/

class TopologicalSort {
    
    public static boolean[] visited;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();

		Vector< Vector <Integer>> g = new Vector<>();
		for(int i = 0; i < V; i++) { // pre initilisation
			g.add(new Vector<Integer>());
		}

		for(int i =0; i < E; i++) {
			g.get(in.nextInt()).add(in.nextInt());
		}
    
        visited = new boolean[V];
		topoSort(g, 0);
	}

// Sort
	public static void topoSort(Vector< Vector< Integer>> g, int v) {
		if(visited[v]) return;
		   
		visited[v] = true;
		for(int i : g.get(v)) {
		    if(!visited[i]) topoSort(g, i);
		   
		}
		
		System.out.print(v+" ");
		
	}

}

