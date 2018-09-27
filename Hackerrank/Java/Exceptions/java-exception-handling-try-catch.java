import java.io.*;
import java.util.*;

public class Solution {
    
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            
            System.out.println((int) (a / b));
        } catch(ArithmeticException e) {
            System.out.println(e);
        } catch(InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        }
    }
}