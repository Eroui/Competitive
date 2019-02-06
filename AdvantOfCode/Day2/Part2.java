import java.util.*;
import java.io.*;

public class Part2 {
    
    private static final String INPUT_FILE = "input.in";
    public static void main(String[] args) throws Exception {
        Long starTime = System.currentTimeMillis();

        try {
            solve();
        } catch (Exception e) {
            System.out.println("Failed Solving Problem Due to Exception " + e.getMessage());
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("\n________________________");
        System.out.printf("Finished Execution : %d ms", (endTime - starTime));
    }

    private static void solve() throws Exception{
        Scanner in = new Scanner(new File(INPUT_FILE));
        ArrayList<String> tokens = new ArrayList<>();
        while (in.hasNext()) {
            tokens.add(in.next());
        }

        String ans = null;
        for (int i = 0; i < tokens.size() && ans == null; ++i) {
            for (int j = i + 1; j < tokens.size() && ans == null; ++j) {
                String diff = getDiff(tokens.get(i), tokens.get(j));
                if (diff.length() == tokens.get(i).length() - 1) {
                    ans = diff;
                }
            }
        }
        
        if (ans == null) {
            System.out.println("No Solution Found!");
        } else {
            System.out.println("Solution Found : " + ans );
        }

        in.close();
    }

    private static String getDiff(String s1, String s2) {
        StringBuilder diff = new StringBuilder();
        for (int i = 0; i < s1.length() && i < s2.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i))  
                diff.append(s1.charAt(i));
        }

        return diff.toString();
    }

}