import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    private static final Pattern pattern = Pattern.compile("([0-9]+)x([0-9]+)x([0-9]+)");
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
        
        HashSet<Pair> set = new HashSet<>();
        set.add(new Pair(0, 0));
        int x = 0;
        int y = 0;
        while (in.available() > 0) {
            char c = (char) in.read();
            if (c == '^') ++y;
            else if (c == '<') --x;
            else if (c == 'v') --y;
            else if (c == '>') ++x;
            
            set.add(new Pair(x, y));
        }
        System.out.println(set.size());
        in.close();
    }


    private static class Pair {
        int f, s;

        public Pair (int f, int s) {
            this.f = f;
            this.s = s;
        }
        
        @Override 
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != this.getClass()) {
                return false;
            }

            Pair p = (Pair) o;
            if (p.f == this.f && p.s == this.s)
                return true;

            return false;
        }
        
        @Override
        public int hashCode() {
            return this.f  + 234 * this.s;
        }
    }


}