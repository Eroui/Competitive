import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i)
            arr[i] = in.nextInt();
        
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + arr[i];
        }
        
        int ans = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                if(pre[i] - pre[j - 1] < 0) {
                    ++ans;
                }
            }
        }
        
        System.out.println(ans);
    }
}