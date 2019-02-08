import java.util.*;
import java.io.*;

public class Part1 {
    private static final String INPUT_FILE = "input.in";
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(INPUT_FILE));

        long result = 0;
        while (in.hasNext()) {
            result += parse(in.nextLine());
        }

        in.close();
        System.out.println(result);
    }

    private static long parse(String s) {
        long value = 1;
        if (s.startsWith("-")) {
            value = -1;
        } 


        return value * Long.parseLong(s.substring(1));
    }
    
}
