/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    
    LinkedList<Integer> getTo;
    
    public Main() {
        getTo = new LinkedList<Integer>();
    }
    
    public void add(int i) {
        getTo.add(i);
    }
    
    public void add(Main i) {
        for(int j: i.getTo) {
            if(getTo.contains(j)) continue;
            getTo.add(j);
        }
    }
    
    public boolean isValid(int n) {
        System.err.println("->"+ this.getTo.size());
        if(this.getTo.size() == n-1) return true;
        return false;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception  {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
		    int m = in.nextInt();
		    int n = in.nextInt();
		    
		    Main[] tab = new Main[m];
		    for(int i = 0; i < m; i++) {
		        tab[i] = new Main();
		    }
		    
		    for(int i = 0; i < n; i++) {
		        int a = in.nextInt();
		        int b = in.nextInt();
		        
		        Main m1 = tab[a];
		        Main m2 = tab[b];
		        
		        m1.add(b);
		        m1.add(m2);
		    }
		    
		    for(int i = 0; i < m; i++) {
		        System.err.println(tab[i].isValid(m) ?"yes": "no");
		    }
		    
		    
		    System.err.println("##");
		    
		}
		
		
	}
}
