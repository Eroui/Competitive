import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part2 {
    
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

                int[] arr = {
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3))
                };
                
                Arrays.sort(arr);

                ans += 2l * (arr[0] + arr[1]) + arr[0]*arr[1]*arr[2];
            }
        }

        System.out.println(ans);
    }


}