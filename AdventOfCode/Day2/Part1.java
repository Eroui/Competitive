import java.util.*;
import java.io.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(INPUT_FILE));

        int count2 = 0;
        int count3 = 0;

        while (in.hasNext()) {
            char[] arr = in.next().toCharArray();
            int[] occs = new int[26];

            int occs2 = 0;
            int occs3 = 0;
            for (char c: arr) {
                ++occs[c - 'a'];
                if (occs[c - 'a'] == 2) {
                    ++occs2;
                } else if (occs[c - 'a'] == 3) {
                    --occs2;
                    ++occs3;
                } else if (occs[c - 'a'] > 3) {
                    --occs3;
                }
            }

            count2 += Math.min(1, occs2);
            count3 += Math.min(1, occs3);
        }

        System.out.println(count2 * count3);
        in.close();
    }
}