import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    // Solution Start
    private static Scanner in = new Scanner(System.in);
    private static int B, H;
    private static boolean flag;

    static {
        B = in.nextInt();
        H = in.nextInt();
        
        try {
            if(B <= 0 || H <= 0)
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
            else 
                flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    // Solution End

    public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class
