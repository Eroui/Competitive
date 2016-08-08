/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] rows, cols;
		
		rows = new int[N];
		cols = new int[N];
		
		for(int i = 0; i < N; i++) {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    
		    rows[a-1]++;
		    cols[b-1]++;
		}
		
		
		for(int i = 0; i < N; i++) {
		    System.err.print(rows[i]+" ");
		}System.err.println("");
		
			for(int i = 0; i < N; i++) {
		    System.err.print(cols[i]+" ");
		}System.err.println("");
		
		
		int i = 0, t = 0;
		for(int k = 0; k < N; k++) {
		    int count = rows[k];
		    int pos = rows[k];
		    for(int j = 0; j <= count; j++) {
		        t += Math.abs(pos - i);
		        i++;
		    }
		}
		
		System.out.println(t-1);
		
        
        
	}
}
