import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.math.*;

import static java.lang.System.out;

class averageseasy {
	
	Kattio io;
	
	public void go() {
		io = new Kattio(System.in);
		int T = io.nextInt();
		
		while(T-->0) {
		    int N1, N2;
		    N1 = io.nextInt();
		    N2 = io.nextInt();
		    
		    double avg1, avg2;
		    avg1 = avg2 = 0;
		    int[] iqs1 = new int[N1];
		    int[] iqs2 = new int[N2];
		    
		    for(int i =0; i < N1; i++) {
		        iqs1[i] = io.nextInt();
		        avg1+= iqs1[i];
		    }
		    
		    avg1 /= N1; 
		    for(int i =0; i < N2; i++) {
		        iqs2[i] = io.nextInt();
		        avg2+= iqs2[i];
		    }
		    avg2 /= N2;
		    
		    System.err.println(avg1+" "+avg2);
		    
		    
		    int count = 0;
		    for(int i = 0; i < N1; i++) {
		        int tmp = iqs1[i];
		        if(tmp < avg1 && tmp > avg2) count++; 
		    }
		    io.println(count);
a