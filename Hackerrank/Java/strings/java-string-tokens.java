import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.replaceAll("[^\\p{Alpha}]+", " ").trim();
        if(s.isEmpty()){
            System.out.println("0");
            return ;
        }
        String[] tokens = s.split("\\p{Space}+");
        System.out.println(tokens.length);
        for(String ss : tokens)
            System.out.println(ss);
        scan.close();
    }
}