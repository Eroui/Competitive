import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        
        ArrayList<Integer>[] li = new ArrayList[n];
        for(int i = 0; i < n; ++i) {
            int d = in.nextInt();
            li[i] = new ArrayList<>();
            
            for(int j = 0; j < d; ++j)
                li[i].add(in.nextInt());
        }
        
        int q = in.nextInt();
        while(q-->0) {
            int x = in.nextInt();
            int y = in.nextInt();
            
            if(x > n || y > li[x - 1].size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(li[x - 1].get(y - 1));
            }
        }
    }
}