/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] tab = new int[N];
		for (int i = 1; i < N; i++) {
			tab[i] = in.nextInt();
		}
		
		double tape = getTape(1, tab, 2);
		if (tape == Double.POSITIVE_INFINITY) {
			System.out.println("impossible");
		} else {
			System.out.println(tape);
		}
	}
	
	public static double getTape(int i, int[] papers, int need) {
		if (papers.length-1 == i) {
			if (need > papers[i]) {
				return Double.POSITIVE_INFINITY;
			} else {
				return need/2*Math.pow(2, (double)-3/4-1.0/2*(i-1));
			}
		}
		double tape = getTape(i+1, papers, Math.max(0, need-papers[i])*2);
		return tape + need/2*Math.pow(2, (double)-3/4-1.0/2*(i-1));
	}
}
