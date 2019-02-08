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
        System.out.printf("Finished Execution : %d ms", (endTime - starTime));
    }

    private static void solve() throws Exception {
        File file = new File(INPUT_FILE);
        FileInputStream inputStream = new FileInputStream(file);

        solve(inputStream);
    }

    private static void solve(FileInputStream in) throws Exception{
        Stack<Character> stk = new Stack<>();
        while (in.available() > 0) {
            char c = (char) in.read();
            if (stk.empty()) {
                stk.push(c);
            } else {
                char cc = stk.peek();
                if (react(c, cc)) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }

        System.out.println(stk.size());
    }

    private static boolean react(char c, char cc) {
        if ('a' <= c && c <= 'z' && 'A' <= cc && cc <= 'Z') {
            return (c - 'a') == (cc - 'A');
        }

        if ('a' <= cc && cc <= 'z' && 'A' <= c && c <= 'Z') {
            return (cc - 'a') == (c - 'A');
        }

        return false;
    }


}