import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        ArrayList<Integer> li = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            li.add(in.nextInt());
        
        int q = in.nextInt();
        while(q-->0) {
            String queryType = in.next();
            if(queryType.equals("Insert")) {
                int idx = in.nextInt();
                int val = in.nextInt();
                
                li.add(idx, val);
            } else {
                int idx = in.nextInt();
                li.remove(idx);
            }
        }
        
        
        for(int i : li)
            System.out.print(i + " ");
    }
}