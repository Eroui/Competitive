import java.util.*;
import java.io.*;



/**
*	@Author: Eoui Abdelaziz <kapi.abdel@Gmail.com>
**/

public class scorify {

	public static int timer = 0;
	public static int[] tin, tout;
	public static int count = 0;


	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new File("secret.in"));
		PrintWriter out = new PrintWriter(new File("secret.out"));

		int T = 0;

		while(in.hasNext()) {
			T++;
			int counter = 0;
			int V = in.nextInt();
			int E = in.nextInt();

			Vector< Vector< Integer>> g = new Vector< Vector <Integer>>(V);	// The graph it self 
			for(int i = 0; i < V; i++) {
				g.add(new Vector<Integer>());
			}

			for(int i = 0; i < E; i++) {
				int u = in.nextInt();
				int v = in.nextInt();

				Vector<Integer> vec= g.get(u);
				if(vec == null) vec = new Vector<Integer>(); // just in case not initialised

				vec.add(v);	// Edge from u to v
			}

			tin  = new int[V];
			tout = new int[V];

			timer = 0;
			count = 0;

			for(int i =0; i < V; i++) {
				tin[i] = tout[i] = -1;
			}

			for(int i = 0; i < V; i++) {
				if(tin[i] != -1) continue;
				dfs(g, i);
			}

			out.println(count);
		}

		out.close();

	}


	public static void dfs(Vector< Vector< Integer>> g, int u) {
		tin[u] = timer++;
		Vector< Integer> _Neighbor = g.get(u);

		for(int v : _Neighbor) {
			if(tin[v] == -1) {
				dfs(g, v);
			}
			else if(tout[v] == -1) {
				count++;
			}
		}

		tout[u] = timer++;
	}

}
