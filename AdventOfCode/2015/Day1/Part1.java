import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    private static final Pattern pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
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
        FileInputStream inputStream = new FileInputStream(file);

        solve(inputStream);
    }

    private static void solve(FileInputStream in) throws Exception{
        int level = 0;
        while (in.available() > 0) {
            char c = (char) in.read();
            if (c == '(') ++level;
            else --level;
        }

        System.out.println(level);
    }

}