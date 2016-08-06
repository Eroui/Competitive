/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    
    public static int[] set;
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);   
		int N = in.nextInt();
		int Q = in.nextInt();
		
		set = new int[N];
		Arrays.fill(set, -1);
		
		for(int i = 0; i < Q ; i++) {
		    char op = in.next().charAt(0);
		    int a = in.nextInt();
		    int b = in.nextInt();
		    
		    if(op == '?') {
		        if(search(set, a) == search(set, b)) System.out.println("yes");
		        else System.out.println("no");
		    }else {
		        union(set, a, b);
		    }
		}
	}
	
	
	
	public static int search(int[] set, int i) {
		if (set[i] < 0) {
			return i;
		} else {
			set[i] = search(set, set[i]);
			return set[i];
		}
	}
	
	public static  void union(int[] set, int a, int b) {
		int aTop = search(set, a);
		int bTop = search(set, b);
		if (aTop != bTop) {
			set[bTop] += set[aTop];
			set[aTop] = bTop;
		}
	}
	
	
}
