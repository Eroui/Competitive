import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    private static final String[] forbidden = {
        "ab", "cd", "pq", "xy"
    };

    public static void main(String[] args) throws Exception {
        Long starTime = System.currentTimeMillis();

        try {
            solve();
        } catch (Exception e) {
            System.out.println("Failed Solving Problem Due to Exception : ");
            System.out.println(e);
        }

        Long endTime =  System.currentTimeMillis();
        System.out.println("\n________________________");
        System.out.printf("Finished Execution : %d ms\n", (endTime - starTime));
    }

    private static void solve() throws Exception {
        File file = new File(INPUT_FILE);
        Scanner in = new Scanner(file);

        int ans = 0;
        while (in.hasNext()) {
            ans += isNice(in.next()) ? 1 : 0;
        }

        System.out.println(ans);
        in.close();
    }

    private static boolean isNice(String s) {
        for (String ss: forbidden) {
            if (s.contains(ss)) {
                return false;
            }
        }

        int countVowel = 0;
        boolean magic = false;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            if (isVowel(arr[i])) ++countVowel;
            if (i > 0 && arr[i] == arr[i - 1])
                magic = true;
        }

        return magic && countVowel >= 3;
    }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a': ;
            case 'o': ;
            case 'e': ;
            case 'u': ;
            case 'i': return true;
            default: return false;
        }
    }


}