/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main implements Comparable<Main>
{
    int base;
    Main power;
    
    public Main(String str) {
        int index = str.indexOf('^');
        if(index < 0) {
            base = Integer.parseInt(str);
            power = null;
            return ;
        }
        
        String str1 = str.substring(0, str.indexOf('^'));
        String str2 = str.substring(str.indexOf('^')+1);

        base= Integer.parseInt(str1);
        power = new Main(str2);
    }
    
    
    @Override
    public String toString() {
        String str = base+"";
        if(power != null) str += "^" + power;
        
        return str;
    }
    
    @Override 
    public int compareTo(Main m) {
        
        
        return 0;
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
           Main m = new Main("2^2");
           System.out.println(m);
    }
    
    
    public static double logb( double a, double b ) {
    return Math.log(a) / Math.log(b);
    }
    
}