import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Solution Start
    
    public static PerformOperation isOdd() {
        return num -> num % 2 == 1;
    }

    public static PerformOperation isPrime() {
        return num -> checkPrimality(num);
    }

    public static PerformOperation isPalindrome() {
        return num -> checkPalyndrome(num);
    }

    private static boolean checkPalyndrome(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        for(int i = 0, j = arr.length - 1; i < j; ++i, --j) {
            if(arr[i] != arr[j]) {
                return false;
            }
        }
        
        return true;
    }

    private static boolean checkPrimality(int n) {
        if(n == 2) return true;
        if(n == 1 || n % 2 == 0)
            return false;
        
        for(int i = 3; i*i <= n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
   
            }
            
            System.out.println(ans);
        }
    }
}