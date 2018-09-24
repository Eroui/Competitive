import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}