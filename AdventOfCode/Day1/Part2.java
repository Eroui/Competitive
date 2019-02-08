import java.util.*;
import java.io.*;

public class Part2 {
    private static final String INPUT_FILE = "input.in";
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File(INPUT_FILE));
        
        HashSet<Long> set = new HashSet<>();
        ArrayList<Long> li = new ArrayList<>();
        while (in.hasNext()) {
            li.add(parse(in.nextLine()));
        }
        
        int currentIndex = 0;
        long currentSum = 0;
        while (true) {
            if (currentIndex == li.size()) 
                currentIndex = 0;

            currentSum += li.get(currentIndex++);
            if  (set.contains(currentSum)) {
                System.out.println(currentSum);
                break;
            }

            set.add(currentSum);
        }

        in.close();
    }

    private static long parse(String s) {
        long value = 1;
        if (s.startsWith("-")) {
            value = -1;
        }

        return value * Long.parseLong(s.substring(1));
    }
    
}
