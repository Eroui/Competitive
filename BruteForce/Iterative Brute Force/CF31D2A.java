import java.util.*;
import java.io.*;

public class CF31D2A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; ++i) {
            arr[i] = in.nextInt();
            map.put(arr[i], i + 1);
        }

        for(int i = 0; i< n; ++i) {
            for(int j = i + 1; j < n; ++j) if(i != j) {
                int answer = -1;
                if((answer = map.getOrDefault(arr[i] + arr[j], -1)) >= 0) {
                    System.out.printf("%d %d %d", answer, j + 1, i + 1);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}