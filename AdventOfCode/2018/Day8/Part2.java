import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part2 {
    
    private static final String INPUT_FILE = "input.in";
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
        Scanner in = new Scanner(new File(INPUT_FILE));
        System.out.println(getNodeSum(in));
        in.close();
    }

    private static int getNodeSum(Scanner in) throws Exception {
        int numChilds = in.nextInt();
        int metaData = in.nextInt();
        
        ArrayList<Integer> childrenValues = new ArrayList<>();
        for (int i = 0; i < numChilds; ++i) {
            childrenValues.add(getNodeSum(in));
        }

        ArrayList<Integer> metaDataValues = new ArrayList<>();
        for (int i = 0; i < metaData; ++i) {
            metaDataValues.add(in.nextInt());
        }

        if (numChilds == 0) {
            return metaDataValues.stream().mapToInt(i -> i ).sum();
        } else {
            int ret = 0;
            for (int metaDataValue: metaDataValues) {
                if (metaDataValue - 1 < childrenValues.size()) {
                    ret += childrenValues.get(metaDataValue - 1);
                }
            }

            return ret;
        }
    }

}