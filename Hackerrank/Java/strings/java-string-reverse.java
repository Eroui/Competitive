import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String sr = new String(sb);
        
        if(sr.equals(s)) System.out.println("Yes");
        else System.out.println("No");
        
    }
}
