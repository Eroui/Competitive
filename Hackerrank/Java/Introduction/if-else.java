import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();            
        String ans="";
        if( n % 2 == 1 ){
          ans = "Weird";
        }
        else{
            ans = "Not Weird";
            if( n <= 20 && n >= 5 ) 
                ans = "Weird";
            
        }

        System.out.println(ans);
    }
}
