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
        Scanner in = new Scanner(file);

        long ans = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            Matcher m = pattern.matcher(line);

            if (m.matches()) {
                int l = Integer.parseInt(m.group(1));
                int w = Integer.parseInt(m.group(2));
                int h = Integer.parseInt(m.group(3));

                ans += 2l * (l*w + w*h + h*l) + Math.min(Math.min(l*w, w*h), h*l);
            }
        }

        System.out.println(ans);
    }


}