import java.util.*;
import java.io.*;



/**
*	@Author: Eoui Abdelaziz <kapi.abdel@Gmail.com>
**/

public class scorify {

  	public static void main(String[] args) throws Exception {

	    int V, E, u, v, w; 
	    File f = new File("secret.in");
	    Scanner sc = new Scanner(f);
		PrintWriter out = new PrintWriter("secret.out");

		int TT = sc.nextInt();
		while(TT-->0) {

		    V = sc.nextInt();
		    E = V*(V-1)/2;
		    long sum = 0;
		    
		    Vector<IntegerTriple> EdgeList = new Vector<IntegerTriple>();

		    for (int i = 0; i < E; i++) {
		      u = sc.nextInt();
		      v = sc.nextInt();
		      w = sc.nextInt();

		      sum += w;
		      EdgeList.add(new IntegerTriple(w, u, v));
		    }
		    
		    Collections.sort(EdgeList);

		    long mst_cost = 0;
		    UnionFind UF = new UnionFind(V);
		    for (int i = 0; i < E; i++) {
		      IntegerTriple front = EdgeList.get(i);
		      if (!UF.isSameSet(front.second(), front.third())) {
		        mst_cost += front.first();
		        UF.unionSet(front.second(), front.third());
		    } }

		    System.err.println(mst_cost);
		    out.println(sum - mst_cost);
		}

		out.close();

	}
}

class IntegerTriple implements Comparable {
  Integer _first, _second, _third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(Object o) {
    if (!this.first().equals(((IntegerTriple)o).first()))
      return this.first() - ((IntegerTriple)o).first();
    else if (!this.second().equals(((IntegerTriple)o).second()))
      return this.second() - ((IntegerTriple)o).second();
    else
      return this.third() - ((IntegerTriple)o).third();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }

  public String toString() { return first() + " " + second() + " " + third(); }
}

class UnionFind {
  private Vector<Integer> p, rank, setSize;
  private int numSets;

  public UnionFind(int N) {
    p = new Vector<Integer>(N);
    rank = new Vector<Integer>(N);
    setSize = new Vector<Integer>(N);
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i);
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) { 
    if (p.get(i) == i) return i;
    else {
      int ret = findSet(p.get(i)); p.set(i, ret);
      return ret; } }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { numSets--; 
    int x = findSet(i), y = findSet(j);
    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
  public int numDisjointSets() { return numSets; }
  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}
