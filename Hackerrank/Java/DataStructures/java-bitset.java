import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet[] bitSets = new BitSet[3];
        bitSets[1] = new BitSet();
        bitSets[2] = new BitSet();
        
        while(m-->0) {
            String query = in.next();
            int idx1 = in.nextInt();
            int idx2 = in.nextInt();
            
            if(query.equals("AND")) {
                bitSets[idx1].and(bitSets[idx2]);
            } else if(query.equals("OR")) {
                bitSets[idx1].or(bitSets[idx2]);
            } else if(query.equals("XOR")) {
                bitSets[idx1].xor(bitSets[idx2]);
            }else if(query.equals("SET")) {
                bitSets[idx1].set(idx2);
            } else if(query.equals("FLIP")) {
                bitSets[idx1].flip(idx2);
            } else {
                System.out.println("Should not reach this statement. /!\\");
            }
            
            System.out.println(bitSets[1].cardinality()+ " " + bitSets[2].cardinality());
        }
    }
}